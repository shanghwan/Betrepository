package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;
import domain.Report;
import service.BetService;
import service.ReportService;


@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	@Autowired
	private BetService betService;
	

	@RequestMapping("/findBetByUserId.do")
	public ModelAndView findBetByUserId(String betOwner){
		List<Bet> list = betService.findByUserId(betOwner);
		ModelAndView modelAndView = new ModelAndView("userAllBetList.jsp");
		modelAndView.addObject("list", list);
		modelAndView.addObject("betOwner", betOwner);
		return modelAndView;
	}
	
	
		
	@RequestMapping("/UserReport.do")
	public ModelAndView UserReport(String target, String userId){
		
		ModelAndView modelAndView = new ModelAndView("UserReportRegist.jsp");
		modelAndView.addObject("target", target);
		modelAndView.addObject("userId", userId);
		return modelAndView;
	}
	
	@RequestMapping("/BetReport.do")
	public ModelAndView BetReport(String target, HttpSession session){
		
		String userId = (String)session.getAttribute("userId");
		
		ModelAndView modelAndView = new ModelAndView("BetReportRegist.jsp");
		modelAndView.addObject("target", target);
		modelAndView.addObject("userId", userId);
		return modelAndView;
	}
	
	
		
	@RequestMapping("/createUserReport.do")
	public ModelAndView createUserReport(Report report){
		reportService.registUserReport(report);
			
		ModelAndView modelAndView = new ModelAndView("BetReportRegist.jsp");
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
	public ModelAndView deleteBetAllReport(String target, String userId){
		
		reportService.removeBetReportAllByTarget(target);
		if(userId.equals("admin")) {
			ModelAndView modelAndView = new ModelAndView("adminpageBet.do");
			return modelAndView;
		}else {
			ModelAndView modelAndView = new ModelAndView("main.do");
			return modelAndView;
		}
			
		
	}
	
	
	
}
