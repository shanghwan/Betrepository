package service;

import java.sql.Date;

import domain.User;

public interface AttendanceService {

	
	void registAttendance(String userId);
	void removeAttendance(String userId);
}
