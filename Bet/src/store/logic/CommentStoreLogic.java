package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Comment;
import store.CommentStore;
import store.mapper.CommentMapper;

@Repository
public class CommentStoreLogic implements CommentStore {

	@Override
	public String create(Comment comment) {
		SqlSession session = BetSessionFactory.getinstance().getSession();

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			mapper.create(comment);
			session.commit();
		} finally {
			session.close();
		}
		return comment.getBetId();
	}

	@Override
	public Comment search(String commentId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		Comment comment = null;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			comment = mapper.search(commentId);
			session.commit();
		} finally {
			session.close();
		}
		return comment;
	}

	@Override
	public List<Comment> searchAll(String betId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Comment> list = null;

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			list = mapper.searchAll(betId);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void delete(String commentId) {
		SqlSession session = BetSessionFactory.getinstance().getSession();

		try {
			CommentMapper mapper = session.getMapper(CommentMapper.class);
			mapper.delete(commentId);
			session.commit();
		} finally {
			session.close();
		}
	}

}
