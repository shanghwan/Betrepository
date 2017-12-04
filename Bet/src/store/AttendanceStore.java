package store;

import java.util.List;

import domain.Attendance;

public interface AttendanceStore {

	String create(Attendance attendance);

	void delete(String userId);

	List<Attendance> search(String userId);

}
