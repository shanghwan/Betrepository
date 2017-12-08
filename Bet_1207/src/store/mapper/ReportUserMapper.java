package store.mapper;

import java.util.List;

import domain.Report;

public interface ReportUserMapper {
   
   void create(Report report);
   Report search(String reportId);
   List<Report> searchByAllUserReport();
   void delete(String reportId);
   

}