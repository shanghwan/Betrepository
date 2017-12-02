package store;

import java.util.List;

import domain.User;

public interface UserStore {

	void create(User user);

	User searchByUserId(String userId);

	List<User> searchByName(String name);

	List<User> searchByPoint();

	void update(User user);

	void delete(String userId);

}
