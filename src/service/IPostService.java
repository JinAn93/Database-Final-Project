package service;

import java.util.List;

import model.Post;

public interface IPostService {

	Post findById(int id);
	
	void savePost(Post post);
	
	void updatePost(Post post);
	
	void deletePostByID(int id);
	
	List<Post> findAllPosts();
	
	void setCurrentPost(Post currentPost);
	
	Post getCurrentPost();
	
	void setCurrentPostID(int currentPostID);
	
	int getCurrentPostID();
}
