package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Record;
import domain.User;
import service.RecordService;
import service.UserService;

@Controller
public class RankController {
	
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/rateRank.do")
	public String rateRank(Model model) {

		List<Record> list = recordService.findByRate();

		model.addAttribute("RateList", list);

		return "rateRank.jsp";
	}
	
	@RequestMapping(value = "/totalRank.do")
	public String totalRank(Model model) {

		List<Record> list = recordService.findByTotal();

		model.addAttribute("RateList", list);

		return "totalRank.jsp";
	}
	
	@RequestMapping(value = "/pointRank.do")
	public String pointRank(Model model) {

		List<User> list = userService.findByPoint();

		model.addAttribute("pointList", list);

		return "pointRank.jsp";
	}
	
	@RequestMapping(value = "/winRank.do")
	public String winRank(Model model) {

		List<Record> list = recordService.findByWin();

		model.addAttribute("winList", list);

		return "winRank.jsp";
	}
	
	@RequestMapping(value = "/loseRank.do")
	public String loseRank(Model model) {

		List<Record> list = recordService.findByLose();

		model.addAttribute("loseList", list);

		return "loseRank.jsp";
	}

}
