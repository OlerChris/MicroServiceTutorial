package com.Revature.MessagingService.services;

import com.Revature.MessagingService.beans.Group;
import com.Revature.MessagingService.beans.UserGroupPair;
import com.Revature.MessagingService.repositories.GroupRepo;
import com.Revature.MessagingService.repositories.UserGroupPairRepo;
import com.sun.deploy.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepo repo;

    @Autowired
    private UserGroupPairRepo UGrepo;

    public Group create(Group persisted) {return repo.save(persisted);
    }

    public Long addUser(Long uid, Long gid) {
        UserGroupPair x = new UserGroupPair(uid, gid);
        UGrepo.save(x);
        return x.getUid();
    }

    public Group getGroup(Long gid) {
        return repo.findOne(gid);
    }

    public Long[] getGroups(Long uid) {
        List<UserGroupPair> gs = UGrepo.findByUid(uid);
        Object[] x = gs.stream()
                .filter(ugp -> ugp.getUid().longValue() == uid.longValue())
                .map(UserGroupPair::getGid)
                .toArray();
        return (Long[]) x;
    }
}
