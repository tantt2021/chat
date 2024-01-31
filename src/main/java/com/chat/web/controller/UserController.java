package com.chat.web.controller;

import com.chat.web.Entity.User;
import com.chat.web.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        System.out.println("收到的参数："+user.toString());
        return userService.addUser(user);
    }

    @PostMapping("/findOne")
    public Optional<User> getUserById(@RequestBody Map<String, Long> userIdMap){
        Long userId = userIdMap.get("userId");
        System.out.println("收到的参数："+userId);
        Optional<User> userOptional = userService.getUserById(userId);
        return userOptional;
    }
}
