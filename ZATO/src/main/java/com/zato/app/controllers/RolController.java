/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("rol")
public class RolController {
    
    @Autowired
     private IService rolService;
    
    
    //tabla
    @RequestMapping(value="/Rol/listar",method=RequestMethod.GET)
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Roles");
        model.addAttribute("roles",rolService.findAllRol());
        return "rol/listar";
    }
    
    //nuevo
     @RequestMapping(value="/Rol/form",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Rol rol = new Rol();
        model.put("rol", rol);
        model.put("titulo", "Datos del Rol");
        return "rol/form";
    }
    
    //editar
    @RequestMapping(value="/Rol/form/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
        Rol rol = null;
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            rol = rolService.findOneRol(id);
        } else {
            return "redirect:/Rol/listar";
        }
        model.put("rol", rol);
        model.put("titulo", "Editar Rol");
        return "rol/form";
    }
    
    
    //guardar
     @RequestMapping(value="/Rol/form",method=RequestMethod.POST)
    public String guardar(Rol rol, SessionStatus status)
    {
        
        rolService.saveRol(rol);
        
        status.setComplete();
        return "redirect:/Rol/listar";
    }

    
    //eliminar
    @RequestMapping(value = "/Rol/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            rolService.deleteRol(id);
        }
        return "redirect:/Rol/listar";
    }
    
}

