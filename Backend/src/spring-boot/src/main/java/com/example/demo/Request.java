package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDate;

/**
 * Class to represent Requests.
 * @author Max Minard, Matthew Martin
 *
 */
@Component
@Table(name = "request")
@Entity
public class Request {
	
	/**
	 * Variable to represent request id
	 */
    @Id
    @Column(name = "id_request")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_request;

    /**
     * Variable to represent title of request.
     */
    @Column(name = "title")
    private String title;

    /**
     * Variable to represent description of request.
     */
    @Column(name = "description")
    private String description;

    /**
     * Variable to represent the requestee who created the request
     */
    @Column(name = "requestee")
    private Integer requestee;

    /**
     * Variable to represent the landlord in charge of the request
     */
    @Column(name = "landlord")
    private Integer landlord;

    /**
     * Variable to represent the worker associated with the request
     */
    @Column(name = "worker")
    private Integer worker;

    /**
     * Variable to represent the status of the request
     */
    @Column(name = "status")
    private String status;

    /**
     * Variable to represent who last updated the status of the request
     */
    @Column(name = "last_updated")
    private Integer last_updated; 
    
    /**
     * Get request id value
     * @return id_request
     * 		Request ID
     */
    public Integer getIdRequest() {
        return id_request;
    }

    /**
     * Get title of the request
     * @return title
     * 		Title of the request
     */
    public String getTitle(){
        return title;
    }

    /**
     * Get description of the request
     * @return description
     * 		Description of the request
     */
    public String getDescription(){
        return description;
    }

    /**
     * Get requestee id value
     * @return requestee
     * 		Requestee ID
     */
    public Integer getRequestee(){
        return requestee;
    }

    /**
     * Get landlord id value
     * @return landlord
     * 		Landlord ID
     */
    public Integer getLandlord(){
        return landlord;
    }

    /**
     * Get worker id value
     * @return worker
     * 		Worker ID
     */
    public Integer getWorker(){
        return worker;
    }

    /**
     * Get status value
     * @return status
     * 		Status of the request
     */
    public String getStatus(){
        return status;
    }

    /**
     * Get last updated user id
     * @return last_updated
     * 		Last Updated user ID
     */
    public Integer getLastUpdated(){
    	return last_updated;
    }

    /**
     * Sets request id to a new given value.
     * @param id_request
     * 		Desired request id
     */
    public void setIdRequest(Integer id_request) {
        this.id_request = id_request;
    }

    /**
     * Sets title of request to a new given value.
     * @param title
     * 		Desired request title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets description of request to a new given value.
     * @param description
     * 		Desired request description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets requestee id to a new given value.
     * @param requestee
     * 		Desired requestee id
     */
    public void setRequestee(Integer requestee) {
        this.requestee = requestee;
    }

    /**
     * Sets landlord id to a new given value.
     * @param landlord
     * 		Desired landlord id
     */
    public void setLandlord(Integer landlord) {
        this.landlord = landlord;
    }

    /**
     * Sets worker id to a new given value.
     * @param worker
     * 		Desired worker id
     */
    public void setWorker(Integer worker) {
        this.worker = worker;
    }

    /**
     * Sets status of request to a new given value.
     * @param status
     * 		Desired request status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * Sets the last updated user id to a new given value.
     * @param last_updated
     * 		Desired last updated user id
     */
    public void setLastUpdated(Integer last_updated){
    	this.last_updated = last_updated;
    }
}
