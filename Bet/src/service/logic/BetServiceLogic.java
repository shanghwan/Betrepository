package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import domain.User;
import service.BetService;
import store.BetStore;
import store.UserStore;

@Service
public class BetServiceLogic implements BetService{
	
	@Autowired
	private BetStore store;
	
	@Autowired
	private UserStore userStore;
	

	@Override
	public String registBet(Bet bet) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		bet.setStartDate(today);
		
		if(bet.getBetWay().equals("all")) {
			bet.setPointCheck("����");
		}
		
		if(bet.getPointCheck().equals("����")) {
		User user = userStore.searchByUserId(bet.getBetOwner());
		bet.setPoint(user.getPoint());
		}
		
		
		// point ���� ����ؾ���
				//������ ����Ʈ �����ؾ���
		
		
		return store.create(bet);
	}

	@Override
	public List<Bet> findAllBet() {
		return store.searchAllBet();
	}

	@Override
	public Bet findByBetId(String betId) {
		return store.searchByBetId(betId);
	}

	@Override
	public List<Bet> findByOwner(String betOwner) {
		return null;
	}

	@Override
	public List<Bet> findByTitle(String title) {
		return null;
	}

	@Override
	public List<Bet> findByState(String state) {
		return store.searchByState(state);
	}

	@Override
	public List<Bet> findByBetWay(String betWay) {
		return store.searchByBetWay(betWay);
	}

	@Override
	public void modify(Bet bet) {
		
	}

	@Override
	public void removeBet(String betId) {
		
	}

}
