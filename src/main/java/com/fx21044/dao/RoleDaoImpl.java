package com.fx21044.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fx21044.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Role findRoleByName(String roleName) {
		
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		Role theRole = null;
		try {
			Query<Role> theQuery = currentSession.createQuery("from Role where name=:roleName",Role.class);
			theQuery.setParameter("roleName", roleName);
			theRole = theQuery.getSingleResult();
		} finally {
			currentSession.close();
		}
		
		return theRole;
	}

	@Override
	public List<Role> getRoles() {
		
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		List<Role> roles = new ArrayList<>();
		try {
			Query<Role> theQuery = currentSession.createQuery("from Role",Role.class);
			roles = theQuery.getResultList();
		} finally {
			currentSession.close();
		}
	
		return roles;
	}

	@Override
	public Role findRoleByID(int id) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		Role theRole =  null;
		try {
			theRole = currentSession.get(Role.class, id);
		} catch (Exception e) {
			currentSession.close();
		}
		
		return theRole;
	}

}
