package store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.User;
import store.InviteStore;
import store.mapper.InviteMapper;

@Repository
public class InviteStoreLogic implements InviteStore{

	@Override
	public void create(String userId, String betId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			InviteMapper mapper = session.getMapper(InviteMapper.class);
			map.put("userId", userId);
			map.put("betId", betId);
			mapper.create(map);
			session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void delete(String userId, String betId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			InviteMapper mapper = session.getMapper(InviteMapper.class);
			map.put("userId", userId);
			map.put("betId", betId);
			mapper.delete(map);
			session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<String> searchByAllInviteByBetId(String betId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		List<String> list = null;
		
		try {
			InviteMapper mapper = session.getMapper(InviteMapper.class);
			list = mapper.searchByAllInviteByBetId(betId);
		}finally {
			session.close();
		}
		
		return list;
	}
	

	@Override
	public List<String> searchByAllInviteByUserId(String userId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		List<String> list = null;
		
		try {
			InviteMapper mapper = session.getMapper(InviteMapper.class);
			list = mapper.searchByAllInviteByUserId(userId);
		}finally {
			session.close();
		}
		return list;
	}

}
