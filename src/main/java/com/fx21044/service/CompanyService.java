package com.fx21044.service;

import java.util.List;

import com.fx21044.dto.CompanyDTO;
import com.fx21044.model.Company;

public interface CompanyService {
	public List<Company> getCompanies();
	
	public int addNewCompany(String name);
	
	public List<Company> getTopFiveCompanies();
	
	public void updateCompany(CompanyDTO companyDTO);
	
	public Company getCompanyById(int id);
}
