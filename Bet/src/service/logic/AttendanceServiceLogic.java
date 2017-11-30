package service.logic;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import service.AttendanceService;
import store.AttendanceStore;
import store.UserStore;

@Service
public class AttendanceServiceLogic implements AttendanceService {

	@Autowired
	private AttendanceStore attendanceStore;
	
	@Autowired
	private UserStore userStore;
	
	@Override
	public void registAttendance(String userId) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		
		User user =  userStore.searchByUserId(userId);
		user.setPoint(user.getPoint() + 100);
		userStore.update(user);
		attendanceStore.create(userId);
	}
	


	@Override
	public void removeAttendance(String userId) {
		attendanceStore.delete(userId);
	}

}
