package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Record;
import store.RecordStore;
import store.mapper.RecordMapper;

@Repository
public class RecordStoreLogic implements RecordStore {

	@Override
	public String create(Record record) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			RecordMapper mapper = session.getMapper(RecordMapper.class);
			mapper.create(record);
			session.commit();
		} finally {
			session.close();
		}
		return record.getUserId();
	}

	@Override
	public Record search(String userId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		Record record = null;

		try {
			RecordMapper mapper = session.getMapper(RecordMapper.class);
			record = mapper.search(userId);
		} finally {
			session.close();
		}
		return record;
	}

	@Override
	public void update(Record record) {
		SqlSession session = BetSessionFactory.getinstance().getSession();

		try {
			RecordMapper mapper = session.getMapper(RecordMapper.class);
			mapper.update(record);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(String userId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();

		try {
			RecordMapper mapper = session.getMapper(RecordMapper.class);
			mapper.delete(userId);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public List<Record> winSearch() {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Record> list = null;
		
		try {
			RecordMapper mapper = session.getMapper(RecordMapper.class);
			list = mapper.winSearch();
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Record> loseSearch() {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Record> list = null;
		
		try {
			RecordMapper mapper = session.getMapper(RecordMapper.class);
			list = mapper.loseSearch();
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	
	@Override
	public List<Record> totalSearch() {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Record> list = null;
		
		try {
			RecordMapper mapper = session.getMapper(RecordMapper.class);
			list = mapper.totalSearch();
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Record> rateSearch() {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Record> list = null;
		
		try {
			RecordMapper mapper = session.getMapper(RecordMapper.class);
			list = mapper.rateSearch();
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

}
