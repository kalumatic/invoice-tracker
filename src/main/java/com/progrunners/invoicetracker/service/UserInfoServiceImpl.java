package com.progrunners.invoicetracker.service;

import com.progrunners.invoicetracker.entity.UserInfo;
import com.progrunners.invoicetracker.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo findById(String username) {
        return userInfoRepository.findById(username).get();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }
}
