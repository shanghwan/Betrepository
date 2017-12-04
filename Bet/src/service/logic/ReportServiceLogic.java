package service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Report;
import domain.User;
import service.ReportService;
import service.TeamService;
import store.BetStore;
import store.InviteStore;
import store.ReportBetStore;

@Service
public class ReportServiceLogic implements ReportService{
	
	@Autowired
	private ReportBetStore reportBetStore;
	@Autowired
	private BetStore betStore;
	@Autowired
	private InviteStore inviteStore;
	@Autowired
	private TeamService teamService;
	
	
	@Override
	public void registBetReport(Report report) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		report.setreportbetdate(today);
		reportBetStore.create(report);
	}

	@Override
	public List<Report> findAllBetReport() {
		
		return reportBetStore.searchByAllBetReport();
	}

	@Override
	public List<Report> findAllUserReport() {
		return null;
	}

	@Override
	public Report findByBetReportId(String reportId) {
		return null;
	}

	@Override
	public List<User> findByTarget(String target) {
		return null;
	}

	@Override
	public Report findByUserReportId(String reportId) {
		return null;
	}

	@Override
	public void removeBetReport(String reportId) {
		reportBetStore.delete(reportId);
	}

	@Override
	public void removeBetReportAllByTarget(String target) {
		
		reportBetStore.deleteAllByTarget(target);
		inviteStore.deletebyBetId(target);
		betStore.delete(target);
		teamService.removeTeam(target);
	}

	@Override
	public void removeUserReport(String reportId) {
		
	}

}
