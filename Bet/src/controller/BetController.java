package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Bet;
import service.BetService;

@Controller
public class BetController {
	
	@Autowired
	private BetService service;
	
	@RequestMapping(value = "/registBet.do", method = RequestMethod.POST)
	public String registBet(Bet bet) { 
		
		service.registBet(bet);

		return "redirect:BetOfOne.jsp";
	}


}
