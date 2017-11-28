

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Team;
import store.TeamStore;
import store.logic.TeamStoreLogic;

public class TeamStoreLogicTest {
	
	private TeamStore store;
	
	@Before
	public void setUp() throws Exception{
		store = new TeamStoreLogic();
	}
	
	@Test
	public void testCreate() {
		Team t = new Team();
		t.setBetId("22");
		t.setTeamName("a");
		
		store.create(t);
	}

	@Test
	public void testSearch() {
		Team t = new Team();
		
	}

	@Test
	public void testSearchByBetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
