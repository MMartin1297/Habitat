package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.micrometer.core.instrument.util.MediaType;

/**
 * Controller for tenant functions.  Allows for API access for tenant information
 * from the database.
 * 
 * @author Matthew Martin, Max Minard
 *
 */
@RestController
class WorkerController{
    
	/**
	 * Variable to represent the worker repository
	 */
    @Autowired
    private WorkerRepository worker;

    /**
     * Constructor method to create a new worker object.
	 * Will set the worker repository to a new given repository
     * @param worker
     * 		Desired worker repository
     */
    public WorkerController(WorkerRepository worker){
        this.worker = worker;
    }
	
    /**
     * API method to receive a POST HTTP request that will update a given
     * worker in the database
     * @param worker
     * 		The worker object to update
     * @return worker
     * 		The updated worker object
     */
	@RequestMapping(method = RequestMethod.POST, path = "/worker/update", consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody Worker updateWorker(@RequestBody Worker worker){
    	if(this.worker.findWorkerByID(worker.getIdWorker()) == null){
    		return null;
    	}else{
    		this.worker.save(worker);
    		return worker;
    	}
    }
}