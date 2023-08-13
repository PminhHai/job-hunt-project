package com.fx21044.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fx21044.dao.CompanyDao;
import com.fx21044.dto.CompanyDTO;
import com.fx21044.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	//Lấy danh sách công ty
	@Override
	@Transactional
	public List<Company> getCompanies() {
		
		return companyDao.getCompanies();
	}
	
	//Thêm mới công ty
	@Override
	@Transactional
	public int addNewCompany(String name) {
		
		return companyDao.addNewCompany(name);
		
	}
	
	//Lấy top công ty
	@Override
	@Transactional
	public List<Company> getTopFiveCompanies() {
		
		return companyDao.topFiveCompanies();
	}
	
	//Cập nhật công ty
	@Override
	@Transactional
	public void updateCompany(CompanyDTO companyDTO) {
		companyDao.updateCompany(companyDTO);
		
	}
	
	//Tìm công ty bằng id
	@Override
	@Transactional
	public Company getCompanyById(int id) {
		return companyDao.getCompanyGetID(id);
	}
	
}
