package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Post_Feedback")
public class PostFeedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer post_feedback_id;
	
	@NotNull
	@Column(name = "USER_NAME", nullable = false)
	private String user_name;
	
	@NotNull
	@Column(name = "POST_ID", nullable = false)
	private Integer post_id;
	
	@NotNull
	@Column(name = "RATING", nullable = false)
	private Integer rating;
	
	@NotNull
	@Column(name = "COMMENT", nullable = false)
	private String comment;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "POST_DATE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate post_date;

	@SuppressWarnings("static-access")
	public PostFeedback() {
		post_date = new LocalDate().now();
	}
	
	public Integer getPost_feedback_id() {
		return post_feedback_id;
	}
	
	public PostFeedback setPost_feedback_id(Integer post_feedback_id) {
		this.post_feedback_id = post_feedback_id;
		return this;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public PostFeedback setUser_name(String user_name) {
		this.user_name = user_name;
		return this;
	}
	
	public Integer getPost_id() {
		return post_id;
	}
	
	public PostFeedback setPost_id(Integer post_id) {
		this.post_id = post_id;
		return this;
	}
	
	public Integer getRating() {
		return rating;
	}
	
	public PostFeedback setRating(Integer rating) {
		this.rating = rating;
		return this;
	}
	
	public String getComment() {
		return comment;
	}
	
	public PostFeedback setComment(String comment) {
		this.comment = comment;
		return this;
	}
	
	public LocalDate getPost_date() {
		return post_date;
	}
	
	public PostFeedback setPost_date(LocalDate post_date) {
		this.post_date = post_date;
		return this;
	}
}
