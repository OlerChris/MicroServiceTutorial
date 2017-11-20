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
     * Creates a new Group and adds owner to it
     * @param x Group specs sent through body as JSON
     * @return the created group
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody GroupDTO x){
        Group g = x.convertToGroup();
        g = groupService.create(g);
        groupService.addUser(g.getOwner(), g.getGroupId());
        x = GroupDTO.getDTO(g);
        return new ResponseEntity<GroupDTO>(x, HttpStatus.ACCEPTED);
    }

    /**
     * adds User to group
     * @param gid id of group passed in header
     * @param uid id of user to be added
     * @return userid
     */
    @RequestMapping(path = "/{gid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestParam String gid, @RequestBody Long uid){
        uid = groupService.addUser(uid, Long.parseLong(gid));
        return new ResponseEntity<Long>(uid, HttpStatus.ACCEPTED);
    }

    /**
     * fetches a group of a given name
     * @param gName group name
     * @return the Group
     */
    @RequestMapping(path = "/getGroup/{gName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getGroup(@RequestParam String gName){
        Group g = groupService.getGroup(gName);
        GroupDTO x = GroupDTO.getDTO(g);
        return new ResponseEntity<GroupDTO>(x, HttpStatus.ACCEPTED);
    }

    /**
     * get the group names associated with a user
     * @param uid the id of the User
     * @return long[] group Ids
     */
    @RequestMapping(path = "/{uid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getGroups(@RequestParam String uid){
        String[] gs = groupService.getGroups(Long.parseLong(uid));
        return new ResponseEntity<String[]>(gs, HttpStatus.ACCEPTED);
    }

    /**
     * fetches users of a group of a given name
     * @param gName group name
     * @return the user ids
     */
    @RequestMapping(path = "/getUsers/{gName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers(@RequestParam String gName){
        Long[] users = groupService.getUsers(gName);
        return new ResponseEntity<Long[]>(users, HttpStatus.ACCEPTED);
    }
}
