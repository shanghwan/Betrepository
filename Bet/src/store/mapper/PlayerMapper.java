package store.mapper;

import java.util.List;
import java.util.Map;

import domain.Player;

public interface PlayerMapper {

	void create(Player player);
	Player searchByPlayerId(String PlayerId);
	List<Player> searchByUserId(String userId);
	List<Player> searchByTeamId(Map<String, String> map);
	void update(Player player);
	void deleteByBetIdAndUserId(Map<String, String> map);
	void delete(String playerId);
	void deleteByBetId(String betId);
	Player searchByBetId(Map<String, String> map);
	int voteCount(Map<String, String> map);
}
