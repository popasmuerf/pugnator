package io.thirdplanet.pugnator.service.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.thirdplanet.pugnator.domain.User;
import io.thirdplanet.pugnator.jpa.repos.UserRepository;




@Service
public class UserService{

    private UserRepository userRepo ;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo ;
    }



    public Page<User> findByFirstName(String firstName){
        Pageable pageable = PageRequest(1,5);
        Page<User> page = userRepo.findByFirstName(firstName, pageable) ;
        return page ;
    }

    public Page<User> findAllByLastName(String lastName, Pageable _pageable ){
        Pageable pageable = _pageable  ;
        Page<User> page = userRepo.findAllByLastName(lastName, pageable) ;
        return page ;
    }

    public List<User> findAllByLastName(String lastName){
        
        List<User> list = userRepo.findAllByLastName(lastName) ;
        return list ;
    }



 
    private Pageable PageRequest(int i, int j) {
        return null;
    }


}