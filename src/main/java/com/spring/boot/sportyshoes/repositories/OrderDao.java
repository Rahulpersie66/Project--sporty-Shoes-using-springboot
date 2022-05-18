package com.spring.boot.sportyshoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.sportyshoes.entities.OrderedBooked;

@Repository
public interface OrderDao extends JpaRepository<OrderedBooked, Integer>{
//by deafult all method -- add-save,delete, findAll,findone are there
	
	//sorted by orderId in orederdTable
	List<OrderedBooked> findByOrderByOrderIdAsc();
	
	//for descending list mention DESC
	List<OrderedBooked> findByOrderByOrderIdDesc();
	
	//for ascending orderdate
	List<OrderedBooked> findByOrderByOrderDate();
	
	//for descending orderDate
	List<OrderedBooked> findByOrderByOrderDateDesc();
}
