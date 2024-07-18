package com.jyberion.mmorpg.loginserver.service;

import com.jyberion.mmorpg.loginserver.model.User;
import com.jyberion.mmorpg.loginserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) { // This should be a hashed password check
            return user;
        }
        return null;
    }
}
