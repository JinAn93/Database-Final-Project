package com.fasoo.spring.model;

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
@Table(name="REPLIES")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "CONTENTS", nullable = false)
	private String contents;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "POST_DATE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate post_date;
	
	@NotNull
	@Size(max = 30)
	@Column(name = "USER_ID", nullable = false)
	private String user_id;
	
	@NotNull
	@Column(name = "POST_ID", nullable = false)
	private int post_id;
	
	@Column(name = "PARENT_ID", nullable = false)
	private int parent_id;
	
	@NotNull
	@Column(name = "DEPTH", nullable = false)
	private int depth;
	
	@SuppressWarnings("static-access")
	public Reply() {
		post_date = new LocalDate().now();
	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public LocalDate getPost_date() {
		return post_date;
	}

	public void setPost_date(LocalDate post_date) {
		this.post_date = post_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
}
