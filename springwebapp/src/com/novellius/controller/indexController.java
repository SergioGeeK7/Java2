package com.novellius.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

//@SessionAttributes({"resultado","mensaje"})
@Controller
@SessionAttributes("resultado")
public class indexController {
	
	
	@RequestMapping("/")
	public String showIndex (Model model,HttpSession session){
		model.addAttribute("resultado","Resultado desde Session");
		//session.setAttribute("resultado", "resultado desde sesion");
		return "index";
	}
	
	@RequestMapping("/about")
	public String showAbout (SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "about";
	}

}
