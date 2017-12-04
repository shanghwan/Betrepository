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
import store.AttendanceStore;
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
	@Autowired
	private AttendanceStore attendanceStore;

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
		if (point.getReceiverId().equals(null)) {
			if (team.getResult().equals("win")) {

			} else if (team.getResult().equals("lose")) {

			}
		}
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

		if (bet.getBetWay().equals("고정")) {

			if (team.getResult().equals("WIN")) {
				team.getTeamName(); // a하고 b
				Team teamW = teamStore.searchByTeamName(team.getBetId(), team.getTeamName());
				// teamW.setTotalPoint(totalPoint);
				// 내기방에 있는 a,b
				// 승자팀 찾아와
				// 팀의 포인트를 2배
				// 그 팀에 속한 개인에 건 포인트수치에 2배
			} else if (team.getResult().equals("lose")) {
				team.getResult();
				team.getTeamName();
				// 패자팀 찿아와
				// 포인트소멸
				// 각 유저마자 건 포인트 제각각
			}
		}

		if (bet.getBetWay().equals("프리")) {

			if (team.getResult().equals("win")) {
				team.getResult();
				team.getTeamName();

			} else if (team.getResult().equals("lose")) {
				team.getResult();
				team.getTeamName();

			}
		}

		if (bet.getBetWay().equals("올인")) {
			User user = userStore.searchByUserId(point.getUserId()); // 유저내역에 포인트 가져와
			user.setPoint(0); // 보유 포인트를 전부걸어 0으로만듬
			userStore.update(user);// 유저내역 변경

			// 상대방 포인트도 포인트가져와서 보유포인트 0으로 만듬.
			User user2 = userStore.searchByUserId(point.getUserId());
			user2.setPoint(0);
			userStore.update(user2);

			if (team.getResult().equals("win")) {
				// 내기방, 팀아이디를 찾아서
				Team teamW = teamStore.searchByTeamName(team.getBetId(), team.getTeamName());
				// 이겼을 경우 내 포인트의 2배를 준다
				teamW.setTotalPoint(user.getPoint() * 2);
				// teamW.setTotalPoint(playerStore.s);
				userStore.update(user);
				pointStore.create(point);

			} else if (team.getResult().equals("lose")) {
				// 졌을때 포인트를 0으로 만듬.
				Team teamL = teamStore.searchByTeamName(team.getBetId(), team.getTeamName());
				playerStore.sear
			}
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

}
