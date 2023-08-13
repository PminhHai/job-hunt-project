package com.fx21044.service;

import java.util.List;

import com.fx21044.model.Role;

public interface RoleService {
	public Role findRoleByName(String roleName);
	
	public List<Role> getRoles();
}	
