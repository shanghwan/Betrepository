package store.mapper;

import java.util.HashMap;
import java.util.List;

import domain.Bet;

public interface BetMapper {
	void create(Bet bet);
	List<Bet> searchAllBet();

	Bet searchByBetId(String betId);

	List<Bet> searchByBetOwner(HashMap<String, String> map);

	List<Bet> searchByTitle(HashMap<String, String> map);

	List<Bet> searchByState(String state);

	List<Bet> searchByBetWay(String betWay);
	
	List<Bet> searchByUserId(String betOwner);

	void update(Bet bet);

	void delete(String betId);

}
