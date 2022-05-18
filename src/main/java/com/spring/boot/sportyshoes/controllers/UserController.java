package com.spring.boot.sportyshoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.sportyshoes.entities.OrderedBooked;
import com.spring.boot.sportyshoes.entities.Product;
import com.spring.boot.sportyshoes.entities.UserRegistered;
import com.spring.boot.sportyshoes.servicesImpls.OrderServiceImpl;
import com.spring.boot.sportyshoes.servicesImpls.ProductServiceImpl;
import com.spring.boot.sportyshoes.servicesImpls.UserServiceImpl;


@RestController
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	ProductServiceImpl productServiceImpl;
	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	//to display WELCOME menu at SportyShoes
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to SportyShoes Website!!!";
	}
	
	
	//add the UserSignUp details --> tb: UserRegistered
	@PostMapping("/signUp")
	public String addUserSignUp(@RequestBody UserRegistered user)
	{	if(userServiceImpl.userNameAvailable(user.getUsername()))
			return "UserName: "+user.getUsername()+" not available!! please try another username.";
		else
		{
		if(userServiceImpl.addUserSignUp(user.getUsername(), user.getFullName(), user.getPassword()))
			return "Congratulation!!! "+user.getFullName()+",you have successfully registered at SportyShoes.";
		else
			return "User :"+user.getFullName()+" not added to SportyShoes registration.";
		}
	}
	
	
	//signIn
	@GetMapping("/signIn/{username}/{password}")
	public String signIn(@PathVariable String username,@PathVariable String password)
	{	if(!userServiceImpl.signIn(username, password).equals("null"))
			return userServiceImpl.signIn(username, password) +". You are successfully signed In.";	
		//here userNAmeAvail method used for check if password is wrong but username correct
		else 
		{
			if(userServiceImpl.signIn(username, password).equals("null") && userServiceImpl.userNameAvailable(username))
				return "Your password is INCORRECT. I think you forget your password!!";
			else
				return "Please Register Yourself first!! Go to signUp page!!";
		}
		
	}
	
	
	//signedOut
	@GetMapping("/signOut")
	public String signOut() {
		return "Bie!! you r successfully Signed Out.";
	}
	
	
//	//add the product
//	@PostMapping("/addTheProduct")
//	public String addTheProduct(@RequestBody Product product)
//	{	if(productServiceImpl.addProduct(product))
//			return "Product added successfully";
//		else
//			return "some error occurred";
//	}
	
	//display the results of the list in the product
	@GetMapping("/signIn/showAllProducts")
	public List<Product> showAllProducts()
	{
		return productServiceImpl.getAllProducts();
	}
	
	
	//get one product by productId
	@GetMapping("/signIn/getOneProduct/{productId}")
	public Product getThatProduct(@PathVariable int productId)
	{
		return productServiceImpl.getOneProduct(productId);
	}
	
	//Product purchase by the productId and quantity suing method addOrder
	@PostMapping("/signIn/purchaseProduct/{productId}/{quantity}/{username}")
	public String productPurchased(@PathVariable int productId,@PathVariable int quantity,@PathVariable String username)
	{	if(orderServiceImpl.addOrder(productId, quantity,username))
			return "ordered is succefully placed.";
		else
			return "Failed placing ordered.";
	}
	
	
	//to display ACCount Details of the customer who is signed in
	@GetMapping("/signIn/accountDetails/{username}")
	public List<String> accountDetails(@PathVariable String username)
	{	
		return userServiceImpl.accountDetails(username);
	}
	
	//to display Purchase history of specfic user by userId
	@GetMapping("/signIn/purchaseHistory/{username}")
	public List<OrderedBooked> purchaseHistory(@PathVariable String username)
	{
		return orderServiceImpl.purchaseHistory(username);
	}
	
	//to edit USer account details using username in user_registered table
	@PutMapping("/signIn/editAccountDetails")
	public String editAccountDetails(@RequestBody UserRegistered user)
	{	if(userServiceImpl.accountDetailsUpdate(user.getUsername(), user.getAddress(), user.getPassword(), user.getCardType(), user.getCardNumber()))
			return "Your account has been updated mr./mrs. "+user.getUsername()+" .";
		else
			return "There's issue while updating...Check your network connection.";
	}
}
