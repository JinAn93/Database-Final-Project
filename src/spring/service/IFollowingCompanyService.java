package spring.service;

import java.util.List;

import spring.model.FollowingCompany;

public interface IFollowingCompanyService {
	
	List<FollowingCompany> findFollowingCompanyByUserName(String user_name);
	
	List<FollowingCompany> findFollowingCompanyByCompanyName(String company_name);
	
	Long countFollowingCompanyByUserName(String user_name);
	
	Long countFollowingCompanyByCompany(String company_name);
}
