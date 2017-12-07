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
import service.RecordService;
import service.TeamService;

@Controller
public class GameController {

	@Autowired
	private TeamService teamService;
	@Autowired
	private BetService betService;
	@Autowired
	private GameService gameService;
	@Autowired
	private RecordService recordService;

	@RequestMapping(value = "/gameJoin.do", method = RequestMethod.POST)
	public String teamJoin(String betId, String pointBet, String teamName, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		int point = Integer.parseInt(pointBet);
		Bet bet = betService.findByBetId(betId);
		Team team = teamService.findByTeamName(betId, teamName);

		// 큰 if 필요 (내기현황불러서 내가 이 내기에 참여했는지 체크)

		if (bet.getBetWay().equals("One")) {
			gameService.joinBetOfOne(userId, teamName, betId, point);
			return "BetDetail.do";
		} else if (bet.getBetWay().equals("All")) {
			gameService.joinBetOfAll(userId, teamName, betId);
			return "BetDetail.do";
		} else if (bet.getBetWay().equals("Team")) {
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

	@RequestMapping(value = "/betVote.do", method = RequestMethod.POST)
	public String gameVote(String betId, String vote, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		// System.out.println("체크"+betId + " " +vote);
		gameService.voteGame(betId, userId, vote);
		return "BetDetail.do";
	}

}
