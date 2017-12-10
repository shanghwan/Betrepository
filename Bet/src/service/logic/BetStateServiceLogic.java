package service.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import domain.BetState;
import domain.Player;
import service.BetStateService;
import store.BetStateStore;
import store.BetStore;
import store.PlayerStore;

@Service
public class BetStateServiceLogic implements BetStateService{
	
	@Autowired
	private BetStore betStore;
	@Autowired
	private PlayerStore playerStore;

	@Override
	public String registBetState(BetState betState) {
		return null;
	}

	@Override
	public void modifyBetState(BetState betState) {
		
	}

	@Override
	public List<BetState> findBetState(String userId) {
		
		List<Player> playerlist = playerStore.searchByUserId(userId);
		
		
		List<BetState> betstatelist = new ArrayList<>();
		
			for(Player list : playerlist) {
				String betId = list.getBetId();
				Bet bet = betStore.searchByBetId(betId);
				
				BetState betstate1 = new BetState();
				betstate1.setBetId(betId);
				betstate1.setBetOwner(bet.getBetOwner());
				betstate1.setBetWay(bet.getBetWay());
				betstate1.setUserId(userId);
				betstate1.setState(bet.getState());
				betstate1.setTitle(bet.getTitle());
				betstatelist.add(betstate1);
			}
			return betstatelist;
	}
		
		

	@Override
	public void removeBetState(String betId) {
		
	}

}
