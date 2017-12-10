package store;

import java.util.List;

import domain.Friend;

public interface FriendStore {
	void create(String userId, String friendId);

	void delete(String userId, String friendId);

	void deleteByFriendId(String userId);

	List<Friend> search(String userId);
}