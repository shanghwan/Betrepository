package service;

import java.sql.Date;

import domain.Attendance;

public interface AttendanceService {

	
	String registAttendance(Attendance attendance);
	void removeAttendance(String userId);
}
