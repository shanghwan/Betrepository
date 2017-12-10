package service.logic;

import java.sql.Date;
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
import service.TeamService;
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
   @Autowired
   private TeamService teamService;

   @Override
   public String registPoint(Point point) {
      Date today = new Date(Calendar.getInstance().getTimeInMillis());
      point.setPointDate(today);
      String result = pointStore.create(point);
      return result;
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
   public int giftPoint(Point point) {
      User sendUser = userStore.searchByUserId(point.getUserId());
      User getUser = userStore.searchByUserId(point.getReceiverId());

      point.setType("선물");
      registPoint(point);

      sendUser.setPoint(sendUser.getPoint() - point.getPoint());
      getUser.setPoint(getUser.getPoint() + point.getPoint());
      userStore.update(getUser);
      userStore.update(sendUser);

      return sendUser.getPoint();
   }

   @Override
   public String checkDayPoint(String userId) {
      User user = userStore.searchByUserId(userId);
      Point point = new Point();
      point.setReceiverId("null");
      point.setType("출석");
      point.setUserId(userId);
      point.setPoint(100);
      registPoint(point);

      user.setPoint(user.getPoint() + 100);
      userStore.update(user);
      return "T";
   }

   @Override
   public String betResultPoint(String teamId, int point) {
	   Team team = teamService.findTeam(teamId);
		String betId = team.getBetId();
		Bet bet = betStore.searchByBetId(betId);
		Point po = new Point();
		int teamTotalP = team.getTotalPoint();
		int resultP = 0;
		int playerP = 0;
		float playerPP = 0;

      if (team.getResult().equals("WIN")) {
			for (Player p : team.getPlayers()) {
				User user = userStore.searchByUserId(p.getUserId());
				playerP = p.getPoint();
				playerPP = (float) playerP / (float) teamTotalP;
				resultP = Math.round(playerPP * point) + playerP;
				po.setUserId(p.getUserId());
				po.setPoint(resultP);
				po.setReceiverId(team.getBetId());
				po.setType("내기승리");
				registPoint(po);
				if(bet.getBetOwner().equals("admin")) {
					user.setPoint(user.getPoint() + bet.getPoint());
				}else {
					user.setPoint(user.getPoint() + resultP);
				}
				userStore.update(user);
			}
		}
		if (team.getResult().equals("LOSE")) {

			for (Player p : team.getPlayers()) {

				po.setUserId(p.getUserId());
				po.setPoint(p.getPoint());
				po.setReceiverId(team.getBetId());
				po.setType("내기패배");
				registPoint(po);
			}
		}

		if (team.getResult().equals("DRAW")) {
			for (Player p : team.getPlayers()) {

				po.setUserId(p.getUserId());
				po.setPoint(p.getPoint());
				po.setReceiverId(team.getBetId());
				po.setType("내기무승부");
				registPoint(po);
			}
		}
		return "T";
	}

   @Override
   public String registUserPoint(String userId) {
      Point point = new Point();
      point.setReceiverId("null");
      point.setType("회원가입");
      point.setUserId(userId);
      point.setPoint(500);
      registPoint(point);

      User user = userStore.searchByUserId(userId);
      user.setPoint(500);
      userStore.update(user);
      return "T";
   }

   @Override
   public String betJoinPoint(String userId, String betId, int point) {
      Point pp = new Point();

      // Point p = pointStore.searchByUserIdBetId(userId, betId);
      // if (p != null) {
      // pointStore.deleteByPointId(p.getPointId());
      // }
      pp.setReceiverId(betId);
      pp.setType("내기참여");
      pp.setUserId(userId);
      pp.setPoint(point);
      registPoint(pp);

      User user = userStore.searchByUserId(userId);
      user.setPoint(user.getPoint() - point);
      userStore.update(user);
      return "T";

   }

   @Override
   public String betExitPoint(String userId, String betId) {
      User user = userStore.searchByUserId(userId);
      Point point = pointStore.searchByUserIdBetId(userId, betId);
      if (point != null) {
         user.setPoint(user.getPoint() + point.getPoint());
         userStore.update(user);
         pointStore.deleteByPointId(point.getPointId());
      }
      return null;
   }

   @Override
   public String betOfAllResultPoint(String teamId) {
      Team team = teamService.findTeam(teamId);
      Point po = new Point();

      if (team.getResult().equals("WIN")) {
         for (Player p : team.getPlayers()) {
            User user = userStore.searchByUserId(p.getUserId());
            po.setUserId(p.getUserId());
            po.setPoint(20);
            po.setReceiverId(team.getBetId());
            po.setType("내기승리");
            registPoint(po);
            user.setPoint(user.getPoint() + 20);
            userStore.update(user);
         }
      }
      if (team.getResult().equals("LOSE")) {

         for (Player p : team.getPlayers()) {

            po.setUserId(p.getUserId());
            po.setPoint(p.getPoint());
            po.setReceiverId(team.getBetId());
            po.setType("내기패배");
            registPoint(po);
         }
      }

      if (team.getResult().equals("DRAW")) {
         for (Player p : team.getPlayers()) {

            po.setUserId(p.getUserId());
            po.setPoint(p.getPoint());
            po.setReceiverId(team.getBetId());
            po.setType("내기무승부");
            registPoint(po);
         }
      }
      return "T";
   }

}