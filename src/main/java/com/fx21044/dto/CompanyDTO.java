package com.fx21044.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fx21044.annotation.ValidEmail;

public class CompanyDTO {
	
	private int id;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String name;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String address;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String phoneNumber;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@ValidEmail
	private String email;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String description;

	public CompanyDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
