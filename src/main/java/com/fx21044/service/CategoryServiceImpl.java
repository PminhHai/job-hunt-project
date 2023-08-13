package com.fx21044.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fx21044.dao.CategoryDao;
import com.fx21044.dto.TopCategoryDTO;
import com.fx21044.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	//Lấy top danh mục
	@Override
	public List<TopCategoryDTO> getTopCategoryDTOs() {
		
		List<TopCategoryDTO> list = categoryDao.getTopCategoryDTO();
		return list;
	}
	
	//Lấy danh sách danh mục
	@Override
	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}

}
