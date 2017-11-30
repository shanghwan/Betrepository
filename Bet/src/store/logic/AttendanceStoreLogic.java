package store.logic;

import java.sql.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import store.AttendanceStore;
import store.mapper.AttendanceMapper;

@Repository
public class AttendanceStoreLogic implements AttendanceStore{

	@Override
	public void create(String userId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		HashMap<String, Object> map = new HashMap<>();
		try {
			AttendanceMapper mapper = session.getMapper(AttendanceMapper.class);
			mapper.create(userId);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(String userId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			AttendanceMapper mapper = session.getMapper(AttendanceMapper.class);
			mapper.delete(userId);
			session.commit();
		} finally {
			session.close();
		}
	}

	
}
