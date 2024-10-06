package com.dev.ict.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.ict.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
 }
