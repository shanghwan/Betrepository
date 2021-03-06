package store;

import java.util.List;

import domain.Player;

public interface PlayerStore {
	
	String create(Player player);
	Player searchByPlayerId(String playerId);
	Player searchByBetId(String userId, String betId);
	List<Player> searchByUserId(String userId);
	List<Player> searchByTeamId(String teamId,String betId);
	void update(Player player);
	void deleteByBetIdAndUserId(String userId, String betId);
	void delete(String playerId);
	int voteCount(String betId, String vote);

}
