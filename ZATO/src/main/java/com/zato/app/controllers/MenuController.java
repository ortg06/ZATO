/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Menu;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author admin
 */
@Controller
@SessionAttributes("menu")
public class MenuController {
    
    @Autowired
     private IService menuService;
    
    //tabla
    @RequestMapping(value="/Menu/listar",method=RequestMethod.GET)
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado Menu");
        model.addAttribute("menus",menuService.findAllMenu());
        return "menu/listar";
    }
    
    //nuevo
     @RequestMapping(value="/Menu/form",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Menu menu = new Menu();
        model.put("menu", menu);
        model.put("titulo", "Datos del Menu");
        return "menu/form";
    }
    
    //editar
    @RequestMapping(value="/Menu/form/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
        Menu menu = null;
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            menu = menuService.findOneMenu(id);
        } else {
            return "redirect:/Menu/listar";
        }
        model.put("menu", menu);
        model.put("titulo", "Editar Menu");
        return "menu/form";
    }
    
    
    //guardar
     @RequestMapping(value="/Menu/form",method=RequestMethod.POST)
    public String guardar(Menu menu, SessionStatus status)
    {
        
        menuService.saveMenu(menu);
        
        status.setComplete();
        return "redirect:/Menu/listar";
    }

    
    //eliminar
    @RequestMapping(value = "/Menu/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            menuService.deleteMenu(id);
        }
        return "redirect:/Menu/listar";
    }
    
}
