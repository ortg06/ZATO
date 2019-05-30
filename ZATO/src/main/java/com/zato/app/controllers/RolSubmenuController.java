/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.RolSubmenu;
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
@RequestMapping("/RolSubmenu")
@SessionAttributes("rolsubmenu")
public class RolSubmenuController {
    
     @Autowired
    private IService RolService;
    @Autowired
    private IService SubmenuService; 
     @Autowired
    private IService RolSubmenuService;
    
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Submenu por Rol");
        model.addAttribute("RolSubmenus",RolSubmenuService.findAllRolS());
       
        return "RolSubmenu/listar";
    }
  
     @RequestMapping(value="/formRS",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        RolSubmenu rolsubmenu = new RolSubmenu();
        model.put("rolsubmenu", rolsubmenu);
        model.put("titulo", "Datos del Submenu por Rol");
        model.put("Rol",RolService.findAllRol());
        model.put("Submenu",SubmenuService.findAllSubmenu());
        return "RolSubmenu/formRS";
    }
    
     @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
            RolSubmenu rolsubmenu = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            rolsubmenu = RolSubmenuService.findOneRolS(id);
          
        } else {
            return "redirect:/RolSubmenu/listar";
        }
        model.put("rolsubmenu", rolsubmenu);
        model.put("titulo", "Editar Submenu por Roles");
        model.put("Rol",RolService.findAllRol());
        model.put("r",rolsubmenu.getRol().getPkRol());
        model.put("s",rolsubmenu.getSubmenu().getPkSubmenu());
        return "RolSubmenu/formRS";
    } 
    
    @RequestMapping(value="/formRS",method=RequestMethod.POST)
    public String guardar(RolSubmenu rolsubmenu, SessionStatus status)
    {
        RolSubmenuService.saveRolS(rolsubmenu);
        status.setComplete();
        return "redirect:/RolSubmenu/listar";
    }
    
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            RolSubmenuService.deleteRolS(id);
        }
        return "redirect:/RolSubmenu/listar";
    }
    
    
}
