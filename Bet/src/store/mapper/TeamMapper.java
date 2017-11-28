package store.mapper;

import java.util.List;

import domain.Team;

public interface TeamMapper {
	void create(Team team);
	Team search(String teamId);
	List<Team> searchByBetId(String betId);
	void update(Team team);
	void delete(String betId);
}
