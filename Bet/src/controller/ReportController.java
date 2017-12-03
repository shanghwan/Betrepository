package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Report;
import service.ReportService;


@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping("/BetReport.do")
	public ModelAndView BetReport(String target, String userId){
		
		ModelAndView modelAndView = new ModelAndView("BetReportRegist.jsp");
		modelAndView.addObject("target", target);
		modelAndView.addObject("userId", userId);
		return modelAndView;
	}
	
	@RequestMapping("/createBetReport.do")
	public ModelAndView createBetReport(Report report){
		reportService.registBetReport(report);
			
		ModelAndView modelAndView = new ModelAndView("BetReportRegist.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/deleteBetReport.do")
	public ModelAndView deleteBetReport(String reportId){
		
		reportService.removeBetReport(reportId);
			
		ModelAndView modelAndView = new ModelAndView("adminpageBet.do");
		return modelAndView;
	}
	
	@RequestMapping("/deleteBetAllReport.do")
	public ModelAndView deleteBetAllReport(String target){
		
		reportService.removeBetReportAllByTarget(target);
		
			
		ModelAndView modelAndView = new ModelAndView("adminpageBet.do");
		return modelAndView;
	}
	
	
	
}
