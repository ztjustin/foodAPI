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
	private int phone;
	
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
	
	public Client(int phone, String name, String lastName, String city, String email, boolean guarantor,
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



	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (guarantor ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + phone;
		result = prime * result + points;
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
		Client other = (Client) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (guarantor != other.guarantor)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone != other.phone)
			return false;
		if (points != other.points)
			return false;
		if (state != other.state)
			return false;
		return true;
	}

}
