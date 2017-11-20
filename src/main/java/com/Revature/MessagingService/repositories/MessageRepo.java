package com.Revature.MessagingService.repositories;

import com.Revature.MessagingService.beans.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface MessageRepo extends JpaRepository<Message,Long> {
}
