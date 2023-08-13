package com.fx21044.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "experience")
	private String experience;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "number_of_recruit")
	private int numberOfRecruit;
	
	@Column(name = "salary")
	private String salary;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "createdDate")
	@CreationTimestamp
	private Date createdDate;
	
	@Column(name = "expire_date")
	private Date expireDate;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "company_id")
	private Company company;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "job_type_id")
	private JobType jobType;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ApplyPost> applyPosts;

	public Post() {
		super();
	}

	public Post(int id, String title, String experience, String description, int numberOfRecruit, String salary,
			String location, Date createdDate, Date expireDate, User user, Category category, Company company,
			JobType jobType, List<ApplyPost> applyPosts) {
		super();
		this.id = id;
		this.title = title;
		this.experience = experience;
		this.description = description;
		this.numberOfRecruit = numberOfRecruit;
		this.salary = salary;
		this.location = location;
		this.createdDate = createdDate;
		this.expireDate = expireDate;
		this.user = user;
		this.category = category;
		this.company = company;
		this.jobType = jobType;
		this.applyPosts = applyPosts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfRecruit() {
		return numberOfRecruit;
	}

	public void setNumberOfRecruit(int numberOfRecruit) {
		this.numberOfRecruit = numberOfRecruit;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public List<ApplyPost> getApplyPosts() {
		return applyPosts;
	}

	public void setApplyPosts(List<ApplyPost> applyPosts) {
		this.applyPosts = applyPosts;
	}
	
	public int getStatus(String username) {
		for(ApplyPost applyPost:applyPosts) {
			if(applyPost.getUser().getUserName().equals(username))
			{
				return applyPost.getStatus();
			}
		}
		
		return 4;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", experience=" + experience + ", description=" + description
				+ ", numberOfRecruit=" + numberOfRecruit + ", salary=" + salary + ", createdDate=" + createdDate
				+ ", expireDate=" + expireDate + ", user=" + user + ", category=" + category + ", company=" + company
				+ ", jobType=" + jobType + ", applyPosts=" + applyPosts + "]";
	}
	
	
}
