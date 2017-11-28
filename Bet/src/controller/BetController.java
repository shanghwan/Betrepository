package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;
import service.BetService;

@Controller
public class BetController {
	
	@Autowired
	private BetService service;
	
	@RequestMapping("/list.do")
	public ModelAndView showMusicChart(){
		List<Bet> list = service.findAllBet();
		ModelAndView modelAndView = new ModelAndView("BetOfOne.jsp");
		modelAndView.addObject("BetList", list);
		return modelAndView;
	}
	
	


}
