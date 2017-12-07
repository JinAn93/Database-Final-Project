package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "POST")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int post_id;

	@NotNull
	@Column(name = "USER_NAME", nullable = false)
	private String user_name;

	@NotNull
	@Column(name = "COMPANY_ID", nullable = false)
	private int company_id;

	@NotNull
	@Size(min = 3, max = 30)
	@Column(name = "USER_ID", nullable = false)
	private String user_id;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "POST_DATE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate post_date;

	@SuppressWarnings("static-access")
	public Post() {
		post_date = new LocalDate().now();
	}
	
	@Size(min = 0, max = 5)
	@Column(name = "COMPANY_RATING")
	private int company_rating;
	
	@Column(name = "INTERVIEW_RESULT")
	private String interview_result;
	
	@Size(max = 255)
	@Column(name = "CONTENT")
	private String content;
	
	@NotNull
	@Column(name = "INTERVIEW_YEAR")
	private int interview_year;
	
	@NotNull
	@Column(name = "INTERVIEW_SEASON")
	private String interview_season;
	
	public int getPost_id() {
		return post_id;
	}
	
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public int getCompany_id() {
		return company_id;
	}
	
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	
	public LocalDate getPost_date() {
		return post_date;
	}
	
	public void setPost_date(LocalDate post_date) {
		this.post_date = post_date;
	}
	
	public int getCompany_rating() {
		return company_rating;
	}
	
	public void setCompany_rating(int company_rating) {
		this.company_rating = company_rating;
	}
	
	public String getInterview_result() {
		return interview_result;
	}
	
	public void setInterview_result(String interview_result) {
		this.interview_result = interview_result;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getInterview_year() {
		return interview_year;
	}
	
	public void setInterview_year (int interview_year) {
		this.interview_year = interview_year;
	}
	
	public String getInterview_season() {
		return interview_season;
	}
	
	public void setInterview_season(String interview_season) {
		this.interview_season = interview_season;
	}
	
}

