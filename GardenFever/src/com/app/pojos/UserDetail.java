package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetail 
{
	private Integer userId;
	private String userFname,userLname,userPhone;
	private String userCity,userState,userCountry,userZip;
	private String userAddressLine1,userAddressLine2;
	private UserLogin userLogin;
	private List<Order> customerOrders=new ArrayList<>();
	private List<Order> orderTeamOrders=new ArrayList<>();
	
	public UserDetail() {
		System.out.println("inside user details const");
	}
	
	public UserDetail( String userFname, String userLname,
			String userPhone, String userCity, String userState, String userCountry, String userZip,
			String userAddressLine1, String userAddressLine2) {
		super();
		this.userFname = userFname;
		this.userLname = userLname;
		this.userPhone = userPhone;
		this.userCity = userCity;
		this.userState = userState;
		this.userCountry = userCountry;
		this.userZip = userZip;
		this.userAddressLine1 = userAddressLine1;
		this.userAddressLine2 = userAddressLine2;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "user_fname",length = 30,nullable = true)
	public String getUserFname() {
		return userFname;
	}
	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}
	
	@Column(name = "user_lname",length = 20)
	public String getUserLname() {
		return userLname;
	}
	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}
	
	@Column(name = "user_phone",length = 10)
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	@Column(name = "user_city",length = 30)
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	
	@Column(name = "user_state",length = 30)
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	
	@Column(name = "user_country",length = 20)
	public String getUserCountry() {
		return userCountry;
	}
	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
	
	@Column(name = "user_zip",length = 20)
	public String getUserZip() {
		return userZip;
	}
	public void setUserZip(String userZip) {
		this.userZip = userZip;
	}
	
	@Column(name = "user_addressline1",length = 50)
	public String getUserAddressLine1() {
		return userAddressLine1;
	}
	public void setUserAddressLine1(String userAddressLine1) {
		this.userAddressLine1 = userAddressLine1;
	}
	
	@Column(name = "user_addressline2",length = 50)
	public String getUserAddressLine2() {
		return userAddressLine2;
	}
	public void setUserAddressLine2(String userAddressLine2) {
		this.userAddressLine2 = userAddressLine2;
	}
	
	@OneToOne(mappedBy = "user") //
	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	public List<Order> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<Order> customerOrders) {
		this.customerOrders = customerOrders;
	}

	@OneToMany(mappedBy = "orderTeam",cascade = CascadeType.ALL)
	public List<Order> getOrderTeamOrders() {
		return orderTeamOrders;
	}

	public void setOrderTeamOrders(List<Order> orderTeamOrders) {
		this.orderTeamOrders = orderTeamOrders;
	}

	@Override public String toString() { 
		return "UserDetails [userId=" + userId + ", userFname=" + userFname + ", userLname=" + userLname
				+ ", userPhone=" + userPhone + ", userCity=" + userCity + ", userState=" + userState + ", userCountry="
				+ userCountry + ", userZip=" + userZip + ", userAddressLine1=" + userAddressLine1
				+ ", userAddressLine2=" + userAddressLine2 + "]";
		  }
	 
	
}
