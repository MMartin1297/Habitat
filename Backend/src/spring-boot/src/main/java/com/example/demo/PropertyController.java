package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.micrometer.core.instrument.util.MediaType;
import java.util.Collection;

/**
 * Controller class for Property objects. 
 * @author Max Minard, Matthew Martin
 *
 */
@RestController
class PropertyController{
	
	/**
	 * Variable to represent property repository.
	 */
	@Autowired
	private PropertyRepository properties;
	
	/**
	 * Variable to represent landlord repository.
	 */
	@Autowired
	private LandlordRepository landlord;
	
	/**
	 * Constructor method to create a new Property Controller object. 
	 * Sets property repository to a new given repository.
	 * @param property
	 * 		Desired property repository
	 */
	public PropertyController(PropertyRepository property){
		this.properties = property;
	}
	
	/**
	 * API method to receive POST Http request and creates a new property with
	 * the given property information. Checks if property has a valid landlord.
	 * Saves the property to the server database. Returns created property.
	 * @param property
	 * 		New property information
	 * @return property
	 * 		Created property
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/property/new", consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody Property createProperty(@RequestBody Property property){
		
		if(this.landlord.findLandlordByID(property.getLandlord()) != null){
			this.properties.save(property);
			return property;
		}
		else{
			return null;
		}
	
    }
	
	/**
	 * API method to receive GET Http request and retrieve all property information on the server database.
	 * Returns all property information.
	 * @param model
	 * 		Model to use
	 * @return propertyList
	 * 		List of all properties
	 */
	@RequestMapping(path = "/properties/all", method = RequestMethod.GET)
    public @ResponseBody Collection<Property> getAllProperties(Model model){
    	Collection<Property> propertyList = this.properties.findAllProperties();;
        model.addAttribute(propertyList);
        return propertyList;
    }
	
	/**
	 * API method to receive GET Http request and retrieve information of given property.
	 * Returns property information with given property id. 
	 * @param id_property
	 * 		Property ID to find
	 * @param model
	 * 		Model to use
	 * @return property
	 * 		Found property
	 */
	@RequestMapping(path = "/properties/{id_property}", method = RequestMethod.GET)
    public @ResponseBody Property getProperty(@PathVariable("id_property") Integer id_property, Model model){
    	Property property = this.properties.findProperty(id_property);
        model.addAttribute(property);
        return property;
    }
	
	/**
	 * API method to receive GET Http request and retrieve information of all properties owned by given landlord.
	 * Returns list of properties owned by landlord with given landlord id.
	 * @param id_landlord
	 * 		Landlord id 
	 * @param model
	 * 		Model to use
	 * @return landlordProperties
	 * 		List of properties
	 */
	@RequestMapping(path = "/properties/landlord/{id_landlord}", method = RequestMethod.GET)
	public @ResponseBody Collection<Property> getLandlordsProperties(@PathVariable("id_landlord") Integer id_landlord, Model model){
		Collection<Property> landlordProperties = this.properties.findPropertyByLandlord(id_landlord);
		return landlordProperties;
	}
	
	/**
	 * API method to receive GET Http request and retrieve information of all properties with a vacant living status.
	 * Returns information of all unoccupied properties from server database. 
	 * @param model
	 * 		Model to use
	 * @return landlordProperties
	 * 		List of properties
	 */
	@RequestMapping(path = "/properties/vacant", method = RequestMethod.GET)
	public @ResponseBody Collection<Property> getVacantProperties(Model model){
		Collection<Property> landlordProperties = this.properties.findPropertyByLivingStatus("vacant");
		return landlordProperties;
	}
	
	/**
	 * API method to receive POST Http request and update the information of a property with the given property id.
	 * Returns the updated information of the property from the server database.
	 * @param property
	 * 		Property to update
	 * @param id_property
	 * 		Property ID
	 * @return property
	 * 		Updated property
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/properties/update/{id_property}", consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody Property updateProperty(@RequestBody Property property, @PathVariable("id_property") Integer id_property){
		if(this.properties.findProperty(property.getIdProperty()) == null){
    		return null;
    	}else{
    		this.properties.save(property);
    		return property;
    	}
	}
    
}