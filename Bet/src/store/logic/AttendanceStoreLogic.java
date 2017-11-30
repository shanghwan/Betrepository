package store.logic;

import java.sql.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Attendance;
import store.AttendanceStore;
import store.mapper.AttendanceMapper;

@Repository
public class AttendanceStoreLogic implements AttendanceStore{

	@Override
	public String create(Attendance attendance) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			AttendanceMapper mapper = session.getMapper(AttendanceMapper.class);
			mapper.create(attendance);
			session.commit();
		} finally {
			session.close();
		}
		return attendance.getAttendanceId();
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
