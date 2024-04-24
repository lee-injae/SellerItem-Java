package com.blit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username, password, city;
	private int birthyear; 
	
	public Seller() {}
	
	public Seller(Long id, String username, String password, String city, int birthyear) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.city = city;
		this.birthyear = birthyear;
	}
	
	public Seller(String username, String password, String city, int birthyear) {
		super();
		this.username = username;
		this.password = password;
		this.city = city;
		this.birthyear = birthyear;
	}
	
	



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthYear) {
		this.birthyear = birthYear;
	}
	
	
	
	
	
	
	

}
