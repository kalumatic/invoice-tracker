package com.progrunners.invoicetracker.repository;

import com.progrunners.invoicetracker.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}
