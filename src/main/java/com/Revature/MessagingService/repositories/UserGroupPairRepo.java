package com.Revature.MessagingService.repositories;

import com.Revature.MessagingService.beans.UserGroupPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserGroupPairRepo extends JpaRepository<UserGroupPair,Long> {

    List<UserGroupPair> findByUid(Long uid);

    List<UserGroupPair> findAllByGid(Long gid);
}
