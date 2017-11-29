package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import service.InviteService;
import store.InviteStore;
@Service
public class InviteServiceLogic implements InviteService{
	
	@Autowired
	private InviteStore inviteStore;

	@Override
	public void registInvite(String userId, String betId) {
		
		inviteStore.create(userId, betId);
		
	}

	@Override
	public void removeInvite(String userId, String betId) {
		
		inviteStore.delete(userId, betId);
		
	}

	@Override
	public List<String> findByAllInviteByBetId(String betId) {
		return inviteStore.searchByAllInviteByBetId(betId);
	}

	@Override
	public List<String> findByAllInviteByUserId(String userId) {
		return inviteStore.searchByAllInviteByUserId(userId);
	}

}
