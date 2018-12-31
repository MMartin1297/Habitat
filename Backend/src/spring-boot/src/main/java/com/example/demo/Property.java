package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

/**
 * Class to represent properties.
 * @author Max Minard, Matthew Martin
 *
 */
@Entity
@Table(name = "property")
public class Property{
	
	/**
	 * Variable to represent property id.
	 */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_property")
    private Integer id_property;

    /**
     * Variable to represent the landlord that owns the property.
     */
    @Column(name = "landlord")
    private Integer landlord;

    /**
     * Variable to represent the living status of the property. 
     */
    @Column(name = "living_status")
    private String living_status;

    /**
     * Variable to represent the address of the property.
     */
    @Column(name = "address")
    private String address;

    /**
     * Variable to represent the worker assigned to the property. 
     */
    @Column(name = "worker")
    private Integer worker;

    /**
     * Variable to represent the due date for rent the tenants are required to pay.
     */
    @Column(name = "rent_due_date")
    private String rent_due_date; 
    
    /**
     * Get property id value.
     * @return id_property
     * 		property id
     */
    public Integer getIdProperty() {
        return id_property;
    }

    /**
     * Set property id to a new given value
     * @param id
     * 		Desired property id
     */
    public void setIdProperty(Integer id) {
        this.id_property = id;
    }

    /**
     * Get id of landlord who owns the property. 
     * @return landlord
     * 		Landlord id
     */
    public Integer getLandlord() {
        return landlord;
    }

    /**
     * Set landlord id to a new given value
     * @param landlord
     * 		Desired landlord id
     */
    public void setLandlord(Integer landlord) {
        this.landlord = landlord;
    }

    /**
     * Get the current living status of the property.
     * @return living_status
     * 		Living status
     */
    public String getLivingStatus() {
        return living_status;
    }

    /**
     * Set living status to a new given value.
     * @param living_status
     * 		Desired living status
     */
    public void setLivingStatus(String living_status) {
        this.living_status = living_status;
    }

    /**
     * Get the address of the property.
     * @return address
     * 		Address of property
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address to a new given value.
     * @param address
     * 		Desired address of property
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the id of the worker assigned to the property.
     * @return worker
     * 		Worker ID
     */
    public Integer getWorker() {
        return worker;
    }

    /**
     * Set worker id to a new given value. 
     * @param worker
     * 		Desired Worker ID
     */
    public void setWorker(Integer worker) {
        this.worker = worker;
    }

    /**
     * Get the rent due date for the property. 
     * @return rent_due_date
     * 		Rent due date
     */
    public String getRentDueDate() {
        return rent_due_date;
    }

    /**
     * Set the rent due date to a new given value.
     * @param rent_due_date
     * 		Desired rent due date
     */
    public void setRentDueDate(String rent_due_date) {
        this.rent_due_date = rent_due_date;
    }
}