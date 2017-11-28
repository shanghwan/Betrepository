package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Bet;
import service.BetService;

@Controller
public class BetController {
	
	@Autowired
	private BetService betService;
	
	@RequestMapping(value="/registBet.do", method=RequestMethod.GET)
	public String showCreateBet(HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		if(userId==null) {
			return "redirect:index.jsp";
		}
		
		return "create.jsp";
	}
	
	@RequestMapping(value="/registBet.do", method=RequestMethod.POST)
	public String registBet(Bet bet, HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		
		bet.setBetOwner(userId);
		
		bet.setPhotoA("null");
		bet.setPhotoB("null");
		
		betService.registBet(bet);
		
		//return 디테일로 바꿔야함
		return "redirect:index.jsp";
	}
	
	

	private String getPhotoFile(Part part) {
		String photoFile = null;
		String contentDispositionHeader = part.getHeader("content-disposition");
		String[] elements = contentDispositionHeader.split(";");
		for(String element : elements) {
			photoFile = element.substring(element.indexOf("=")+ 1);
			photoFile = photoFile.trim().replace("\"", "");
		}
		return photoFile;
	}
}
