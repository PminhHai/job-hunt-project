package com.fx21044.dao;

import java.util.List;

import com.fx21044.model.Post;

public interface PostDao {
	
	public List<Post> getPosts();
	
//	public List<Post> getPostsWithIndex(int index);
	
	public List<Post> getTopFivePosts();
	
	public List<Post> getPostsByCompanyID(int companyId, int index);
	
	public List<Post> getPostsByUserID(int userId, int index);
	
	public int getCountByCompanyId(int companyId);
	
	public int getCountByUserId(int userId);
	
	public int savePost(Post post);
	
	public int deletePost(int id);
	
	public void updatePost(Post post);
	
	public Post getPostById(int postId);
	
	public List<Post> getPostsByCompanyName(String name,int index);
	
	public List<Post> getPostsByAddress(String name,int index);
	
	public List<Post> getPostsByCategory(String name, int index);
	
	public int getCountOfLastSearchQuery();
	
	public List<Post> getPostsUserApplied(int userId, int index);
	
}
