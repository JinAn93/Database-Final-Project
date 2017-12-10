package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.IPostFeedbackDao;
import spring.model.PostFeedback;

@Service("postFeedbackService")
@Transactional
public class PostFeedbackService implements IPostFeedbackService {

	@Autowired
	private IPostFeedbackDao dao;

	private PostFeedback currentPostFeedback;
	private int currentPostFeedbackID;

	public PostFeedback findById(int id) {
		return dao.findById(id);
	}

	public void savePostFeedback(PostFeedback postFeedback) {
		dao.savePostFeedback(postFeedback);
	}

	public void updatePostFeedback(PostFeedback postFeedback) {
		PostFeedback entity = dao.findById(postFeedback.getPost_feedback_id());
		if (entity != null) {
			entity.setComment(postFeedback.getComment());
			// entity.setPostFeedback_date(postFeedback.get());
		}
	}

	public void deletePostFeedbackByID(int id) {
		dao.deletePostFeedbackById(id);
	}

	public List<PostFeedback> findAllPostFeedbacks() {
		return dao.findAllPostFeedbacks();
	}

	public List<PostFeedback> findPostFeedbacksByUserName(String userName) {
		return dao.findPostFeedbacksByUserName(userName);
	}

	public void setCurrentPostFeedback(PostFeedback currentPostFeedback) {
		this.currentPostFeedback = currentPostFeedback;
	}

	public PostFeedback getCurrentPostFeedback() {
		return this.currentPostFeedback;
	}

	public void setCurrentPostFeedbackID(int currentPostFeedbackID) {
		this.currentPostFeedbackID = currentPostFeedbackID;
	}

	public int getCurrentPostFeedbackID() {
		return currentPostFeedbackID;
	}

}
