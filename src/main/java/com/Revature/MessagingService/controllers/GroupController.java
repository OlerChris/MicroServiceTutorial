package com.Revature.MessagingService.controllers;

import com.Revature.MessagingService.beans.Group;
import com.Revature.MessagingService.dataTransferObjects.GroupDTO;
import com.Revature.MessagingService.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messagingService/group")
public class GroupController {

    public GroupController(){}

    @Autowired
    private GroupService groupService;

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody GroupDTO x){
        Group g = x.convertToGroup();
        g = groupService.create(g);
        x = GroupDTO.getDTO(g);
        return new ResponseEntity<GroupDTO>(x, HttpStatus.ACCEPTED);
    }

    @RequestMapping( consumes = "/", path = "/{gid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@PathVariable Long gid, @RequestBody Long uid){
        uid = groupService.addUser(uid, gid);
        return new ResponseEntity<Long>(uid, HttpStatus.ACCEPTED);
    }

}
