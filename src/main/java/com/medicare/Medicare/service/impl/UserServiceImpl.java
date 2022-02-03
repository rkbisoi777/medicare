package com.medicare.Medicare.service.impl;

import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.entity.UserRole;
import com.medicare.Medicare.repository.RoleRepository;
import com.medicare.Medicare.repository.UserRepository;
import com.medicare.Medicare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local != null) {
            System.out.println("User is already there !!");
            throw new Exception("User already present !!");
        } else {
            // create user
            for(UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(String username, User updateUser) throws Exception {
        User user = this.userRepository.findByUsername(username);
        if(user == null) {
            System.out.println("User not found!! !!");
            throw new Exception("User not found !!");
        }else {
            user.setUsername(updateUser.getUsername());
            user.setFirstName(updateUser.getFirstName());
            user.setLastName(updateUser.getLastName());
            user.setEmail(updateUser.getEmail());
            user.setPassword(updateUser.getPassword());
            user.setPhone(updateUser.getPhone());
            user.setProfile(updateUser.getProfile());
            user = this.userRepository.save(user);
        }
        return user;
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
