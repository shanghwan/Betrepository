package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Point;
import domain.User;
import service.PointService;
import service.UserService;

@Controller
public class PointController {
	@Autowired
	private PointService pointService;
	@Autowired
	private UserService userService;

	@RequestMapping("/pointList.do")
	public ModelAndView PointList(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		ModelAndView modelAndView = new ModelAndView("pointList.jsp");
		List<Point> pList = pointService.findAllPoint(userId);

		// System.out.println(pList.toString());

		modelAndView.addObject("pList", pList);

		return modelAndView;
	}

	@RequestMapping(value = "/gitfPoint.do", method = RequestMethod.POST)
	public ModelAndView GiftPoint(Point point, HttpSession session, HttpServletRequest req) {
		String userId = (String) req.getSession().getAttribute("userId");
		String receiverId = (String) session.getAttribute("receiverId");

		User user = userService.findByUserId(userId);

		if (receiverId != null) {
			point.setType("gift");

			pointService.updatePoint(point);
			session.setAttribute("point", point);
			ModelAndView modelAndView = new ModelAndView("pointList.jsp");


		} else if (receiverId == null) {
			point.setType("chulcheck");
			ModelAndView modelAndView = new ModelAndView("pointList.jsp");


		} else if (receiverId == null) {
			point.setType("signUp");
			ModelAndView modelAndView = new ModelAndView("pointList.jsp");


		} else if (receiverId == null) {
			point.setType("result");
			ModelAndView modelAndView = new ModelAndView("pointList.jsp");

		}

		ModelAndView modelAndView = new ModelAndView("pointList.jsp");

		return modelAndView;
	}

	// String userId = (String) req.getSession().getAttribute("userId");
	//
	//
	// List<Attendance> list = attendacneService.findAttendance(userId);
	//
	// session.setAttribute("loginUser", loginUser.getPoint());
	// return "attendance.jsp";
	// }

}
