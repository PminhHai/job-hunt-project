package com.fx21044.dto;

public class TopCategoryDTO {
	private String categoryName;
	
	private long countPost;

	public TopCategoryDTO() {
		super();
	}

	public TopCategoryDTO(String categoryName, long countPost) {
		super();
		this.categoryName = categoryName;
		this.countPost = countPost;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getCountPost() {
		return countPost;
	}

	public void setCountPost(long countPost) {
		this.countPost = countPost;
	}
	
	
}
