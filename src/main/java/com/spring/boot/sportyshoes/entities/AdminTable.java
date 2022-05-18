package com.spring.boot.sportyshoes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin_Table")
public class AdminTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	private String adminUsername;
	private String password;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminTable(int adminId, String adminUsername, String password) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.password = password;
	}
	public AdminTable(String adminUsername, String password) {
		super();
		this.adminUsername = adminUsername;
		this.password = password;
	}
	public AdminTable() {
		super();
	}
	
	
}
