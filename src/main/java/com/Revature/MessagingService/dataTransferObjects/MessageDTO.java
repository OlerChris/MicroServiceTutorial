package com.Revature.MessagingService.dataTransferObjects;

import com.Revature.MessagingService.beans.Message;
import com.Revature.MessagingService.repositories.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;

public class MessageDTO {

    private long messageId;
    private long authorId; /*Refers to User in Account Service*/
    private long groupId;
    private String message;

    @Transient
    GroupRepo repo;

    public MessageDTO(){}

    public MessageDTO(long messageId, long authorId, long groupId, String message) {
        this.messageId = messageId;
        this.authorId = authorId;
        this.groupId = groupId;
        this.message = message;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
       this.authorId = authorId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message convertToMessage(){
        System.out.println(groupId);
        Message x = new Message(
                this.messageId,
                this.authorId,
                this.groupId,
                this.message);
        return x;
    }

    public static MessageDTO getDTO(Message m){
        MessageDTO x = new MessageDTO();
        x.messageId = m.getMessageId();
        x.authorId = m.getAuthorId();
        x.groupId = m.getGroup().getGroupId();
        x.message = m.getMessage();
        return x;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "messageId=" + messageId +
                ", authorId=" + authorId +
                ", groupId=" + groupId +
                ", message='" + message + '\'' +
                '}';
    }
}
