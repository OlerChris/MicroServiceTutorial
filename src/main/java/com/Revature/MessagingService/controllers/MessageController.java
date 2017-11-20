package com.Revature.MessagingService.controllers;

import com.Revature.MessagingService.beans.Message;
import com.Revature.MessagingService.dataTransferObjects.MessageDTO;
import com.Revature.MessagingService.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * Creates a new Group and adds owner to it
     * @param x Group specs sent through body as JSON
     * @return the created group
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody MessageDTO x){
        System.out.println(x);
        System.out.println(x);
        Message m = x.convertToMessage();
        m = messageService.create(m);
        x = MessageDTO.getDTO(m);
        return new ResponseEntity<MessageDTO>(x, HttpStatus.ACCEPTED);
    }
}
