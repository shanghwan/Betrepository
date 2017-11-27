package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.User;
import service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/Userregist.do", method=RequestMethod.POST)
	public String join(User user) { 
		userservice.regist(user);


		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(User user, HttpServletRequest req) {
		
		User loginUser = userservice.login(user);
		
		if(loginUser != null) {
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", loginUser);
		}else {
			HttpSession session = req.getSession();
			session.invalidate();
			return "redirect:index.jsp";
		}
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.POST)
	public String join(HttpServletRequest req) { 
		HttpSession session = req.getSession();
		session.invalidate();


		return "redirect:index.jsp";
	}
	
	
}
