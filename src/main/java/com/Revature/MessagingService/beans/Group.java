package com.Revature.MessagingService.beans;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Message_Groups")
public class Group {

    @Id
    @SequenceGenerator(name="Group_ID_SEQ", sequenceName = "Group_ID_SEQ",allocationSize=1)
    @GeneratedValue(strategy=SEQUENCE, generator="Group_ID_SEQ")
    @Column(name="Message_Group_Id")
    private long groupId;

    @Column(name="Group_Owner")
    private long owner;

    @Column(name="Public_Access") //TODO converter
    private boolean publicAccess;

    public Group(){}

    public Group(long groupId, long owner, boolean publicAccess) {
        this.groupId = groupId;
        this.owner = owner;
        this.publicAccess = publicAccess;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }

    public boolean isPublicAccess() {
        return publicAccess;
    }

    public void setPublicAccess(boolean publicAccess) {
        this.publicAccess = publicAccess;
    }
}
