package com.fasoo.spring.dao;

import java.util.List;

import com.fasoo.spring.model.Reply;

/**
 * Data Access Object (DAO) for Reply
 * 
 * @author Jin An
 *
 */
public interface IReplyDao {

	/**
	 * Identifies a reply by id (primary key)
	 * @param id
	 * @return
	 */
	Reply findById (int id);
	
	/**
	 * Saves reply to database 
	 * @param reply
	 */
	void saveReply (Reply reply);
	
	/**
	 * Finds all the replies from database
	 * @return
	 */
	List<Reply> findAllReplies();
	
	/**
	 * Find all the relevant replies under same post_id from database
	 * @param post_id
	 * @return
	 */
	List<Reply> findByPostId (int post_id);
	
	/**
	 * Return sorted list of replies of post_id by parent_id and depth
	 * @param post_id
	 * @return
	 */
	List<Reply> findSortedReplies(int post_id);
	/**
	 * Deletes reply by looking up the id from database
	 * @param id
	 */
	void deleteReplyById (int id);
	
	/**
	 * Return currently working reply that has been stored previously
	 * @return
	 */
	Reply getCurrentlyWorkingReply();
	
	/**
	 * Set currently working reply object
	 * @param currentlyWorkingReply
	 */
	void setCurrentlyWorkingReply(Reply currentlyWorkingReply);
}
