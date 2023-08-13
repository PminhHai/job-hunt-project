package com.fx21044.dao;

import java.util.List;

import com.fx21044.dto.CompanyDTO;
import com.fx21044.model.Company;

public interface CompanyDao {
	public List<Company> topFiveCompanies();
	
	public List<Company> getCompanies();
	
	public Company getCompanyGetID(int id);
	
	public int addNewCompany(String name);
	
	public void updateCompany(CompanyDTO companyDTO);
}
