/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 *
 * @author Dell
 */
@Controller
@RequestMapping("/bitacora")
@SessionAttributes("bitacora")
public class BitacoraController {
      
    @Autowired
    private IService bitacora;
    
     @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Bitacora");
        model.addAttribute("bitacoras",bitacora.findAllBitacora());
       
        return "bitacora/listar";
    }
    
    
   
      
    
    
   
    
    
}
