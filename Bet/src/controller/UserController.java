package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.User;
import service.AttendanceService;
import service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	private AttendanceService attendanceservice;

	@RequestMapping(value = "/Userregist.do", method = RequestMethod.POST)
	public String join(User user) {
		userservice.regist(user);

		return "redirect:index.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(User user, HttpServletRequest req) {

		User loginUser = userservice.login(user);

		if (loginUser != null) {
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", loginUser);
		} else {
			HttpSession session = req.getSession();
			session.invalidate();
			return "redirect:index.jsp";
		}

		return "redirect:index.jsp";
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public String join(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();

		return "redirect:index.jsp";
	}

	@RequestMapping(value = "/pwok.do", method = RequestMethod.POST)
	public String pwok(HttpServletRequest req, String paw) {

		String userId = (String) req.getSession().getAttribute("userId");

		User user = userservice.findByUserId(userId);
		System.out.println(user);
		if (user.getPassword().equals(paw)) {
			return "redirect:usermodify.jsp";

		}

		return "rediect:mypage.jsp";
	}

	// @RequestMapping(value="/attendance.do", method = RequestMethod.POST)
	// public String attendance(HttpServletRequest re){
	// String userId = (String)req.getSession().getAttribute("userId");
	// User user = userservice.findByUserId(userId);
	
	// return "rediect:attendance.jsp";
	//
	// }

}
