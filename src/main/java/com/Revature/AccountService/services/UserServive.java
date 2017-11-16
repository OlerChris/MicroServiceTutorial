package com.Revature.AccountService.services;

import com.Revature.AccountService.beans.User;
import com.Revature.AccountService.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServive {

    @Autowired
    private UserRepo repo;

    public User register(User persisted){
        return repo.save(persisted);
    }
}
