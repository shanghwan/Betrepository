package store.mapper;

import java.util.List;

import domain.Comment;

public interface CommentMapper {

	void create(Comment comment);

	Comment search(String commentId);

	List<Comment> searchAll(String betId);

	void delete(String commentId);

}