package store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Player;
import store.PlayerStore;
import store.mapper.PlayerMapper;

@Repository
public class PlayerStoreLogic implements PlayerStore {

	@Override
	public String create(Player player) {

		SqlSession session = BetSessionFactory.getinstance().getSession();

		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);
			mapper.create(player);
			session.commit();
		} finally {
			session.close();
		}

		return player.getPlayerId();
	}

	@Override
	public Player searchByPlayerId(String PlayerId) {

		SqlSession session = BetSessionFactory.getinstance().getSession();
		Player player = null;
		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);
			player = mapper.searchByPlayerId(PlayerId);
		} finally {
			session.close();
		}

		return player;
	}

	@Override
	public List<Player> searchByTeamId(String teamId, String betId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		HashMap<String, String> map = new HashMap<>();
		List<Player> players = null;
		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);
			map.put("teamId", teamId);
			map.put("betId", betId);
			players = mapper.searchByTeamId(map);
		} finally {
			session.close();
		}
		return players;
	}

	@Override
	public void update(Player player) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);
			mapper.update(player);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(String userId, String betId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();

		HashMap<String, String> map = new HashMap<>();

		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);
			map.put("userId", userId);
			map.put("betId", betId);
			mapper.delete(map);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Player> searchByUserId(String userId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		List<Player> list = null;
		
		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);
			list = mapper.searchByUserId(userId);
		}finally {
			session.close();
		}
		
		return list;
	}

}
