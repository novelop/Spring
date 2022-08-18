package com.spring.redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
		@RequestMapping(value="/redirect")
		public String redirect(HttpServletRequest request,RedirectAttributes rttr) {
			String url = "redirect:/target";
			
			rttr.addAttribute("data",request.getParameter("data"));
			
			//다시요청하면 사라짐
			rttr.addFlashAttribute("data", request.getParameter("data"));
			
			
			return url;
		
	}
		@RequestMapping(value="/target")
		public String target(HttpServletRequest request, RedirectAttributes rttr) {
			String url = "target";
			
			return url;
		}
		
	
}
