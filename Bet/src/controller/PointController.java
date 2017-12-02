package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	// @RequestMapping(value = "/gitfPoint.do", method=RequestMethod.POST)
	// public ModelAndView GiftPoint(String point, HttpSession session) {
	// session.getAttribute("userId");
	// String userId = (String)session.getAttribute("userId");
	// pointService.presentPoint(point);
	// session.setAttribute("pointId", pointId);
	//
	//
	//
	//
	// ModelAndView modelAndView = new ModelAndView("pointList.jsp");
	//
	//
	//
	// return modelAndView;
	// }

}
