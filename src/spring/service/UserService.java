package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.IUserDao;
import spring.model.User;

@Service("userService")
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao dao;
	private PasswordEncoder passwordEncoder;
	
	//TODO: Resourcebundle
	private static final int NO_ERROR = 0;
	private static final int DIGIT_ERROR = 1;
	private static final int LOWERCASE_ERROR = 2;
	private static final int UPPERCASE_ERROR = 3;
	private static final int SPECIAL_CHAR_ERROR = 4;
	private static final int WHITESPACE_ERROR = 5;
	
	public User findById(String id) {
		return dao.findById(id);
	}

	public void saveUser(User user) {
		user.setPassword(dao.hashPassword(user.getPassword()));
		dao.saveUser(user);
	}

	public void updateUser(User user) {
		User entity = dao.findById(user.getUser_name());
		if (entity != null) {
			entity.setFirst_name(user.getFirst_name());
			entity.setEmail(user.getEmail());
			entity.setPassword(dao.hashPassword(user.getPassword()));
		}
	}

	public void deleteUserById(String id) {
		dao.deleteUserById(id);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserIdUnique(String user_name) {
		List<User> allUsers = findAllUsers();
		for (User user : allUsers) {
			if (user.getUser_name().equals(user_name))
				return false;
		}
		return true;
	}
	
	public int isPasswordValid (String password) {
		if(!password.matches("(?=.*[0-9]).+"))
			return DIGIT_ERROR;
		if(!password.matches("(?=.*[a-z]).+"))
			return LOWERCASE_ERROR;
		if(!password.matches("(?=.*[a-z]).+"))
			return UPPERCASE_ERROR;
		if(!password.matches("(?=.*[!@#$%^&*+=?-_()/\"\\.,<>~`;:]).+"))
			return SPECIAL_CHAR_ERROR;
		if(!password.matches("(?=\\S+$).+"))
			return WHITESPACE_ERROR;
		return NO_ERROR;

	}
	
	public boolean isValidUser(String user_name, String password) {
		return dao.isValidUser(user_name, dao.hashPassword(password));
	}
}
