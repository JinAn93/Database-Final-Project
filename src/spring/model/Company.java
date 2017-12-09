package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Company")
public class Company {

	@Id
	@NotNull
	@Column(name = "COMPANY_NAME", nullable = false)
	private String company_name;
	
	@Column(name = "LOCATION")
	private String location;
	
	public String getCompany_name() {
		return company_name;
	}
	
	public Company setCompany_name(String company_name) {
		this.company_name = company_name;
		return this;
	}
	
	public String getLocation() {
		return location;
	}
	
	public Company setLocation(String location) {
		this.location = location;
		return this;
	}
}
