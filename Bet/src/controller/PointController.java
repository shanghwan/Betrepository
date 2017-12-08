package controller;

import java.util.List;

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

	@RequestMapping(value = "/giftPoint.do", method = RequestMethod.POST)
	public ModelAndView GiftPoint(Point point, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("pointList.do");
		String userId = (String) session.getAttribute("userId");
		if(userService.findByUserId(point.getReceiverId())==null) {
			//받을 유저가 없습니다.
			return modelAndView;
		}
		if(userService.findByUserId(point.getUserId()).getPoint()<point.getPoint()) {
			//포인트가 부족합니다.
			return modelAndView;
		}
		int userPoint = pointService.giftPoint(point);
		
		User loginUser = userService.findByUserId(userId);
		session.setAttribute("userId", loginUser.getUserId());
		session.setAttribute("loginUser", loginUser);
		modelAndView.addObject("userPoint", userPoint);
		return modelAndView;
	}


}
