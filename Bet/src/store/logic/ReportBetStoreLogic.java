package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Report;
import store.ReportBetStore;
import store.mapper.BetMapper;
import store.mapper.ReportBetMapper;

@Repository
public class ReportBetStoreLogic implements ReportBetStore{
	

	@Override
	public void create(Report report) {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		
		try {
			ReportBetMapper mapper = session.getMapper(ReportBetMapper.class);
			mapper.create(report);
			session.commit();
		}finally {
			session.close();
		}
	}
	

	@Override
	public Report search(String reportId) {
		return null;
	}

	@Override
	public List<Report> searchByAllReportByBetId(String betId) {
		return null;
	}

	@Override
	public List<Report> searchByTarget(String target) {
		return null;
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


	@Override
	public List<Report> searchByAllBetReport() {
		
		SqlSession session = BetSessionFactory.getinstance().getSession();
		List<Report> list = null;
		
		try {
			ReportBetMapper mapper = session.getMapper(ReportBetMapper.class);
			list = mapper.searchByAllBetReport();
		}finally {
			session.close();
		}
		
		return list;
	}
}
