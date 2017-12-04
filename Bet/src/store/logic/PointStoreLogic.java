package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Point;
import domain.User;
import store.PointStore;
import store.mapper.PointMapper;
import store.mapper.UserMapper;

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
			session.commit();
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
	public Point searchPoint(String userId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		Point point = null;
		try {
			PointMapper mapper = session.getMapper(PointMapper.class);
			point = mapper.searchPoint(userId);
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
}
