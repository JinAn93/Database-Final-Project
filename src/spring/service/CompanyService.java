package spring.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
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
		dao.saveCompany(normalizeCompanyName(company));
	}

	@Override
	public List<Company> findAllCompanys() {
		return dao.findAllCompanys();
	}
	
	private Company normalizeCompanyName(Company company) {
		String company_name = company.getCompany_name();
		company_name.replaceAll("\\s+","");
		company_name.toLowerCase();
		return company.setCompany_name(company_name);
	}
}
