package spring.service;

import java.util.List;

import spring.model.Company;

public interface ICompanyService {
	Company findById(String id);
	
	void saveCompany(Company company);
	
	List<Company> findAllCompanys();
}
