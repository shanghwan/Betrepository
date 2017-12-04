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
	public void deleteByBetIdAndUserId(String userId, String betId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();

		HashMap<String, String> map = new HashMap<>();

		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);
			map.put("userId", userId);
			map.put("betId", betId);
			mapper.deleteByBetIdAndUserId(map);
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
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Player searchByBetId(String userId, String betId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		HashMap<String, String> map = new HashMap<>();
		Player player = null;
		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);
			map.put("userId", userId);
			map.put("betId", betId);
			player = mapper.searchByBetId(map);
		} finally {
			session.close();
		}
		return player;
	}

	@Override
	public int voteCount(String betId, String vote) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		HashMap<String, String> map = new HashMap<>();
		int result = 0;
		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);
			map.put("vote", vote);
			map.put("betId", betId);
			result = mapper.voteCount(map);
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public void delete(String playerId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);

			mapper.delete(playerId);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public Player searchPointByTeamId(String teamId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		Player player = null;
		try {
			PlayerMapper mapper = session.getMapper(PlayerMapper.class);
			player = mapper.searchPointByTeamId(teamId);
		} finally {
			session.close();
		}
		return player;
	}
}
