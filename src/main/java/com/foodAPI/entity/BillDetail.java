package com.foodAPI.entity;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="bill_detail")
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"bill_id" , "product_id"})}) //this does not let duplicate 
public class BillDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bill_detail_id",nullable=false,unique=true,length=8)
	private Long billDetailId;
	
	@JsonIgnore //this maens when try to serialize dont care about this entity and print
	@ManyToOne
	@JoinColumn(name = "bill_id")
	private Bill bill;
	
	// ignore the entity
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Basic
	@Column(name="unity")
	private int unity;
	
	
	@Basic
	@Column(name="price")
	private double price;


	public BillDetail() {
		super();
	}
	
	

	public BillDetail(Long billDetailId, Bill bill, Product product, int unity, double price) {
		super();
		this.billDetailId = billDetailId;
		this.bill = bill;
		this.product = product;
		this.unity = unity;
		this.price = price;
	}
	
	
	public Long getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(Long billDetailId) {
		this.billDetailId = billDetailId;
	}



	public Bill getBill() {
		return bill;
	}


	public void setBill(Bill bill) {
		this.bill = bill;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getUnity() {
		return unity;
	}


	public void setUnity(int unity) {
		this.unity = unity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bill == null) ? 0 : bill.hashCode());
		result = prime * result + ((billDetailId == null) ? 0 : billDetailId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + unity;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillDetail other = (BillDetail) obj;
		if (bill == null) {
			if (other.bill != null)
				return false;
		} else if (!bill.equals(other.bill))
			return false;
		if (billDetailId == null) {
			if (other.billDetailId != null)
				return false;
		} else if (!billDetailId.equals(other.billDetailId))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (unity != other.unity)
			return false;
		return true;
	}	
	
}