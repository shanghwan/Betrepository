package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Point;
import domain.Team;
import domain.User;
import service.PointService;
import store.PlayerStore;
import store.PointStore;
import store.TeamStore;
import store.UserStore;

@Service
public class PointServiceLogic implements PointService {
	@Autowired
	private PointStore pointStore;
	@Autowired
	private UserStore userStore;
	@Autowired
	private TeamStore teamStore;
	@Autowired
	private PlayerStore playerStore;

	@Override
	public String registPoint(Point point) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		point.setPointDate(today);
		User user = userStore.searchByUserId(point.getUserId());
		point.setPointId(point.getPointId());
		point.setUserId(point.getUserId());
		point.setReceiverId(point.getReceiverId());
		point.setPointDate(point.getPointDate());
		point.setType(point.getType());
		point.setPoint(point.getPoint());
		pointStore.update(point);

		return pointStore.create(point);
	}

	@Override
	public List<Point> findAllPoint(String userId) {
		return pointStore.searchAll(userId);
	}

	@Override
	public void removePoint(String userId) {
		pointStore.delete(userId);
	}

	/*
	 * @Override public String presentPoint(Point point) { User user =
	 * userStore.searchByUserId(point.getUserId()); User receiverUser =
	 * userStore.searchByUserId(point.getReceiverId());
	 * 
	 * String sendPoint = user.getPoint(); user.setPoint(receiverUser.getPoint());
	 * receiverUser.setPoint(sendPoint);
	 * 
	 * return pointStore.gift(point); }
	 */
	
//	@Override
//	public String registAttendance(Attendance attendance) {
//		Date today = new Date(Calendar.getInstance().getTimeInMillis());
//		attendance.setAttendanceDate(today);
//		User user = userStore.searchByUserId(attendance.getUserId());
//		user.setPoint(user.getPoint() + 100);
//		// pointStore.create(point)
//		userStore.update(user);
//		return attendanceStore.create(attendance);
//	}

	@Override
	public void updatePoint(Point point) {
		
		if (point.getType() == "gift") {
			User user = userStore.searchByUserId(point.getUserId());
			user.setPoint(user.getPoint() + 10);// 내포인트꺼내서 다시 셋팅
			user = userStore.searchByUserId(point.getReceiverId());
			user.setPoint(user.getPoint() + 10);
			userStore.update(user);
			pointStore.create(point);

		} else if (point.getType() == "chulcheck") {
			User user = userStore.searchByUserId(point.getUserId());
			user.setPoint(user.getPoint() + 100);
			userStore.update(user);
			pointStore.create(point);

		} else if (point.getType() == "signUp") {
			User user = userStore.searchByUserId(point.getUserId());
			user.setPoint(user.getPoint() + 300);
			userStore.update(user);

		} else if (point.getType() == "result") {
			// 승패에 따라서 포인트부여해야함.

		}
	}
}
