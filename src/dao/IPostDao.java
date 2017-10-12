package com.fasoo.spring.dao;

import java.util.List;
import com.fasoo.spring.model.Post;

/**
 * Data Access Object (DAO) for Post
 * 
 * @author Jin An
 * 
 */
public interface IPostDao {

	/**
	 * Identifies a post by id (primary key)
	 * 
	 * @param id
	 * @return
	 */
	Post findById(int id);

	/**
	 * Receives and saves the post to database
	 * 
	 * @param post
	 */
	void savePost(Post post);

	/**
	 * Find all Posts in the database
	 * 
	 * @return
	 */
	List<Post> findAllPosts();

	/**
	 * Deletes Post by looking up the id from database
	 * @param id
	 */
	void deletePostById(int id);
}
