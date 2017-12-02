package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Bet;
import domain.Team;
import service.BetService;
import service.GameService;
import service.TeamService;

@Controller
public class GameController {

	@Autowired
	private TeamService teamService;
	@Autowired
	private BetService betService;
	@Autowired
	private GameService gameService;

	@RequestMapping(value = "/gameJoin.do", method = RequestMethod.POST)
	public String teamJoin(String betId, String pointBet, String teamName, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		int point = Integer.parseInt(pointBet);
		Bet bet = betService.findByBetId(betId);
		Team team = teamService.findByTeamName(betId, teamName);
		

		// 큰 if 필요 (내기현황불러서 내가 이 내기에 참여했는지 체크)

		if (bet.getBetWay().equals("one")) {
			if (team.getPlayers().size() > 0) {
				// 참여 불가능 하다는 alert 필요
				return "BetDetail.do";
			}
			gameService.joinBetOfOne(userId, teamName, betId, point);
			return "BetDetail.do";
		} else if (bet.getBetWay().equals("all")) {
			gameService.joinBetOfAll(userId, teamName, betId);
			return "BetDetail.do";
		} else if(bet.getBetWay().equals("team")) {
			gameService.joinBetOfTeam(userId, teamName, betId, point);
			return "BetDetail.do";
		}
		return "BetDetail.do";
	}
	
	@RequestMapping(value = "/gameReady.do", method = RequestMethod.POST)
	public String gameReady(String betId, String teamId) {
		gameService.gameReady(betId, teamId);
		return "BetDetail.do";
	}

}
