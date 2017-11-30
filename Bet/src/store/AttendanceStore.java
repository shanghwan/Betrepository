package store;


import domain.Attendance;

public interface AttendanceStore {

	String create(Attendance attendance);
	void delete(String userId);
	
}
