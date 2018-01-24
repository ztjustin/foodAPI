package com.foodAPI.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity(name="product")
public class Product implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id",nullable=false,unique=true,length=8)
	private Long productId;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="image",nullable=false)
	private byte[] image;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="price",nullable=false)
	private float price;
	
	
	@Column(name="state",nullable=false)
	private boolean state;
	
	
	public Product() {
		super();
	}
	
	public Product(Long productId, byte[] image, String name, float price, boolean state) {
		super();
		this.productId = productId;
		this.image = image;
		this.name = name;
		this.price = price;
		this.state = state;
	}
	
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}
	

	//return the string code
    public String getImageEncoded() {
    	byte[] encodeImage = Base64.getEncoder().encode(this.image);
        return new String(encodeImage);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + (state ? 1231 : 1237);
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
		Product other = (Product) obj;
		if (!Arrays.equals(image, other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (state != other.state)
			return false;
		return true;
	}
    
}
