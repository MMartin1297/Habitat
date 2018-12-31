package com.example.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.micrometer.core.instrument.util.MediaType;

/**
 * Controller class for Landlord objects.
 * @author Max Minard, Matthew Martin
 *
 */
@RestController
class LandlordController{

	/**
	 * Variable to represent landlord repository
	 */
	@Autowired
    private LandlordRepository landlord;

	/**
	 * Constructor method to create a new Landlord Controller object. 
	 * Sets landlord repository to a new given repository. 
	 * @param landlord
	 * 		Desired landlord repository.
	 */
    public LandlordController(LandlordRepository landlord){
        this.landlord = landlord;
    }
    
    /**
     * API method to receive POST Http request and update a landlord from the server database. 
     * Given new landlord information and updates the same landlord with the new information.
     * Returns updated landlord information. 
     * @param landlord
     * 		Landlord information to update.
     * @return landlord
     * 		Updated landlord information in server database.
     */
    @RequestMapping(method = RequestMethod.POST, path = "/landlord/update", consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody Landlord updateLandlord(@RequestBody Landlord landlord){
    	if(this.landlord.findLandlordByID(landlord.getIdLandlord()) == null){
    		return null;
    	}else{
    		this.landlord.save(landlord);
    		return landlord;
    	}
    }
    
    /**
     * API method to receive GET Http request and retrieve all landlord information from the 
     * server database. Returns all landlord information. 
     * @param model
     * 		model to store information.
     * @return landlordList
     * 		list of all landlords.
     */
    @RequestMapping(path = "/landlords/all", method = RequestMethod.GET)
    public @ResponseBody Collection<Landlord> getAllLandlords(Model model){
    	Collection<Landlord> landlordList = this.landlord.findAllLandlords();
        model.addAttribute(landlordList);
        return landlordList;
    }
}