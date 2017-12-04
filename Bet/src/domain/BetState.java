package domain;

public class BetState {
	
	private String userId;
	private String stateId;
	private String betId;
	private String state;
	private String title;
	private String betOwner;
	private String betWay;
	
	public BetState() {}
	
	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getBetOwner() {
		return betOwner;
	}



	public void setBetOwner(String betOwner) {
		this.betOwner = betOwner;
	}



	public String getBetWay() {
		return betWay;
	}



	public void setBetWay(String betWay) {
		this.betWay = betWay;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getBetId() {
		return betId;
	}

	public void setBetId(String betId) {
		this.betId = betId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
