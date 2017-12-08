package service.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import domain.Invite;
import domain.User;
import service.InviteService;
import store.BetStore;
import store.InviteStore;
@Service
public class InviteServiceLogic implements InviteService{
	
	@Autowired
	private InviteStore inviteStore;
	@Autowired
	private BetStore betStore;

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
	public List<Invite> findByAllInviteByUserId(String userId) {
		
		List<Invite> list = inviteStore.searchByAllInviteByUserId(userId);
		List<Invite> listTrue = new ArrayList<>(); 
		for(Invite in : list) {
			String betId = in.getBetId();
			Bet bet = betStore.searchByBetId(betId);
			
			Invite invite = new Invite();
			invite.setBetId(betId);
			invite.setInviteUserId(userId);
			invite.setTitle(bet.getTitle());
			invite.setBetOwner(bet.getBetOwner());
			listTrue.add(invite);
			
		}
		return listTrue;
	}

}
