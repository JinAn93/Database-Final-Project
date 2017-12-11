package spring.service;

import java.util.List;

import spring.model.FollowingUser;

public interface IFollowingUserService {

	List<FollowingUser> findFollowingUserByFollower(String follower);
	
	List<FollowingUser> findFollowingUserByFollowee(String followee);
	
	Long countFollowingUserByFollower(String follower);
	
	Long countFollowingUserByFollowee(String followee);
}
