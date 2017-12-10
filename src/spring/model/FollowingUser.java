package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Following_User")
public class FollowingUser {

	@NotNull
	@Column(name = "FOLLWER")
	private String follower;
	
	@NotNull
	@Column(name = "FOLLOWEE")
	private String followee;
	
	public String getFollower() {
		return follower;
	}
	
	public FollowingUser setFollower(String follower) {
		this.follower = follower;
		return this;
	}
	
	public String getFollowee() {
		return followee;
	}
	
	public FollowingUser setFollowee(String followee) {
		this.followee = followee;
		return this;
	}
}
