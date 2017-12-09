package store;

import java.util.List;

import domain.Bet;

public interface BetStore {
	
	String create(Bet bet);
	List<Bet> searchAllBet();
	Bet searchByBetId(String betId);
	List<Bet> searchByBetOwner(String betOwner, String betWay);
	List<Bet> searchByUserId(String betOwner);
	List<Bet> searchByTitle(String title, String betWay);
	List<Bet> searchByState(String state);
	List<Bet> searchByBetWay(String betWay);
	void update(Bet bet);
	void delete(String betId);
}
