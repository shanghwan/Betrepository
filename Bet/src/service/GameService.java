package service;

import domain.Bet;

public interface GameService {
	String joinBetOfOne(String userId,String teamName, String betId, int point);
	String joinBetOfTeam(String userId,String teamName, String betId, int point);
	String joinBetOfAll(String userId,String teamName, String betId);
	String gameReady(String betId, String teamId);
	String gameStart(String betId);
	String voteGame(String betId, String userId, String vote);
	String gameEnd(String betId,String vote);
	String timeEndGame(Bet bet);
}
