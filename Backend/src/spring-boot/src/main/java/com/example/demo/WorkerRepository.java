package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for workers
 * 
 * @author Matthew Martin, Max Minard
 *
 */
public interface WorkerRepository extends Repository<Worker, Integer>{
    /**
     * Saves a given worker to the database
     * @param worker
     * 		A worker object to be saved
     */
	public void save(Worker worker);
    
	/**
	 * Method that performs a query on the database to return a specific worker
	 * based on their id
	 * @param id_worker
	 * 		ID of the requested worker
	 * @return worker
	 * 		Requested worker object
	 */
    @Query("select w from Worker w where w.id_worker = :id_worker")
    @Transactional(readOnly = true)
    public Worker findWorkerByID(@Param("id_worker") Integer id_worker);
}