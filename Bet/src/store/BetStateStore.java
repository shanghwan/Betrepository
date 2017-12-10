package store;

import java.util.List;

import domain.BetState;

public interface BetStateStore {
	
	String create(BetState betState);
	void update(BetState betState);
	List<BetState> search(String userId);
	void delete(String betId);

}
