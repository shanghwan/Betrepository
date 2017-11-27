package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import service.BetService;
import store.BetStore;

@Service
public class BetServiceLogic implements BetService{
	
	@Autowired
	private BetStore store;

	@Override
	public String registBet(Bet bet) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		bet.setStartDate(today);
		return store.create(bet);
	}

	@Override
	public List<Bet> findAllBet() {
		return null;
	}

	@Override
	public List<Bet> findByBetId(String betId) {
		return null;
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
		return null;
	}

	@Override
	public List<Bet> findByBetWay(String betWay) {
		return null;
	}

	@Override
	public void modify(Bet bet) {
		
	}

	@Override
	public void removeBet(String betId) {
		
	}

}
