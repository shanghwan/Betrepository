package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;
import domain.Comment;
import service.BetService;
import service.CommentService;

@Controller
public class BetController {

	@Autowired
	private BetService service;
	private CommentService commentService;

	@RequestMapping("/BetOfOnelist.do")
	public ModelAndView BetOfOnelist(String betWay) {
		List<Bet> list = service.findByBetWay(betWay);

		if (betWay.equals("one")) {
			ModelAndView modelAndView = new ModelAndView("BetOfOne.jsp");
			modelAndView.addObject("BetList", list);
			return modelAndView;
		} else if (betWay.equals("all")) {
			ModelAndView modelAndView = new ModelAndView("BetOfAll.jsp");
			modelAndView.addObject("BetList", list);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("BetOfTeam.jsp");
			modelAndView.addObject("BetList", list);
			return modelAndView;
		}

	}

	@RequestMapping("/BetOfOneDetail.do")
	public ModelAndView BetOfOneDetail(String betId) {
		Bet bet = service.findByBetId(betId);
		ModelAndView modelAndView = new ModelAndView("detailBet.jsp");
		modelAndView.addObject("bet", bet);
		return modelAndView;
	}

	@RequestMapping("/BetOfOnelistByState.do")
	public ModelAndView BetOfOnelistByState(String state) {
		List<Bet> list = service.findByState(state);
		ModelAndView modelAndView = new ModelAndView("preseasonGame.jsp");
		modelAndView.addObject("BetList", list);
		return modelAndView;
	}

}
