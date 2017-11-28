package store;

import java.util.List;

import domain.Team;

public interface TeamStore {
	
	String create(Team team);
	Team search(String teamId);
	List<Team> searchByBetId(String betId);
	void update(Team team);
	void delete(String betId);
	

}
