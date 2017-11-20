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
        return repo.fingByName(gName);
    }

    public String[] getGroups(Long uid) {
        List<UserGroupPair> gs = UGrepo.findByUid(uid);
        Object[] x = gs.stream()
                .filter(ugp -> ugp.getUid().longValue() == uid.longValue())
                .map(UserGroupPair::getGid)
                .toArray();
        Long[] x2 = (Long[]) x;
        ArrayList<String> y = new ArrayList<>();
        for ( Long id : x2){
            y.add(repo.findOne(id).getName());
        }
        String[] y2 = (String[]) y.toArray();
        return y2;
    }
}
