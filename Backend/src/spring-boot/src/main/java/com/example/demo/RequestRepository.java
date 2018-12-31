package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

/**
 * Repository interface for Requests.
 * @author Max Minard, Matthew Martin
 *
 */
public interface RequestRepository extends Repository<Request, Integer>{
    public void save(Request request);
    
    //public void update(Request request);

    /**
     * Method that performs given query on server database and returns the request with the 
     * given id_request
     * @param id_request
     * 		Request ID to find
     * @return request
     * 		Found Request
     */
    @Query("select r from Request r where r.id_request = :id_request")
    @Transactional(readOnly = true)
    public Request findRequestByID(@Param("id_request") Integer id_request);
    
    /**
     * Method that performs given query on server database and returns all requests where the 
     * requestee id is the same as the given user id
     * @param id_users
     * 		User Id to find
     * @return Collection of requests
     * 		List of requests found
     */
    @Query("select r from Request r where r.requestee = :id_users")
    @Transactional(readOnly = true)
    public Collection<Request> findRequestByRequestee(@Param("id_users") Integer id_users);
    
    /**
     * Method that performs given query on server database and returns all requests where the
     * landlord id is the same as the given user id
     * @param id_users
     * 		User ID to find
     * @return Collection of requests
     * 		List of requests found
     */
    @Query("select r from Request r where r.landlord = :id_users")
    @Transactional(readOnly = true)
    public Collection<Request> findRequestByLandlord(@Param("id_users") Integer id_users);
    
    /**
     * Method that performs given query on server database and returns all requests where the
     * worker id is the same as the given user id
     * @param id_users
     * 		User ID to find
     * @return Collection of requests
     * 		List of requests found
     */
    @Query("select r from Request r where r.worker = :id_users")
    @Transactional(readOnly = true)
    public Collection<Request> findRequestByWorker(@Param("id_users") Integer id_users);
}
