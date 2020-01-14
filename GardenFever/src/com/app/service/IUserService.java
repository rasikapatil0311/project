package com.app.service;

import java.util.List;

import com.app.pojos.UserLogin;

public interface IUserService 
{
	List<UserLogin> getLogInUsers();
	UserLogin getUser(String email);
}
