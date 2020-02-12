package io.thirdplanet.pugnator.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private  Long userId ;

    @Column(name="first_name")
    private String firstName ;


    @Column(name="last_name")
    private String lastName ;


    @Column(name="middle_name")
    private String middleName ;


    @Column(name="dob")
    private Date dateOfBirth ;


    @Column(name="date_created")
    private Timestamp dateCreated ;


    @Column(name="email")
    private String email ;


    @Column(name="url")
    private String url ;



    /**
     * 
     * @param id
     */
    public void setUserId(Long id){
        this.userId = id ;
    }
    /**
     * 
     * @return userId
     */
    public Long getUserId(){
        return userId ;
    }

    /**
     * 
     * @param firstName
     */
    public void setFirstName(String firstName){
        this.firstName = firstName ;
    }
    

    /**
     * 
     * @return firstName
     */
    public String getFirstName(){
        return firstName ;
    }


    /**
     * @param lastName
     * 
     */
    public void setLastName(String lastName){
        this.lastName = lastName ;
    }


    /**
     * 
     * @return
     */
    public String getLastName(){
        return lastName ;
    }

    /**
     * 
     * @param middleName
     */

    public void setMiddleName(String middleName){
        this.middleName = middleName ;
    }

    /**
     * 
     * @return middleName
     */
    public String getMiddleName(){
        return middleName ;
    }


    /**
     * 
     * 
     * @param dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth ;
    }

    /**
     * 
     * @return dateOfBirth
     */
    public Date DateOfBirth(){
        return dateOfBirth ;
    }



    public void setEmail(String email){
        this.email = email ;
    }
    public String getEmail(){
        return email ;
    }




    public void setUrl(String url){
        this.url = url ;
    }
    public String getUrl(){
        return url ;
    }




    public void setDateCreated(Timestamp dateCreated){
        this.dateCreated = dateCreated ;
    }
    public Timestamp getDateCreated(){
        return  dateCreated ;
    }




}