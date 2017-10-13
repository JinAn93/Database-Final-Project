package dao;

import java.util.List;

import model.User;

/**
 * Data Access Object(DAO) for User.
 * @author Jin An
 *
 */
public interface IUserDao {
	
	/**
	 * Identifies a user by user_id
	 * @param id
	 * @return
	 */
	User findById(String id);

	/**
	 * Receives the User object and save it to database
	 * @param user
	 */
	void saveUser(User user);

	/**
	 * Find all Users in the database
	 * @return
	 */
	List<User> findAllUsers();

	/**
	 * Delete User from database by using user_id
	 * @param id
	 */
	void deleteUserById(String id);

	/**
	 * Hash Password using SHA-256
	 * @param password
	 * @return
	 */
	String hashPassword(String password);
}
