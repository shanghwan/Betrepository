package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Player;
import domain.Team;
import service.TeamService;
import store.PlayerStore;
import store.TeamStore;

@Service
public class TeamServiceLogic implements TeamService{
	
	@Autowired
	private TeamStore teamStore;
	@Autowired
	private PlayerStore playerStore;

	@Override
	public String registTeam(Team team) {
		
		return teamStore.create(team);
	}

	@Override
	public Team findTeam(String teamId) {
		Team team = teamStore.search(teamId);
		List<Player> players = playerStore.searchByTeamId(team.getTeamId(), team.getBetId());
		for(Player p : players) {
			if(p.getPosition().equals("leader")) {
				team.setLeader(p);
			}
		}
		team.setPlayers(players);
		return team;
		
	}

	@Override
	public List<Team> findTeamByBetId(String betId) {
		return teamStore.searchByBetId(betId);
		
	}

	@Override
	public void modifyTeam(Team team) {
		teamStore.update(team);
		
	}

	@Override
	public void removeTeam(String betId) {
		teamStore.delete(betId);
		
	}

	@Override
	public Team findByTeamName(String betId, String teamName) {
		Team team = teamStore.searchByTeamName(betId, teamName);
		
		List<Player> players = playerStore.searchByTeamId(team.getTeamId(), betId);
		for(Player p : players) {
			if(p.getPosition().equals("leader")) {
				team.setLeader(p);
			}
		}
		team.setPlayers(players);
		return team;
	}

	@Override
	public void removePlayerByTeam(String userId, String betId, String teamId) {
		playerStore.deleteByBetIdAndUserId(userId, betId);
		Team team = findTeam(teamId);
		if(team.getPlayers().size()>0) {
			if(team.getLeader()==null) {
				String playerId = team.getPlayers().get(0).getPlayerId();
				Player player = playerStore.searchByPlayerId(playerId);
				player.setPosition("leader");
				playerStore.update(player);
			}
		}
	}
	
}
