package com.Revature.MessagingService.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="USER_GROUP_MAP")
public class UserGroupPair {

    @Column(name="U_ID")
    private Long uid;

    @Column(name="G_ID")
    private Long gid;

    public UserGroupPair() {
    }

    public UserGroupPair(long uid, long gid) {
        this.uid = uid;
        this.gid = gid;
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
