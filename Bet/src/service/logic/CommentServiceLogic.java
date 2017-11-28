package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import domain.Comment;
import service.CommentService;
import store.CommentStore;
import store.logic.CommentStoreLogic;

@Service
public class CommentServiceLogic implements CommentService {
	private CommentStore commentStore;

	public CommentServiceLogic() {
		commentStore = new CommentStoreLogic();
	}

	@Override
	public void registComment(Comment comment) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		comment.setRegDate(today);
		commentStore.create(comment);
	}

	@Override
	public Comment findComment(String commentId) {
		return commentStore.search(commentId);
	}

	@Override
	public List<Comment> findAllComent(String betId) {
		return commentStore.searchAll(betId);
	}

	@Override
	public void removeComment(String commentId) {
		commentStore.delete(commentId);
	}

}
