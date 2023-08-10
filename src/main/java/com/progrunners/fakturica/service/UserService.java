package com.progrunners.fakturica.service;

import com.progrunners.fakturica.entity.User;

public interface UserService {

    User findById(String username);
}
