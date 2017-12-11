package spring.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import spring.util.FollowerFolloweePK;

@Entity
@Table(name = "Following_User")
public class FollowingUser {

	@EmbeddedId
	FollowerFolloweePK pk;
	
	public FollowerFolloweePK getFollowerFolloweePK() {
		return pk;
	}
	
	public FollowingUser setFollowerFolloweePK(FollowerFolloweePK pk) {
		this.pk = pk;
		return this;
	}
	
	public String getFollower() {
		return pk.getFollower();
	}
	
	public FollowingUser setFollower(String follower) {
		pk.setFollower(follower);
		return this;
	}
	
	public String getFollowee() {
		return pk.getFollowee();
	}
	
	public FollowingUser setFollowee(String followee) {
		pk.setFollowee(followee);
		return this;
	}
}
