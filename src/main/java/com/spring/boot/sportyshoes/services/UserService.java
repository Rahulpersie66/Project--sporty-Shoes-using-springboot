package com.spring.boot.sportyshoes.services;

import java.util.List;

import com.spring.boot.sportyshoes.entities.UserRegistered;

public interface UserService {

	//add the signUp details to UserRegistered table
	public boolean addUserSignUp(String username,String name, String password);
	
	//if userName available or not
	public boolean userNameAvailable(String username);
	
	//Check if username and password are correct and then provide him Signed In Screen and fetch fullname of user
	public String signIn(String username, String password);
	
	//return account details from the user
	public List<String> accountDetails(String username);
	
	//Update the account Details of the user using username
	public Boolean accountDetailsUpdate(String username,String address,String password,String card_type,int card_number);

	//list of all user signed up -- required by admin controller
	public List<String> allSignedUpUser();
	
	//search for the user by username is avialble in the databse of sportyshoes
	public Boolean searchUser(String username);
	
	//details of the user by userid
	public UserRegistered detailsUser(int userId);
}
