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
}
