package domain;

import java.util.List;

public class Team {
	
	private String teamId;
	private String betId;
	private int totalPoint;
	private String teamName;
	private String start;
	private String result;

	private Player leader;
	private List<Player> players;
	
	public Team() {}
	
	

	public Team(String teamId, String betId, int totalPoint, String teamName, String start, String result,
			Player leader, List<Player> players) {
		super();
		this.teamId = teamId;
		this.betId = betId;
		this.totalPoint = totalPoint;
		this.teamName = teamName;
		this.start = start;
		this.result = result;
		this.leader = leader;
		this.players = players;
	}



	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getBetId() {
		return betId;
	}

	public void setBetId(String betId) {
		this.betId = betId;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Player getLeader() {
		return leader;
	}

	public void setLeader(Player leader) {
		this.leader = leader;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	
	
}
