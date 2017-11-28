package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;


@Controller
public class ReportController {
	
	
		@RequestMapping("/createBetReport.do")
		public ModelAndView createBetReport(String betId){
			ModelAndView modelAndView = new ModelAndView("preseasonGame.jsp");
			return modelAndView;
		}
}
