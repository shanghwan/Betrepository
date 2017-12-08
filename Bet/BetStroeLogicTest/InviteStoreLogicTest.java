import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Bet;
import domain.User;
import service.logic.UserServiceLogic;
import store.BetStore;
import store.InviteStore;
import store.UserStore;
import store.logic.BetStoreLogic;
import store.logic.InviteStoreLogic;
import store.logic.UserStoreLogic;

public class InviteStoreLogicTest {
	
	private InviteStore store;
	private UserStore userstore;
	private BetStore betstore;

	@Before
	public void setUp() throws Exception {
		
		store = new InviteStoreLogic();
		userstore = new UserStoreLogic();
		betstore = new BetStoreLogic();
	}

//	@Test
//	public void testCreate() {
//		
//		User user = userstore.searchByUserId("koo");
//		Bet bet = betstore.searchByBetId("5");
//		
//		store.create(user.getUserId(), bet.getBetId());
//		
//	}

	@Test
	public void testDelete() {
		
		User user = userstore.searchByUserId("koo");
		System.out.println(user.toString());
		Bet bet = betstore.searchByBetId("1");
		
		
		store.delete(user.getUserId(), bet.getBetId());
	}

}
