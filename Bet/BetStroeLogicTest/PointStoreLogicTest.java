import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import domain.Point;
import store.PointStore;
import store.logic.PointStoreLogic;

public class PointStoreLogicTest {

	private PointStore pointStore;

	@Before
	public void setUp() {
		pointStore = new PointStoreLogic();
	}

	@Test
	public void testCreate() {
		Point point = new Point();
		Date date = new Date(2017 / 11 / 11);
		point.setPointId("4");
		point.setUserId("eunhye");
		point.setReceiverId("hwa");
		point.setRegDate(date);
		point.setType("gift");
		point.setPoint(500);
		pointStore.create(point);
	}

	@Test
	public void testSearchAll() {
	}

	@Test
	public void testGift() {
	}

	@Test
	public void testDelete() {
	}

}
