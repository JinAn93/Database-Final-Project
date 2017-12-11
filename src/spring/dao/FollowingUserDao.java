package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import spring.model.FollowingUser;
import spring.util.FollowerFolloweePK;

@Repository("followingUserDao")
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
	
	@SuppressWarnings("unchecked")
	public List<FollowingUser> findFollowingUserByFollower(String follower) {
		Query query = getSession().createSQLQuery("select * from Following_User where follower = :follower").addEntity(FollowingUser.class);
		query.setString("follower", follower);
		return (List<FollowingUser>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<FollowingUser> findFollowingUserByFollowee(String followee) {
		Query query = getSession().createSQLQuery("select * from Following_User where followee = :followee").addEntity(FollowingUser.class);
		query.setString("followee", followee);
		return (List<FollowingUser>) query.list();
	}
	
	public Long countFollowingUserByFollower(String follower) {
		Query query = getSession().createSQLQuery("select count(*) from Following_User where follower = :follower");
		query.setString("follower",follower);
		return (Long) query.uniqueResult();
	}
	
	public Long countFollowingUserByFollowee(String followee) {
		Query query = getSession().createSQLQuery("select count(*) from Following_User where followee = :followee");
		query.setString("followee", followee);
		return (Long) query.uniqueResult();
	}
}
