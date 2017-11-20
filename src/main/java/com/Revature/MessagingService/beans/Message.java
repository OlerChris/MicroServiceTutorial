package com.Revature.MessagingService.beans;

import com.Revature.MessagingService.repositories.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;

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
    private long authorId; /*Refers to User in Acount Service*/

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Group_Id", referencedColumnName="Message_Group_Id")
    private Group group;

    @Column(name="TEXT")
    private String message;

    public Message(){}

    public Message(long messageId, long authorId, Group group, String message) {
        this.messageId = messageId;
        this.authorId = authorId;
        this.group = group;
        this.message = message;
    }

    public Message(long messageId, long authorId, long groupId, String message) {
        this.messageId = messageId;
        this.authorId = authorId;
        this.group = new Group();
        this.group.setGroupId(groupId);
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
