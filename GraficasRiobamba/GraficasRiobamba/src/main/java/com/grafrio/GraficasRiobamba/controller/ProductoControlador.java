package com.grafrio.GraficasRiobamba.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.RequestMapping;



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
	
	}
	
		
	 
	 