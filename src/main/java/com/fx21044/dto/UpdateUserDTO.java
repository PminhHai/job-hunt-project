package com.fx21044.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fx21044.annotation.ValidEmail;

public class UpdateUserDTO {
	
	private int id;
	
	@ValidEmail
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String email;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String fullName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String phoneNumber;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String description;
	
	public UpdateUserDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
}
