package service;

import java.util.List;

import domain.Invite;

public interface InviteService {
	
	void registInvite(String userId, String betId);
	void removeInvite(String userId, String betId);
	List<String> findByAllInviteByBetId(String betId);
	List<Invite> findByAllInviteByUserId(String userId);

}
