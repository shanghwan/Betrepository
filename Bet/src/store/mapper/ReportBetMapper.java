package store.mapper;

import java.util.List;

import domain.Report;

public interface ReportBetMapper {
	
	void create(Report report);
	Report search(String reportId);
	List<Report> searchByAllReportByBetId(String betId);
	List<Report> searchByTarget(String target);
	void delete(String reportId);
	void deleteAllByTarget(String target);

}
