package store;

import java.util.List;

import domain.Comment;

public interface CommentStore {

	String create(Comment comment);

	Comment search(String commentId);

	List<Comment> searchAll(String betId);

	void delete(String commentId);

}
