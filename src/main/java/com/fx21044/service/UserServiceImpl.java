package com.fx21044.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fx21044.dao.CompanyDao;
import com.fx21044.dao.RoleDao;
import com.fx21044.dao.UserDao;
import com.fx21044.dto.UpdateUserDTO;
import com.fx21044.dto.UserDTO;
import com.fx21044.model.Company;
import com.fx21044.model.Role;
import com.fx21044.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User findUserByUserName(String userName) {
		
		User user = userDao.findByUserName(userName);
		return user;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userDao.findByUserName(userName);
		
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),Arrays.asList(authority));
		
		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void saveUser(UserDTO userDTO, int roleId, int companyId) {
		Role role = roleDao.findRoleByID(roleId);
		
		User user = new User();
		user.setUserName(userDTO.getUserName());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setFullName(userDTO.getFullName());
		user.setEmail(userDTO.getEmail());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		if(roleId == 1) {
			user.setRole(role);
		} else {
			user.setRole(role);
			Company company = companyDao.getCompanyGetID(companyId);
			user.setCompany(company);
		}
		
		userDao.saveUser(user);
	}

	@Override
	@Transactional
	public void updateUser(UpdateUserDTO userDTO) {
		userDao.updateUser(userDTO);		
	}

	@Override
	@Transactional
	public void saveFile(User theUser) {
		userDao.saveFile(theUser);
		
	}
}
