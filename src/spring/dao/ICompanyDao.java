package spring.dao;

import java.util.List;

import spring.model.Company;

public interface ICompanyDao {
	/**
	 * Identifies a company by id (primary key)
	 * 
	 * @param id
	 * @return
	 */
	Company findById(String id);

	/**
	 * Receives and saves the post to database
	 * 
	 * @param post
	 */
	void saveCompany(Company company);

	/**
	 * Find all Posts in the database
	 * 
	 * @return
	 */
	List<Company> findAllCompanys();
}
