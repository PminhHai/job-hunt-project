package com.fx21044.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "type_job")
public class JobType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "createdDate")
	@CreationTimestamp
	private Date createdDate;
	
	@OneToMany(mappedBy = "jobType", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
										CascadeType.DETACH, CascadeType.REFRESH})
	private List<Post> posts;
	
	public JobType() {
		
	}

	public JobType(int id, String name, Date createdDate, List<Post> posts) {
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
		this.posts = posts;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
