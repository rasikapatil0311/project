package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.UserDetail;
import com.app.pojos.UserLogin;
import com.app.service.IUserService;

@CrossOrigin//(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private IUserService service;
	
	@GetMapping("/login")
	public List<UserLogin> getUserLogin()
	{
		return service.getLogInUsers();
	}
	@PostMapping("/login")
	public String validateUser(@RequestBody UserLogin u)
	{
		System.out.println(u);
		UserLogin u1=service.getUser(u.getUserEmail());
		System.out.println(u1);
		if(u1!=null)
		{
			if(u1.getUserPassword().equals(u.getUserPassword()))
				return "login successfull";
		}
		return "login insuccessfull";
	}
	@PostMapping("/register")
	public String registerUser(@RequestBody UserDetail u/*,@RequestBody String email,@RequestBody String password*/)
	{
		System.out.println(u);
		return "";
	}
}
