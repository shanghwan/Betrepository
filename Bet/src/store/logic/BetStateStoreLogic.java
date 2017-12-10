package store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import domain.BetState;
import store.BetStateStore;

@Repository
public class BetStateStoreLogic implements BetStateStore{

	@Override
	public String create(BetState betState) {
		return null;
	}

	@Override
	public void update(BetState betState) {
		
	}

	@Override
	public List<BetState> search(String userId) {
		return null;
	}

	@Override
	public void delete(String betId) {
		
	}

}
