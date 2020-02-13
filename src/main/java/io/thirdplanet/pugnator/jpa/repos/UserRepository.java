package io.thirdplanet.pugnator.jpa.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.thirdplanet.pugnator.domain.User;

/**
 * Note: 
 * APIs taking Sort and Pageable expect non-null values to be handed into methods.
 * If you don't want to apply any sorting or pagination use the following as
 * params accordingly:
 * 
 *  Sort.unsorted()
 *  Pageable.unpaged()
 * 
 * 
 * reference : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.special-parameters
 * 
 * 
 * Queries we currently need for Users
 * -----------------------------------------------
 * 1.  findAll() pageable
 * 2.  findAllById() pageable
 * 3.  findByFirstName() pageable
 * 4.  findByLastName() pageable
 * 
 * 
 * Queries we currently need for Registrations
 * ----------------------------------------------
 * 1. findAllByUserByRegistration()
 * 2. findAllRegistrationsByName()
 * 3. findAllRegistrationsById
 * 
 * 
 * 
 */
public interface UserRepository extends JpaRepository<User,Long>{
    //pass
    //List<User> findAll() ;
    List<User> findByFirstName(String firstName, Sort sort);
    //List<User> findByLastName(String lastName, Sort sort);

    Page<User> findByUserId(Long userId,Pageable pageable);
    Page<User>  findByFirstName(String firstName,Pageable pageable);
    //Page<User>  findByLastName(String lastName,Pageable pageable);
    Page<User>  findByMiddleName(String middleName,Pageable pageable) ;
    

    /*
    @Query("select user  from users user WHERE user.first_name LIKE CONCAT(:firstName,'%')  AND user.last_name LIKE CONCAT(:lastName,'%')") 
    List<User>  findAllByFirstAndLastName(@Param("firstName")String firstName, @Param("lastName") String lastName);
    */

    /**
     * 
     * We can pass parameters to our database quieries by passing method parameters to
     * our query methods.
     * 
     * Spring Data JPA supports both posistion based parameter binding and 
     * named parameters.
     * 
     * 
     * Both of these options are described in the following:
     *          - Via parameter order:
     *              method(title, description)
     *              title -->  ?1
     *              description -->  ?2
     * 
     *              @("SELECT t FROM  Todo t where t.title =?1 AND t.description = ?2")
     *              public Optional<Todo> findByTitleAndDescription(String title, String description)
     * 
     * 
     *  Sample Query for finding user by both  first and last name....
     * 
     *  
     * 
     */

    @Query(value = "SELECT *  FROM users u WHERE u.last_name LIKE :lastName ", nativeQuery=true) 
    public List<User>  findAllByLastName( @Param("lastName") String lastName);

    @Query(value = "SELECT *  FROM users u WHERE u.last_name LIKE :lastName", nativeQuery=true) 
    public Page<User>  findAllByLastName( @Param("lastName") String lastName ,Pageable pageable);
    
     
    
}