package com.Revature.MessagingService.beans;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="USER_GROUP_MAP")
public class UserGroupPair {

    @Id
    @SequenceGenerator(name="USER_GROUP_MAP_ID_SEQ", sequenceName = "USER_GROUP_MAP_ID_SEQ",allocationSize=1)
    @GeneratedValue(strategy=SEQUENCE, generator="USER_GROUP_MAP_ID_SEQ")
    @Column(name="UG_ID")
    private Long id;

    @Column(name="U_ID")
    private Long uid;

    @Column(name="G_ID")
    private Long gid;

    public UserGroupPair() {
    }

    public UserGroupPair(long id, long uid, long gid) {
        this.id = id;
        this.uid = uid;
        this.gid = gid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }
}
