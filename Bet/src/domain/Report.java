package domain;

import java.sql.Date;

public class Report {
	
	private String reportId;
	private String userId;
	private String target;
	private String division;
	private String reason;
	private Date reportdate;
	
	public Report() {}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getreportdate() {
		return reportdate;
	}

	public void setreportdate(Date reportdate) {
		this.reportdate = reportdate;
	}
	
	

}
