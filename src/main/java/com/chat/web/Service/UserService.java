package com.chat.web.Service;

import com.chat.web.Entity.User;
import com.chat.web.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        // 检查用户名是否已经存在
        user.setRegistrationTime(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }

//    用于表示可能不存在的 User 对象
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
}
