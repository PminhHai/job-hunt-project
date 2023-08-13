package com.fx21044.dao;

import java.util.List;

import com.fx21044.model.JobType;

public interface JobTypeDao {
	public List<JobType> geJobTypes();
	public JobType getJobTypeByID(int id);
}
