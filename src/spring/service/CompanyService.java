package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.ICompanyDao;
import spring.model.Company;

@Service("companyService")
@Transactional
public class CompanyService implements ICompanyService{

	@Autowired
	private ICompanyDao dao;
	
	public Company findById(String id) {
		return dao.findById(id);
	}

	@Override
	public void saveCompany(Company company) {
		dao.saveCompany(company);
	}

	@Override
	public List<Company> findAllCompanys() {
		return dao.findAllCompanys();
	}
}
