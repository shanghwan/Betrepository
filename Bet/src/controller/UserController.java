package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Bet;
import domain.Invite;
import domain.User;
import service.AttendanceService;
import service.BetService;
import service.InviteService;
import service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	private AttendanceService attendanceservice;
	@Autowired
	private BetService betservice; 
	@Autowired
	private InviteService inviteservice;

	@RequestMapping(value="/Userregist.do", method = RequestMethod.POST)
	public String join(User user) {
		userservice.regist(user);

		return "redirect:index.jsp";
	}

	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(User user, HttpSession session, String password) {

		User loginUser = userservice.login(user);

		if (loginUser != null && loginUser.getPassword().equals(password)) {
			session.setAttribute("userId", loginUser.getUserId());
			session.setAttribute("loginUser", loginUser);
			return "redirect:index.jsp";
		} else {
			session.invalidate();
			return "redirect:signUp.jsp";
		}

	}

	@RequestMapping(value="/logout.do", method = RequestMethod.POST)
	public String join(HttpSession session) {
		session.invalidate();

		return "redirect:index.jsp";
	}

	@RequestMapping(value="/pwok.do", method = RequestMethod.POST)
	public String pwok(HttpSession session, String paw) {

		String userId = (String) session.getAttribute("userId");
		User user = userservice.findByUserId(userId);
		if (user.getPassword().equals(paw)) {
			return "redirect:usermodify.jsp";
		}
		return "rediect:mypage.jsp";
	}
	
	@RequestMapping(value="/usermodify.do", method = RequestMethod.POST)
	public String usermodify(HttpSession session, String paw) {
		
		String userId = (String) session.getAttribute("userId");
		User user = userservice.findByUserId(userId);
		
		user.setPassword(paw);
		userservice.modifyUser(user);

		return "mypage.jsp";
	}
	
	@RequestMapping(value="/deletepwok.do", method = RequestMethod.POST)
	public String deletepwok(HttpSession session, String paw) {

		String userId = (String) session.getAttribute("userId");
		User user = userservice.findByUserId(userId);
		if (user.getPassword().equals(paw)) {
			return "redirect:userDelete.jsp";
		}
		return "rediect:userDeletepassword.jsp";
	}
	
	@RequestMapping(value="/userdelete.do", method = RequestMethod.POST)
	public String userdelete(HttpSession session) {
		
		String userId = (String)session.getAttribute("userId");
		
		userservice.remove(userId);
		session.invalidate();
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="/findByuserId.do", method = RequestMethod.POST)
	public String findByuserId(String userId, String betId, Model model) {
		
		Bet bet = betservice.findByBetId(betId);
		User user = userservice.findByUserId(userId);
		model.addAttribute("user", user);
		model.addAttribute("bet", bet);
		return "BetFail.jsp";
	}
	
	@RequestMapping(value="/invite.do")
	public String invite(String userId, String betId, Model model) {
		
		inviteservice.registInvite(userId, betId);
		model.addAttribute("betId", betId);
		return "redirect:BetFail.do";
	}
	
	
	@RequestMapping(value="/inviteList.do")
	public String inviteList(HttpSession session, Model model) {
		
		String userId = (String)session.getAttribute("userId");
		
		List<Invite> list = inviteservice.findByAllInviteByUserId(userId);
		
		model.addAttribute("list", list);
		return "inviteList.jsp";
	}
	
	
	
		
	
	
	


}
