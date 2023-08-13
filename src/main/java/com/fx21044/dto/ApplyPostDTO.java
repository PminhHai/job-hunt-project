package com.fx21044.dto;

import org.springframework.web.multipart.MultipartFile;

public class ApplyPostDTO {
	
	private String description;
	
	private MultipartFile file;
	
	private int cvSubmitType;
	
	private int postId;
	
	private int type;
	
	private String queryString;
	
	private int page;

	public ApplyPostDTO() {
		super();
	}

	public ApplyPostDTO(String description, MultipartFile file, int cvSubmitType, int postId, int type,
			String queryString, int page) {
		super();
		this.description = description;
		this.file = file;
		this.cvSubmitType = cvSubmitType;
		this.postId = postId;
		this.type = type;
		this.queryString = queryString;
		this.page = page;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getCvSubmitType() {
		return cvSubmitType;
	}

	public void setCvSubmitType(int cvSubmitType) {
		this.cvSubmitType = cvSubmitType;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
