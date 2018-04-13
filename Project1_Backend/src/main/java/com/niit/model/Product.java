package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity  //mapped with Product relational table
@Table(name="product")
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@NotEmpty(message="ProductName cannot be blank(*)")
private String productname;
@NotEmpty(message="Product description is required(*)")
private String productdescription;
@Min(value=1,message="minimum quantity must be 1")
private int quantity;
@Min(value=1,message="minimum price must be 1")
private double price;
@ManyToOne
@JoinColumn(name="cid")
//FK category_id
private Category category;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getProductdescription() {
	return productdescription;
}
public void setProductdescription(String productdescription) {
	this.productdescription = productdescription;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
@Override
	public String toString() {
		return "[" + this.id + " " + this.productname + " " + this.productdescription + " " + this.price + " " + this.quantity + " ]";
	}
}






