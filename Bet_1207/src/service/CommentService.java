package service;

import java.util.List;

import domain.Comment;

public interface CommentService {

	void registComment(Comment comment);

	Comment findComment(String commentId);

	List<Comment> findAllComent(String betId);

	void removeComment(String commentId);

}
