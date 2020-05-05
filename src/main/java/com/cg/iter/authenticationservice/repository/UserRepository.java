package com.cg.iter.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.iter.authenticationservice.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
