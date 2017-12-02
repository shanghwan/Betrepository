package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import domain.Comment;
import domain.Player;
import domain.Team;
import domain.User;
import service.BetService;
import service.TeamService;
import store.BetStateStore;
import store.BetStore;
import store.PlayerStore;
import store.UserStore;
import store.CommentStore;
import store.InviteStore;

@Service
public class BetServiceLogic implements BetService {

	@Autowired
	private CommentStore CommentStore;
	@Autowired
	private BetStore betStore;
	@Autowired
	private UserStore userStore;
	@Autowired
	private PlayerStore playerStore;
	@Autowired
	private TeamService teamService;
	@Autowired
	private InviteStore inviteStore;

	@Override
	public String registBet(Bet bet) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		User user = userStore.searchByUserId(bet.getBetOwner());

		bet.setStartDate(today);

		if (bet.getBetWay().equals("all")) {
			bet.setPointCheck("LOCK");
			bet.setPoint(10);
		}
		if (bet.getPointCheck().equals("ALLIN")) {
			bet.setPoint(user.getPoint());
		}

		// point 처리해야함

		String betId = betStore.create(bet);

		Team team = new Team();

		team.setBetId(betId);
		team.setTeamName("A");
		String teamId = teamService.registTeam(team);
		Player player = new Player();
		player.setBetId(betId);
		player.setPosition("leader");
		player.setPoint(bet.getPoint());
		player.setTeamId(teamId);
		player.setUserId(user.getUserId());
		playerStore.create(player);

		team.setTeamName("B");
		teamService.registTeam(team);
		
		return betId;
	}

	@Override
	public List<Bet> findAllBet() {
		return betStore.searchAllBet();
	}

	@Override
	public Bet findByBetId(String betId) {

		Bet bet = betStore.searchByBetId(betId);
		List<Comment> list = CommentStore.searchAll(betId);
		bet.setComments(list);

		return bet;
	}

	@Override
	public List<Bet> findByOwner(String betOwner) {
		return null;
	}

	@Override
	public List<Bet> findByTitle(String title) {
		return null;
	}

	@Override
	public List<Bet> findByState(String state) {
		return betStore.searchByState(state);
	}

	@Override
	public List<Bet> findByBetWay(String betWay) {
		return betStore.searchByBetWay(betWay);
	}

	@Override
	public void modify(Bet bet) {
	}

	@Override
	public void removeBet(String betId) {
		inviteStore.deletebyBetId(betId);
		betStore.delete(betId);
		teamService.removeTeam(betId);
	}

}
