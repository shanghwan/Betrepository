package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Point;
import service.PointService;

@Controller
public class PointController {
	@Autowired
	private PointService pointService;

	@RequestMapping("/pointList.do")
	public ModelAndView PointList(HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		ModelAndView modelAndView = new ModelAndView("pointList.jsp");
		List<Point> pList = pointService.findAllPoint(userId);
		
	//	System.out.println(pList.toString());
		
		modelAndView.addObject("pList", pList);

		return modelAndView;
	}

}
