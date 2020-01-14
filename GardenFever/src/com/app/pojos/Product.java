package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product")
public class Product {
	private Integer productId;
	private String productName;
	private ProductCategory productCategory;
	private String productDesc;
	private double productPrice;
	private byte[] productImage;
	private int productStock;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date productUpdated;
	//private List<OrderDetail> orderDetail=new ArrayList<>();
	
	public Product() {
		System.out.println("inside product const");
	}

	public Product(String productName, ProductCategory productCategory, String productDesc,
			double productPrice, int productStock, Date productUpdated) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productUpdated = productUpdated;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	@Column(name = "product_name",length = 30)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "product_category",length = 10)
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	@Column(name = "product_description",length = 100)
	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	@Column(name = "product_price")
	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Lob
	@Column(name = "product_image")
	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	@Column(name = "product_stock")
	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "product_updated")
	public Date getProductUpdated() {
		return productUpdated;
	}

	public void setProductUpdated(Date productUpdated) {
		this.productUpdated = productUpdated;
	}
	
	/*
	 * @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Employee_Project", 
        joinColumns = { @JoinColumn(name = "employee_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
	 */
	/*
	 * @ManyToMany(cascade = CascadeType.ALL) public List<OrderDetail>
	 * getOrderDetail() { return orderDetail; } public void
	 * setOrderDetail(List<OrderDetail> orderDetail) { this.orderDetail =
	 * orderDetail; }
	 */

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productDesc=" + productDesc + ", productPrice=" + productPrice
			    + ", productStock=" + productStock
				+ ", productUpdated=" + productUpdated + "]";
	}
	
}
