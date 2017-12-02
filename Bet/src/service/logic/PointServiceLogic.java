package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Point;
import domain.User;
import service.PointService;
import store.PointStore;
import store.UserStore;

@Service
public class PointServiceLogic implements PointService {
	@Autowired
	private PointStore pointStore;
	@Autowired
	private UserStore userStore;

	@Override
	public void registPoint(Point point) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		point.setPointDate(today);
		pointStore.create(point);
	}

	@Override
	public List<Point> findAllPoint(String userId) {
		return pointStore.searchAll(userId);
	}

	@Override
	public void removePoint(String userId) {
		pointStore.delete(userId);
	}

	@Override
	public String presentPoint(Point point) {
		User user = userStore.searchByUserId(point.getUserId());
		User receiverUser = userStore.searchByUserId(point.getReceiverId());

		String sendPoint = user.getPoint();
		user.setPoint(receiverUser.getPoint());
		receiverUser.setPoint(sendPoint);

		return pointStore.gift(point);
	}

	// @Override
	// public String presentPoint(Point point) {
	// User user = userStore.searchByUserId(point.getUserId());
	// user.setPoint(user.getPoint() - sendPoint);// 내포인트꺼내서 다시 셋팅
	// user = userStore.searchByUserId(point.getReceiverId());
	// user.setPoint(user.getPoint() + 10);
	// userStore.update(user);
	//
	// return pointStore.gift(point);
	// }

	@Override
	public String attendance(Point point) {
		User user = userStore.searchByUserId(point.getUserId());
		user.setPoint(user.getPoint() + 100);
		userStore.update(user);

		return pointStore.create(point);
	}

	@Override
	public String singUp(Point point) {
		User user = userStore.searchByUserId(point.getUserId());
		user.setPoint(user.getPoint() + 300);
		userStore.update(user);

		return pointStore.create(point);
	}

	@Override
	public String result(Point point) {
		// TODO Auto-generated method stub
		return null;
	}

}
