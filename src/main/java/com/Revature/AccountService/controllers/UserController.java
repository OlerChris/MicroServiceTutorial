package com.Revature.AccountService.controllers;

import com.Revature.AccountService.beans.User;
import com.Revature.AccountService.dataTransferObjects.UserCredentials;
import com.Revature.AccountService.dataTransferObjects.UserDTO;
import com.Revature.AccountService.services.UserServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accountService/user")
public class UserController {

    public UserController(){}

    @Autowired
    private UserServive userService;

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody UserDTO x){
        User u = x.convertToUser();
        u = userService.register(u);
        x = UserDTO.getDTO(u);
        return new ResponseEntity<UserDTO>(x, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody UserCredentials x){
        Long id;
        id = userService.login(x);
        return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "{uid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserName(@RequestParam Long uid){
        String username = userService.getUsername(uid);
        return new ResponseEntity<String>(username, HttpStatus.ACCEPTED);
    }
}
