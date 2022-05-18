package com.spring.boot.sportyshoes.servicesImpls;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.sportyshoes.entities.UserRegistered;
import com.spring.boot.sportyshoes.repositories.UserDao;
import com.spring.boot.sportyshoes.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	//add the SignUp user details in the table UserRegistered in the Database
	@Override
	public boolean addUserSignUp(String username, String name, String password) {
		Boolean flag=false;
			UserRegistered user=new UserRegistered(username, name, password);
			userDao.save(user);
			flag=true;
		return flag;
	}

	//check if userName available or NOT
	@Override
	public boolean userNameAvailable(String username) {
		Boolean flag=false;
		Set<UserRegistered> usernames=new LinkedHashSet<UserRegistered>(userDao.findAll());
		for(UserRegistered user:usernames)
			if(user.getUsername().equals(username))
				flag=true;
		return flag;
	}

	
	//Check username and password coorect if correct then signed in 
	@Override
	public String signIn(String username, String password) {
		String fullName="null";
		Set<UserRegistered> users=new LinkedHashSet<UserRegistered>(userDao.findAll());
		for(UserRegistered user:users)
			if(user.getUsername().equals(username) && user.getPassword().equals(password))
				fullName=user.getFullName();
		return fullName;
	}

	
	//return Account details
	@Override
	public List<String> accountDetails(String username) {
		List<String> accDetails=new ArrayList<>();
		List<UserRegistered> lists=new ArrayList<UserRegistered>(userDao.findAll());
		for(UserRegistered user:lists)
			if(user.getUsername().equals(username))
			{
				accDetails.add("Address: "+user.getAddress());
				accDetails.add("Card Type: "+user.getCardType());
				accDetails.add("Card Number: "+user.getCardNumber());
				
			}
		return accDetails;
	}

	
	//update the account details using username
	@Override
	public Boolean accountDetailsUpdate(String username, String address, String password, String card_type,
			int card_number) {
		boolean flag=false;
		int userId;String fullName;
		Set<UserRegistered> listUser=new LinkedHashSet<UserRegistered>(userDao.findAll());
		for(UserRegistered userOld:listUser)
			if(userOld.getUsername().equals(username))
				{userId=userOld.getId();
				fullName=userOld.getFullName();
				UserRegistered userUpdate=new UserRegistered(userId,username,fullName,password,address,card_type,card_number);
				userDao.save(userUpdate);
				}
		flag=true;
		return flag;
	}

	
	//list of all signed up user required by admin controller
	@Override
	public List<String> allSignedUpUser() {
		List<String> allUser=new ArrayList<String>();
		Set<UserRegistered> regUser=new LinkedHashSet<UserRegistered>(userDao.findAll());
		for(UserRegistered user:regUser)
				allUser.add("User name: "+user.getUsername() +" -- "+"Full Name: "+user.getFullName() );
		return allUser;
	}

	//search if user is found in the UserRegistered table
	@Override
	public Boolean searchUser(String username) {
		boolean flag=false;
		Set<UserRegistered> regUser=new LinkedHashSet<UserRegistered>(userDao.findAll());
		for(UserRegistered user:regUser)
			if(user.getUsername().equals(username))
				flag=true;
		return flag;
	}

	
	//all deatils of user by userId
	@Override
	public UserRegistered detailsUser(int userId) {
		UserRegistered user=userDao.findById(userId).get();
		return user;
	}




}
