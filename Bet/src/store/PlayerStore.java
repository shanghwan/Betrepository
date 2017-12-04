package store;

import java.util.List;

import domain.Player;

public interface PlayerStore {
	
	String create(Player player);
	Player searchByPlayerId(String PlayerId);
	Player searchByBetId(String userId, String betId);
	List<Player> searchByUserId(String userId);
	List<Player> searchByTeamId(String teamId,String betId);
	void update(Player player);
	void delete(String userId, String betId);
	int voteCount(String betId, String vote);
}
