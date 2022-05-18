package com.spring.boot.sportyshoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.sportyshoes.entities.UserRegistered;

@Repository
public interface UserDao extends JpaRepository<UserRegistered, Integer> {
//all by default methods are define here like add-->save, delete, findall, findone
}
