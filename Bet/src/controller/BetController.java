package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;
import domain.User;
import service.BetService;
import service.UserService;

@Controller
public class BetController {
	
	@Autowired
	private BetService betService;
	private UserService userService;
	
	@RequestMapping(value="/registBet.do",method = RequestMethod.GET)
	public String showCreateBet() {
		return "create.jsp";
	}
	
	@RequestMapping(value="/registBet.do",method = RequestMethod.POST)
	public String createBet(Bet bet, HttpSession session) {
		
		System.out.println(bet.getTitle());
		System.out.println(bet.getContent());
		System.out.println(bet.getEndDate());
		String userId = (String)session.getAttribute("userId");
		User user = userService.findByUserId(userId);
		String betOwner = user.getName();
		bet.setBetOwner(betOwner);
		bet.setBetWay("one");
		
		System.out.println(bet.getBetOwner());
		System.out.println(bet.getBetWay());
		
		
		betService.registBet(bet);
		return "redirect:index.jsp";
	}
	
	
	@RequestMapping("/list.do")
	public ModelAndView showMusicChart(){
		List<Bet> list = betService.findAllBet();
		
		ModelAndView modelAndView = new ModelAndView("BetOfOne.jsp");
		modelAndView.addObject("BetList", list);
		return modelAndView;
	}

	
	


}
