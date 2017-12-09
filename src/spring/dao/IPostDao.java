package spring.dao;

import java.util.List;
import spring.model.Post;

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
	 * Find all Posts from a particular user name in the database
	 * @param userName
	 * @return
	 */
	List<Post> findPostsByUserName(String userName);

	/**
	 * Deletes Post by looking up the id from database
	 * @param id
	 */
	void deletePostById(int id);
}
