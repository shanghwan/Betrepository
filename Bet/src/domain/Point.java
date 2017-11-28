package domain;

import java.sql.Date;

public class Point {
	
	private String pointId;
	private String userId;
	private String receiverId;
	private int point;
	private Date regDate;
	private String type;
	
	public Point() {}
	
	public Point(String pointId, String userId, String receiverId, int point, Date regDate, String type) {
		super();
		this.pointId = pointId;
		this.userId = userId;
		this.receiverId = receiverId;
		this.point = point;
		this.regDate = regDate;
		this.type = type;
	}

	public String getPointId() {
		return pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
