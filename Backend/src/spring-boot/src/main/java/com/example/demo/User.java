package com.example.demo;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class for Users
 * @author Matthew Martin, Max Minard
 *
 */
@Component
@Table(name = "user")
@Entity
public class User {

	/**
	 * Variable to represent the ID of the User
	 */
    @Id
    @Column(name = "id_users")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_users;

    /**
     * Variable to represent the email of the user
     */
    @Column(name = "email")
    private String email;

    /**
     * Variable to represent the first name of the user
     */
    @Column(name = "first_name")
    private String first_name;

    /**
     * Variable to represent the last name of the user
     */
    @Column(name = "last_name")
    private String last_name;

    /**
     * Variable to represent the password of the user
     */
    @Column(name = "password")
    private String password;

    /**
     * Variable to represent the phone number of the user
     */
    @Column(name = "phone_number")
    private String phone_number;

    /**
     * Variable to represent the user type
     */
    @Column(name = "user_type")
    private String user_type;

    /**
     * Get the User's ID
     * @return id_users
     * 		User's ID
     */
    public Integer getIdUsers() {
        return id_users;
    }
    
    /**
     * Get the User's email
     * @return email
     * 		The User's email
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * Get the User's first name
     * @return first_name
     * 		The User's first name
     */
    public String getFirstName(){
        return first_name;
    }
    
    /**
     * Get the User's last name
     * @return last_name
     * 		The User's last name
     */
    public String getLastName(){
        return last_name;
    }
    
    /**
     * Get the User's password
     * @return password
     * 		The User's password
     */
    public String getPassword(){
        return password;
    }
    
    /**
     * Get the User's phone number
     * @return phone_number
     * 		The User's phone number
     */
    public String getPhoneNumber(){
        return phone_number;
    }
    
    /**
     * Get the User's user type
     * @return user_type
     * 		The User's user type
     */
    public String getUserType(){
        return user_type;
    }

    /**
     * Set the User's ID
     * @param id
     * 		The ID of the user
     */
    public void setIdUsers(Integer id)
    {
        this.id_users = id;
    }
    
    /**
     * Set the User's email
     * @param email
     * 		The email of the user
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * Set the User's first name
     * @param firstName
     * 		The first name of the user
     */
    public void setFirstName(String firstName){
        this.first_name = firstName;
    }
    
    /**
     * Set the User's last name
     * @param lastName
     * 		The last name of the user
     */
    public void setLastName(String lastName){
        this.last_name = lastName;
    }
    
    /**
     * Set the User's password
     * @param password
     * 		The password of the user
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    /**
     * Set the User's phone number
     * @param phoneNumber
     * 		The phone number of the user
     */
    public void setPhoneNumber(String phoneNumber){
        this.phone_number = phoneNumber;
    }
    
    /**
     * Set the User's user type
     * @param user_type
     * 		The user type of the user
     */
    public void setUserType(String user_type){
        this.user_type = user_type;
    }

}
