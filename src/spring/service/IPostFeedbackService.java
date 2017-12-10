package spring.service;

import java.util.List;

import spring.model.PostFeedback;

public interface IPostFeedbackService {
	
	PostFeedback findById(int id);

	void savePostFeedback(PostFeedback postFeedback);

	void updatePostFeedback(PostFeedback postFeedback);

	void deletePostFeedbackByID(int id);

	List<PostFeedback> findAllPostFeedbacks();

	List<PostFeedback> findPostFeedbacksByUserName(String userName);

	void setCurrentPostFeedback(PostFeedback currentPostFeedback);

	PostFeedback getCurrentPostFeedback();

	void setCurrentPostFeedbackID(int currentPostFeedbackID);

	int getCurrentPostFeedbackID();

	List<PostFeedback> findPostFeedbacksByPostID(int post_id);
}
