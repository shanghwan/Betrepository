package store.logic;

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
		}finally {
			session.close();
		}
		
		return bet;
	}

	@Override
	public List<Bet> searchByBetOwner(String betOwner) {
		return null;
	}

	@Override
	public List<Bet> searchByTitle(String title) {
		return null;
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
		
	}

	@Override
	public void delete(String betId) {
		
	}



}
