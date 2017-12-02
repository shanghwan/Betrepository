package service;

public interface GameService {
	String joinBetOfOne(String userId,String teamName, String betId, int point);
	String joinBetOfTeam(String userId,String teamName, String betId, int point);
	String joinBetOfAll(String userId,String teamName, String betId);
	String gameReady(String betId, String teamId);
	String gameStart(String betId);
}
