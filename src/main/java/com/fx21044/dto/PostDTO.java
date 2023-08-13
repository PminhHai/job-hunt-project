package com.fx21044.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PostDTO {
	@NotNull(message = "title is empty")
	@Size(min = 1,message = "title is required")
	private String title;
	@NotNull(message = "description is empty")
	@Size(min = 1,message = "description is required")
	private String description;
	@NotNull(message = "experience is empty")
	@Size(message = "experience is required")
	private String experience;
	@NotNull(message = "number Of Recruit is empty")
	@Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="number Of Recruit must be a positive number")
	@Size(min = 1,message = "number is required")
	private String numberOfRecruit;
	@NotNull(message = "date is empty")
	@Size(min = 1,message = "date is required")
	private String expireDate;
	@NotNull(message = "salary is empty")
	@Size(min = 1,message = "salary is required")
	private String salary;
	@NotNull(message = "location is empty")
	@Size(min = 1,message = "location is required")
	private String location;
	@NotNull(message = "jobtype is not suitable ")
	@Min(value = 0)
	private int jobTypeId;
	@NotNull(message = "category is not suitable")
	@Min(value = 0)
	private int categoryId;
	 
	public PostDTO() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getNumberOfRecruit() {
		return numberOfRecruit;
	}

	public void setNumberOfRecruit(String numberOfRecruit) {
		this.numberOfRecruit = numberOfRecruit;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getJobTypeId() {
		return jobTypeId;
	}

	public void setJobTypeId(int jobTypeId) {
		this.jobTypeId = jobTypeId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	 
	 
}
