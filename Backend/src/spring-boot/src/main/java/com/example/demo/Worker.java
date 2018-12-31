package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;

/**
 * 
 * Class for the worker user
 * @author Matthew Martin, Max Minard
 *
 */
@Component
@Entity
@Table(name = "worker")
public class Worker{
   /**
    * Variable to represent the Worker's user
    */
	@Id
    @Column(name = "id_worker")
    private Integer id_worker;

	/**
	 * Variable to represent the Worker's company
	 */
    @Column(name = "company")
    private String company;

    /**
     * Get the Worker's Id
     * @return id_worker
     * 		The ID of the worker
     */
    public Integer getIdWorker() {
        return id_worker;
    }

    /**
     * Set the Worker's ID
     * @param id_worker
     * 		The ID of the worker
     */
    public void setIdWorker(Integer id_worker) {
        this.id_worker = id_worker;
    }

    /**
     * Get the Worker's company
     * @return company
     * 		The company of the worker
     */
    public String getCompany() {
        return company;
    }

    /**
     * Set the Worker's company
     * @param company
     * 		The company of the worker
     */
    public void setCompany(String company) {
        this.company = company;
    }
}