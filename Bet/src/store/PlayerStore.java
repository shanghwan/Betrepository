package store;

import java.util.List;

import domain.Player;

public interface PlayerStore {
	
	String create(Player player);
	Player searchByPlayerId(String PlayerId);
	List<Player> searchByTeamId(String teamId,String betId);
	void update(Player player);
	void delete(String userId, String betId);
	

}
