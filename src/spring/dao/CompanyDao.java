package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import spring.model.Company;

@Repository("companyDao")
public class CompanyDao extends AbstractDao<String, Company> implements ICompanyDao{

	public Company findById(String id) {
		return getByKey(id);
	}

	public void saveCompany(Company company) {
		persist(company);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAllCompanys() {
		Criteria criteria = createEntityCriteria();
		return (List<Company>) criteria.list();
	}
}