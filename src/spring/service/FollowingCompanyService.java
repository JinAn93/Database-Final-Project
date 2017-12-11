package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.IFollowingCompanyDao;
import spring.model.FollowingCompany;

@Service("followingCompanyService")
@Transactional
public class FollowingCompanyService implements IFollowingCompanyService {

	@Autowired
	private IFollowingCompanyDao dao;
	
	public List<FollowingCompany> findFollowingCompanyByUserName(String user_name) {
		return dao.findFollowingCompanyByUserName(user_name);
	}
	
	public List<FollowingCompany> findFollowingCompanyByCompanyName(String company_name) {
		return dao.findFollowingCompanyByCompany(company_name);
	}
	
	public Long countFollowingCompanyByUserName(String user_name) {
		return dao.countFollowingCompanyByUserName(user_name);
	}
	
	public Long countFollowingCompanyByCompany(String company_name) {
		return dao.countFollowingCompanyByCompany(company_name);
	}
}
