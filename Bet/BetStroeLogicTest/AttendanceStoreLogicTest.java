import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import domain.User;
import store.AttendanceStore;
import store.UserStore;
import store.logic.AttendanceStoreLogic;
import store.logic.UserStoreLogic;

public class AttendanceStoreLogicTest {
	
	private AttendanceStore attendanceStore;
	private UserStore userStore;
	
	@Before
	public void setUp() {
		attendanceStore = new AttendanceStoreLogic();
		userStore = new UserStoreLogic();
		}

	@Test
	public void testCreate() {
		User user = userStore.searchByUserId("koo");
		Date date = new Date(2017/11/11);
		attendanceStore.create(user.getUserId());
		
	}

	@Test
	public void testDelete() {
//		fail("Not yet implemented");
	}

}
