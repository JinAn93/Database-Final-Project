package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import spring.model.FollowingUser;
import spring.util.FollowerFolloweePK;

public class FollowingUserDao extends AbstractDao<FollowerFolloweePK, FollowingUser> implements IFollowingUserDao {

	public FollowingUser findFollowingUser(FollowerFolloweePK pk) {
		return getByKey(pk);
	}

	public void saveFollowingUser(FollowingUser followingUser) {
		persist(followingUser);
	}

	@SuppressWarnings("unchecked")
	public List<FollowingUser> findAllFollowingUser() {
		Criteria criteria = createEntityCriteria();
		return (List<FollowingUser>) criteria.list();
	}
	
	public void deleteFollowingCompany(String follower, String followee) {
		Query query = getSession().createSQLQuery("delete from Following_User where follower = :follower and followee = :followee");
		query.setString("follower", follower);
		query.setString("followee", followee);
		query.executeUpdate();
	}
	

}
