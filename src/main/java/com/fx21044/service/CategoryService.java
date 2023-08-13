package com.fx21044.service;

import java.util.List;

import com.fx21044.dto.TopCategoryDTO;
import com.fx21044.model.Category;

public interface CategoryService {
	public List<TopCategoryDTO> getTopCategoryDTOs();
	public List<Category> getCategories();
}
