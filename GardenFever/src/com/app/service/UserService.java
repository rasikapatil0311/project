package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.UserLogin;

@Service
@Transactional
public class UserService implements IUserService
{
	@Autowired
	private IUserDao dao;
	@Override
	public List<UserLogin> getLogInUsers() {
		return dao.getLogInUsers();
	}
	@Override
	public UserLogin getUser(String email) {
		return dao.getUser(email);
	}

}
