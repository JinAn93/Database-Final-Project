package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.IFollowingUserDao;
import spring.model.FollowingUser;

@Service("followingUserService")
@Transactional
public class FollowingUserService {

	@Autowired
	private IFollowingUserDao dao;
	
	public List<FollowingUser> findFollowingUserByFollower(String follower) {
		return dao.findFollowingUserByFollower(follower);
	}
	
	public List<FollowingUser> findFollowingUserByFollowee(String followee) {
		return dao.findFollowingUserByFollowee(followee);
	}
	
	public Long countFollowingUserByFollower(String follower) {
		return dao.countFollowingUserByFollower(follower);
	}
	
	public Long countFollowingUserByFollowee(String followee) {
		return dao.countFollowingUserByFollowee(followee);
	}
}
