package com.Revature.AccountService.repositories;

import com.Revature.AccountService.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
