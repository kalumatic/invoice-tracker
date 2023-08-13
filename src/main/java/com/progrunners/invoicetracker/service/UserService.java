package com.progrunners.invoicetracker.service;

import com.progrunners.invoicetracker.entity.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findById(String username);

}
