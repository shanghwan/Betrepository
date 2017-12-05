package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;
import domain.Comment;
import service.BetService;
import service.CommentService;

@Controller
@MultipartConfig(maxFileSize = 1024 * 1024
		* 1024, location = "C:/Users/kosta/eclipse-workspace/web.servlet.todayCom_ver01/WebContent/photo")
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
		betService.findByBetId(comment.getBetId());
//		comment.setBetId(comment.getBetId());
		System.out.println(comment.getBetId());

		String commentId = commentService.registComment(comment);

		return "redirect:BetDetail.do";
	}

	@RequestMapping(value = "/uploadFile.do", method = RequestMethod.POST)
	public ModelAndView uploadHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				File dir = new File("c:\\" + File.separator + "tempFiles");
				if (!dir.exists()) {
					dir.mkdirs();
				}
				File saveFile = new File(dir.getAbsolutePath() + File.separator + name);

				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));

				out.write(bytes);
				out.close();

				ModelAndView modelAndView = new ModelAndView("detailBetOfOne.jsp");
				modelAndView.addObject("img", "/images/" + name);

				return modelAndView;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@RequestMapping(value = "/removeComment.do")
	public ModelAndView deleteComment(Comment comment, String commentId) {

		commentService.removeComment(commentId);

		ModelAndView modelAndView = new ModelAndView("BetDetail.do");
		return modelAndView;
	}

}