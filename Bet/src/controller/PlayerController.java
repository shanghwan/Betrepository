package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.BetService;
import service.PlayerService;
import service.TeamService;

@Controller
public class PlayerController {

	@Autowired
	private TeamService teamService;
	@Autowired
	private BetService betService;
	@Autowired
	private PlayerService playerService;
	
	
	@RequestMapping(value = "/deleteplayerByTeamA.do")
	public ModelAndView deleteplayerByTeamA(String userId, String betId, String betWay) {
		
		playerService.removePlayerByBetIdAndUserId(betId, userId);
		
		ModelAndView modelAndView = new ModelAndView("BetDetail.do");
		return modelAndView;
		}
	}
