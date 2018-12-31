package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

/**
 * Repository interface for Properties.
 * @author Max Minard, Matthew Martin
 *
 */
public interface PropertyRepository extends Repository<Property, Integer>{
    
	/**
	 * Saves a given property to the server database.
	 * @param property
	 * 		Property to save
	 * @return property
	 * 		Saved property
	 */
	Property save(Property property);
    
	/**
	 * Method that performs given query on server database and returns the information
	 * of all properties.
	 * @return Collection of properties
	 * 		List of all properties
	 */
	@Query("select p from Property p")
    @Transactional(readOnly = true)
    public Collection<Property> findAllProperties();
	
	/**
	 * Method that performs given query on server database and returns the property
	 * with the id_property.
	 * @param id_property
	 * 		Property ID used to find property
	 * @return property
	 * 		Found property
	 */
	@Query("select p from Property p where p.id_property = :id_property")
    @Transactional(readOnly = true)
    public Property findProperty(@Param("id_property") Integer id_property);
	
	/**
	 * Method that performs given query on server database and returns the properties
	 * owned by the landlord with the given landlord id. 
	 * @param id_landlord
	 * 		Landlord ID
	 * @return Collection of properties
	 * 		List of properties found
	 */
	@Query("select p from Property p where p.landlord = :id_landlord")
    @Transactional(readOnly = true)
    public Collection<Property> findPropertyByLandlord(@Param("id_landlord") Integer id_landlord);
	
	/**
	 * Method that performs given query on server database and returns the properties
	 * with the given living status.
	 * @param living_status
	 * 		Living status
	 * @return Collection of properties
	 * 		List of properties found
	 */
	@Query("select p from Property p where p.living_status = :living_status")
    @Transactional(readOnly = true)
    public Collection<Property> findPropertyByLivingStatus(@Param("living_status") String living_status);
	
}