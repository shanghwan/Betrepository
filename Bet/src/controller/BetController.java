package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;
import domain.BetState;
import domain.Team;
import service.BetService;
import service.BetStateService;
import service.CommentService;
import service.InviteService;
import service.TeamService;

@Controller
public class BetController {

	@Autowired
	private BetService betService;
	@Autowired
	private InviteService inviteService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private BetStateService betStateService;

	@RequestMapping("/Betlist.do")
	public ModelAndView Betlist(String betWay) {
		List<Bet> list = betService.findByBetWay(betWay);

		if (betWay.equals("One")) {
			ModelAndView modelAndView = new ModelAndView("BetOfOne.jsp");
			modelAndView.addObject("BetList", list);
			return modelAndView;
		} else if (betWay.equals("All")) {
			ModelAndView modelAndView = new ModelAndView("BetOfAll.jsp");
			modelAndView.addObject("BetList", list);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("BetOfTeam.jsp");
			modelAndView.addObject("BetList", list);
			return modelAndView;
		}
	}

	@RequestMapping("/BetDetail.do")
	public ModelAndView BetDetail(String betId) {
		Bet bet = betService.findByBetId(betId);
		List<String> list = inviteService.findByAllInviteByBetId(betId);
		String teamName = "A";
		Team teamA = teamService.findByTeamName(betId, teamName);
		teamName = "B";
		Team teamB = teamService.findByTeamName(betId, teamName);

		if (bet.getBetWay().equals("One")) {
			ModelAndView modelAndView = new ModelAndView("detailBetOfOne.jsp");
			modelAndView.addObject("bet", bet);
			modelAndView.addObject("list", list);
			modelAndView.addObject("teamA", teamA);
			modelAndView.addObject("teamB", teamB);
			return modelAndView;

		} else if (bet.getBetWay().equals("Team")) {
			ModelAndView modelAndView = new ModelAndView("detailBetOfTeam.jsp");
			modelAndView.addObject("bet", bet);
			modelAndView.addObject("list", list);
			modelAndView.addObject("teamA", teamA);
			modelAndView.addObject("teamB", teamB);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("detailBetOfAll.jsp");
			modelAndView.addObject("bet", bet);
			modelAndView.addObject("list", list);
			modelAndView.addObject("teamA", teamA);
			modelAndView.addObject("teamB", teamB);
			return modelAndView;
		}

	}

	@RequestMapping("/BetlistByState.do")
	public ModelAndView BetlistByState(String state) {
		List<Bet> list = betService.findByState(state);
		ModelAndView modelAndView = new ModelAndView("preseasonGame.jsp");
		modelAndView.addObject("BetList", list);
		return modelAndView;
	}

	@RequestMapping(value = "/registBet.do", method = RequestMethod.GET)
	public String showCreateBet(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if (userId == null) {

			return "redirect:index.jsp";
		}
		return "BetCreate.jsp";
	}

	@RequestMapping(value = "/registBet.do", method = RequestMethod.POST)
	public String registBet(Bet bet, HttpSession session) {

		String userId = (String) session.getAttribute("userId");

		bet.setBetOwner(userId);

		bet.setPhotoA("null");
		bet.setPhotoB("null");

		String betId = betService.registBet(bet);
		return "redirect:BetDetail.do?betId=" + betId;
	}

	@RequestMapping(value = "/BetFail.do")
	public String BetFail(String betId, Model model, HttpSession session) {

		List<String> list = inviteService.findByAllInviteByBetId(betId);

		session.setAttribute("betId", betId);
		model.addAttribute("list", list);
		return "BetFail.jsp";
	}

	@RequestMapping(value = "/deleteinviteByuserId.do")
	public String deleteinviteByuserId(String userId, String betId) {

		inviteService.removeInvite(userId, betId);
		return "BetFail.do";
	}

	@RequestMapping(value = "/gamestart.do")
	public String gamestart(String userId, String betId, Model model) {

		Bet bet = betService.findByBetId(betId);
		model.addAttribute("bet", bet);

		return "BetDetail.do";
	}

	@RequestMapping(value = "/betStateList.do")
	public String betStateList(String userId, String state, Model model) {

		List<BetState> list = betStateService.findBetState(userId, state);
		model.addAttribute("list", list);

		return "betstate.jsp";
	}

	@RequestMapping(value = "/findBet.do")
	public String findBet(String betId, String betOwner, String title, Model model, String betWay) {

		if (betId != null) {
			Bet bet = betService.findByBetId(betId);
			if (betWay.equals("One")) {
				model.addAttribute("betWay", betWay);
				model.addAttribute("bet", bet);
				return "BetOfOne.jsp";
			} else if (betWay.equals("All")) {
				model.addAttribute("betWay", betWay);
				model.addAttribute("bet", bet);
				return "BetOfAll.jsp";
			} else {
				model.addAttribute("betWay", betWay);
				model.addAttribute("bet", bet);
				return "BetOfTeam.jsp";
			}
		} else if (betOwner != null) {
			List<Bet> list = betService.findByOwner(betOwner, betWay);
			if (betWay.equals("One")) {
				model.addAttribute("betWay", betWay);
				model.addAttribute("list", list);
				return "BetOfOne.jsp";
			} else if (betWay.equals("All")) {
				model.addAttribute("betWay", betWay);
				model.addAttribute("list", list);
				return "BetOfAll.jsp";
			} else {
				model.addAttribute("betWay", betWay);
				model.addAttribute("list", list);
				return "BetOfTeam.jsp";
			}
		} else {
			List<Bet> list1 = betService.findByTitle(title, betWay);
			if (betWay.equals("One")) {
				model.addAttribute("betWay", betWay);
				model.addAttribute("list1", list1);
				return "BetOfOne.jsp";
			} else if (betWay.equals("All")) {
				model.addAttribute("betWay", betWay);
				model.addAttribute("list1", list1);
				return "BetOfAll.jsp";
			} else {
				model.addAttribute("betWay", betWay);
				model.addAttribute("list1", list1);
				return "BetOfTeam.jsp";
			}
		}
	}

}
