package com.fx21044.service;

import java.util.List;

import com.fx21044.model.ApplyPost;
import com.fx21044.model.Post;
import com.fx21044.model.User;

public interface ApplyPostService {
	public List<ApplyPost> getApplyPostsByPostId (int postId);
	public ApplyPost getApplyPostById(int applyPostId);
	public void approveApplyPost(ApplyPost applyPost);
	public void refuseApplyPost(ApplyPost applyPost);
	public void addNeApplyPost(User user, Post post, byte[] file, String description);
	public void deleteAllByPostId(int postId);
}
