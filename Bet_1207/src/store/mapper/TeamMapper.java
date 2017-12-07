package store.mapper;

import java.util.List;
import java.util.Map;

import domain.Team;

public interface TeamMapper {
	void create(Team team);
	Team search(String teamId);
	List<Team> searchByBetId(String betId);
	Team searchByTeamName(Map<String, String> map);
	void update(Team team);
	void delete(String betId);
}
