import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.User;
import store.UserStore;
import store.logic.UserStoreLogic;

public class UserStoreLogicTest {
	
	private UserStore store;
	
	@Before
	public void setUp() {
		store = new UserStoreLogic();
	}

	@Test
	public void testCreate() {
	}

	@Test
	public void testSearchByUserId() {
		
		User user = store.searchByUserId("koo");
		assertNotNull(user);
		assertEquals("koo", user.getUserId());
		
	}

	@Test
	public void testSearchByName() {
	}

	@Test
	public void testSearchByPoint() {
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
	}
	
	@Test
	public void testAttendance() {
	
	}


}
