package com.app.dao;

import java.util.List;

import com.app.pojos.UserLogin;

public interface IUserDao
{
	List<UserLogin> getLogInUsers();
	UserLogin getUser(String email);
}
