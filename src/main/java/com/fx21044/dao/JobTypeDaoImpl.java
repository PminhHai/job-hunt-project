package com.fx21044.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fx21044.model.JobType;

@Repository
public class JobTypeDaoImpl implements JobTypeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<JobType> geJobTypes() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<JobType> query = currentSession.createQuery("FROM JobType", JobType.class);
		List<JobType> jobTypes = query.getResultList();
		return jobTypes;
	}

	@Override
	public JobType getJobTypeByID(int id) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		JobType jobType = null;
		try {
			Query<JobType> query = currentSession.createQuery("FROM JobType where id =:id", JobType.class);
			query.setParameter("id", id);
			jobType = query.getSingleResult();
		} finally {
			currentSession.close();
		}
		
		return jobType;
	}

}
