package store;

import java.util.List;

import domain.User;

public interface InviteStore {
	
	void create(String userId, String betId);
	void delete(String userId, String betId);
	List<String> searchByAllInviteByBetId(String betId);
	List<String> searchByAllInviteByUserId(String userId);

}
