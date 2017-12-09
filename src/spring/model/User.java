package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "User")
public class User {

	@Id
	@Size(min = 3, max = 45)
	@Column(name = "USER_NAME", unique = true, nullable = false)
	private String user_name;

	@Column(name = "FIRST_NAME")
	private String first_name;
	
	@Column(name = "LAST_NAME")
	private String last_name;
	
	@NotNull
	@Column(name = "PASSWORD", nullable = false) 	
	private String password;

	@NotNull
	@Email
	@Size(max = 255)
	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "CURRENT_COMPANY")
	private String current_company;
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCurrent_company() {
		return current_company;
	}
	
	public void setCurrent_company(String current_company) {
		this.current_company = current_company;
	}
}