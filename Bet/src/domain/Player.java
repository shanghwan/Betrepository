package domain;

public class Player {
	
	private String playerId;
	private String userId;
	private String teamId;
	private String position;
	private String point;
	private String vote;
	private String betId;
	
	public Player() {}

	

	public Player(String playerId, String userId, String teamId, String position, String point, String vote,
			String betId) {
		super();
		this.playerId = playerId;
		this.userId = userId;
		this.teamId = teamId;
		this.position = position;
		this.point = point;
		this.vote = vote;
		this.betId = betId;
	}



	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public String getBetId() {
		return betId;
	}

	public void setBetId(String betId) {
		this.betId = betId;
	}
	
	

}
