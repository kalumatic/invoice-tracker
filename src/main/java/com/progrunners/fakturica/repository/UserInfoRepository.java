package com.progrunners.fakturica.repository;

import com.progrunners.fakturica.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}
