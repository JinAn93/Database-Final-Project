package spring.dao;

import java.util.List;

import spring.model.PostFeedback;

/**
 * Data Access Object (DAO) for Post_Feedback
 * 
 * @author taekwhunchung
 */

public interface IPostFeedbackDao {

	/**
	 * Identifies a post feedback by id (primary key)
	 * 
	 * @param id
	 * @return
	 */
	PostFeedback findById(int id);

	/**
	 * Receives and saves the post feedback to database
	 * 
	 * @param post
	 */
	void savePostFeedback(PostFeedback postFeedback);

	/**
	 * Find all post feedbacks in the database
	 * 
	 * @return
	 */
	List<PostFeedback> findAllPostFeedbacks();

	/**
	 * Find all post feedbacks from a particular user name in the database
	 * 
	 * @param userName
	 * @return
	 */
	List<PostFeedback> findPostFeedbacksByUserName(String userName);

	/**
	 * Deletes post feedback by looking up the id from database
	 * 
	 * @param id
	 */
	void deletePostFeedbackById(int id);
}
