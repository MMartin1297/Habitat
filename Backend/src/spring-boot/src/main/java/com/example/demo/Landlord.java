package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * 
 * Class to represent Landlords. 
 * @author Max Minard, Matthew Martin 
 *
 */
@Component
@Entity
@Table(name = "landlord")
public class Landlord{
	
	/**
	 * Variable to represent landlord id
	 */
    @Id
    @Column(name = "id_landlord")
    private Integer id_landlord;

    /**
     * Variable to represent address
     */
    @Column(name = "address")
    private String address;

    /**
     * Get landlord id value 
     * @return id_landlord
     * 		landlord id
     */
    public Integer getIdLandlord() {
        return id_landlord;
    }

    /**
     * Sets landlord id to a new given value.
     * @param id_landlord
     * 		Desired landlord id.
     */
    public void setIdLandlord(Integer id_landlord) {
        this.id_landlord = id_landlord;
    }

    /**
     * Get address value
     * @return address
     * 		Address of landlord
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address to a new given value.
     * @param address
     * 		Desired landlord address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}