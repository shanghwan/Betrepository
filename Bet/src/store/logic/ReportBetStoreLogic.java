package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Report;
import store.ReportBetStore;
import store.mapper.ReportBetMapper;

@Repository
public class ReportBetStoreLogic implements ReportBetStore{
	

	@Override
	public String create(Report report) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			ReportBetMapper mapper = session.getMapper(ReportBetMapper.class);
			mapper.create(report);
			session.commit();
		}finally {
			session.close();
		}
		
		return report.getReportId();
	}

	@Override
	public Report search(String reportId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		Report report = null;
		
		try {
			ReportBetMapper mapper = session.getMapper(ReportBetMapper.class);
			report = mapper.search(reportId);
			
		}finally {
			session.close();
		}
		return report;
	}

	@Override
	public List<Report> searchByAllReportByBetId(String betId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Report> list = null;
		
		try {
			ReportBetMapper mapper = session.getMapper(ReportBetMapper.class);
			list = mapper.searchByAllReportByBetId(betId);
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<Report> searchByTarget(String target) {
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Report> list = null;
		
		try {
			ReportBetMapper mapper = session.getMapper(ReportBetMapper.class);
			list = mapper.searchByTarget(target);
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public void delete(String reportId) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			ReportBetMapper mapper = session.getMapper(ReportBetMapper.class);
			mapper.delete(reportId);
			session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deleteAllByTarget(String target) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			ReportBetMapper mapper = session.getMapper(ReportBetMapper.class);
			mapper.deleteAllByTarget(target);
			session.commit();
		}finally {
			session.close();
		}
		
	}
}
