package store;

import java.util.List;

import domain.Invite;

public interface InviteStore {
	
	void create(String userId, String betId);
	void delete(String userId, String betId);
	List<String> searchByAllInviteByBetId(String betId);
	List<Invite> searchByAllInviteByUserId(String userId);

}
