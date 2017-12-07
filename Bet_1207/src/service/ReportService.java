package service;

import java.util.List;

import domain.Report;
import domain.User;

public interface ReportService {
	
	void registBetReport(Report report);
	void registUserReport(Report report);
	List<Report> findAllBetReport();
	List<Report> findAllUserReport();
	Report findByBetReportId(String reportId);
	List<User> findByTarget(String target);
	Report findByUserReportId(String reportId);
	void removeBetReport(String reportId);
	void removeBetReportAllByTarget(String target);
	void removeUserReport(String reportId);
	

}
