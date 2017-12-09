package store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Point;
import store.PointStore;
import store.mapper.PointMapper;

@Repository
public class PointStoreLogic implements PointStore {

	@Override
	public String create(Point point) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			PointMapper mapper = session.getMapper(PointMapper.class);
			mapper.create(point);
			session.commit();
		} finally {
			session.close();
		}
		return point.getPointId();
	}

	@Override
	public List<Point> searchAll(String userId) {

		List<Point> list = null;
		SqlSession session = BetSessionFactory.getinstance().getSession();

		try {
			PointMapper mapper = session.getMapper(PointMapper.class);
			list = mapper.searchAll(userId);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void delete(String userId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			PointMapper mapper = session.getMapper(PointMapper.class);
			mapper.delete(userId);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Point point) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			PointMapper mapper = session.getMapper(PointMapper.class);
			mapper.update(point);
			session.commit();
		} finally {
			session.close();
		}
		// return point.getPointId();
	}

	@Override
	public Point searchByUserIdBetId(String userId, String receiverId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		HashMap<String, String> map = new HashMap<>();
		Point point = null;
		try {
			PointMapper mapper = session.getMapper(PointMapper.class);
			map.put("receiverId", receiverId);
			map.put("userId", userId);
			point = mapper.searchByUserIdBetId(map);
		} finally {
			session.close();
		}
		return point;
	}

	@Override
	public Point searchReceiver(String receiverId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		Point point = null;
		try {
			PointMapper mapper = session.getMapper(PointMapper.class);
			point = mapper.searchReceiver(receiverId);
		} finally {
			session.close();
		}
		return point;
	}

	@Override
	public void deleteByReceiverId(String receiverId, String userId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		HashMap<String, String> map = new HashMap<>();
		
		try {
			PointMapper mapper = session.getMapper(PointMapper.class);
			map.put("receiverId", receiverId);
			map.put("userId", userId);
			mapper.deleteByReceiverId(map);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public void deleteByPointId(String pointId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		try {
			PointMapper mapper = session.getMapper(PointMapper.class);
			mapper.deleteByPointId(pointId);
			session.commit();
		} finally {
			session.close();
		}
		
	}
}
