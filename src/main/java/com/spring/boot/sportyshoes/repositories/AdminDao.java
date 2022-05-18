package com.spring.boot.sportyshoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.sportyshoes.entities.AdminTable;

@Repository
public interface AdminDao extends JpaRepository<AdminTable, Integer> {
//default functions like add-->save, delete,findall,find byid
}
