package com.progrunners.fakturica.service;


import com.progrunners.fakturica.entity.UserInfo;

public interface UserInfoService {
    UserInfo findById(String username);

    void save(UserInfo userInfo);
}
