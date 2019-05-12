package com.zato.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
	
	@Value("${application.controllers.mensaje}")
	private String mensaje;
	
	@GetMapping("/")
	public String hola(Model model) {
		model.addAttribute("mensaje",mensaje);
		return "main";
	}

}
