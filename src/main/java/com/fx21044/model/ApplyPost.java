package com.fx21044.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "applypost")
public class ApplyPost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "createDate")
	@CreationTimestamp
	private Date createDate;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "file_cv")
	private byte[] fileCv;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

	public ApplyPost() {
		super();
	}

	public ApplyPost(int id, Date createDate, int status, String text, byte[] fileCv, User user, Post post) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.status = status;
		this.text = text;
		this.fileCv = fileCv;
		this.user = user;
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getFileCv() {
		return fileCv;
	}

	public void setFileCv(byte[] fileCv) {
		this.fileCv = fileCv;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
