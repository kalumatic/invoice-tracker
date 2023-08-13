package com.progrunners.invoicetracker.service;


import com.progrunners.invoicetracker.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> findAll();

    UserInfo findById(String username);

    void save(UserInfo userInfo);
}
