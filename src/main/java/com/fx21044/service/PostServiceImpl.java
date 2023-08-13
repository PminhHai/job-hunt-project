package com.fx21044.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fx21044.dao.ApplyPostDao;
import com.fx21044.dao.CategoryDao;
import com.fx21044.dao.JobTypeDao;
import com.fx21044.dao.PostDao;
import com.fx21044.dto.PostDTO;
import com.fx21044.model.ApplyPost;
import com.fx21044.model.Category;
import com.fx21044.model.JobType;
import com.fx21044.model.Post;
import com.fx21044.model.User;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private JobTypeDao jobTypeDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ApplyPostDao applyPostDao;
	
	//lấy danh sách post
	@Override
	@Transactional
	public List<Post> getPosts() {
		
		return postDao.getPosts();
	}
	
	//lấy top post
	@Override
	@Transactional
	public List<Post> getTopFivePosts() {
		
		return postDao.getTopFivePosts();
	}
	
	//Lấy danh sách post bằng id company
	@Override
	@Transactional
	public List<Post> getPostsByCompanyID(int companyId, int index) {
		
		return postDao.getPostsByCompanyID(companyId, index);
	}
	
	//Đếm số post bằng company id
	@Override
	@Transactional
	public int getCountByCompanyId(int companyId) {
		
		return postDao.getCountByCompanyId(companyId);
	}
	
	//Thêm post
	@Override
	@Transactional
	public int addPost(PostDTO postDTO, User user) {
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setExperience(postDTO.getExperience());
		post.setNumberOfRecruit(Integer.parseInt(postDTO.getNumberOfRecruit()));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed;
		
		try {
			parsed = format.parse(postDTO.getExpireDate());
			java.sql.Date expireDate = new java.sql.Date(parsed.getTime());
			post.setExpireDate(expireDate);
			post.setCreatedDate(new Date(System.currentTimeMillis()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		post.setCompany(user.getCompany());
		post.setSalary(postDTO.getSalary());
		post.setLocation(postDTO.getLocation());
		JobType jobType = jobTypeDao.getJobTypeByID(postDTO.getJobTypeId());
		post.setJobType(jobType);
		Category category = categoryDao.getCategoryById(postDTO.getCategoryId());
		post.setCategory(category);
		post.setUser(user);
		return postDao.savePost(post);
	}
	
	//Xóa post
	@Override
	@Transactional
	public int deletePost(int postId) {
		applyPostDao.deleteAllByPostId(postId);
		return postDao.deletePost(postId);
	}
	
	//Cập nhật post
	@Override
	@Transactional
	public void updatePost(PostDTO postDTO, User user, int postId) {
		Post post =  postDao.getPostById(postId);
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setExperience(postDTO.getExperience());
		post.setNumberOfRecruit(Integer.parseInt(postDTO.getNumberOfRecruit()));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed;
		
		try {
			parsed = format.parse(postDTO.getExpireDate());
			java.sql.Date expireDate = new java.sql.Date(parsed.getTime());
			post.setExpireDate(expireDate);
			post.setCreatedDate(new Date(System.currentTimeMillis()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		post.setCompany(user.getCompany());
		post.setSalary(postDTO.getSalary());
		JobType jobType = jobTypeDao.getJobTypeByID(postDTO.getJobTypeId());
		post.setJobType(jobType);
		Category category = categoryDao.getCategoryById(postDTO.getCategoryId());
		post.setCategory(category);
		post.setUser(user);
		postDao.updatePost(post);
	}
	
	//Lấy post bằng id
	@Override
	@Transactional
	public Post getPostById(int postId) {
		return postDao.getPostById(postId);
	}
	
	//Lấy danh sách post có bằng user id
	@Override
	@Transactional
	public List<Post> getPostsByUserID(int userId, int index) {
		return postDao.getPostsByUserID(userId, index);
	}
	
	//Đếm số post bằng user id
	@Override
	@Transactional
	public int getCountByUserId(int userId) {
		return postDao.getCountByUserId(userId);
	}
	
	//Lấy danh sách post bằng tên công ty
	@Override
	@Transactional
	public List<Post> getPostsByCompanyName(String name, int index) {
		
		return postDao.getPostsByCompanyName(name, index);
	}

	@Override
	@Transactional
	public int getCountOfLastSearchQuery() {
		
		return postDao.getCountOfLastSearchQuery();
	}
	
	//Lấy danh sách post bằng địa chỉ
	@Override
	@Transactional
	public List<Post> getPostsByAddress(String name, int index) {
		
		return postDao.getPostsByAddress(name, index);
	}
	
	//Lấy danh sách post bằng danh mục
	@Override
	@Transactional
	public List<Post> getPostsByCategory(String name, int index) {
		
		return postDao.getPostsByCategory(name, index);
	}
	
	//Đếm số post user đã apply 
	@Override
	public int getAllPostsByUserApplied(int userId) {
		List<Post> posts = postDao.getPosts();
		
		List<Post> appliedPosts = new ArrayList<Post>();
		
		for(int i = 0; i < posts.size(); i++) {
			List<ApplyPost> applyPostInLoop = posts.get(i).getApplyPosts();
			for(int j = 0; j < applyPostInLoop.size(); j++) {
				if(applyPostInLoop.get(j).getUser().getId() == userId) {
					appliedPosts.add(posts.get(i));
				}
			}
		}
		
		int postSize = appliedPosts.size();
		
		System.out.println(postSize);
		
		return postSize;
	}
	
	//Lấy danh sách post user đã apply
	@Override
	public List<Post> getPostsByUserApplied(int userId, int index) {
		
		return postDao.getPostsUserApplied(userId, index);
	}

}
