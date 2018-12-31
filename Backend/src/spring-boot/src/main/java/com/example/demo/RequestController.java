package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.micrometer.core.instrument.util.MediaType;
import java.util.Collection;

/**
 * Controller class for Request objects.
 * @author Max Minard, Matthew Martin
 *
 */
@RestController
public class RequestController {

	/**
	 * Variable to represent request repository
	 */
    @Autowired
    private RequestRepository request;
    
    /**
     * Variable to represent user repository
     */
    @Autowired
    private UserRepository users;

    /**
     * Constructor method to create a new Request Controller object.
     * Sets request repository to a new given repository.
     * @param request
     * 		Desired request repository
     */
    public RequestController(RequestRepository request){
        this.request = request;
    }
    
    /**
     * API method to receive GET Http request and retrieve information of given request.
     * Returns request information with given request id.
     * @param id_request
     * 		ID of request to find
     * @param model
     * 		Model to save
     * @return request
     * 		Found request
     */
    @RequestMapping(path = "/request/{id_request}", method = RequestMethod.GET)
    public @ResponseBody Request getRequest(@PathVariable("id_request") Integer id_request, Model model){
    	Request request = this.request.findRequestByID(id_request);
        model.addAttribute(request);
        return request;
    }
    
    /**
     * API method to receive POST Http request and creates a new request with
     * the given request information. Saves the request to the server database.
     * Returns created request.
     * @param request
     * 		Request to create
     * @return request
     * 		Created Request
     */
    @RequestMapping(method = RequestMethod.POST, path = "/request/new", consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody Request createRequest(@RequestBody Request request){
    	request.setLastUpdated(request.getRequestee());
    	this.request.save(request);
        return request;
    }
    
    /**
     * API method to receive POST Http request and update the last updated id of a request with the given user id.
     * Returns the updated information of the request from the server database.
     * @param request
     * 		Request to update
     * @param id_users
     * 		User id of last updated
     * @return request
     * 		Updated request
     */
    @RequestMapping(method = RequestMethod.POST, path = "/request/update/{id_users}", consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody Request updateRequest(@RequestBody Request request, @PathVariable("id_users") Integer id_users){
    	if(this.request.findRequestByID(request.getIdRequest()) == null){
    		return null;
    	}else{
    		request.setLastUpdated(id_users);
    		this.request.save(request);
    		return request;
    	}
    }
    
    /**
     * API method to receive GET Http request and retrieve the information of all requests associated with the given user id.
     * Returns the list of requests from the server database.
     * @param id_users
     * 		User id to find requests
     * @param model
     * 		Model to use
     * @return Collection of requests
     * 		List of requests
     */
    @RequestMapping(path = "/users/{id_users}/requests", method = RequestMethod.GET)
    public @ResponseBody Collection<Request> getUserRequests(@PathVariable("id_users") Integer id_users, Model model){
    	
    	Collection<Request> requests = null;
    	String type = this.users.findByID(id_users).getUserType();
    	
    	if(type.equalsIgnoreCase("tenant")){
    		requests = this.request.findRequestByRequestee(id_users);
    		model.addAttribute(requests);
    	}
    	else if(type.equalsIgnoreCase("landlord")){
    		requests = this.request.findRequestByLandlord(id_users);
    		model.addAttribute(requests);
    	}
    	else if(type.equalsIgnoreCase("worker")){
    		requests = this.request.findRequestByWorker(id_users);
    		model.addAttribute(requests);
    	}
    	
        return requests;
    	
    }

    
}
