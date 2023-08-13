package com.fx21044.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fx21044.dto.UpdateUserDTO;
import com.fx21044.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String userName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", userName);
		User theUser = null;
		
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}
		
		return theUser;
	}

	@Override
	public void saveUser(User theUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(theUser);
		
	}

	@Override
	public void updateUser(UpdateUserDTO userDTO) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		User user = currentSession.get(User.class, userDTO.getId());
		if(user != null) {
			user.setFullName(userDTO.getFullName());
			user.setEmail(userDTO.getEmail());
			user.setPhoneNumber(userDTO.getPhoneNumber());
			user.setDescription(userDTO.getDescription());
			
			currentSession.saveOrUpdate(user);
			
			
		}
	}

	@Override
	public void saveFile(User theUser) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.update(theUser);
		
		
	}

	@Override
	public User findUserByID(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		User theUser = null;
		
		try {
			Query<User> theQuery = currentSession.createQuery("from User where id=:id", User.class);
			theQuery.setParameter("id", id);
			theUser = theQuery.getSingleResult();
		} finally {
			currentSession.close();
		}
			
		
		return theUser;
	}

	
}
