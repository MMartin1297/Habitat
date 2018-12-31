package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.micrometer.core.instrument.util.MediaType;

/**
 * 
 * Controller for tenant functions.  Allows for API access for tenant information
 * from the database.
 * 
 * @author Matthew Martin, Max Minard
 *
 */
@RestController
class TenantController{
    
	/**
	 * Variable to represent the tenant repository
	 */
	@Autowired
    private final TenantRepository tenant;

	/**
	 * Constructor method to create a new tenant object.
	 * Will set the tenant repository to a new given repository
	 * @param tenant
	 * 		Desired tenant repository
	 */
    public TenantController(TenantRepository tenant) {
        this.tenant = tenant;
    }

    /**
     * API method to receive a POST HTTP request and update the tenant object in
     * the server database.
     * @param tenant
     * 		A tenant object to update in the database
     * @return tenant
     * 		The updated tenant object
     */
    @RequestMapping(method = RequestMethod.POST, path = "/tenant/update", consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody Tenant updateTenant(@RequestBody Tenant tenant){
    	if(this.tenant.findTenantByID(tenant.getIdTenant()) == null){
    		return null;
    	}else{
    		this.tenant.save(tenant);
    		return tenant;
    	}
    }
    
    /**
     * API method to receive a GET HTTP request and get a specific tenant from 
     * the database.
     * @param id_tenant
     * 		The id of the tenant for the requested object
     * @param model
     * 		Model to use
     * @return
     * 		The tenant object that was requested
     */
    @RequestMapping(path = "/tenant/{id_tenant}", method = RequestMethod.GET)
    public @ResponseBody Tenant getTenantProfile(@PathVariable("id_tenant") Integer id_tenant, Model model){
    	Tenant tenant = this.tenant.findTenantByID(id_tenant);
        model.addAttribute(tenant);
        return tenant;
    }
}