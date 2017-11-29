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
	
	
	 @RequestMapping(value="/attendance.do", method = RequestMethod.POST)
	 public String attendance(HttpServletRequest req, HttpSession session){
	 String userId = (String)req.getSession().getAttribute("userId");
	 User loginUser = userservice.findByUserId(userId);
	 userservice.attendanceUser(userId);
	 //session.invalidate();
	 session.setAttribute("loginUser", loginUser);
	 return "redirect:attendance.jsp";
	
	 }

}
