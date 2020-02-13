package io.thirdplanet.pugnator.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.thirdplanet.pugnator.domain.User;
import io.thirdplanet.pugnator.service.user.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController{

    UserService userService ;

    public UserController(UserService userService){
      this.userService = userService ;
    }



    @RequestMapping(
        value = "/user", 
        params = { "firstName","middleName","lastName" }, 
        method = RequestMethod.GET
      )
    Page<User> getUsers(@RequestParam("page") int page,
                        @RequestParam("size") int size){
        return userService.findByFirstName("Michael");

    }



    @RequestMapping(
        value = "/alpha", 
        params = {"id", "page", "size" }, 
        method = RequestMethod.GET
      )
    Page<User> getUserById(@RequestParam("id") long id,
                           @RequestParam("page") int page,
                           @RequestParam("size") int size){
        //return userService.findUserById(id);
       return null ;

    }


    @RequestMapping(
        value = "/beta", 
        params = { "page", "size" }, 
        method = RequestMethod.GET
      )
    Page<User> getUser(@RequestParam("page") int page,
                        @RequestParam("size") int size){
        return userService.findByFirstName("Michael");

    }

    @RequestMapping(
      value = "/delta", 
      params = {"lastName" ,"page", "size" }, 
      method = RequestMethod.GET
    )
  Page<User> getUser( @RequestParam("lastName") String lastName,
                      @RequestParam("page") int page,
                      @RequestParam("size") int size){
      Pageable pageable = PageRequest.of(0,5);
      return userService.findAllByLastName(lastName, pageable);

  }


  @RequestMapping(
      value = "/sigma", 
      params = { "lastName" }, 
      method = RequestMethod.GET
    )
  ResponseEntity< List <User>> getUser( @RequestParam("lastName") String lastName){
      
      List<User> list =  userService.findAllByLastName(lastName);
      return ResponseEntity.ok().body(list) ;
  }

    /*
    @RequestMapping(
      value = "/beta", 
      params = { "page", "size" }, 
      method = RequestMethod.GET
    )
  Page<User> alpha(@RequestParam("page") int page,
                      @RequestParam("size") int size){
      return userService.findByFirstNameAndLastName("Michael","Brown");
  }

  */


    /*

    @RequestMapping(
        value = "/users/get", 
        params = { "page", "size" }, 
        method = RequestMethod.GET
      )
    Page<User> getUsers(@RequestParam("page") int page,
                        @RequestParam("size") int size){
        return null;

    }

    */

    /*
    private Pageable PageRequest(int i, int j) {
      return null;
    }
    */
    
}