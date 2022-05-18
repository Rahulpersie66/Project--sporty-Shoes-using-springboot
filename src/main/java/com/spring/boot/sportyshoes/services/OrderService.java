package com.spring.boot.sportyshoes.services;

import java.util.List;

import com.spring.boot.sportyshoes.entities.OrderedBooked;

public interface OrderService {

	//to add the Order details or Order Booking in table-- Order_Booked
	public Boolean addOrder(int productId,int quantity,String username);

	//to display the purchase History of the user
	public List<OrderedBooked> purchaseHistory(String username);
	
	//order by clause in asc on table orderedBooked
	public List<OrderedBooked> purcahseHistoryOrderByOrderId();

	//order by clause in desc on table orderedBooked
	public List<OrderedBooked> purcahseHistoryOrderByOrderIdDesc();
	
	//order by clause in asc on table orderedBooked--orderDate
	public List<OrderedBooked> purcahseHistoryOrderByOrderDate();
	
	//order by clause in desc on table orderedBooked--orderDate
	public List<OrderedBooked> purcahseHistoryOrderByOrderDateDesc();
	
	//list of order history by productId
	public List<OrderedBooked> orderHistoryByProdId(int productId);
	
	//list of order history by userId
	public List<OrderedBooked> orderHistoryByUserId(int userId);
}

