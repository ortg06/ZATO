/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoAptitud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping("/catalogoAptitud")
@SessionAttributes("catalogoAptitud")
public class CatalogoAptitudController {
    
    @Autowired
    private IService aptitud;
    
     @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Catálogo Aptitud");
        model.addAttribute("aptitudes",aptitud.findAllCatalogoAptitud());
       
        return "catalogoAptitud/listar";
    }
    
     
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoAptitud catalogoAptitud = new CatalogoAptitud();
        model.put("catalogoAptitud", catalogoAptitud);
        model.put("titulo", "Datos de Aptitud");
        
        return "catalogoAptitud/form";
    }
    
         @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoAptitud catalogoAptitud = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoAptitud = aptitud.findOneCatalogoAptitud(id);
          
        } else {
            return "redirect:/catalogoAptitud/listar";
        }
        model.put("catalogoAptitud",catalogoAptitud);
        model.put("titulo", "Editar Aptitud");
       
        return "catalogoAptitud/form";
    }
    
     @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(CatalogoAptitud catalogoAptitud, SessionStatus status)
    {
        aptitud.saveCatalogoAptitud(catalogoAptitud);
        status.setComplete();
        return "redirect:/catalogoAptitud/listar";
    }
    
   
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            aptitud.deleteCatalogoAptitud(id);
        }
        return "redirect:/catalogoAptitud/listar";
    }
    
    
    
}