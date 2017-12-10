package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.IPostFeedbackDao;
import spring.model.PostFeedback;

public class PostFeedbackService implements IPostFeedbackService{

	@Override
	public void savePostFeedback(PostFeedback postFeedback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePostFeedback(PostFeedback postFeedback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePostFeedbackByID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostFeedback> findAllPostFeedbacks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostFeedback> findPostFeedbacksByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentPostFeedback(PostFeedback currentPostFeedback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PostFeedback getCurrentPostFeedback() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentPostFeedbackID(int currentPostFeedbackID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCurrentPostFeedbackID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public spring.service.PostFeedback getCurrentPostFeedback() {
		// TODO Auto-generated method stub
		return null;
	}

}
