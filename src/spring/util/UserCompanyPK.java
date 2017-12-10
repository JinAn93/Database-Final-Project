package spring.util;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class UserCompanyPK implements Serializable {
	
	@NotNull
	@Column(name = "user_name")
	private String user_name;
	
	@NotNull
	@Column(name = "company_name")
	private String company_name;
	
	public String getUser_name() {
		return user_name;
	}
	
	public UserCompanyPK setUser_name(String user_name) {
		this.user_name = user_name;
		return this;
	}
	
	public String getCompany_name() {
		return company_name;
	}
	
	public UserCompanyPK setCompany_name(String company_name) {
		this.company_name = company_name;
		return this;
	}
}
