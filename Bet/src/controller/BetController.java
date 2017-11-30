package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;
import domain.Invite;
import domain.User;
import domain.Team;
import service.BetService;
import service.InviteService;
import service.TeamService;

@Controller
public class BetController {
	
	@Autowired
	private BetService betService;
	@Autowired
	private InviteService inviteservice;
	@Autowired
	private TeamService teamService;
	
	@RequestMapping("/BetOfOnelist.do")
	public ModelAndView BetOfOnelist(String betWay){
		List<Bet> list = betService.findByBetWay(betWay);
		
		if(betWay.equals("one")) {
			ModelAndView modelAndView = new ModelAndView("BetOfOne.jsp");
			modelAndView.addObject("BetList", list);
			return modelAndView;
		}else if(betWay.equals("all")) {
			ModelAndView modelAndView = new ModelAndView("BetOfAll.jsp");
			modelAndView.addObject("BetList", list);
			return modelAndView;
		}else {
			ModelAndView modelAndView = new ModelAndView("BetOfTeam.jsp");
			modelAndView.addObject("BetList", list);
			return modelAndView;
		}
		
	}
	
	@RequestMapping("/BetOfOneDetail.do")
	public ModelAndView BetOfOneDetail(String betId){
		Bet bet = betService.findByBetId(betId);
		List<String> list = inviteservice.findByAllInviteByBetId(betId);
		String teamName = "A";
		Team teamA = teamService.findByTeamName(betId, teamName);
		teamName = "B";
		Team teamB = teamService.findByTeamName(betId, teamName);
		
		ModelAndView modelAndView = new ModelAndView("detailBet.jsp");
		modelAndView.addObject("bet", bet);
		modelAndView.addObject("list", list);
		modelAndView.addObject("teamA", teamA);
		modelAndView.addObject("teamB", teamB);
		return modelAndView;
	}
	
	@RequestMapping("/BetOfOnelistByState.do")
	public ModelAndView BetOfOnelistByState(String state){
		List<Bet> list = betService.findByState(state);
		ModelAndView modelAndView = new ModelAndView("preseasonGame.jsp");
		modelAndView.addObject("BetList", list);
		return modelAndView;
	}
		
		
	@RequestMapping(value="/registBet.do", method=RequestMethod.GET)
	public String showCreateBet(HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		if(userId==null) {
			return "redirect:index.jsp";
		}
		
		return "BetCreate.jsp";
	}
	
	@RequestMapping(value="/registBet.do", method=RequestMethod.POST)
	public String registBet(Bet bet, HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		
		bet.setBetOwner(userId);
		
		bet.setPhotoA("null");
		bet.setPhotoB("null");
		
		String betId = betService.registBet(bet);
		
		return "BetOfOneDetail.do?betId="+betId;
	}
	
	@RequestMapping(value="/BetFail.do")
	public String BetFail(String betId, Model model, HttpSession session) {
		
		List<String> list = inviteservice.findByAllInviteByBetId(betId);
		
		session.setAttribute("betId", betId);
		model.addAttribute("list", list);
		return "BetFail.jsp";
	}
	
	@RequestMapping(value="/deleteinviteByuserId.do")
	public String deleteinviteByuserId(String userId, String betId) {
		
		
		inviteservice.removeInvite(userId, betId);
		
		
		return "BetFail.do";
	}
	
	@RequestMapping(value="/gamestart.do")
	public String gamestart(String userId, String betId, Model model) {
		
		Bet bet = betService.findByBetId(betId);
		model.addAttribute("bet", bet);
		
		
		//modify
		
		return "detailBet.jsp";
	}
	
	
	
	

	private String getPhotoFile(Part part) {
		String photoFile = null;
		String contentDispositionHeader = part.getHeader("content-disposition");
		String[] elements = contentDispositionHeader.split(";");
		for(String element : elements) {
			photoFile = element.substring(element.indexOf("=")+ 1);
			photoFile = photoFile.trim().replace("\"", "");
		}
		return photoFile;
	}
}
