package com.Revature.MessagingService.repositories;

import com.Revature.MessagingService.beans.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface GroupRepo extends JpaRepository<Group,Long> {
}
