package com.novellius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novellius.pojo.Admin;
import com.novellius.pojo.Direccion;
import com.novellius.service.AdminService;
import com.novellius.service.DireccionService;

@Controller
@SessionAttributes("admin")
public class DireccionController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private DireccionService direccionService;
	

	@RequestMapping("/direccion/{idAdmin}")
	public String getAll(Model model,
			@PathVariable("idAdmin")int idAdmin,
			@ModelAttribute("resultado") String resultado
			){
		
		Admin admin = adminService.findById(idAdmin);
		model.addAttribute("admin",admin);
		model.addAttribute("direccion",new Direccion());
		model.addAttribute("resultado",resultado);
		model.addAttribute("direcciones",direccionService.findAll(idAdmin));

		return "direccion";
	}
	
	@RequestMapping("/direccion/save")
	public String save(Model model,
			@ModelAttribute("direccion")Direccion direccion,
			@ModelAttribute("admin")Admin admin,
			RedirectAttributes rd){
		
		direccionService.save(admin, direccion);
		rd.addFlashAttribute("resultado", "Cambios realizados con exito");
		return "redirect:/direccion/" + admin.getIdAdmin();
	}
	
	
	
}
