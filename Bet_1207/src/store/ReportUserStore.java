package store;

import java.util.List;

import domain.Report;

public interface ReportUserStore {
   
   void create(Report report);
   Report search(String reportId);
   List<Report> searchByAllUserReport();
   void delete(String reportId);
}