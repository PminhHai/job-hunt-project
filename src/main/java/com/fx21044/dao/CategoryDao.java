package com.fx21044.dao;

import java.util.List;

import com.fx21044.dto.TopCategoryDTO;
import com.fx21044.model.Category;

public interface CategoryDao {
	public List<Category> getCategories();
	
	public List<TopCategoryDTO> getTopCategoryDTO();
	
	public Category getCategoryById(int id);
}
