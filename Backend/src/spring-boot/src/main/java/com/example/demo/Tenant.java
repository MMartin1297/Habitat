package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;
import org.springframework.stereotype.Component;

/**
 * Class for Tenant Users
 * @author Matthew Martin, Max Minard
 *
 */

@Component
@Entity
@Table(name = "tenant")
public class Tenant {
    
	/**
	 * Variable to represent the tenant's ID
	 */
	@Id
    @Column(name = "id_tenant")
    private Integer id_tenant;

	/**
	 * Variable to represent the ID of the tenant's landlord
	 */
    @Column(name = "landlord")
    private Integer landlord;

    /**
     * Variable to represent the address of residence
     */
    @Column(name = "residence")
    private Integer residence;

    /**
     * Variable to represent how much the tenant is paying for rent
     */
    @Column(name = "monthly_rent")
    private Integer monthly_rent;

    /**
     * Get the tenant's ID
     * @return id_tenant
     * 		Tenant's ID
     */
    public Integer getIdTenant(){
        return id_tenant;
    }

    /**
     * Set the ID of the tenant
     * @param id_tenant
     * 		Tenant's ID
     */
    public void setIdTenant(Integer id_tenant){
        this.id_tenant = id_tenant;
    }

    /**
     * Get the associating Landlord's ID
     * @return landlord
     * 		Landlord's ID
     */
    public Integer getLandlord(){
        return this.landlord;
    }

    /**
     * Set the associating Landlord's ID
     * @param landlord
     * 		Desired landlord ID
     */
    public void setLandlord(Integer landlord){
        this.landlord = landlord;
    }

    /**
     * Get the address of residence associating with the tenant
     * @return residence
     * 		Address of residence
     */
    public Integer getResidence(){
        return this.residence;
    }

    /**
     * Set the address of residence associating with the tenant
     * @param residence
     * 		Desired residence
     */
    public void setResidence(Integer residence){
        this.residence = residence;
    }

    /**
     * Get the monthly payment amount the tenant is paying for their place
     * @return monthly_rent
     * 		Monthly Rent in dollars
     */
    public Integer getMonthlyRent() {
        return monthly_rent;
    }

    /**
     * Set the monthly payment amount the tenant is paying for their place
     * @param monthly_rent
     * 		Desired monthly rent
     */
    public void setMonthlyRent(Integer monthly_rent) {
        this.monthly_rent = monthly_rent;
    }

}