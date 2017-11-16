package com.Revature.MessagingService.beans;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="MESSAGES")
public class Message {

    @Id
    @SequenceGenerator(name="Message_ID_SEQ", sequenceName = "Message_ID_SEQ",allocationSize=1)
    @GeneratedValue(strategy=SEQUENCE, generator="Message_ID_SEQ")
    @Column(name="MESSAGE_ID")
    private long messageId;

    @Column(name="Author")
    private long AuthorID; /*Refers to User in Acount Service*/

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Group_Id", referencedColumnName="Message_Group_Id")
    private Group group;

    @Column(name="TEXT")
    private String message;

    public Message(){}

    public Message(long messageId, long authorID, Group group, String message) {
        this.messageId = messageId;
        AuthorID = authorID;
        this.group = group;
        this.message = message;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(long authorID) {
        AuthorID = authorID;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
