package service;

import java.util.List;

import domain.BetState;

public interface BetStateService {
	
	String registBetState(BetState betState);
	void modifyBetState(BetState betState);
	List<BetState> findBetState(String userId);
	void removeBetState(String betId);

}
