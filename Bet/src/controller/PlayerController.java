package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;
import domain.Player;
import domain.Team;
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
	
	
	
	
	
	
	
}
