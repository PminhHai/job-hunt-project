package com.fx21044.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.fx21044.dto.TopCategoryDTO;
import com.fx21044.model.Category;

@Repository
public class CategoyDaoImpl implements CategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategories() {
		Session currentSession =  sessionFactory.getSessionFactory().openSession();
		List<Category> categories = new ArrayList<>();
		try {
			Query<Category> query = currentSession.createQuery("FROM Category", Category.class);
			categories = query.getResultList();
			
		} finally {
			currentSession.close();
		}
		return categories;
	}

	@Override
	public List<TopCategoryDTO> getTopCategoryDTO() {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		List<TopCategoryDTO> list = new ArrayList<>();
		try {
			TypedQuery<TopCategoryDTO> query = 
					currentSession.createQuery("SELECT NEW com.fx21044.dto.TopCategoryDTO (cat.name,COUNT(p.numberOfRecruit)) FROM Category AS cat INNER JOIN Post AS p ON cat.id = p.category.id GROUP BY cat.id ORDER BY COUNT(p.numberOfRecruit) desc",TopCategoryDTO.class);
			query.setMaxResults(4);
			list = query.getResultList();
		} finally {
			currentSession.close();
		}
		
		return list;
	}

	@Override
	public Category getCategoryById(int id) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		Category category = null;
		try {
			Query<Category> query = currentSession.createQuery("FROM Category where id =: id",Category.class);
			query.setParameter("id", id);
			category = query.getSingleResult();
		} finally {
			currentSession.close();
		}
		return category;
	}

}
