package store.mapper;

import java.util.List;

import domain.BetState;

public interface BetStateMapper {
	
	String create(BetState betState);
	void update(BetState betState);
	List<BetState> search(String userId, String state);
	void delete(String betId);

}
