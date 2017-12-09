package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Player;
import domain.Team;
import service.PointService;
import service.TeamService;
import store.PlayerStore;
import store.TeamStore;

@Service
public class TeamServiceLogic implements TeamService {

	@Autowired
	private TeamStore teamStore;
	@Autowired
	private PlayerStore playerStore;
	@Autowired
	private PointService pointService;

	@Override
	public String registTeam(Team team) {

		return teamStore.create(team);
	}

	@Override
	public Team findTeam(String teamId) {
		Team team = teamStore.search(teamId);
		List<Player> players = playerStore.searchByTeamId(team.getTeamId(), team.getBetId());
		int total = 0;
		for (Player p : players) {
			if (p.getPosition().equals("leader")) {
				team.setLeader(p);
			}
			total = total + p.getPoint();
		}
		team.setPlayers(players);
		team.setTotalPoint(total);
		
//		if (team.getPlayers().isEmpty()) {
//			team.setStart("N");
//			teamStore.update(team);
//		}

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
		int total = 0;
		for (Player p : players) {
			if (p.getPosition().equals("leader")) {
				team.setLeader(p);
			}
			total = total + p.getPoint();
		}
		team.setPlayers(players);
		team.setTotalPoint(total);

		if (team.getPlayers().isEmpty()) {
			team.setStart("N");
			teamStore.update(team);
		}

		return team;
	}

	@Override
	public String removePlayerByTeam(String userId, String betId, String teamId) {
		// Team team = findTeam(teamId);
		// if(team.getLeader().getUserId().equals(userId)) {
		// team.setStart("N");
		// teamStore.update(team);
		// }
		playerStore.deleteByBetIdAndUserId(userId, betId);
		Team team = findTeam(teamId);
		if (team.getPlayers().size() > 0) {
			if (team.getLeader() == null) {
				String playerId = team.getPlayers().get(0).getPlayerId();
				Player player = playerStore.searchByPlayerId(playerId);
				player.setPosition("leader");
				playerStore.update(player);
			}
		}
		pointService.betExitPoint(userId, betId);
		return null;
	}

}
