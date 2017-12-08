package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Attendance;
import service.AttendanceService;
import service.PointService;
import store.AttendanceStore;
import store.UserStore;

@Service
public class AttendanceServiceLogic implements AttendanceService {

	@Autowired
	private AttendanceStore attendanceStore;

	@Autowired
	private UserStore userStore;

	@Autowired
	private PointService pointService;

	@Override
	public String registAttendance(Attendance attendance) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		attendance.setAttendanceDate(today);
		String result = attendanceStore.create(attendance);
		if (result != null) {
			pointService.checkDayPoint(attendance.getUserId());
		}
		return result;
	}

	@Override
	public void removeAttendance(String userId) {
		attendanceStore.delete(userId);
	}

	@Override
	public List<Attendance> findAttendance(String userId) {
		return attendanceStore.search(userId);
	}

}
