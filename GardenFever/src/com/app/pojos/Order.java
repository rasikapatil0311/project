package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Order 
{
	private Integer orderId;
	private UserDetail customer;
	private UserDetail orderTeam;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	private List<OrderDetail> orderDetails=new ArrayList<>();
	public Order() {
		System.out.println("inside orders const");
	}
	public Order(Date orderDate) {
		super();
		this.orderDate = orderDate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne  
	@JoinColumn(name = "customer_id")
	public UserDetail getCustomer() {
		return customer;
	}
	
	public void setCustomer(UserDetail customer) {
		this.customer = customer;
	}
	 
	@ManyToOne
	@JoinColumn(name = "order_team_id")
	public UserDetail getOrderTeam() {
		return orderTeam;
	}
	public void setOrderTeam(UserDetail orderTeam) {
		this.orderTeam = orderTeam;
	}
	@Temporal(TemporalType.DATE)
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	@Override
	public String toString() {
		return "Orders [orderDate=" + orderDate + "]";
	}
	
}
