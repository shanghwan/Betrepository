package service;

import java.util.List;

import domain.Friend;
import domain.User;

public interface UserService {

	User login(User user);

	String regist(User user);

	void modifyUser(User user);

	User findByUserId(String userId);

	List<User> findByName(String name);

	List<User> findByPoint();

	void remove(String userId);

	void registFriend(String userId,  String friendId);

	void removeByUserId(String userId);

	void removeFriend(String userId, String friendId);

	List<Friend> findFriends(String userId);
}
