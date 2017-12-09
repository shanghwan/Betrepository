package store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Bet;
import store.BetStore;
import store.mapper.BetMapper;


@Repository
public class BetStoreLogic implements BetStore{
	

	@Override
	public String create(Bet bet) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			BetMapper mapper = session.getMapper(BetMapper.class);
			mapper.create(bet);
			session.commit();
		}finally {
			session.close();
		}
		
		return bet.getBetId();
	}

	@Override
	public List<Bet> searchAllBet() {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Bet> list = null;
		
		try {
			BetMapper mapper = session.getMapper(BetMapper.class);
			list = mapper.searchAllBet();
		}finally {
			session.close();
		}
		
		return list;
	}
	

	@Override
	public Bet searchByBetId(String betId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		Bet bet = null;
		
		try {
			BetMapper mapper = session.getMapper(BetMapper.class);
			bet = mapper.searchByBetId(betId);
			System.out.println("스토어B"+bet.getPhotoB());
		}finally {
			session.close();
		}
		System.out.println("스토어A"+bet.getPhotoA());
		
		return bet;
	}

	@Override
	public List<Bet> searchByBetOwner(String betOwner, String betWay) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		HashMap<String, String> map = new HashMap<>();
		List<Bet> list = null;
		
		try {
			BetMapper mapper = session.getMapper(BetMapper.class);
			map.put("betOwner", betOwner);
			map.put("betWay", betWay);
			list = mapper.searchByBetOwner(map);
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<Bet> searchByTitle(String title, String betWay) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Bet> list = null;
		HashMap<String, String> map = new HashMap<>();
		
		try {
			BetMapper mapper = session.getMapper(BetMapper.class);
			map.put("title", title);
			map.put("betWay", betWay);
			list = mapper.searchByTitle(map);
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Bet> searchByState(String state) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Bet> list = null;
		
		try {
			BetMapper mapper = session.getMapper(BetMapper.class);
			list = mapper.searchByState(state);
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Bet> searchByBetWay(String betWay) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Bet> list = null;
		
		try {
			BetMapper mapper = session.getMapper(BetMapper.class);
			list = mapper.searchByBetWay(betWay);
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public void update(Bet bet) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			BetMapper mapper = session.getMapper(BetMapper.class);
			mapper.update(bet);
			session.commit();
		}finally {
			session.close();
		}
	}

	@Override
	public void delete(String betId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			BetMapper mapper = session.getMapper(BetMapper.class);
			mapper.delete(betId);
			session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Bet> searchByUserId(String betOwner) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Bet> list = null;

		try {
			BetMapper mapper = session.getMapper(BetMapper.class);
			list = mapper.searchByUserId(betOwner);

		} finally {
			session.close();
		}
		return list;
	}



}
