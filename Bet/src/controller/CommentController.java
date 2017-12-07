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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;
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

	@RequestMapping(value = "/commentUploadFile.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView uploadHandler(Comment comment, MultipartHttpServletRequest file) throws IOException {

		Bet bet = betService.findByBetId(comment.getBetId());

		File dir = new File("c:\\" + File.separator + "tempFiles");

		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		MultipartFile photoA = file.getFile("photoA");

		if (!photoA.isEmpty()) {

			byte[] bytes = photoA.getBytes();

			File saveFile = new File(dir.getAbsolutePath() + File.separator + photoA);

			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
			out.write(bytes);
			out.close();

			ModelAndView modelAndView = new ModelAndView("detailBetOfOne.jsp");
			modelAndView.addObject("img", "/images/" + photoA);

			// comment.setPhoto(saveFile);

			return modelAndView;
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