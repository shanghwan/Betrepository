package service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import domain.Player;
import domain.Team;
import domain.User;
import service.BetService;
import service.GameService;
import service.PlayerService;
import service.TeamService;
import store.UserStore;



@Service
public class GameServiceLogic implements GameService{
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private PlayerService playerService;
	@Autowired 
	private BetService betService;
	@Autowired
	private UserStore userStore;
	

	@Override
	public String joinBetOfAll(String userId, String teamName, String betId) {
		Team team = teamService.findByTeamName(betId, teamName);
		Player player = new Player();
		int point = 10;
		
		player.setBetId(betId);
		player.setUserId(userId);
		player.setPoint(point);
		player.setPosition("member");
		player.setTeamId(team.getTeamId());
		
		return playerService.registPlayer(player);
	}

	@Override
	public String joinBetOfOne(String userId, String teamName, String betId, int point) {
		Team team = teamService.findByTeamName(betId, teamName);
		Player player = new Player();
		Bet bet = betService.findByBetId(betId);
		User user = userStore.searchByUserId(userId);
		
		
		player.setBetId(betId);
		player.setTeamId(team.getTeamId());
		player.setPoint(point);
		player.setUserId(userId);
		player.setPosition("leader");
		
		if(bet.getPointCheck().equals("LOCK")) {
			player.setPoint(bet.getPoint());
		}else if(bet.getPointCheck().equals("ALLIN")) {
			player.setPoint(user.getPoint());
		}
		
		return playerService.registPlayer(player);
	}

	@Override
	public String joinBetOfTeam(String userId, String teamName, String betId, int point) {
		Team team = teamService.findByTeamName(betId, teamName);
		Player player = new Player();
		Bet bet = betService.findByBetId(betId);
		User user = userStore.searchByUserId(userId);
		
		
		player.setBetId(betId);
		player.setTeamId(team.getTeamId());
		player.setPoint(point);
		player.setUserId(userId);
		player.setPosition("member");
		
		if(team.getPlayers().isEmpty()) {
			player.setPosition("leader");
		}
		
		if(bet.getPointCheck().equals("LOCK")) {
			player.setPoint(bet.getPoint());
		}else if(bet.getPointCheck().equals("ALLIN")) {
			player.setPoint(user.getPoint());
		}
		
		return playerService.registPlayer(player);
	}

}
