package store.logic;

import java.util.List;

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

	@Override
	public List<Attendance> search(String userId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Attendance> list = null;
		try {
			AttendanceMapper mapper = session.getMapper(AttendanceMapper.class);
			list = mapper.search(userId);
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	
}
