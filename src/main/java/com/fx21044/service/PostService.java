package com.fx21044.service;

import java.util.List;

import com.fx21044.dto.PostDTO;
import com.fx21044.model.Post;
import com.fx21044.model.User;

public interface PostService {
	public List<Post> getPosts();
	
	public List<Post> getTopFivePosts();
	
	public List<Post> getPostsByCompanyID(int companyId, int index);
	
	public List<Post> getPostsByUserID(int userId, int index);
	
	public int getCountByCompanyId(int companyId); 
	
	public int getCountByUserId(int userId); 
	
	public int addPost(PostDTO postDTO, User user);
	
	public int deletePost(int postId);
	
	public void updatePost(PostDTO postDTO, User user, int postId);
	
	public Post getPostById(int postId);
	
	public List<Post> getPostsByCompanyName(String name,int index);
	
	public int getCountOfLastSearchQuery();
	
	public List<Post> getPostsByAddress(String name,int index);
	
	public List<Post> getPostsByCategory(String name,int index);
	
	public int getAllPostsByUserApplied(int userId);
	
	public List<Post> getPostsByUserApplied(int userId, int index);
}
