import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Comment;
import domain.Point;
import store.PointStore;
import store.logic.PointStoreLogic;

public class PointStoreLogicTest {

	private PointStore pointStore;

	@Before
	public void setUp() {
		pointStore = new PointStoreLogic();
	}

//	@Test
//	public void testCreate() {
//		Point point = new Point();
//		Date date = new Date(2017 / 07 / 11);
//		point.setPointId("8");
//		point.setUserId("jang");
//		point.setReceiverId("hwa");
//		point.setRegDate(date);
//		point.setType("gift");
//		point.setPoint(500);
//		pointStore.create(point);
//	}

	@Test
	public void testSearchAll() {
		List<Point> list = pointStore.searchAll("jang");
		assertEquals(1, list.size());
		assertEquals("44", list.get(0).getPointId());

	}

	@Test
	public void testGift() {
	}

//	@Test
//	public void testDelete() {
//		pointStore.delete("eunhye");
//	}

}
