package com.progrunners.fakturica.service;


import com.progrunners.fakturica.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> findAll();

    UserInfo findById(String username);

    void save(UserInfo userInfo);
}
