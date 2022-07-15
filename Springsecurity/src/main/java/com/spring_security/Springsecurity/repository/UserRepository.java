package com.spring_security.Springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_security.Springsecurity.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}