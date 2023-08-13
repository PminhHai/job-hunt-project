package com.fx21044.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fx21044.dao.RoleDao;
import com.fx21044.model.Role;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleDao roleDao;
	
	@Override
	@Transactional
	public Role findRoleByName(String roleName) {
		
		return roleDao.findRoleByName(roleName);
	}
	
	@Override
	@Transactional
	public List<Role> getRoles() {
	
		return roleDao.getRoles();
	}

	

}
