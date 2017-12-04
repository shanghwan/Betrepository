package service;

import java.util.List;

import domain.Player;

public interface PlayerService {
	
	String registPlayer(Player player);
	Player findPlayer(String playerId);
	List<Player> findByTeamId(String teamId);
	List<Player> findByUserId(String userId);
	void modifyPlayer(Player player);
	void removePlayer(String playerId);
	void removePlayer(String betId, String userId);
	Player findByBetId(String betId,String userId);
}
