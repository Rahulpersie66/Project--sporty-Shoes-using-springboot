package com.spring.boot.sportyshoes.entities;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ordered_Booked")
public class OrderedBooked {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private LocalDate orderDate;
	private String prodName;
	private int prodId;
	private String vendorName;
	private double pricePerPiece;
	private int quantityOrder;
	private double totalAmount;
	private String customerName;
	private String address;
	private long cardNumber;
	private String cardType;
	private String username;
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public double getPricePerPiece() {
		return pricePerPiece;
	}
	public void setPricePerPiece(double pricePerPiece) {
		this.pricePerPiece = pricePerPiece;
	}
	public int getQuantityOrder() {
		return quantityOrder;
	}
	public void setQuantityOrder(int quantityOrder) {
		this.quantityOrder = quantityOrder;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public OrderedBooked() {
		super();
	}
	
	
	public OrderedBooked(LocalDate orderDate, String prodName, int prodId, String vendorName, double pricePerPiece,
			int quantityOrder, double totalAmount, String customerName, String address, long cardNumber,
			String cardType,String username,int userId) {
		super();
		this.orderDate = orderDate;
		this.prodName = prodName;
		this.prodId = prodId;
		this.vendorName = vendorName;
		this.pricePerPiece = pricePerPiece;
		this.quantityOrder = quantityOrder;
		this.totalAmount = totalAmount;
		this.customerName = customerName;
		this.address = address;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.username=username;
		this.userId=userId;
	}
	public OrderedBooked(int orderId, LocalDate orderDate, String prodName, int prodId, String vendorName,
			double pricePerPiece, int quantityOrder, double totalAmount, String customerName, String address,
			long cardNumber, String cardType,String username,int userId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.prodName = prodName;
		this.prodId = prodId;
		this.vendorName = vendorName;
		this.pricePerPiece = pricePerPiece;
		this.quantityOrder = quantityOrder;
		this.totalAmount = totalAmount;
		this.customerName = customerName;
		this.address = address;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.username=username;
		this.userId=userId;
		
	}
	
	
	
	
	
	
}
