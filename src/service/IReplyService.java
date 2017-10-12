package com.fasoo.spring.service;

import java.util.List;

import com.fasoo.spring.model.Reply;

public interface IReplyService {

	Reply findById(int id);
	
	void saveReply(Reply reply);
	
	void updateReply(Reply reply);
	
	void deleteReplyByID(int id);
	
	List<Reply> findAllReplies();
	
	List<Reply> findByPostId(int post_id);
	
	List<Reply> findSortedReplies(int post_id);
	
	void setCurrentlyWorkingReply(Reply currentlyWorkingReply);
	
	Reply getCurrentlyWorkingReply();
}
