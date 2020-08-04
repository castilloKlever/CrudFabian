package com.grafrio.GraficasRiobamba.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grafrio.GraficasRiobamba.entities.Producto;
import com.grafrio.GraficasRiobamba.interfaces.IproductoService;
import com.grafrio.GraficasRiobamba.service.PictureService;



@Controller
@RequestMapping("/GraficasRiobamba")

public class ProductoControlador {

	 @Autowired
	 private IproductoService  service;
	 @Autowired
	    PictureService picService;
	 
	 @RequestMapping("")
	 public String login() {
	     return "login";
	 }
	
	 @RequestMapping("/login")
	 public String showLogin() {
	     return "login.html";
	 }
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @RequestMapping("/private")
	 public String Listar(Model model) {
		 List<Producto>producto=service.listar();
		 model.addAttribute("productos", producto);
	     return "admin";
 
	 }
	 
	 @RequestMapping("/index")
	 public String customers(Model model) {
		 List<Producto>producto=service.listar();
		 model.addAttribute("productos", producto);
	     return "index";
	 }
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/new")
	 public String agregar(Model model) {
		 List<Producto>producto=service.listar();
		 model.addAttribute("productos", producto);
		 model.addAttribute("producto", new Producto());
		 return "new";
	 }
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @RequestMapping("/listar")
	 public String listar(Model model) {
		List<Producto> productos = service.listar();
		model.addAttribute("productos",productos);
		 return "admin";
	 }
	 
	 
	
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @PostMapping("/save")
	 public String save (@Validated Producto p, Model model, BindingResult result , @RequestParam("file") MultipartFile file) {
		 if (result.hasErrors()) {
		        return "new";
		     }
		 UUID idPic = UUID.randomUUID();
	     picService.uploadPicture(file, idPic);
	     p.setFoto(idPic);
	     service.save(p);  
		 return"redirect:/GraficasRiobamba/listar";
	 }
	 
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/editar/{codigo}")
	 public String editar(@PathVariable Long codigo, Model model) {
		 List<Producto> productos = service.listar();
		 model.addAttribute("productos",productos);
		 
		 Optional<Producto>producto = service.listarId(codigo);
		 model.addAttribute("producto",producto);
		 return("new");
	 }
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/eliminar/{codigo}")
		public String delete(@PathVariable long codigo,Model model) {
			service.delete(codigo);
			return "redirect:/GraficasRiobamba/listar";
		}
	
	}
	
		
	 
	 