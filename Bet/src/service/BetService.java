package service;

import java.util.List;

import domain.Bet;

public interface BetService {
	
	String registBet(Bet bet);
	List<Bet> findAllBet();
	List<Bet> findByBetId(String betId);
	List<Bet> findByOwner(String betOwner);
	List<Bet> findByTitle(String title);
	List<Bet> findByState(String state);
	List<Bet> findByBetWay(String betWay);
	void modify(Bet bet);
	void removeBet(String betId);

}
