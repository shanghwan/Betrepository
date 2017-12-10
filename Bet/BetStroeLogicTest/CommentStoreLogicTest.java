import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Bet;
import domain.Comment;
import store.BetStore;
import store.CommentStore;
import store.logic.BetStoreLogic;
import store.logic.CommentStoreLogic;

public class CommentStoreLogicTest {

	private CommentStore store;

	@Before
	public void setUp() {
		store = new CommentStoreLogic();
	}

	@Test
	public void testCreate() {
		Comment comment = new Comment();
		comment.setBetId("1");
		comment.setUserId("eunhye");
		comment.setContent("I'M LEEHWAJUNG");
//		comment.setPhoto("null");
		store.create(comment);
	}

	@Test
	public void testSearch() {
		Comment comment = store.search("1");
		assertNotNull(comment);
		assertEquals("1", comment.getCommentId());
	}

	@Test
	public void testSearchAll() {
		List<Comment> list = store.searchAll("1");
	//	assertEquals("2", list.size());
	//	assertEquals("2", list.get(0).getBetId());

	}

	// @Test
	// public void testDelete() {
	// store.delete("9");
	// }

}
