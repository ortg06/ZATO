/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Submenu;
import java.math.BigDecimal;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



@Controller
@RequestMapping("/submenu")
@SessionAttributes("submenu")
public class SubmenuController {
    @Autowired
    private IService SubmenuService;
    @Autowired
    private IService menuService; 
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado Submenu");
        model.addAttribute("submenus",SubmenuService.findAllSubmenu());
       
        return "submenu/listar";
    }
  
     @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Submenu submenu = new Submenu();
        model.put("submenu", submenu);
        model.put("titulo", "Datos del Submenu");
        model.put("menus",menuService.findAll());
        return "submenu/formsubm";
    }
    
     @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        Submenu submenu = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            submenu = SubmenuService.findOneSubmenu(id);
          
        } else {
            return "redirect:/submenu/listar";
        }
        model.put("submenu", submenu);
        model.put("titulo", "Editar Submenu");
        model.put("menus",menuService.findAll());
        model.put("p",submenu.getMenu().getPkMenu());
        return "submenu/formsubm";
    } 
    
    
    
}
