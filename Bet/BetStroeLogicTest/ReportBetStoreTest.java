import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import domain.Report;
import store.ReportBetStore;
import store.logic.ReportBetStoreLogic;

public class ReportBetStoreTest {
	
	private ReportBetStore store;

	@Before
	public void setUp() throws Exception {
		
		store = new ReportBetStoreLogic();
	}

	@Test
	public void testCreate() {
		
		Report re = new Report();
		Date date = new Date(1992/07/04);
		re.setReportId("1");
		re.setUserId("koo");
		re.setTarget("2");
		re.setReason("멍청이");
		re.setRegDate(date);
		
		store.create(re);
		
	}

	@Test
	public void testSearch() {
	}

	@Test
	public void testSearchByAllReportByBetId() {
	}

	@Test
	public void testSearchByTarget() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testDeleteAllByTarget() {
	}

}
