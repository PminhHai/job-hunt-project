package com.fx21044.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fx21044.model.ApplyPost;
import com.fx21044.model.Category;
import com.fx21044.model.Company;
import com.fx21044.model.JobType;
import com.fx21044.model.Post;
import com.fx21044.model.User;

@Repository
public class PostDaoImpl implements PostDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private JobTypeDao jobTypeDao;
	
	@Autowired
	private ApplyPostDao applyPostDao;
	
	String lastQuery;
	
	@Override
	public List<Post> getPosts() {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		List<Post> posts = new ArrayList<>();
		try {
			Query<Post> query = currentSession.createQuery("from Post", Post.class);
			
			posts = query.getResultList();
		} finally {
			currentSession.close();
		}
		
		return posts;
	}

	@Override
	public List<Post> getTopFivePosts() {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		List<Post> posts = new ArrayList<>();
		try {
			Query<Post> query = currentSession.createQuery("from Post order by createdDate", Post.class);
			query.setMaxResults(5);
			posts = query.getResultList();
		} finally {
			currentSession.close();
		}
		
		return posts;
	}

	@Override
	public List<Post> getPostsByCompanyID(int companyId,int index) {
		int maxResult = 5;
		int offset = (index - 1) * maxResult;
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		
		List<Post> posts = new ArrayList<>();
		
		try {
			String hql = "from Post where company.id =: id";
			Query<Post> query = currentSession.createQuery(hql, Post.class);
			query.setParameter("id", companyId);
			query.setFirstResult(offset);
			query.setMaxResults(maxResult);
			
			posts = query.getResultList();
		} finally {
			currentSession.close();
		}
		
		return posts;
	}

	@Override
	public int getCountByCompanyId(int companyId) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		
		long output = 0;
		try {
			Query<Long> query = currentSession.createQuery("SELECT COUNT (*) FROM Post where company.id =: companyId", Long.class);
			query.setParameter("companyId", companyId);
			output = query.getSingleResult();
		} finally {
			currentSession.close();
		}
		return (int) output;
	}

	@Override
	public int savePost(Post post) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		Integer result = null;
		try {
			result = (Integer) currentSession.save(post);
		} finally {
			currentSession.close();
		}
		return result;
	}

	@Override
	public int deletePost(int id) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		Integer result = null;
		try {
			currentSession.getTransaction().begin();
			Query query = currentSession.createQuery("delete From Post where id =: postId");
			query.setParameter("postId", id);
			result = query.executeUpdate();
			currentSession.getTransaction().commit();;
		} finally {
			currentSession.close();
		}
		
		return result;
	}

	@Override
	public void updatePost(Post post) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		try {
			currentSession.getTransaction().begin();
			currentSession.update(post);
			currentSession.getTransaction().commit();
		} finally {
			currentSession.close();
		}
		
	}

	@Override
	public Post getPostById(int postId) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		Post post = null;
		
		try {
			Query<Post> query = currentSession.createQuery("FROM Post where id =: postId", Post.class);
			query.setParameter("postId", postId);
			post = query.getSingleResult();
		} finally {
			currentSession.close();
		}
		
		return post;
	}

	@Override
	public List<Post> getPostsByUserID(int userId, int index) {
		int maxResult = 5;
		int offset = (index - 1) * maxResult;
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		
		List<Post> posts = new ArrayList<>();
		
		try {
			String hql = "from Post where user.id =: id";
			Query<Post> query = currentSession.createQuery(hql, Post.class);
			query.setParameter("id", userId);
			query.setFirstResult(offset);
			query.setMaxResults(maxResult);
			
			posts = query.getResultList();
		} finally {
			currentSession.close();
		}
		
		return posts;
	}

	@Override
	public int getCountByUserId(int userId) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		
		long output = 0;
		try {
			Query<Long> query = currentSession.createQuery("SELECT COUNT (*) FROM Post where user.id =: userId", Long.class);
			query.setParameter("userId", userId);
			output = query.getSingleResult();
		} finally {
			currentSession.close();
		}
		return (int) output;
	}

	@Override
	public List<Post> getPostsByCompanyName(String name, int index) {
		int maxResult = 5;
		int offset = (index - 1) * maxResult;
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		List<Post> posts =  new ArrayList<>();
		try {
			String hql = "from Post where company.name like '%"+name+"%'";
			lastQuery = hql;
			Query<Post> query = currentSession.createQuery(hql, Post.class);
			
			query.setFirstResult(offset);
			query.setMaxResults(maxResult);
			posts = query.getResultList();
		} finally {
			currentSession.close();
		}
		return posts;
	}

	@Override
	public List<Post> getPostsByAddress(String name, int index) {
		int maxResult = 5;
		int offset = (index - 1) * maxResult;
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		List<Post> posts = new ArrayList<>();
		try {
			String hql = "from Post where location like '%"+name+"%'";
			lastQuery = hql;
			Query<Post> query = currentSession.createQuery(hql, Post.class);
			query.setFirstResult(offset);
			query.setMaxResults(maxResult);
			posts = query.getResultList();
		} finally {
			currentSession.close();
		}
		return posts;
	}

	@Override
	public List<Post> getPostsByCategory(String name, int index) {
		int maxResult = 5;
		int offset = (index - 1) * maxResult;
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		List<Post> posts = new ArrayList<>();
		try {
			String hql = "from Post where title like '%"+name+"%'" + " or description like '%"+name+"%'";
			lastQuery = hql;
			Query<Post> query = currentSession.createQuery(hql, Post.class);
			query.setFirstResult(offset);
			query.setMaxResults(maxResult);
			posts = query.getResultList();
		} finally {
			currentSession.close();
		}
		return posts;
	}

	@Override
	public int getCountOfLastSearchQuery() {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		long output = 0;
		try {
			String hql  = "SELECT COUNT (*) " + lastQuery;
			Query<Long> query = currentSession.createQuery(hql, Long.class);
			output = query.getSingleResult();
		} finally {
			currentSession.close();
		}
		return (int) output;
	}

	@Override
	public List<Post> getPostsUserApplied(int userId, int index) {
		int maxResult = 5;
		int offset = (index - 1) * maxResult;
		SimpleDateFormat sdf = new SimpleDateFormat(
			    "yyyy-MM-dd");
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		List<Post> posts = new ArrayList<>();
		try {
			String hql = "SELECT p.id, p.title, p.company_id, p.category_id, p.job_type_id, ap.status,ap.id as ap_id " +
					"FROM applypost ap LEFT JOIN post p ON ap.post_id = p.id "+
					"WHERE ap.user_id = " + userId + " LIMIT " + maxResult + " OFFSET " + offset ;
			SQLQuery query = currentSession.createSQLQuery(hql);
			List<Object[]> rows = query.list();
			for(Object[] row : rows){
				Post post = new Post();
				post.setId(Integer.parseInt(row[0].toString()));
				post.setTitle(row[1].toString());
				Company company = companyDao.getCompanyGetID(Integer.parseInt(row[2].toString()));
				post.setCompany(company);
				Category category = categoryDao.getCategoryById(Integer.parseInt(row[3].toString()));
				post.setCategory(category);
				JobType jobType = jobTypeDao.getJobTypeByID(Integer.parseInt(row[4].toString()));
				post.setJobType(jobType);
				List<ApplyPost> applyPosts = new ArrayList<>();
				ApplyPost applyPost = applyPostDao.getApplyPostById(Integer.parseInt(row[6].toString()));
				applyPosts.add(applyPost);
				post.setApplyPosts(applyPosts);
				posts.add(post);
				
			}
		} finally {
			currentSession.close();
		}
		return posts;
	}



	

	

	

}
