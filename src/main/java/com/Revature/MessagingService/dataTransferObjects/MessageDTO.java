package com.Revature.MessagingService.dataTransferObjects;

import com.Revature.MessagingService.beans.Message;

public class MessageDTO {

    private long messageId;
    private long authorID; /*Refers to User in Acount Service*/
    private long GroupId;
    private String message;

    public MessageDTO(){}

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(long authorID) {
       authorID = authorID;
    }

    public long getGroupId() {
        return GroupId;
    }

    public void setGroupId(long groupId) {
        GroupId = groupId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message convertToMessage(){
        Message x = new Message(
                this.messageId,
                this.authorID,
                null, //TODO
                this.message);
        return x;
    }

    public static MessageDTO getDTO(Message m){
        MessageDTO x = new MessageDTO();
        x.messageId = m.getMessageId();
        x.authorID = m.getAuthorID();
        x.GroupId = m.getGroup().getGroupId();
        return x;
    }
}
