package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.User;
import store.UserStore;
import store.mapper.UserMapper;

@Repository
public class UserStoreLogic implements UserStore{

	@Override
	public void create(User user) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			System.out.println(user.toString());
			
			mapper.create(user);
			
			session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public User searchByUserId(String userId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		User user = null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			user = mapper.searchByUserId(userId);
		}
		finally {
			session.close();
		}
		return user;
	}

	@Override
	public List<User> searchByName(String name) {
		
		List<User> list = null;
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.searchByName(name);
			session.commit();
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<User> searchByPoint() {
		
		List<User> list = null;
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.searchByPoint();
			session.commit();
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public void update(User user) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.update(user);
			session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void delete(String userId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.delete(userId);
			session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void attendance(String userId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.attendance(userId);
			session.commit();
		}finally {
			session.close();
		}
	}

}
