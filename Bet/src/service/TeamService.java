package service;

import java.util.List;

import domain.Team;

public interface TeamService {
	
	String registTeam(Team team);
	Team findTeam(String teamId);
	List<Team> findTeamByBetId(String betId);
	void modifyTeam(Team team);
	void removeTeam(String betId);
	Team findByTeamName(String betId, String teamName);
	String removePlayerByTeam(String userId,String betId, String teamId);
}
