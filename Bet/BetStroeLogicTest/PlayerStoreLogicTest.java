import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Player;
import store.PlayerStore;
import store.logic.PlayerStoreLogic;

public class PlayerStoreLogicTest {

	private PlayerStore store;

	@Before
	public void setUp() throws Exception{
		store = new PlayerStoreLogic();
	}

	@Test
	public void testCreate() {

		Player p = new Player();
		p.setBetId("99");
		p.setPoint("30");
		p.setPosition("member");
		p.setTeamId("99");
		p.setUserId("ggg");
		store.create(p);
	}

//	@Test
//	public void testSearchByPlayerId() {
//		Player p = store.searchByPlayerId("12");
//		assertNotNull(p);
//		assertEquals("hhh", p.getUserId());
//	}

//	@Test
//	public void testSearchByTeamId() {
//		List<Player> p = store.searchByTeamId("a","1");
//		assertNotNull(p);
//		assertEquals(2, p.size());
//	}

//	@Test
//	public void testUpdate() {
//		Player pp = store.searchByPlayerId("1");
//		
//		pp.setPoint(1000);
//		pp.setPosition("leader");
//		pp.setTeamId("a");
//		
//		store.update(pp);
//	}

//	@Test
//	public void testDelete() {
//		store.delete("koo", "1");
//	}

}
