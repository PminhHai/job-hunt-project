package com.fx21044.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fx21044.dto.UpdateUserDTO;
import com.fx21044.dto.UserDTO;
import com.fx21044.model.User;

public interface UserService extends UserDetailsService {
	
	public User findUserByUserName(String userName);
	
	public void saveUser(UserDTO userDTO, int roleId, int companyId);
	
	public void updateUser(UpdateUserDTO userDTO);
	
	public void saveFile(User theUser);
}
