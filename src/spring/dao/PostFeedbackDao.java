package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import spring.model.PostFeedback

@Repository("PostFeedbackDao")
public class PostFeedbackDao extends AbstractDao<Integer, PostFeedback> implements IPostFeedbackDao {

	public PostFeedback findById(int id) {
		return getByKey(id);
	}

	public void savePostFeedback(PostFeedback postFeedback) {
		persist(postFeedback);
	}

	public void deletePostFeedbackById(int id) {
		Query query = getSession().createSQLQuery("delete from Post_Feedback where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<PostFeedbackf> findAllPostFeedbacks() {
		Criteria criteria = createEntityCriteria();
		return (List<PostFeedback>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<PostFeedback> findPostsByUserName(String userName) {
		Query query = getSession().createSQLQuery("SELECT * FROM Post_Feedback WHERE user_name = :u_name").addEntity(PostFeedback.class);
		query.setString("u_name", userName);
		return (List<PostFeedback>) query.list();
	}

}