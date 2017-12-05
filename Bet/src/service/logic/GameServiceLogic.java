package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import domain.Player;
import domain.Team;
import domain.User;
import service.BetService;
import service.GameService;
import service.PlayerService;
import service.TeamService;
import store.CommentStore;
import store.PlayerStore;
import store.TeamStore;
import store.UserStore;

@Service
public class GameServiceLogic implements GameService {

	@Autowired
	private TeamService teamService;
	@Autowired
	private PlayerService playerService;
	@Autowired
	private BetService betService;
	@Autowired
	private UserStore userStore;
	@Autowired
	private TeamStore teamStore;
	@Autowired
	private CommentStore commentStore;
	@Autowired
	private PlayerStore playerStore;

	@Override
	public String joinBetOfAll(String userId, String teamName, String betId) {
		Team team = teamService.findByTeamName(betId, teamName);
		Player player = new Player();
		int point = 10;
		
		
		playerService.removePlayerByBetIdAndUserId(betId, userId);
		
		player.setBetId(betId);
		player.setUserId(userId);
		player.setPoint(point);
		player.setPosition("member");
		player.setTeamId(team.getTeamId());
		player.setVote(teamName);
		return playerService.registPlayer(player);
	}

	@Override
	public String joinBetOfOne(String userId, String teamName, String betId, int point) {
		Team team = teamService.findByTeamName(betId, teamName);
		Player player = new Player();
		Bet bet = betService.findByBetId(betId);
		User user = userStore.searchByUserId(userId);
		if(team.getLeader() != null && !(team.getLeader().getUserId().equals(userId)) ) {
			return "false";
		}
			// 내기에 참여중인 나를 삭제
			playerService.removePlayerByBetIdAndUserId(betId, userId);
			
		
		// 나를 내기에 새로 참여 등록

		player.setBetId(betId);
		player.setTeamId(team.getTeamId());
		player.setPoint(point);
		player.setUserId(userId);
		player.setPosition("leader");
		player.setVote("N");

		if (bet.getPointCheck().equals("LOCK")) {
			player.setPoint(bet.getPoint());
		} else if (bet.getPointCheck().equals("ALLIN")) {
			player.setPoint(user.getPoint());
		}

		return playerService.registPlayer(player);
	}

	@Override
	public String joinBetOfTeam(String userId, String teamName, String betId, int point) {

		// 내기에 참여중인 나를 삭제
		playerService.removePlayerByBetIdAndUserId(betId, userId);
		
		Team team = teamService.findByTeamName(betId, teamName);
		Player player = new Player();
		Bet bet = betService.findByBetId(betId);
		User user = userStore.searchByUserId(userId);
	
		// 나를 내기에 새로 참여 등록
		player.setBetId(betId);
		player.setTeamId(team.getTeamId());
		player.setPoint(point);
		player.setUserId(userId);
		player.setPosition("member");
		player.setVote("N");

		if (team.getPlayers().isEmpty()) {
			player.setPosition("leader");
		}

		if (bet.getPointCheck().equals("LOCK")) {
			player.setPoint(bet.getPoint());
		} else if (bet.getPointCheck().equals("ALLIN")) {
			player.setPoint(user.getPoint());
		}

		return playerService.registPlayer(player);
	}

	@Override
	public String gameReady(String betId, String teamId) {
		int gameStart = 0;

		Team team = teamStore.search(teamId);

		if (team.getStart().equals("Y")) {
			team.setStart("N");
			teamStore.update(team);
		} else if (team.getStart().equals("N")) {
			team.setStart("Y");
			teamStore.update(team);
		}
		List<Team> list = teamStore.searchByBetId(betId);
		for (Team t : list) {
			if (t.getStart().equals("Y")) {
				gameStart++;
			}
		}

		if (gameStart == 2) {
			return gameStart(betId);
		}
		return "true";
	}

	@Override
	public String gameStart(String betId) {
		Bet bet = betService.findByBetId(betId);

		bet.setState("진행");
		if (bet.getPhotoA() == null) {
			bet.setPhotoA("null");
		}
		if (bet.getPhotoB() == null) {
			bet.setPhotoB("null");
		}

		// comment 삭제 추가해야함
		betService.modify(bet);
		return betId;
	}

	@Override
	public String voteGame(String betId, String userId, String vote) {
		Player player = playerStore.searchByBetId(userId, betId);
		player.setVote(vote);
		playerStore.update(player);

		int result = 0;
		result = playerStore.voteCount(betId, vote);
		if (result > 1) {
			return gameEnd(betId, vote);
		}
		// TODO Auto-generated method stub
		return betId;
	}

	@Override
	public String gameEnd(String betId, String vote) {
		Bet bet = betService.findByBetId(betId);

		bet.setState("종료");
		if (bet.getPhotoA() == null) {
			bet.setPhotoA("null");
		}
		if (bet.getPhotoB() == null) {
			bet.setPhotoB("null");
		}

		betService.modify(bet);
		if (vote.equals("A")) {
			Team teamW = teamService.findByTeamName(betId, vote);

			teamW.setResult("WIN");
			teamStore.update(teamW);
			String teamName = "B";
			Team teamL = teamService.findByTeamName(betId, teamName);
			teamL.setResult("LOSE");
			teamStore.update(teamL);

			// 포인트 처리 서비스 호출 2개 teamW,teamL
			// 전적 기록

		}
		if (vote.equals("B")) {
			Team teamW = teamService.findByTeamName(betId, vote);
			teamW.setResult("WIN");
			teamStore.update(teamW);
			String teamName = "A";
			Team teamL = teamService.findByTeamName(betId, teamName);
			teamL.setResult("LOSE");
			teamStore.update(teamL);

			// 포인트 처리 서비스 호출 2개 teamW,teamL
			// 전적 기록

		}

		return betId;
	}

}
