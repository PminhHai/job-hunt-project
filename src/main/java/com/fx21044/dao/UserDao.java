package com.fx21044.dao;

import com.fx21044.dto.UpdateUserDTO;
import com.fx21044.model.User;

public interface UserDao {
	public User findByUserName(String userName);
	
	public void saveUser(User theUser);
	
	public void updateUser(UpdateUserDTO userDTO);
	
	public void saveFile(User theUser);
	
	public User findUserByID (int id);
}
