package spring.dao;

import java.util.List;

import spring.model.FollowingUser;
import spring.util.FollowerFolloweePK;

public interface IFollowingUserDao {

	/**
	 * Get following user object by their names
	 * @return
	 */
	FollowingUser findFollowingUser(FollowerFolloweePK pk);
	
	/**
	 * Receives and saves the following user to database
	 * 
	 * @param following company
	 */
	void saveFollowingUser(FollowingUser followingUser);

	/**
	 * Find all Following Users in the database
	 * 
	 * @return
	 */
	List<FollowingUser> findAllFollowingUser();
	
	void deleteFollowingCompany(String follower, String followee);
	
	List<FollowingUser> findFollowingUserByFollower(String follower);
	
	List<FollowingUser> findFollowingUserByFollowee(String followee);
	
	Long countFollowingUserByFollower(String follower);
	
	Long countFollowingUserByFollowee(String followee);
}
