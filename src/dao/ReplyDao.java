package com.fasoo.spring.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fasoo.spring.model.Reply;

@Repository("replyDao")
public class ReplyDao extends AbstractDao<Integer, Reply> implements IReplyDao {

	private Reply currentlyWorkingReply;

	public Reply findById(int id) {
		return getByKey(id);
	}

	public void saveReply(Reply reply) {
		persist(reply);
	}

	@SuppressWarnings("unchecked")
	public List<Reply> findAllReplies() {
		Criteria criteria = createEntityCriteria();
		return (List<Reply>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Reply> findByPostId(int post_id) {
		return createEntityCriteria().add(
				Restrictions.eqOrIsNull("post_id", post_id)).list();
	}

	public void deleteReplyById(int id) {
		Query query = getSession().createSQLQuery(
				"delete from Replies where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	public Reply getCurrentlyWorkingReply() {
		return currentlyWorkingReply;
	}

	public void setCurrentlyWorkingReply(Reply currentlyWorkingReply) {
		this.currentlyWorkingReply = currentlyWorkingReply;
	}

	public List<Reply> findSortedReplies(int post_id) {
		List<Reply> repliesByPostId = findByPostId(post_id);
		List<Reply> rootReplies = findByParent_id(repliesByPostId, 0);
		List<Reply> sortedReplies = new ArrayList<>();
		if (rootReplies == null)
			return null;
		return dfs(repliesByPostId, 0, sortedReplies);
	}

	private List<Reply> dfs(List<Reply> repliesByPostId, int parent_id, List<Reply> sortedReplies) {

		List<Reply> children = findByParent_id(repliesByPostId, parent_id);
		for (Reply child : children) {
			sortedReplies.add(child);
			dfs(repliesByPostId, child.getId(), sortedReplies);
		}

		return sortedReplies;
	}

	private List<Reply> findByParent_id(List<Reply> repliesByPostID, int parent_id) {
		List<Reply> rootReplies = new ArrayList<>();
		for (Reply r : repliesByPostID) {
			if (r.getParent_id() == parent_id)
				rootReplies.add(r);
		}
		return rootReplies;
	}
}