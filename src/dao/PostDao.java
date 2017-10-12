package com.fasoo.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.fasoo.spring.model.Post;

@Repository("postDao")
public class PostDao extends AbstractDao<Integer, Post> implements IPostDao{

	public Post findById(int id) {
		return getByKey(id);
	}

	public void savePost(Post post) {
		persist(post);
	}
	
	public void deletePostById(int id){
		Query query = getSession().createSQLQuery("delete from Posts where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Post> findAllPosts() {
		Criteria criteria = createEntityCriteria();
		return (List<Post>) criteria.list();
	}
}
