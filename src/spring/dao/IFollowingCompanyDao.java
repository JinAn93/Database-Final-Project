package spring.dao;

import java.util.List;

import spring.model.FollowingCompany;
import spring.util.UserCompanyPK;

public interface IFollowingCompanyDao {

	/**
	 * Get following company object by username and company name
	 * @return
	 */
	FollowingCompany findFollowingCompany(UserCompanyPK pk);
	
	/**
	 * Receives and saves the following company to database
	 * 
	 * @param following company
	 */
	void saveFollowingCompany(FollowingCompany followingCompany);

	/**
	 * Find all following companys in the database
	 * 
	 * @return
	 */
	List<FollowingCompany> findAllFollowingCompanys();
	
	List<FollowingCompany> findFollowingCompanyByUserName(String user_name);
	
	List<FollowingCompany> findFollowingCompanyByCompany(String company_name);
		
	void deleteFollowingCompany(String user_name, String company_name);
	
	Long countFollowingCompanyByUserName(String user_name);
	
	Long countFollowingCompanyByCompany(String company_name);
		
}
