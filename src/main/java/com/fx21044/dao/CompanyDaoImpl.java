package com.fx21044.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fx21044.dto.CompanyDTO;
import com.fx21044.model.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Company> topFiveCompanies() {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		List<Company> companies = new ArrayList<>();
		try {
			Query<Company> theQuery = currentSession.createQuery("from Company c order by size(c.posts) desc", Company.class);
			theQuery.setMaxResults(5);
			companies = null;
			companies = theQuery.getResultList();
		} finally {
			currentSession.close();
		}
		
		return companies;
	}

	@Override
	public List<Company> getCompanies() {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		List<Company> companies = new ArrayList<>();
		
		try {
			Query<Company> theQuery = currentSession.createQuery("from Company", Company.class);
			companies = theQuery.getResultList();
		} finally {
			currentSession.close();
		}
		
		return companies;
	}

	@Override
	public Company getCompanyGetID(int id) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		Company company = null;
		try {
			Query<Company> theQuery = currentSession.createQuery("from Company c where id =: id", Company.class);
			theQuery.setParameter("id", id);
			company = theQuery.getSingleResult();
		} finally {
			currentSession.close();
		}
		
		return company;
	}

	@Override
	public int addNewCompany(String name) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		
		Integer result = null;
		
		try {
			Company company = new Company();
			company.setName(name);
			result = (Integer) currentSession.save(company);
		} finally {
			currentSession.close();
		}
		
		return result;
		
	}

	@Override
	public void updateCompany(CompanyDTO companyDTO) {
		Session currentSession = sessionFactory.getSessionFactory().openSession();
		currentSession.getTransaction().begin();
		Company company = currentSession.get(Company.class, companyDTO.getId());
		if(company != null) {
			company.setName(companyDTO.getName());
			company.setAddress(companyDTO.getAddress());
			company.setPhoneNumber(companyDTO.getPhoneNumber());
			company.setEmail(companyDTO.getEmail());
			company.setDescription(companyDTO.getDescription());
			
			currentSession.saveOrUpdate(company);
			currentSession.getTransaction().commit();
			currentSession.close();
		}
	}

}
