package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_login")
public class UserLogin {
	private String userEmail, userPassword;
	private UserRole user_role;
	private UserDetail user;

	public UserLogin() {
		System.out.println("inside userLogin const");
	}

	public UserLogin(String userEmail, String userPassword, UserRole user_role) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.user_role = user_role;
	}

	@Id
	@Column(name = "user_email", length = 50, unique = true, nullable = true)
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "user_password", length = 20)
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role", length = 20)
	public UserRole getUser_role() {
		return user_role;
	}

	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_id")
	public UserDetail getUser() {
		return user;
	}

	public void setUser(UserDetail user) {
		this.user = user;
	}
	
	@Override public String toString() { 
		return "UserLogin [userEmail=" + userEmail + ", userPassword=" + userPassword +
	 ", user_role=" + user_role +  "]"; } 

}
