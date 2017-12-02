package domain;

import java.sql.Date;

public class Point {

	private String pointId;
	private String userId;
	private String receiverId;
	private int point;
	private int sendPoint;
	private Date pointDate;
	private String type;

	public Point() {
	}

	public Point(String pointId, String userId, String receiverId, int point, /* int sendPoint, */ Date pointDate,
			String type) {
		super();
		this.pointId = pointId;
		this.userId = userId;
		this.receiverId = receiverId;
		this.point = point;
		this.pointDate = pointDate;
		this.type = type;
		this.sendPoint = sendPoint;
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

	public int getSendPoint() {
		return sendPoint;
	}

	public void setSendPoint(int sendPoint) {
		this.sendPoint = sendPoint;
	}

	public Date getPointDate() {
		return pointDate;
	}

	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
