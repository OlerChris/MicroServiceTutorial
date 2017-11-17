package com.Revature.MessagingService.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="USER_GROUP_MAP")
public class UserGroupPair {

    @Column(name="U_ID")
    private long uid;

    @Column(name="G_ID")
    private long gid;

    public UserGroupPair() {
    }

    public UserGroupPair(long uid, long gid) {
        this.uid = uid;
        this.gid = gid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }
}
