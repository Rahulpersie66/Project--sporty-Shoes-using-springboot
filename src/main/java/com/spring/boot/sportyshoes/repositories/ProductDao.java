package com.spring.boot.sportyshoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.sportyshoes.entities.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
//all basic are added alread-- like add, findall, find one, delete
}
