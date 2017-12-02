package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Attendance;
import domain.User;
import service.AttendanceService;
import store.AttendanceStore;
import store.PointStore;
import store.UserStore;

@Service
public class AttendanceServiceLogic implements AttendanceService {

	@Autowired
	private AttendanceStore attendanceStore;
	
	@Autowired
	private UserStore userStore;
	
	@Autowired
	private PointStore pointStore;
	
	@Override
	public String registAttendance(Attendance attendance) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		attendance.setAttendanceDate(today);
		User user = userStore.searchByUserId(attendance.getUserId());
		user.setPoint(user.getPoint() + 100);
//		pointStore.create(point)
		userStore.update(user);
		return attendanceStore.create(attendance);
	}
	
	


	@Override
	public void removeAttendance(String userId) {
		attendanceStore.delete(userId);
	}

}
