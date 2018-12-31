package com.example.demo;

import java.util.Collection;

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
public interface UserRepository extends Repository<User, Integer>{
    /**
     * Saves a given user to the database
     * @param user
     * 		A user to be saved to the database
     */
	public void save(User user);

	/**
	 * Method that performs a query on the database to find a user by their ID
	 * @param id_users
	 * 		ID of the request user
	 * @return user
	 * 		User that was requested by ID
	 */
    @Query("select u from User u where u.id_users = :id_users")
    @Transactional(readOnly = true)
    public User findByID(@Param("id_users") Integer id_users);

    /**
     * Method that performs a query on the database to find a user by their email
     * @param email
     * 		Email of the request user
     * @return user
     * 		User that was requested by email
     */
    @Query("select u from User u where u.email = :email")
    @Transactional(readOnly = true)
    public User findByEmail(@Param("email") String email);
    
    /**
     * Method that performs a query on the database to find all the users in the database
     * @return users
     * 		Returns a collection of all users in the database
     */
    @Query("select u from User u")
    @Transactional(readOnly = true)
    public Collection<User> findAllUsers();
}
