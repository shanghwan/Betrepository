import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Bet;
import store.BetStore;
import store.logic.BetStoreLogic;

public class BetStoreLogicTest {

	private BetStore store;

	@Before
	public void setUp() {
		store = new BetStoreLogic();
	}
//	@Test
//	public void testCreate() {
//		Date date = new Date(2017/11/11);
//		Date date2 = new Date(2017/11/21);
//		Bet bet = new Bet();
//		bet.setBetId("1");
//		bet.setState("0");
//		bet.setTitle("싸운다");
//		bet.setContent("이긴다");
//		bet.setPhotoA("null");
//		bet.setPhotoB("null");
//		bet.setBetWay("1");
//		bet.setStartDate(date);
//		bet.setPointCheck("1");
//		bet.setEndDate(date2);
//		bet.setOpenCheck("1");
//		bet.setPoint(100);
//		
//		store.create(bet);
//		
//		
//	}
	@Test
	public void testCreate() {
		Date date = new Date(2017/11/11);
		Date date2 = new Date(2017/11/21);
		Bet bet = new Bet();
		bet.setBetId("1");
		bet.setState("0");
		bet.setTitle("�떥�슫�떎");
		bet.setContent("�씠湲대떎");
		bet.setPhotoA("null");
		bet.setPhotoB("null");
		bet.setBetWay("1");
		bet.setPointCheck("1");
//		bet.setEndDate(date2);
		bet.setPoint(100);
		
		store.create(bet);
		
		
	}

	@Test
	public void testSearchAll() {
		
		List<Bet> list = store.searchAllBet();
		assertEquals(2, list.size());
		assertEquals("1", list.get(0).getBetId());
		
	}

// @Test
// public void testSearchByBetId() {
//
// Bet bet = store.searchByBetId("1");
// assertNotNull(bet);
// assertEquals("1", bet.getBetId());
//
// }
//
// @Test
// public void testSearchByBetOwner() {
// }
//
// @Test
// public void testSearchByTitle() {
// }
//
// @Test
// public void testSearchByState() {
// }
//
// @Test
// public void testSearchByBetWay() {
// }
//
// @Test
// public void testUpdate() {
// }
//
// @Test
// public void testDelete() {
// }
//
 }
