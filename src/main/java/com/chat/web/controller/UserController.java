package com.chat.web.controller;

import com.chat.utils.ApiResponse;
import com.chat.web.Entity.User;
import com.chat.web.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @PostMapping(value="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse addUser(@RequestBody User user){
        System.out.println("添加用户，收到的参数："+user.toString());
        User res = userService.addUser(user);

        ApiResponse<User> response = new ApiResponse<User>(0, "success", res);
        return response;
    }

    @PostMapping("/findOne")
    public Optional<User> getUserById(@RequestBody Map<String, Long> userIdMap){
        Long userId = userIdMap.get("userId");
        System.out.println("查找用户，收到的参数："+userId);
        Optional<User> userOptional = userService.getUserById(userId);
        return userOptional;
    }


    @PostMapping("/delete")
    public void deleteUser(@RequestBody Map<String,Long> userIdMap){
        // 直接删除数据，删除可以使用另一种方式：用一个状态字段表示用户当前的有效性
        Long userId = userIdMap.get("userId");
        System.out.println("删除用户，参数userId:"+userId);
        userService.deleteUser(userId);
    }

    @PostMapping("/update")
    public User updateById(@RequestBody User updateUser){
        System.out.println("更新用户信息："+updateUser.toString());
        Optional<User> existingUserOptional = userService.getUserById(updateUser.getUserId());


        if(existingUserOptional.isPresent()){
//            // 用户存在
            User existingUser = existingUserOptional.get();

            if (updateUser.getGender() != null) {
                existingUser.setGender(updateUser.getGender());
            }
            return userService.updateUser(existingUser,updateUser);
////            BeanUtils.copyProperties(updateUser,existingUser);
//            System.out.println(updateUser.toString() +"\n"+ existingUserOptional.toString());
//
////            User savedUser = userService.updateUser(existingUser);
//            return null;
        }
//        else{
//            return null;
//        }
        return null;

    }
}
