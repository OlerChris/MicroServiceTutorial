package com.Revature.MessagingService.services;

import com.Revature.MessagingService.beans.Message;
import com.Revature.MessagingService.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepo repo;

    public Message create(Message persisted) {
        return repo.save(persisted);
    }
}
