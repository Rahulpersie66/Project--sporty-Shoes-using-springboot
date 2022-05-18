package com.spring.boot.sportyshoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.sportyshoes.entities.AdminTable;
import com.spring.boot.sportyshoes.entities.OrderedBooked;
import com.spring.boot.sportyshoes.entities.Product;
import com.spring.boot.sportyshoes.entities.UserRegistered;
import com.spring.boot.sportyshoes.servicesImpls.AdminServiceImpl;
import com.spring.boot.sportyshoes.servicesImpls.OrderServiceImpl;
import com.spring.boot.sportyshoes.servicesImpls.ProductServiceImpl;
import com.spring.boot.sportyshoes.servicesImpls.UserServiceImpl;

@RestController
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
		//to signIn user admin -- if admin is valid Admin
		@GetMapping("/auth/signIn/{adminname}/{password}")
		public String signInAdmin(@PathVariable String adminname,@PathVariable String password)
		{
			if(adminServiceImpl.signInAdmin(adminname, password))
				return "You are valid ADMIN- "+adminname+" !! Welcome to Admin page.";
			else if(adminServiceImpl.checkAdminName(adminname, password))
				return "Admin your password is wrong!!";
			else
				return "Not a valid admin";
		}
		
		//add the admin details
		@PostMapping("/auth/addAdmin/{adminname}/{password}")
		public AdminTable addAdmin(@PathVariable String adminname,@PathVariable String password) {
			return adminServiceImpl.addAdmin(adminname, password);
		}
		
		//to signout the adminFunctions
		@GetMapping("/admin/signOut")
		public String adminSignOut()
		{
			return "Admin is succesfully Signed Out.";
		}
		
		
		//to change admin password by taking adminname as arguments
		@PutMapping("/admin/changePassword/{adminName}/{password}")
		public String changePassword(@PathVariable String adminName,@PathVariable String password)
		{	if(adminServiceImpl.changePassword(adminName, password))
				return adminName+" , your password has been sucessfully changed to "+ password;
		else
			return "Issue in the network cannot change the password";
		}
		
		//View list of all the user that are sugned up
		@GetMapping("/admin/allSignedUpUser")
		public List<String> allSignedUpUser()
		{
			return userServiceImpl.allSignedUpUser();
		}
		
		//Username is user avilable or not in databse
		@GetMapping("/admin/searchUser/{username}")
		public String searchUser(@PathVariable String username)
		{	if(userServiceImpl.searchUser(username))
				return username+" found is registered on the SportyShoes!!";
			else
				return "No such user exists in the SportyShoes!!";
		}
		
		
		//View the details of user by userId from table-- UserRegistered
		@GetMapping("/admin/detailsOfUser/{userId}")
		public UserRegistered detailsOfUser(@PathVariable int userId)
		{
			return userServiceImpl.detailsUser(userId);
		}
		
		//List of all products name in the Product table
		@GetMapping("/admin/allProducts")
		public List<String> allProducts()
		{
			return productServiceImpl.viewAllProducts();
		}
		
		//Add a new product in the product table
		@PostMapping("/admin/addProduct")
		public String addTheProduct(@RequestBody Product product)
		{	if(productServiceImpl.addProduct(product))
				return "Product added successfully";
			else
				return "some error occurred";
		}
		
		//view details of product by ProductId
		@GetMapping("/admin/showProductDetails/{productId}")
		public Product showProductDetails(@PathVariable int productId)
		{
			return productServiceImpl.showProductDetails(productId);
		}
		
		//update the name of product using product id
		@PutMapping("/admin/updateProductName/{productId}/{productName}")
		public String updateProductName(@PathVariable int productId,@PathVariable String productName)
		{	if(productServiceImpl.updateProductName(productId, productName))
				return "product name of productId: "+productId+" is updated to: "+productName;
			else
				return "Some issue occured , product not updated.";
		}
		
		//update the MSRP of product using product id
		@PutMapping("/admin/updateProductMSRP/{productId}/{msrp}")
		public String updateProductMsrp(@PathVariable int productId,@PathVariable double msrp)
		{	if(productServiceImpl.updateProductMsrp(productId, msrp))
				return "Product MSRP of productId: "+productId+" is updated to: "+msrp;
			else
				return "Some issue occured , product not updated.";
		}
		
		//update the QuantityInStock of product using product id
		@PutMapping("/admin/updateProductQuantityInStock/{productId}/{quantity}")
		public String updateProductQuantityInStock(@PathVariable int productId,@PathVariable int quantity)
		{	if(productServiceImpl.updateProductQuantityInStock(productId, quantity))
				return "Product Quantity in Stock  of productId: "+productId+" is updated to: "+quantity;
			else
				return "Some issue occured , product not updated.";
		}
		
		//update the VenodorName of product using product id
		@PutMapping("/admin/updateProductVendorName/{productId}/{vendorName}")
		public String updateProductVendorName(@PathVariable int productId, @PathVariable String vendorName)
		{	if(productServiceImpl.updateProductVendorName(productId, vendorName))
				return "Product Vendor name of productId: "+productId+" is updated to: "+vendorName;
			else
				return "Some issue occured , product not updated.";
		}
		
		//to delete the product item using productId
		@DeleteMapping("/admin/deleteProduct/{productId}")
		public String deleteProduct(@PathVariable int productId) {
			if(productServiceImpl.deleteProduct(productId))
				return "Product item deleted succesfully!!";
			else
				return "delete of product was unsuccesful";
		}
		
		//View the list of all orders(history purcase) order by orderId asc
		@GetMapping("/admin/orderHistoryAsc")
		public List<OrderedBooked> purchasedHistoryOrderByOrderId()
		{
			return orderServiceImpl.purcahseHistoryOrderByOrderId();
		}
		
		//View the list of all orders(history purcase) order by orderId asc
		@GetMapping("/admin/orderHistoryDesc")
		public List<OrderedBooked> purchasedHistoryOrderByOrderIdDesc()
		{
			return orderServiceImpl.purcahseHistoryOrderByOrderIdDesc();
		}
		
		//View the list of all orders(history purcase) order by orderId asc
		@GetMapping("/admin/orderHistoryOrderDateAsc")
		public List<OrderedBooked> purchasedHistoryOrderByOrderDate()
		{
			return orderServiceImpl.purcahseHistoryOrderByOrderDate();
		}
		
		//View the list of all orders(history purcase) order by orderId asc
		@GetMapping("/admin/orderHistoryOrderDateDesc")
		public List<OrderedBooked> purchasedHistoryOrderByOrderDateDesc()
		{
			return orderServiceImpl.purcahseHistoryOrderByOrderDateDesc();
		}
		
		//view all orders using product pid
		@GetMapping("/admin/orderHistory/productId/{productId}")
		public List<OrderedBooked> orderHistoryByProdId(@PathVariable int productId){
			return orderServiceImpl.orderHistoryByProdId(productId);
		}
		
		//view all orders using userId
		@GetMapping("/admin/orderHistory/userId/{userId}")
		public List<OrderedBooked> orderHistoryByUserId(@PathVariable int userId){
			return orderServiceImpl.orderHistoryByUserId(userId);
		}


}
