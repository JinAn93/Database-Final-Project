package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import spring.model.FollowingCompany;
import spring.util.UserCompanyPK;

@Repository("followingCompanyDao")
public class FollowingCompanyDao extends AbstractDao<UserCompanyPK, FollowingCompany> implements IFollowingCompanyDao {

	public FollowingCompany findFollowingCompany(UserCompanyPK userCompanyPK) {
		return getByKey(userCompanyPK);
	}

	public void saveFollowingCompany(FollowingCompany followingCompany) {
		persist(followingCompany);
	}

	@SuppressWarnings("unchecked")
	public List<FollowingCompany> findAllFollowingCompanys() {
		Criteria criteria = createEntityCriteria();
		return (List<FollowingCompany>) criteria.list();
	}
	
	public void deleteFollowingCompany(String user_name, String company_name) {
		Query query = getSession().createSQLQuery("delete from Following_Company where user_name = :user_name and company_name = :company_name");
		query.setString("user_name", user_name);
		query.setString("company_name",  company_name);
		query.executeUpdate();
	}
}
