package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for tenants
 * 
 * @author Matthew Martin, Max Minard
 *
 */
public interface TenantRepository extends Repository<Tenant, Integer>{
	/**
	 * Saves a given tenant to the database
	 * @param tenant
	 * 		A tenant object to be saved
	 */
	public void save(Tenant tenant);
	
	/**
	 * Method that performs a query on the database to return a specific tenant
	 * based on their id
	 * @param id_tenant
	 * 		ID of the requested tenant
	 * @return tenant
	 * 		Requested tenant object
	 */
    @Query("select t from Tenant t where t.id_tenant = :id_tenant")
    @Transactional(readOnly = true)
    public Tenant findTenantByID(@Param("id_tenant") Integer id_tenant);
	
}