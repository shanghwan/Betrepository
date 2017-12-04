package controller;

import java.sql.Date;
import java.util.Calendar;
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

//	@RequestMapping(value = "/pointList.do", method = RequestMethod.POST)
//	public ModelAndView attendancePoint(Point point, HttpSession session) {
//
//		pointService.registPoint(point);
//
//		return null;
//	}

	@RequestMapping(value = "/giftPoint.do", method = RequestMethod.POST)
	public ModelAndView GiftPoint(Point point, HttpSession session) {

		pointService.registPoint(point);

		ModelAndView modelAndView = new ModelAndView("pointList.do");

		return modelAndView;
	}
//
//	@RequestMapping(value = "/pointList.do", method = RequestMethod.POST)
//	public ModelAndView gamePoint(Point point) {
//
//		return null;
//
//	}

}
