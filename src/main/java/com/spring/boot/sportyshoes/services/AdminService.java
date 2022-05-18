package com.spring.boot.sportyshoes.services;

import com.spring.boot.sportyshoes.entities.AdminTable;

public interface AdminService {
	
	//sign in the admin and search if is admin
	public Boolean signInAdmin(String adminName,String password);
	
	//if admin name is correct
	public Boolean checkAdminName(String adminName,String password);
	
	//add admin in the table-- AdminTable
	public AdminTable addAdmin(String adminName,String password);
	
	//to change the password of admin using - adminname
	public Boolean changePassword(String adminName, String password);
}
