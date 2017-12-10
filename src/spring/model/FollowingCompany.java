package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Following_Company")
public class FollowingCompany {

	@NotNull
	@Column(name = "FOLLWER")
	private String follower;
	
	@NotNull
	@Column(name = "COMPANY_NAME")
	private String company_name;
	
	public String getFollower() {
		return follower;
	}
	
	public FollowingCompany setFollower(String follower) {
		this.follower = follower;
		return this;
	}
	
	public String getCompany_name() {
		return company_name;
	}
	
	public FollowingCompany setCompany_name(String company_name) {
		this.company_name = company_name;
		return this;
	}
}
