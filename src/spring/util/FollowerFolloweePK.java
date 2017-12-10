package spring.util;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class FollowerFolloweePK implements Serializable {
	
	@NotNull
	@Column(name = "FOLLOWER")
	private String follower;
	
	@NotNull
	@Column(name = "FOLLOWEE")
	private String followee;
	
	public String getFollower() {
		return follower;
	}
	
	public FollowerFolloweePK setFollower(String follower) {
		this.follower = follower;
		return this;
	}
	
	public String getFollowee() {
		return followee;
	}
	
	public FollowerFolloweePK setFollowee(String followee) {
		this.followee = followee;
		return this;
	}
}
