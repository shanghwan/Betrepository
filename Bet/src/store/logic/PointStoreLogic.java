package store.logic;

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
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public String gift(Point point) {
		SqlSession session = BetSessionFactory.getinstance().getSession();

		try {
			PointMapper mapper = session.getMapper(PointMapper.class);
			mapper.gift(point);
			session.commit();
		} finally {
			session.close();
		}
		return point.getPointId();
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
}
