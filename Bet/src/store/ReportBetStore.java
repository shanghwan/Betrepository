package store;

import java.util.List;

import domain.Report;

public interface ReportBetStore {
	
	String create(Report report);
	Report search(String reportId);
	List<Report> searchByAllReportByBetId(String betId);
	List<Report> searchByTarget(String target);
	void delete(String reportId);
	void deleteAllByTarget(String target);
	

}
