package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Attendance;
import domain.Bet;
import domain.Invite;
import domain.Record;
import domain.Report;
import domain.User;
import service.AttendanceService;
import service.BetService;
import service.InviteService;
import service.RecordService;
import service.ReportService;
import service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private BetService betService;
	@Autowired
	private InviteService inviteService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private RecordService recordService;


	@RequestMapping(value = "/Userregist.do", method = RequestMethod.POST)
	public String join (User user, BindingResult bindingResult) {
		
		userService.regist(user);

		return "redirect:main.jsp";
	}
	
	@RequestMapping(value = "/main.do")
	public String main(Model model, HttpSession session) {
		
		String userId = (String) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:index.jsp";
		}
		
		Record recordUser = recordService.findRecord(userId);

		model.addAttribute("recordUser",recordUser);
		
		return "main.jsp";
	}
	
	

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(User user, HttpSession session, String password, Model model) {

		User loginUser = userService.login(user);

		if (loginUser != null && loginUser.getPassword().equals(password)) {
			session.setAttribute("userId", loginUser.getUserId());
			session.setAttribute("loginUser", loginUser);

			return "main.do";
		} else {
			session.invalidate();
			return "redirect:signUp.jsp";
		}

	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public String join(HttpSession session) {
		session.invalidate();

		return "redirect:index.jsp";
	}

	@RequestMapping(value = "/pwok.do", method = RequestMethod.POST)
	public String pwok(HttpSession session, String paw) {

		String userId = (String) session.getAttribute("userId");
		User user = userService.findByUserId(userId);
		if (user.getPassword().equals(paw)) {
			return "redirect:usermodify.jsp";
		}
		return "rediect:mypage.jsp";
	}

	@RequestMapping(value = "/usermodify.do", method = RequestMethod.POST)
	public String usermodify(HttpSession session, String paw) {

		String userId = (String) session.getAttribute("userId");
		User user = userService.findByUserId(userId);

		user.setPassword(paw);
		userService.modifyUser(user);

		return "mypage.jsp";
	}

	@RequestMapping(value = "/deletepwok.do", method = RequestMethod.POST)
	public String deletepwok(HttpSession session, String paw) {

		String userId = (String) session.getAttribute("userId");
		User user = userService.findByUserId(userId);
		if (user.getPassword().equals(paw)) {
			return "redirect:userDelete.jsp";
		}
		return "rediect:userDeletepassword.jsp";
	}

	@RequestMapping(value = "/userdelete.do", method = RequestMethod.POST)
	public String userdelete(HttpSession session) {

		String userId = (String) session.getAttribute("userId");

		userService.remove(userId);
		session.invalidate();
		return "redirect:index.jsp";
	}

	@RequestMapping(value = "/findByuserId.do", method = RequestMethod.POST)
	public String findByuserId(String userId, String betId, Model model) {

		Bet bet = betService.findByBetId(betId);
		User user = userService.findByUserId(userId);
		model.addAttribute("user", user);
		model.addAttribute("bet", bet);
		return "BetFail.jsp";
	}
	@RequestMapping(value = "/invite.do")
	public String invite(String userId, String betId, Model model) {

		inviteService.registInvite(userId, betId);
		model.addAttribute("betId", betId);
		return "redirect:BetFail.do";
	}

	@RequestMapping(value = "/inviteList.do")
	public String inviteList(HttpSession session, Model model) {

		String userId = (String) session.getAttribute("userId");

		List<Invite> list = inviteService.findByAllInviteByUserId(userId);

		model.addAttribute("list", list);
		return "inviteList.jsp";
	}
	
	
		
	@RequestMapping(value = "/adminpage.do")
	public String adminpage(Model model) {
		List<Report> list = reportService.findAllUserReport();
		model.addAttribute("BetList", list);
		return "adminpage.jsp";
	}

	@RequestMapping(value = "/adminpageBet.do")
	public String adminpageBet(Model model) {

		List<Report> list = reportService.findAllBetReport();

		model.addAttribute("BetList", list);

		return "adminpageBet.jsp";
	}

	@RequestMapping(value = "/registattendance.do", method = RequestMethod.POST)
	public String registattendance(HttpSession session, String userId, Attendance attendance, Model model) {

		User loginUser = userService.findByUserId(userId);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		List<Attendance> list = attendanceService.findAttendance(userId);

		if (list.size() == 0) {
			attendanceService.registAttendance(attendance);
		} else {
			for (Attendance a : list) {
				if (sdf.format(d).toString().equals((a.getAttendanceDate().toString()))) {
					break;
				} else {
					attendanceService.registAttendance(attendance);
				}
			}
		}
		model.addAttribute("list", list);
		session.setAttribute("loginUser", loginUser);
		return "attendance.jsp";
	}
	
	@RequestMapping(value = "/pointReset.do")
	public String pointReset(String userId, Model model) {
		
		User user = userService.findByUserId(userId);
		user.setPoint(0);
		userService.modifyUser(user);
		List<Report> list = reportService.findAllBetReport();
		model.addAttribute("BetList", list);
		return "adminpage.do";
	}

	
	

}
