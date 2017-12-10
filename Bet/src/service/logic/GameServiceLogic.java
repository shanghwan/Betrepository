package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Bet;
import domain.Comment;
import domain.Player;
import domain.Record;
import domain.Team;
import domain.User;
import service.BetService;
import service.GameService;
import service.PlayerService;
import service.PointService;
import service.TeamService;
import store.CommentStore;
import store.PlayerStore;
import store.RecordStore;
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
   @Autowired
   private PointService pointService;
   @Autowired
   private RecordStore recordStore;

   @Override
   public String joinBetOfAll(String userId, String teamName, String betId) {
     
      Team team = teamService.findByTeamName(betId, teamName);
      Bet bet = betService.findByBetId(betId);
      Player player = new Player();
      int point = 10;
      
      if(bet.getBetOwner().equals("admin")) {
         point = 0;
         if(userId.equals("admin")) {
            return null;
         }
      }
      

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
      if (team.getLeader() != null && !(team.getLeader().getUserId().equals(userId))) {
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
      Team team = teamService.findByTeamName(betId, teamName);

      // 내기에 참여중인 나를 삭제
      // playerService.removePlayerByBetIdAndUserId(betId, userId);
      teamService.removePlayerByTeam(userId, betId, team.getTeamId());

      Player player = new Player();
      Bet bet = betService.findByBetId(betId);
      User user = userStore.searchByUserId(userId);

      team = teamService.findByTeamName(betId, teamName);
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
       List<Comment> list = bet.getComments();
         for(Comment c : list) {
            commentStore.delete(c.getCommentId());
         }
      
      betService.modify(bet);
      return betId;
   }

   @Override
   public String voteGame(String betId, String userId, String vote) {
      Player player = playerStore.searchByBetId(userId, betId);
      Bet bet = betService.findByBetId(betId);
      if(bet.getBetOwner().equals("admin")) {
         return gameEnd(betId, vote);
      }
      player.setVote(vote);
      playerStore.update(player);

      int result = 0;
      result = playerStore.voteCount(betId, vote);
      if (result > 1) {
          return gameEnd(betId, vote);
       }
      return betId;
   }

   @Override
   public String gameEnd(String betId, String vote) {
      // int totalPoint = 0;

      Bet bet = betService.findByBetId(betId);

      bet.setState("종료");
      // if (bet.getPhotoA() == null) {
      // bet.setPhotoA("null");
      // }
      // if (bet.getPhotoB() == null) {
      // bet.setPhotoB("null");
      // }

      betService.modify(bet);

      if (vote.equals("A")) {
         Team teamW = teamService.findByTeamName(betId, vote);

         teamW.setResult("WIN");
         teamStore.update(teamW);
         String teamName = "B";
         Team teamL = teamService.findByTeamName(betId, teamName);
         teamL.setResult("LOSE");
         teamStore.update(teamL);

         // totalPoint = teamW.getTotalPoint()+teamL.getTotalPoint();

         // 포인트 처리 서비스 호출 2개 teamW,teamL
         pointService.betResultPoint(teamW.getTeamId(), teamL.getTotalPoint());
         pointService.betResultPoint(teamL.getTeamId(), teamL.getTotalPoint());

         // 전적 기록
         List<Player> winner = playerStore.searchByTeamId(teamW.getTeamId(), betId);
         for (Player p : winner) {
            Record r = recordStore.search(p.getUserId());
            r.setWin(r.getWin() + 1);
            recordStore.update(r);

         }

         List<Player> loser = playerStore.searchByTeamId(teamL.getTeamId(), betId);
         for (Player p : loser) {
            Record r = recordStore.search(p.getUserId());
            r.setLose(r.getLose() + 1);
            recordStore.update(r);
         }
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
         pointService.betResultPoint(teamW.getTeamId(), teamL.getTotalPoint());
         pointService.betResultPoint(teamL.getTeamId(), teamL.getTotalPoint());
         
         // 전적 기록
         List<Player> winner = playerStore.searchByTeamId(teamW.getTeamId(), betId);
         for (Player p : winner) {
            Record r = recordStore.search(p.getUserId());
            r.setWin(r.getWin() + 1);
            recordStore.update(r);

         }

         List<Player> loser = playerStore.searchByTeamId(teamL.getTeamId(), betId);
         for (Player p : loser) {
            Record r = recordStore.search(p.getUserId());
            r.setLose(r.getLose() + 1);
            recordStore.update(r);

         }
      }
      return betId;
   }

   @Override
   public String timeEndGame(Bet bet) {
      int A = playerStore.voteCount(bet.getBetId(), "A");
      int B = playerStore.voteCount(bet.getBetId(), "B");

      bet.setState("종료");
      betService.modify(bet);

      List<Team> teams = teamService.findTeamByBetId(bet.getBetId());

      if (bet.getBetWay().equals("All")) {
         if (A > B) {
            Team teamW = teamService.findByTeamName(bet.getBetId(), "A");
            teamW.setResult("WIN");
            teamStore.update(teamW);
            Team teamL = teamService.findByTeamName(bet.getBetId(), "B");
            teamL.setResult("LOSE");
            teamStore.update(teamL);

            // 포인트 처리 서비스 호출 2개 teamW,teamL
            pointService.betOfAllResultPoint(teamW.getTeamId());
            pointService.betOfAllResultPoint(teamL.getTeamId());

            // 전적 기록
            List<Player> winner = playerStore.searchByTeamId(teamW.getTeamId(), bet.getBetId());
            for (Player p : winner) {
               Record r = recordStore.search(p.getUserId());
               r.setWin(r.getWin() + 1);
               recordStore.update(r);

            }

            List<Player> loser = playerStore.searchByTeamId(teamL.getTeamId(), bet.getBetId());
            for (Player p : loser) {
               Record r = recordStore.search(p.getUserId());
               r.setLose(r.getLose() + 1);
               recordStore.update(r);

            }
         } else if (B > A) {
            Team teamW = teamService.findByTeamName(bet.getBetId(), "B");
            teamW.setResult("WIN");
            teamStore.update(teamW);
            Team teamL = teamService.findByTeamName(bet.getBetId(), "A");
            teamL.setResult("LOSE");
            teamStore.update(teamL);

            // 포인트 처리 서비스 호출 2개 teamW,teamL
            pointService.betOfAllResultPoint(teamW.getTeamId());
            pointService.betOfAllResultPoint(teamL.getTeamId());

            // 전적 기록
            List<Player> winner = playerStore.searchByTeamId(teamW.getTeamId(), bet.getBetId());
            for (Player p : winner) {
               Record r = recordStore.search(p.getUserId());
               r.setWin(r.getWin() + 1);
               recordStore.update(r);

            }

            List<Player> loser = playerStore.searchByTeamId(teamL.getTeamId(), bet.getBetId());
            for (Player p : loser) {
               Record r = recordStore.search(p.getUserId());
               r.setLose(r.getLose() + 1);
               recordStore.update(r);
            }
         } else if (A == B) {
            for (Team t : teams) {
               t.setResult("DRAW");
               teamStore.update(t);
               // 포인트 처리 서비스 호출
               pointService.betOfAllResultPoint(t.getTeamId());
               // 전적 기록
               List<Player> players = playerStore.searchByTeamId(t.getTeamId(), bet.getBetId());
               for (Player p : players) {
                  Record r = recordStore.search(p.getUserId());
                  r.setDraw(r.getDraw() + 1);
                  recordStore.update(r);
               }
            }
         }
         return bet.getBetId();
      }
      for (Team t : teams) {
         t.setResult("DRAW");
         teamStore.update(t);
         // 포인트 처리 서비스 호출
         pointService.betOfAllResultPoint(t.getTeamId());
         // 전적 기록
         List<Player> players = playerStore.searchByTeamId(t.getTeamId(), bet.getBetId());
         for (Player p : players) {
            Record r = recordStore.search(p.getUserId());
            r.setDraw(r.getDraw() + 1);
            recordStore.update(r);
         }
      }
      
      return bet.getBetId();
   }

   @Override
   public String startBetOfAll(String betId) {
       Bet bet = betService.findByBetId(betId);
         bet.setState("진행");
         betService.modify(bet);
         List<Comment> list = bet.getComments();
         for(Comment c : list) {
            commentStore.delete(c.getCommentId());
         }
      return betId;
   }

}