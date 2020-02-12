package io.thirdplanet.pugnator.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.thirdplanet.pugnator.domain.User;
import io.thirdplanet.pugnator.service.user.UserService;

@RestController
@RequestMapping(path="/demo")
public class UserController{

    UserService userService ;

    public UserController(UserService userService){
      this.userService = userService ;
    }



    @RequestMapping(
        value = "/foo", 
        params = { "page", "size" }, 
        method = RequestMethod.GET
      )
    Page<User> getUsers(@RequestParam("page") int page,
                        @RequestParam("size") int size){
        return userService.findByFirstName("Michael");

    }


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



    
}