package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import domain.Report;
import store.ReportUserStore;
import store.mapper.ReportUserMapper;

@Repository
public class ReportUserStoreLogic implements ReportUserStore{

   @Override
   public void create(Report report) {
      
      SqlSession session = BetSessionFactory.getinstance().getSession();
      
      try {
         ReportUserMapper mapper = session.getMapper(ReportUserMapper.class);
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
   public List<Report> searchByAllUserReport() {
      
      SqlSession session = BetSessionFactory.getinstance().getSession();
      List<Report> list = null;
      
      try {
         ReportUserMapper mapper = session.getMapper(ReportUserMapper.class);
         list = mapper.searchByAllUserReport();
         
      }finally {
         session.close();
      }
      
      return list;
   }

   @Override
   public void delete(String reportId) {
	   
	   SqlSession session = BetSessionFactory.getinstance().getSession();
	   
	   try {
		   ReportUserMapper mapper = session.getMapper(ReportUserMapper.class);
		   mapper.delete(reportId);
		   session.commit();
	   }finally {
		session.close();
	}
      
   }
   
}