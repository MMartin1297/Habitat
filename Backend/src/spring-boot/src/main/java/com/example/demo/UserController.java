package com.example.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.micrometer.core.instrument.util.MediaType;

/**
 * 
 * Controller for User functions.  Allows for API access for user information
 * from the database.
 * 
 * @author Matthew Martin, Max Minard
 *
 */
@RestController
public class UserController {

	/**
	 * Variable to represent the user repository
	 */
    @Autowired
    private UserRepository users;
    
    /**
	 * Variable to represent the tenant repository
	 */
    @Autowired
    private TenantRepository tenants;
    
    /**
	 * Variable to represent the landlord repository
	 */
    @Autowired
    private LandlordRepository landlords;
    
    /**
	 * Variable to represent the worker repository
	 */
    @Autowired
    private WorkerRepository workers;

    /**
     * Constructor method to create a new user object.
	 * Will set the user repository to a new given repository
     * @param user
     * 		Desired user repository
     */
    public UserController(UserRepository user){
        this.users = user;
    }

    /**
     * API method to receive a POST HTTP request and create a new user object
     * @param user
     * 		New user object to be created
     * @return user
     * 		The new user object that has been successfully created
     */
    @RequestMapping(method = RequestMethod.POST, path = "/users/new", consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody User createUser(@RequestBody User user){
    	String email = user.getEmail();
    	if(!(email.contains("@"))){
    		return null;
    	}else if(this.users.findByEmail(email) == null){
    		this.users.save(user);
    		
    		if(user.getUserType().equalsIgnoreCase("tenant")){
    			Tenant tenant = new Tenant();
    			tenant.setIdTenant(user.getIdUsers());
    			this.tenants.save(tenant);
    		}
    		else if(user.getUserType().equalsIgnoreCase("landlord")){
    			Landlord landlord = new Landlord();
    			landlord.setIdLandlord(user.getIdUsers());
    			this.landlords.save(landlord);
    		}
    		else if(user.getUserType().equalsIgnoreCase("worker")){
    			Worker worker = new Worker();
    			worker.setIdWorker(user.getIdUsers());
    			this.workers.save(worker);
    		}
    		
            return user;
    	}else{
    		return null;
    	}

    }
     
    /**
     * API method to receive a POST HTTP request that will update a specified user
     * @param user
     * 		User object to be updated
     * @return user
     * 		The successfully updated user
     */
    @RequestMapping(method = RequestMethod.POST, path = "/users/update", consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody User updateUser(@RequestBody User user){
    	if(this.users.findByID(user.getIdUsers()) == null){
    		return null;
    	}else{
    		this.users.save(user);
    		return user;
    	}
    }

    /**
     * API method to receive a GET HTTP request that will get a specified user.
     * @param id_users
     * 		The ID of the user requested
     * @param model
     * 		Model to use
     * @return user
     * 		The specified user object
     */
    @RequestMapping(path = "/users/{id_users}", method = RequestMethod.GET)
    public @ResponseBody User getUserProfile(@PathVariable("id_users") Integer id_users, Model model){
    	User user = this.users.findByID(id_users);
        model.addAttribute(user);
        return user;
    }

    /**
     * API method to receive a GET HTTP request that will get all users in the database
     * @param model
     * 		Model to use
     * @return userList
     * 		All user objects in the database
     */
    @RequestMapping(path = "/users/all", method = RequestMethod.GET)
    public @ResponseBody Collection<User> getAllUsers(Model model){
    	Collection<User> userList = this.users.findAllUsers();
        model.addAttribute(userList);
        return userList;
    }
    
    /**
     * API method to receive a POST HTTP request that will login a given user
     * @param user
     * 		User object consisting of email and password to login
     * @return user
     * 		The successfully logged in user
     */
    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody User getUserFromLogin(@RequestBody User user){
    	String email = user.getEmail();
    	String password = user.getPassword();
    	User databaseUser;
    	if(this.users.findByEmail(email) == null){
    		return null;
    	}else{
    		databaseUser = this.users.findByEmail(email);
    	}
    	String databasePassword = databaseUser.getPassword();
    	if(password.equals(databasePassword)){
    		return databaseUser;
    	}else{
    		return null;
    	}
    }

    
}
