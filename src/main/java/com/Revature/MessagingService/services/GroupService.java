package com.Revature.MessagingService.services;

import com.Revature.MessagingService.beans.Group;
import com.Revature.MessagingService.beans.UserGroupPair;
import com.Revature.MessagingService.repositories.GroupRepo;
import com.Revature.MessagingService.repositories.UserGroupPairRepo;
import com.sun.deploy.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepo repo;

    @Autowired
    private UserGroupPairRepo UGrepo;

    public Group create(Group persisted) {return repo.save(persisted);
    }

    public Long addUser(Long uid, Long gid){
        UserGroupPair x = new UserGroupPair(0L, uid, gid);
        UGrepo.save(x);
        return x.getId();
    }

    public Group getGroup(String gName) {
        return repo.findByGroupName(gName);
    }

    public String[] getGroups(Long uid) {
        List<UserGroupPair> gs = UGrepo.findByUid(uid);
        return gs.stream()
                .filter(ugp -> ugp.getUid().longValue() == uid.longValue())
                .map(UserGroupPair::getGid)
                .map(gid -> repo.findOne(gid).getName())
                .toArray(String[]::new);
    }

    public Long[] getUsers(String gName) {
       Group g = repo.findByGroupName(gName);
       List<UserGroupPair> x = UGrepo.findAllByGid(g.getGroupId());
       return x.stream().map(UserGroupPair::getUid).toArray(Long[]::new);
    }
}
