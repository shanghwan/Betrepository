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
	void delete(Map<String, String> map);
	
}
