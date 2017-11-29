package store;

public interface AttendanceStore {

	String create(String userId);
	void delete(String userId);
	
}
