package com.progrunners.fakturica.repository;

import com.progrunners.fakturica.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


}
