package service;

import java.sql.Date;
import java.util.List;

import domain.Attendance;

public interface AttendanceService {

	
	String registAttendance(Attendance attendance);
	void removeAttendance(String userId);
	List<Attendance> findAttendance(String userId);
}
