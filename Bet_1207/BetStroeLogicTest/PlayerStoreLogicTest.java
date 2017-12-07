import org.junit.Before;
import org.junit.Test;

import store.PlayerStore;
import store.logic.PlayerStoreLogic;

public class PlayerStoreLogicTest {
	
	private PlayerStore store;

	@Before
	public void setUp() throws Exception{
		store = new PlayerStoreLogic();
	}
	
	@Test
	public void testCountVote() {
		int result=0;
		String vote = "N";
		String betId = "2";
		result= store.voteCount(betId, vote);
		System.out.println(result);
	}

}
