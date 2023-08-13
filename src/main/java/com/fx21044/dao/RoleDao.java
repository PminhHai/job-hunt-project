package com.fx21044.dao;

import java.util.List;

import com.fx21044.model.Role;

public interface RoleDao {
	public Role findRoleByName(String roleName);
	
	public Role findRoleByID(int id);
	
	public List<Role> getRoles();
}
