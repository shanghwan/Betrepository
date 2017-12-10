package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import domain.Comment;
import domain.Team;
import domain.User;
import service.BetService;
import service.GameService;
import service.TeamService;
import store.BetStore;
import store.CommentStore;
import store.InviteStore;
import store.PlayerStore;
import store.UserStore;

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
   @Autowired
   private GameService gameService;
   

   @Override
   public String registBet(Bet bet) {
      User user = userStore.searchByUserId(bet.getBetOwner());
      bet.setState("대기");

      if (bet.getBetWay().equals("All")) {
			bet.setPointCheck("LOCK");
			if(!user.getUserId().equals("admin")) {
				bet.setPoint(10);
			}
			
		}
		if (bet.getPointCheck().equals("ALLIN")) {
			bet.setPoint(user.getPoint());
		}

      // point 처리해야함

      String betId = betStore.create(bet);

      Team team = new Team();

      team.setBetId(betId);
      team.setTeamName("A");
      teamService.registTeam(team);

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
      Date today = new Date(Calendar.getInstance().getTimeInMillis());
      Bet bet = betStore.searchByBetId(betId);
      int com = bet.getEndDate().compareTo(today);
         if (com <= 0 && bet.getState().equals("진행")) {
           //내기 종료 메소드
            gameService.timeEndGame(bet);
         }
      
      List<Comment> list = CommentStore.searchAll(betId);
      bet.setComments(list);
      int A = playerStore.voteCount(betId, "A");
      int B = playerStore.voteCount(betId, "B");
      bet.setaVote(A);
      bet.setbVote(B);
      return bet;
   }

   @Override
   public List<Bet> findByOwner(String betOwner, String betWay) {
      return betStore.searchByBetOwner(betOwner, betWay);
   }

   @Override
   public List<Bet> findByTitle(String title, String betWay) {
      return betStore.searchByTitle(title, betWay);
   }

   @Override
   public List<Bet> findByState(String state) {
      return betStore.searchByState(state);
   }

   @Override
   public List<Bet> findByBetWay(String betWay) {
      List<Bet> betList = betStore.searchByBetWay(betWay);
      Date today = new Date(Calendar.getInstance().getTimeInMillis());
      
      for(Bet b : betList) {
         int eq = b.getEndDate().compareTo(today);
         if(eq <=0 && b.getState().equals("진행")) {
             gameService.timeEndGame(b);
         }
      }
      return betList;
   }

   @Override
   public void modify(Bet bet) {
      betStore.update(bet);
   }

   @Override
   public void removeBet(String betId) {
      inviteStore.deletebyBetId(betId);
      betStore.delete(betId);
      teamService.removeTeam(betId);
      playerStore.deleteByBetId(betId);
   }

   @Override
   public List<Bet> findByUserId(String betOwner) {
       return betStore.searchByUserId(betOwner);
   }

}