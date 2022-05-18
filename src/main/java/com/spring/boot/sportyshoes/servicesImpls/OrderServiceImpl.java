package com.spring.boot.sportyshoes.servicesImpls;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.sportyshoes.entities.OrderedBooked;
import com.spring.boot.sportyshoes.entities.Product;
import com.spring.boot.sportyshoes.entities.UserRegistered;
import com.spring.boot.sportyshoes.repositories.OrderDao;
import com.spring.boot.sportyshoes.repositories.ProductDao;
import com.spring.boot.sportyshoes.repositories.UserDao;
import com.spring.boot.sportyshoes.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Boolean addOrder(int productId, int quantity,String username) {
		LocalDate localDate=LocalDate.now();
		LocalDate Date=LocalDate.parse("2021-05-14");
		Timestamp localDateTime=Timestamp.valueOf(Date.atTime(LocalTime.MIDNIGHT));
		Product pro=productDao.findById(productId).get();
		//search for user by uname
		UserRegistered userData=null;
		Set<UserRegistered> allUser=new LinkedHashSet<UserRegistered>(userDao.findAll());
		for(UserRegistered user:allUser)
			if(user.getUsername().equals(username))
				userData=user;
//		UserRegistered user=userDao.findById(userId).get();
		OrderedBooked order=new OrderedBooked(localDate,pro.getProductName(),pro.getProductID(),pro.getVendorName(),pro.getMrp(),quantity,quantity*pro.getMrp(),userData.getFullName(),userData.getAddress(),userData.getCardNumber(),userData.getCardType(),username,userData.getId());
		orderDao.save(order);
		//product quantity update in table -Product
		Product p=new Product(productId,pro.getProductName(),pro.getShoeType(),pro.getSize(),pro.getVendorName(),pro.getQuantity()-quantity,pro.getMrp());
		productDao.save(p);
		return true;
	}

	
	
	//to dispaly the ordered booked in purchase history of user
	@Override
	public List<OrderedBooked> purchaseHistory(String username) {
		List<OrderedBooked> allPurchase=new ArrayList<OrderedBooked>();
		List<OrderedBooked> purchase=new ArrayList<OrderedBooked>(orderDao.findAll());
		for(OrderedBooked order:purchase)
			if(username.equals(order.getUsername()))
				allPurchase.add(order);
		return allPurchase;
	}


	//Order by clause on orderId in OrderedBooked table --purchase history
	@Override
	public List<OrderedBooked> purcahseHistoryOrderByOrderId() {
		return orderDao.findByOrderByOrderIdAsc();
	}
	
	//Order by clause on orderId in OrderedBooked table --purchase history
	@Override
	public List<OrderedBooked> purcahseHistoryOrderByOrderIdDesc() {
		return orderDao.findByOrderByOrderIdDesc();
	}
	
	//Order by clause on orderId in OrderedBooked table --purchase history
	@Override
	public List<OrderedBooked> purcahseHistoryOrderByOrderDate() {
		return orderDao.findByOrderByOrderDate();
	}

	//Order by clause on orderId in OrderedBooked table --purchase history
	@Override
	public List<OrderedBooked> purcahseHistoryOrderByOrderDateDesc() {
		return orderDao.findByOrderByOrderDateDesc();
	}


	//view all order history by productId
	@Override
	public List<OrderedBooked> orderHistoryByProdId(int productId) {
		List<OrderedBooked> allPurchase=new ArrayList<OrderedBooked>();
		List<OrderedBooked> purchase=new ArrayList<OrderedBooked>(orderDao.findAll());
		for(OrderedBooked order:purchase)
			if(productId==order.getProdId())
				allPurchase.add(order);
		return allPurchase;
	}


	//view all order history by userId
	@Override
	public List<OrderedBooked> orderHistoryByUserId(int userId) {
		List<OrderedBooked> allPurchase=new ArrayList<OrderedBooked>();
		List<OrderedBooked> purchase=new ArrayList<OrderedBooked>(orderDao.findAll());
		for(OrderedBooked order:purchase)
			if(userId==order.getUserId())
				allPurchase.add(order);
		return allPurchase;
	}
	

}
