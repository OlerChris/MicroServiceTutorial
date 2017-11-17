package com.Revature.MessagingService.repositories;

import com.Revature.MessagingService.beans.UserGroupPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserGroupPairRepo extends JpaRepository<UserGroupPair,Integer> {
}
