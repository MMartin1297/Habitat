package com.example.demo;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for Landlords. 
 * @author Max Minard, Matthew Martin
 *
 */
public interface LandlordRepository extends Repository<Landlord, Integer>{
	/**
	 * Saves a given landlord to the server database. 
	 * @param landlord
	 * 		landlord to save to database
	 */
    public void save(Landlord landlord);
    
    /**
     * Method that performs given query on server database and returns the landlord
     * with the given id_landlord. 
     * @param id_landlord
     * 		landlord id to find
     * @return landlord
     * 		landlord found
     */
    @Query("select l from Landlord l where l.id_landlord = :id_landlord")
    @Transactional(readOnly = true)
    public Landlord findLandlordByID(@Param("id_landlord") Integer id_landlord);
    
    /**
     * Method that performs given query on server database and returns the information
     * of all landlords. 
     * @return Collection of landlords
     * 		All landlords in server database.
     */
    @Query("select l from Landlord l")
    @Transactional(readOnly = true)
    public Collection<Landlord> findAllLandlords();
}