package com.spring.boot.sportyshoes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserRegistered")
public class UserRegistered {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String fullName;
	private String password;
	private String address;
	private String cardType;
	private int cardNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public UserRegistered() {
		super();
	}
	public UserRegistered(int id, String username, String fullName, String password, String address, String cardType,
			int cardNumber) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.address = address;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
	}
	public UserRegistered(String username, String fullName, String password) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.password = password;
	}
	
	
	

	
}
