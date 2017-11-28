package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Team;
import store.TeamStore;
import store.mapper.TeamMapper;

@Repository
public class TeamStoreLogic implements TeamStore{

	@Override
	public String create(Team team) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			TeamMapper mapper = session.getMapper(TeamMapper.class);
			mapper.create(team);
			session.commit();
		} finally {
			session.close();
		}
		
		return team.getTeamId();
	}

	@Override
	public Team search(String teamId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		Team team = null;
		
		try {
			TeamMapper mapper = session.getMapper(TeamMapper.class);
			team = mapper.search(teamId);
		}finally {
			session.close();
		}
		return team;
	}

	@Override
	public List<Team> searchByBetId(String betId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Team> teams = null;
		
		try {
			TeamMapper mapper = session.getMapper(TeamMapper.class);
			teams = mapper.searchByBetId(betId);
		}finally {
			session.close();
		}
		return teams;
	}

	@Override
	public void update(Team team) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			TeamMapper mapper = session.getMapper(TeamMapper.class);
			mapper.update(team);
			session.commit();
		}finally {
			session.close();
		}
	}

	@Override
	public void delete(String betId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			TeamMapper mapper = session.getMapper(TeamMapper.class);
			mapper.delete(betId);
			session.commit();
		}finally {
			session.close();
		}
	}

}
