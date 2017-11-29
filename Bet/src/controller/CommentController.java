package controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Comment;
import service.CommentService;

@Controller
@MultipartConfig(maxFileSize = 1024 * 1024 * 1024, location = "C:/Users/kosta/eclipse-workspace/web.servlet.todayCom_ver01/WebContent/photo")
public class CommentController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CommentService service;

	@RequestMapping(value = "/registComment.do", method = RequestMethod.POST)
	public ModelAndView registComment(HttpSession session, Comment comment) {
		String userId = (String) session.getAttribute("userId");
		comment.setUserId(userId);
		service.registComment(comment);
		ModelAndView modelAndView = new ModelAndView("detailBet.jsp");
		modelAndView.addObject("comment", comment);
		return modelAndView;
	}

	@RequestMapping(value = "/removeComment.do", method = RequestMethod.POST)
	public ModelAndView deleteComment(Comment comment, String commentId) {
		service.removeComment(commentId);
		ModelAndView modelAndView = new ModelAndView("detailBet.jsp");
		return modelAndView;
	}

}
