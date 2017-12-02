package domain;

import java.sql.Date;
import java.util.List;

public class Bet {

	private String betId;
	private String title;
	private String state;
	private String betWay;
	private String content;
	private String photoA;
	private String photoB;
	private String betOwner;
	private int point;
	private String endDate;
	private Date startDate;
	private String openCheck;
	private int aVote;
	private int bVote;
	private String pointCheck;

	private List<Comment> comments;

	public Bet() {
	}

	public String getPointCheck() {
		return pointCheck;
	}

	public void setPointCheck(String pointCheck) {
		this.pointCheck = pointCheck;
	}

	public String getBetId() {
		return betId;
	}

	public void setBetId(String betId) {
		this.betId = betId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBetWay() {
		return betWay;
	}

	public void setBetWay(String betWay) {
		this.betWay = betWay;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhotoA() {
		return photoA;
	}

	public void setPhotoA(String photoA) {
		this.photoA = photoA;
	}

	public String getPhotoB() {
		return photoB;
	}

	public void setPhotoB(String photoB) {
		this.photoB = photoB;
	}

	public String getBetOwner() {
		return betOwner;
	}

	public void setBetOwner(String betOwner) {
		this.betOwner = betOwner;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getOpenCheck() {
		return openCheck;
	}

	public void setOpenCheck(String openCheck) {
		this.openCheck = openCheck;
	}

	public int getaVote() {
		return aVote;
	}

	public void setaVote(int aVote) {
		this.aVote = aVote;
	}

	public int getbVote() {
		return bVote;
	}

	public void setbVote(int bVote) {
		this.bVote = bVote;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
