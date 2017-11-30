package store;

import java.sql.Date;

public interface AttendanceStore {

	void create(String userId);
	void delete(String userId);
	
}
