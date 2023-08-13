package com.fx21044.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fx21044.dao.ApplyPostDao;
import com.fx21044.model.ApplyPost;
import com.fx21044.model.Post;
import com.fx21044.model.User;

@Service
public class ApplyPostServiceImpl implements ApplyPostService{
	
	@Autowired
	ApplyPostDao applyPostDao;
	
	//lấy danh sách applypost bằng post id
	@Override
	@Transactional
	public List<ApplyPost> getApplyPostsByPostId(int postId) {
		
		return applyPostDao.getApplyPostsByPostId(postId);
	}
	
	//tìm applypost bằng id
	@Override
	@Transactional
	public ApplyPost getApplyPostById(int applyPostId) {
		return applyPostDao.getApplyPostById(applyPostId);
	}
	
	//chấp thuận applypost
	@Override
	@Transactional
	public void approveApplyPost(ApplyPost applyPost) {
		applyPost.setStatus(1);
		applyPostDao.updateApplyPost(applyPost);
	}

	//từ chối applypost
	@Override
	@Transactional
	public void refuseApplyPost(ApplyPost applyPost) {
		applyPost.setStatus(2);
		applyPostDao.updateApplyPost(applyPost);
	}
	
	//Thêm mới applypost
	@Override
	@Transactional
	public void addNeApplyPost(User user, Post post, byte[] file, String description) {
		ApplyPost applyPost = new ApplyPost();
		applyPost.setUser(user);
		applyPost.setPost(post);
		applyPost.setStatus(0);
		applyPost.setText(description);
		applyPost.setFileCv(file);
		applyPost.setCreateDate(new Date(System.currentTimeMillis()));
		applyPostDao.addnewApplyPost(applyPost);
	}

	@Override
	public void deleteAllByPostId(int postId) {
		applyPostDao.deleteAllByPostId(postId);
		
	}
	
	
}
