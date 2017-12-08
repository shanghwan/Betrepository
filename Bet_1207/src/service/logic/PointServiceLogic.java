package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import domain.Point;
import domain.Team;
import domain.User;
import service.PointService;
import store.BetStore;
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
	@Autowired
	private BetStore betStore;
	// @Autowired
	// private AttendanceStore attendanceStore;

	@Override
	public String registPoint(Point point) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		point.setPointDate(today);

		if (!point.getReceiverId().equals(null)) {
			String type = "gift";
			point.setType(type);

			User user = userStore.searchByUserId(point.getUserId());
			user.setPoint(user.getPoint() - point.getPoint());
			userStore.update(user);

			User user1 = userStore.searchByUserId(point.getReceiverId());
			user1.setPoint(user.getPoint() + point.getPoint());
			userStore.update(user1);

			return pointStore.create(point);

		} else if (point.getReceiverId().equals(null)) {
			point.setType("chulcheck");
			// User user = userStore.searchByUserId(attendance.getUserId());

		} else if (point.getReceiverId().equals(null)) {
			point.setType("signUp");

		}
		return null;
	}

	@Override
	public String betAllGamePoint(Point point, Team team) {
		// 포인트방식없음
		return null;
	}

	@Override
	public String betTeamGamePoint(Point point, Team team) {
		// 팀하고 원하고 같이.player.size로 해결할 예정

		Bet bet = new Bet();
		team = teamStore.search(team.getTeamId());
		team.getBetId();
		team.getTeamName();
		team.getResult();

		// 내기방식에 따라서(올/팀/원)
		if (bet.getBetWay().equals("One")) {

			if (point.getReceiverId().equals(null)) {
				if (point.getType().equals("win")) {
					// 내기방에 있는 a,b
					// 승자팀 찾아와
					// 포인트방식에 따라서(올인/프리/고정)
					// 팀의 포인트를 2배
					// 그 팀에 속한 개인에 건 포인트수치에 2배
				} else if (point.getType().equals("lose")) {
					// 패자팀 찿아와
					// 포인트소멸
					// 각 유저마자 건 포인트 제각각
				}
			}

		} else if (bet.getBetWay().equals("All")) {

		} else if (bet.getBetWay().equals("Team")) {

		}

		return null;
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
	public void updatePoint(Point point) {

	}

}
