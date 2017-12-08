package service;

import java.util.List;

import domain.Bet;

public interface BetService {
	
	String registBet(Bet bet);
	List<Bet> findAllBet();
	Bet findByBetId(String betId);
	List<Bet> findByOwner(String betOwner, String betWay);
	List<Bet> findByUserId(String betOwner);
	List<Bet> findByTitle(String title, String betWay);
	List<Bet> findByState(String state);
	List<Bet> findByBetWay(String betWay);
	void modify(Bet bet);
	void removeBet(String betId);

}
