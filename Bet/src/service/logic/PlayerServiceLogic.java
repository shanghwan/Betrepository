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
		// TODO Auto-generated method stub
		return playerStore.create(player);
	}

	@Override
	public Player findPlayer(String playerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> findByTeamId(String teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePlayer(String playerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePlayer(String betId, String userId) {
		// TODO Auto-generated method stub
		
	}

}
