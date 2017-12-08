package domain;

import java.sql.Date;

public class Attendance {
	
	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", userId=" + userId + ", attendanceDate=" + attendanceDate
				+ "]";
	}
	private String attendanceId;
	private String userId;
	private Date attendanceDate;
	
	
	public String getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(String attendanceId) {
		this.attendanceId = attendanceId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

}
