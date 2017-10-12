package com.fasoo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasoo.spring.dao.IReplyDao;
import com.fasoo.spring.model.Reply;

@Service("replyService")
@Transactional
public class ReplyService implements IReplyService {

	@Autowired
	private IReplyDao dao;
	
	public Reply findById(int id) {
		return dao.findById(id);
	}

	public void saveReply(Reply reply) {
		dao.saveReply(reply);
	}

	public void updateReply(Reply reply) {
		Reply entity = dao.findById(reply.getId());
		System.out.println("Here is the reply ID: " + reply.getId());
		if(entity != null){
			entity.setContents(reply.getContents());
			entity.setPost_date(reply.getPost_date());
		}
	}

	public void deleteReplyByID(int id) {
		dao.deleteReplyById(id);
	}

	public List<Reply> findAllReplies() {
		return dao.findAllReplies();
	}


	public List<Reply> findByPostId(int post_id) {
		return dao.findByPostId(post_id);
	}

	public void setCurrentlyWorkingReply(Reply currentlyWorkingReply) {
		dao.setCurrentlyWorkingReply(currentlyWorkingReply);
	}

	public Reply getCurrentlyWorkingReply() {
		return dao.getCurrentlyWorkingReply();
	}

	public List<Reply> findSortedReplies(int post_id) {
		return dao.findSortedReplies(post_id);
	}
}
