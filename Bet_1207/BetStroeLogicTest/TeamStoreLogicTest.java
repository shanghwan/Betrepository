import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Team;
import store.TeamStore;
import store.logic.TeamStoreLogic;

public class TeamStoreLogicTest {

	private TeamStore store;
	
	@Before
	public void setUp() {
		store = new TeamStoreLogic();
	}
	
//	@Test
//	public void testCreate() {
//		Team t = new Team();
//		
//		t.setBetId("33");
//		t.setTeamName("B");
//		store.create(t);
//	}

//	@Test
//	public void testSearch() {
//		Team t = store.search("5");
//		assertEquals("N", t.getResult());
//	}

//	@Test
//	public void testSearchByBetId() {
//		List<Team> t = store.searchByBetId("33");
//		assertEquals(1, t.size());
//	}

//	@Test
//	public void testUpdate() {
//		Team t = store.search("5");
//		t.setResult("win");
//		store.update(t);
//	}

//	@Test
//	public void testDelete() {
//		store.delete("33");
//	}

}
