package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Comment;
import service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService service;

	@RequestMapping("/registComment.do")
	public ModelAndView registComment(Comment comment) {
		service.registComment(comment);
		ModelAndView modelAndView = new ModelAndView("detailBet.jsp");
		modelAndView.addObject("comment", comment);

		return modelAndView;
	}

}
