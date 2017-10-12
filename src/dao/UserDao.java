package com.fasoo.spring.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.fasoo.spring.model.User;

@Repository("userDao")
public class UserDao extends AbstractDao<String, User> implements IUserDao {

	public User findById(String id) {
		return getByKey(id);
	}

	public void saveUser(User user) {
		persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	public void deleteUserById(String id) {
		Query query = getSession().createSQLQuery("delete from Users where user_id = :user_id");
		query.setString("user_id", id);
		query.executeUpdate();
	}

	public String hashPassword (String password){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] byteData = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
