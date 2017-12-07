package domain;

public class Invite {
	
	private String inviteUserId;
	private String BetId;
	private String title;
	private String betOwner;
	
	public Invite() {}
	
	

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



	public String getInviteUserId() {
		return inviteUserId;
	}

	public void setInviteUserId(String inviteUserId) {
		this.inviteUserId = inviteUserId;
	}

	public String getBetId() {
		return BetId;
	}

	public void setBetId(String betId) {
		BetId = betId;
	}
	
	

}
