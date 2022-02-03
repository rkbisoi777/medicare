package com.medicare.Medicare.controller;

import com.medicare.Medicare.entity.Role;
import com.medicare.Medicare.entity.User;
import com.medicare.Medicare.entity.UserRole;
import com.medicare.Medicare.entity.medicare.Cart;
import com.medicare.Medicare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test")
    public String test(){
        return "Welcome to backend api of Medicare";
    }

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        //encoding password with bcryptpasswordencoder
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        Cart cart = new Cart();
//        user.setCart(cart);
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("normal");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return this.userService.createUser(user,roles);
    }

    //update user
    @PostMapping("/{username}")
    public User updateUser(@PathVariable("username") String username, @RequestBody User user) throws Exception {
        return this.userService.updateUser(username,user);
    }

    //get user by username
    @GetMapping("/{username}")
    public User getUSer(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    //delete user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }


}
