package com.Revature.MessagingService.dataTransferObjects;

import com.Revature.MessagingService.beans.Group;

public class GroupDTO {

    private long groupId;
    private long owner;
    private boolean publicAccess;

    public GroupDTO() {}

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

    public Group convertToGroup(){
        Group g = new Group(
                this.groupId,
                this.owner,
                this.publicAccess);
        return g;
    }

    public static GroupDTO getDTO(Group g){
        GroupDTO x = new GroupDTO();
        x.groupId = g.getGroupId();
        x.owner = g.getOwner();
        x.publicAccess = g.isPublicAccess();
        return x;
    }
}
