package com.progrunners.fakturica.service;

import com.progrunners.fakturica.entity.User;
import com.progrunners.fakturica.repository.UserRepository;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(String username) {
        return userRepository.findById(username).get();
    }
}
