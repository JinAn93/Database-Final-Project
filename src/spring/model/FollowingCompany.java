package spring.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import spring.util.UserCompanyPK;

@Entity
@Table(name = "Following_Company")
public class FollowingCompany {

	@EmbeddedId
	UserCompanyPK pk;
	
	public UserCompanyPK getUserCompanyPK() {
		return pk;
	}
	
	public FollowingCompany setUserCompanyPK(UserCompanyPK pk) {
		this.pk = pk;
		return this;
	}
	
	public String getUser_name() {
		return pk.getUser_name();
	}
	
	public FollowingCompany setUser_name(String user_name) {
		pk.setUser_name(user_name);
		return this;
	}
	
	public String getCompany_name() {
		return pk.getCompany_name();
	}
	
	public FollowingCompany setCompany_name(String company_name) {
		pk.setCompany_name(company_name);
		return this;
	}
}
