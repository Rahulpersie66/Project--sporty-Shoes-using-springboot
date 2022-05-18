package com.spring.boot.sportyshoes.servicesImpls;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.sportyshoes.entities.AdminTable;
import com.spring.boot.sportyshoes.repositories.AdminDao;
import com.spring.boot.sportyshoes.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	
	
	//Check if Admin is valid or not
	@Override
	public Boolean signInAdmin(String adminName, String password) {
		boolean flag=false;
		Set<AdminTable> allAdmins=new LinkedHashSet<AdminTable>(adminDao.findAll());
		for(AdminTable admin:allAdmins)
			if(admin.getAdminUsername().equals(adminName) && admin.getPassword().equals(password))
				flag=true;
		return flag;
	}


	//check adminName is Right
	@Override
	public Boolean checkAdminName(String adminName, String password) {
		boolean flag=false;
		Set<AdminTable> allAdmins=new LinkedHashSet<AdminTable>(adminDao.findAll());
		for(AdminTable admin:allAdmins)
			if(admin.getAdminUsername().equals(adminName))
				flag=true;
		return flag;
	}


	//add the admin details in admin Table
	@Override
	public AdminTable addAdmin(String adminName, String password) {
		AdminTable admin=new AdminTable(adminName,password);
		adminDao.save(admin);
		return admin;
	}

	//to change the password using adminName 
	@Override
	public Boolean changePassword(String adminName, String password) {
		boolean flag=false;
		Set<AdminTable> allAdmins=new LinkedHashSet<AdminTable>(adminDao.findAll());
		
		for(AdminTable admin:allAdmins)
			if(admin.getAdminUsername().equals(adminName))
			{
				AdminTable newAdmin=new AdminTable(admin.getAdminId(),admin.getAdminUsername(),password);
				adminDao.save(newAdmin);
				flag=true;
			}
		
		return flag;
	}
	
	
	
	

}
