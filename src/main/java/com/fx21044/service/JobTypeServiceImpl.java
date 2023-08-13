package com.fx21044.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fx21044.dao.JobTypeDao;
import com.fx21044.model.JobType;

@Service
public class JobTypeServiceImpl implements JobTypeService {
	
	@Autowired
	private JobTypeDao jobTypeDao;

	@Override
	@Transactional
	public List<JobType> getJobTypes() {
		
		return jobTypeDao.geJobTypes();
	}

}
