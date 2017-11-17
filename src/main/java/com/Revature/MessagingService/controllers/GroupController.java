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

    /**
     * Creates a new Group
     * @param x Group specs sent through body as JSON
     * @return the created group
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody GroupDTO x){
        Group g = x.convertToGroup();
        g = groupService.create(g);
        x = GroupDTO.getDTO(g);
        return new ResponseEntity<GroupDTO>(x, HttpStatus.ACCEPTED);
    }

    /**
     * adds User to group
     * @param gid id of group passed in header
     * @param uid id of user to be added
     * @return userid
     */
    @RequestMapping( consumes = "/", path = "/{gid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@PathVariable Long gid, @RequestBody Long uid){
        uid = groupService.addUser(uid, gid);
        return new ResponseEntity<Long>(uid, HttpStatus.ACCEPTED);
    }

    /**
     * fetches a group of a given id
     * @param gid groupId
     * @return the Group
     */
    @RequestMapping( consumes = "/", path = "/group/{gid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getGroup(@PathVariable Long gid){
        Group g = groupService.getGroup(gid);
        GroupDTO x = GroupDTO.getDTO(g);
        return new ResponseEntity<GroupDTO>(x, HttpStatus.ACCEPTED);
    }

    /**
     * get the group ids associated with a user
     * @param uid the id of the User
     * @return long[] group Ids
     */
    @RequestMapping( consumes = "/", path = "/{uid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getGroups(@PathVariable Long uid){
        Long[] gs = groupService.getGroups(uid);
        return new ResponseEntity<Long[]>(gs, HttpStatus.ACCEPTED);
    }
}
