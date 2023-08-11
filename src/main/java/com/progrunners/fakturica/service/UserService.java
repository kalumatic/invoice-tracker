package com.progrunners.fakturica.service;

import com.progrunners.fakturica.entity.Invoice;
import com.progrunners.fakturica.entity.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findById(String username);

}
