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

    @Column(name="Group_NAME")
    private String name;

    @Column(name="Group_Owner")
    private long owner;

    @Column(name="Public_Access")
    private boolean publicAccess;

    public Group(){}

    public Group(long groupId, String name, long owner, boolean publicAccess) {
        this.groupId = groupId;
        this.name = name;
        this.owner = owner;
        this.publicAccess = publicAccess;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
