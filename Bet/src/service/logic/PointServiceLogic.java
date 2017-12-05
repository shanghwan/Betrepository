package service.logic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import domain.Player;
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

		} else if (point.getReceiverId().equals(null)) {
			point.setType("signUp");

		} else if (point.getReceiverId().equals(null)) {
			point.setType("result");

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
	public String betTeamGamePoint(Point point, Team team, Player player) {
		Team teamW = teamStore.searchByTeamName(team.getBetId(), team.getTeamName());
		int betTeamTotalPoint = 0;

		Bet bet = new Bet();
		team = teamStore.search(team.getTeamId());
		String betId = team.getBetId();
		String teamName = team.getTeamName();
		String userId = player.getUserId();
		String result = team.getResult();

		if (bet.getBetWay().equals("고정")) {

			if (team.getResult().equals("WIN")) {
				team.getTeamName();
				teamW = teamStore.searchByTeamName(team.getBetId(), team.getTeamName());
			} else if (team.getResult().equals("lose")) {
				team.getResult();
				team.getTeamName();
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

			teamW = teamStore.searchByTeamName(team.getBetId(), team.getTeamName());
			List<Team> listTeam = teamStore.searchByBetId(betId);
			int max = 0;

			for (Team t : listTeam) {
				int index = 0;
				betTeamTotalPoint += listTeam.get(index).getTotalPoint();
				index++;
				max = betTeamTotalPoint;
			}

			if (team.getResult().equals("win")) {

				teamW.setTotalPoint(max * 2);
				// userStore.update(user);
				pointStore.create(point);

			} else if (team.getResult().equals("lose")) {
				Team teamL = teamStore.searchByTeamName(team.getBetId(), team.getTeamName());

				player.setPoint(0);

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

	@Override
	public String betTeamGamePoint(Point point, Team team) {
		// TODO Auto-generated method stub
		return null;
	}

}
