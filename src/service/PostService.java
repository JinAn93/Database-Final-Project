package com.fasoo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasoo.spring.dao.IPostDao;
import com.fasoo.spring.model.Post;

@Service("postService")
@Transactional
public class PostService implements IPostService{

	@Autowired
	private IPostDao dao;
	
	private Post currentPost; 
	private int currentPostID;
	
	public Post findById(int id) {
		return dao.findById(id);
	}

	public void savePost(Post post) {
		dao.savePost(post);
	}

	public void updatePost(Post post) {
		Post entity = dao.findById(post.getId());
		if(entity != null){
			entity.setContents(post.getContents());
			entity.setPost_date(post.getPost_date());
			entity.setTitle(post.getTitle());
		}		
	}

	public void deletePostByID(int id) {
		dao.deletePostById(id);
	}

	public List<Post> findAllPosts() {
		return dao.findAllPosts();
	}

	public void setCurrentPost(Post currentPost) {
		this.currentPost = currentPost;		
	}

	public Post getCurrentPost() {
		return this.currentPost;
	}

	public int getCurrentPostID() {
		return currentPostID;
	}

	public void setCurrentPostID(int currentPostID) {
		this.currentPostID = currentPostID;
	}
}
