package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Player;
import service.PlayerService;
import service.PointService;
import store.PlayerStore;
import store.PointStore;

@Service
public class PlayerServiceLogic implements PlayerService{

	@Autowired
	private PlayerStore playerStore;
	@Autowired
	private PointService pointService;
	@Autowired
	private PointStore pointStore;
	
	@Override
	public String registPlayer(Player player) {
		String result = playerStore.create(player);
		if(result!=null) {
			pointService.betJoinPoint(player.getUserId(), player.getBetId(), player.getPoint());
		}
		return result;
	}

	@Override
	public Player findPlayer(String playerId) {
		return playerStore.searchByPlayerId(playerId);
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
		
		pointStore.deleteByReceiverId(betId, userId);
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
