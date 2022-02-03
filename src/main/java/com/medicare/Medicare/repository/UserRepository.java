package com.medicare.Medicare.repository;

import com.medicare.Medicare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);

}
