package service;

import java.util.List;

import domain.User;

public interface UserService {
	
	User login(User user);
	void regist(User user);
	void modifyUser(User user);
	User findByUserId(String userId);
	List<User> findByName(String name);
	List<User> findByPoint();
	void remove(String userId);
	String registFriend(String userId);
	void removeFriend(String userId);
	void attendanceUser(String userId); 

}
