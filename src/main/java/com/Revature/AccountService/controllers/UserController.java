package com.Revature.AccountService.controllers;

import com.Revature.AccountService.beans.User;
import com.Revature.AccountService.services.UserServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountService/user")
public class UserController {

    @Autowired
    private UserServive userService;

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody User in){
        User u;
        u = in;
        u = userService.register(u);
        return new ResponseEntity<User>(u, HttpStatus.ACCEPTED);
    }
}
