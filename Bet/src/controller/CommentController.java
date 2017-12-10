package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Comment;
import service.BetService;
import service.CommentService;

@Controller
public class CommentController {
   private static final long serialVersionUID = 1L;

   @Autowired
   private CommentService commentService;
   @Autowired
   private BetService betService;

   @RequestMapping(value = "/registComment.do", method = RequestMethod.POST)
   public String registComment(HttpSession session, Comment comment) {

      String userId = (String) session.getAttribute("userId");

      comment.setUserId(userId);
      String betId = commentService.registComment(comment);

      return "redirect:BetDetail.do?betId=" + betId;
   }


   @RequestMapping(value = "/removeComment.do")
   public ModelAndView deleteComment(Comment comment, String commentId) {

      commentService.removeComment(commentId);

      ModelAndView modelAndView = new ModelAndView("BetDetail.do");
      return modelAndView;
   }

}