package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Player;
import service.PlayerService;
import store.PlayerStore;

@Service
public class PlayerServiceLogic implements PlayerService{

	@Autowired
	private PlayerStore playerStore;
	
	@Override
	public String registPlayer(Player player) {
		return playerStore.create(player);
	}

	@Override
	public Player findPlayer(String playerId) {
		return null;
	}

	@Override
	public List<Player> findByTeamId(String teamId) {
		return null;
	}

	@Override
	public void modifyPlayer(Player player) {
		playerStore.update(player);
	}

	@Override
	public void removePlayer(String playerId) {
		playerStore.delete(playerId);
	}

	@Override
	public void removePlayerByBetIdAndUserId(String betId, String userId) {
		playerStore.deleteByBetIdAndUserId(userId, betId);
	}

	@Override
	public List<Player> findByUserId(String userId) {
		return playerStore.searchByUserId(userId);
	}

	@Override
	public Player findByBetId(String betId,String userId) {
		return playerStore.searchByBetId(betId,userId);
	}
}
