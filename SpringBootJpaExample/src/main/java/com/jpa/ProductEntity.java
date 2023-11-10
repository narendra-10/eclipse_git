package com.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false,nullable = false)
	int product_id;
	@Column(length = 40)
	String product_name;
	@Column(length = 40)
	String description;
	
	public int getProduct_id() 
	{
		return product_id;
	}
	public void setProduct_id(int product_id) 
	{
		this.product_id = product_id;
	}
	public String getProduct_name() 
	{
		return product_name;
	}
	public void setProduct_name(String product_name) 
	{
		this.product_name = product_name;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
}