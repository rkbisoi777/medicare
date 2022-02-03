package com.medicare.Medicare.service;

import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.entity.UserRole;

import java.util.Set;

public interface UserService {

    // create user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user
    public User getUser(String username);

    //update user
    public User updateUser(String username, User updatedUser) throws Exception;

    //delete user by id
    public void deleteUser(Long userId);


}
