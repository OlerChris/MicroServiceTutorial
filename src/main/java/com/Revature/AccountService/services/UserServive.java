package com.Revature.AccountService.services;

import com.Revature.AccountService.beans.User;
import com.Revature.AccountService.dataTransferObjects.UserCredentials;
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

    public Long login(UserCredentials x) {
        User u = repo.findByUsername(x.getUsername());
        if (u.getPword().equals(x.getPassword())){
            return u.getUserId();
        }
        else {
            return 0L;
        }
    }
}
