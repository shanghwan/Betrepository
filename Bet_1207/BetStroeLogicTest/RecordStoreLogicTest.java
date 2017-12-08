import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Record;
import domain.User;
import store.RecordStore;
import store.UserStore;
import store.logic.RecordStoreLogic;
import store.logic.UserStoreLogic;

public class RecordStoreLogicTest {

	
	private RecordStore store;
	
	@Before
	public void setUp() {
		store = new RecordStoreLogic();
	}
	
//	@Test
//	public void testCreate() {
//		
//		Record r = new Record();
//		r.setUserId("q");
//		r.setWin(6);
//		r.setLose(34);
//		r.setDraw(3);
//		store.create(r);
//	}

//	@Test
//	public void testSearch() {
//		Record r = store.search("hwa");
//		assertEquals(10, r.getWin());
//	}

//	@Test
//	public void testUpdate() {
//		Record r = store.search("hwa");
//		r.setWin(20);
//		store.update(r);
//		
//	}

//	@Test
//	public void testDelete() {
//		store.delete("q");
//	}

//	@Test
//	public void testWinSearch() {
//		List<Record> r = store.winSearch();
//		assertEquals(8, r.size());
//	}

//	@Test
//	public void testLoseSearch() {
//		
//		List<Record> r = store.loseSearch();
//		assertEquals(8, r.size());
//	}

//	@Test
//	public void testTotalSearch() {
//		List<Record> r = store.totalSearch();
//		assertEquals(8, r.size());
//	}

	@Test
	public void testRateSearch() {
		List<Record> r = store.rateSearch();
		assertEquals(8, r.size());
	}

}
