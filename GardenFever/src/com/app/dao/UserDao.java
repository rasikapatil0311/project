package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.UserLogin;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<UserLogin> getLogInUsers() 
	{	
		String jpql="select u from UserLogin u";
		return sf.getCurrentSession().createQuery(jpql, UserLogin.class).getResultList();
	}

	@Override
	public UserLogin getUser(String email) {
		
		return sf.getCurrentSession().get(UserLogin.class, email);
	}

}
