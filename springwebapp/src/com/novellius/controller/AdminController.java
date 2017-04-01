package com.novellius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novellius.pojo.Admin;
import com.novellius.service.AdminService;
@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin")
	public String showAdmin (Model model,@ModelAttribute("resultado")String resultado){
		
		List<Admin> admins = adminService.findAll();
		
		model.addAttribute("admin",new Admin());
		model.addAttribute("resultado",resultado);
		model.addAttribute("admins",admins);
		
		return "admin";
	}
	
	@RequestMapping(value="/admin/save",method=RequestMethod.POST)
	public String saveAdmin(@ModelAttribute("admin")Admin adminForm,
			Model model,RedirectAttributes rd,
			@RequestParam("estado") String estado){
		
		
		//model.addAttribute("adminForm",adminForm);
		//System.out.println(estado);
		
		if(adminService.saveOrUpdate(adminForm)){
			rd.addFlashAttribute("resultado","Cambios realizados con exito");
		}else{
			rd.addFlashAttribute("resultado","Hubo un error. consulte con el administrador");
		}
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/{idAdmin}/update")
	public String showUpdate(Model model,@PathVariable("idAdmin")int id){
		
		Admin admin = adminService.findById(id);
		model.addAttribute("admin",admin);
		return "admin";
	}
	
	@RequestMapping("/admin/{idAdmin}/delete")
	public String delete (@PathVariable("idAdmin")int id,
			RedirectAttributes rd){
		if(adminService.delete(id)){
			rd.addFlashAttribute("resultado","Borrado con exito");
		}else{
			rd.addFlashAttribute("resultado","Hubo un error. caramba!!!");
		}
		return "redirect:/admin";
		
	}
	
	
}
