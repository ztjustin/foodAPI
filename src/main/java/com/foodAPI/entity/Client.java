package com.foodAPI.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="client")
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="phone",nullable=false,unique=true,length=8)
	private Long phone;
	
	@Column(name="name",nullable=false,length=45)
	private String name;
	
	@Column(name="lastname",nullable=false,length=45)
	private String lastName;
	
	@Column(name="city",nullable=false,length=45)
	private String city;
		
	@Column(name="email",nullable=false)
	private String email;
	
	@Column(name="guarantor",nullable=false)
	private boolean guarantor;
	
	@Column(name="password",nullable=false,length=60)
	private String password;
	
	@Column(name="points",nullable=false,length=60)
	private int points;
	
	@Column(name="state",nullable=false)
	private boolean state;
	

	public Client() {
		super();
	}
	
	public Client(Long phone, String name, String lastName, String city, String email, boolean guarantor,
			String password, int points, boolean state) {
		super();
		this.phone = phone;
		this.name = name;
		this.lastName = lastName;
		this.city = city;
		this.email = email;
		this.guarantor = guarantor;
		this.password = password;
		this.points = points;
		this.state = state;
	}



	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isGuarantor() {
		return guarantor;
	}

	public void setGuarantor(boolean guarantor) {
		this.guarantor = guarantor;
	}

}
