package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import domain.User;
import service.UserService;
import store.UserStore;
@Service
public class UserServiceLogic implements UserService{
	
	@Autowired
	private UserStore userstore;

	@Override
	public User login(User user) {
		
		User readerUser = null;
		
		if(validate(user)) {
			readerUser = userstore.searchByUserId(user.getUserId());
		}
		return readerUser;
		
	}
	
	private boolean validate(User user) {
	      if (user == null) {
	         throw new RuntimeException("사용자 정보가 없습니다.");
	      } else if (user.getUserId() == null || user.getUserId().isEmpty()) {
	         throw new RuntimeException("ID가 없습니다.");
	      } else if (user.getPassword() == null || user.getPassword().isEmpty()) {
	         throw new RuntimeException("비밀번호가 없습니다.");
	      }
	      return true;
	   }

	@Override
	public void regist(User user) {
		userstore.create(user);
	}

	@Override
	public void modifyUser(User user) {
		
		userstore.update(user);
		
	}

	@Override
	public User findByUserId(String userId) {
		return userstore.searchByUserId(userId);
	}

	@Override
	public List<User> findByName(String name) {
		return null;
	}

	@Override
	public List<User> findByPoint() {
		return null;
	}

	@Override
	public void remove(String userId) {
		userstore.delete(userId);
	}

	@Override
	public String registFriend(String userId) {
		return null;
	}

	@Override
	public void removeFriend(String userId) {
		
	}

}
