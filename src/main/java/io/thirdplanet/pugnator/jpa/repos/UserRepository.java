package io.thirdplanet.pugnator.jpa.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

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
    List<User> findByFirstName(String firstName, Sort sort);
    List<User> findByLastName(String lastName, Sort sort);
    Page<User>  findByFirstName(String firstName,Pageable pageable);
    Page<User>  findByLastName(String lastName,Pageable pageable);
    Page<User>  findByMiddleName(String middleName,Pageable pageable) ;
}