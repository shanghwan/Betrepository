package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Team;
import service.TeamService;
import store.TeamStore;

@Service
public class TeamServiceLogic implements TeamService{
	
	@Autowired
	private TeamStore teamStore;

	@Override
	public String registTeam(Team team) {
		
		return teamStore.create(team);
	}

	@Override
	public Team findTeam(String teamId) {
		
		return teamStore.search(teamId);
	}

	@Override
	public List<Team> findTeamByBetId(String betId) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return teamStore.searchByTeamName(betId, teamName);
	}
	
}
