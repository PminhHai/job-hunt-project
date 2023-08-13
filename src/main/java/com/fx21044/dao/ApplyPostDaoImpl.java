package com.fx21044.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fx21044.model.ApplyPost;

@Repository
public class ApplyPostDaoImpl implements ApplyPostDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int deleteAllByPostId(int postId) {
		Session session = sessionFactory.getSessionFactory().openSession();
		Integer result = null;
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("delete FROM ApplyPost where post.id =: postId");
			query.setParameter("postId", postId);
			result = query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.close();
		}
		return result;
	}

	@Override
	public List<ApplyPost> getApplyPostsByPostId(int postId) {
		Session session = sessionFactory.getCurrentSession();
		Query<ApplyPost> query = session.createQuery("FROM ApplyPost where post.id =: postId",ApplyPost.class);
		query.setParameter("postId", postId);
		List<ApplyPost> applyPosts = query.getResultList();
		return applyPosts;
	}

	@Override
	public ApplyPost getApplyPostById(int applyPostId) {
		Session session = sessionFactory.getSessionFactory().openSession();
		ApplyPost applyPost = null;
		
		try {
			Query<ApplyPost> query = session.createQuery("FROM ApplyPost where id =: id",ApplyPost.class);
			query.setParameter("id", applyPostId);
			applyPost = query.getSingleResult();
		} finally {
			session.close();
		}
		
		return applyPost;
	}

	@Override
	public void updateApplyPost(ApplyPost applyPost) {
		Session session = sessionFactory.getCurrentSession();
		session.update(applyPost);
		
	}

	@Override
	public void addnewApplyPost(ApplyPost applyPost) {
		Session session = sessionFactory.getCurrentSession();
		session.save(applyPost);
		
	}

	@Override
	public List<ApplyPost> getApplyPostsByUserId(int userId) {
		Session session = sessionFactory.getSessionFactory().openSession();
		List<ApplyPost> applyPosts = new ArrayList<>();
		try {
			Query<ApplyPost> query = session.createQuery("FROM ApplyPost where user.id =: userId",ApplyPost.class);
			query.setParameter("userId", userId);
			applyPosts = query.getResultList();
		} catch (Exception e) {
			session.close();
		}
		
		return applyPosts;
	}

	@Override
	public void deleteById(int applyPostId) {
		// TODO Auto-generated method stub
		
	}

}
