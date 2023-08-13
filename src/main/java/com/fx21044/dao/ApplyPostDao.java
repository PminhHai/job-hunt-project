package com.fx21044.dao;

import java.util.List;

import com.fx21044.model.ApplyPost;

public interface ApplyPostDao {
	public int deleteAllByPostId(int postId);
	public List<ApplyPost> getApplyPostsByPostId(int postId);
	public ApplyPost getApplyPostById(int applyPostId);
	public void updateApplyPost(ApplyPost applyPost);
	public void addnewApplyPost(ApplyPost applyPost);
	
	public List<ApplyPost> getApplyPostsByUserId(int userId);
	
	public void deleteById(int applyPostId);
}
