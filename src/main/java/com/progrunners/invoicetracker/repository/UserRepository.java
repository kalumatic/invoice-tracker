package com.progrunners.invoicetracker.repository;

import com.progrunners.invoicetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


}
