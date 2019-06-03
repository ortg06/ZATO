/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoEscrito;
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

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping("/catalogoEscrito")
@SessionAttributes("catalogoEscrito")
public class CatalogoEscritoController {
     
    @Autowired
    private IService escrito;
    
     @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Catálogo Tipo Escrito");
        model.addAttribute("escritos",escrito.findAllCatalogoEscrito());
       
        return "catalogoEscrito/listar";
    }
    
     
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoEscrito catalogoEscrito = new CatalogoEscrito();
        model.put("catalogoEscrito",catalogoEscrito);
        model.put("titulo", "Datos de Tipo Escrito");
        
        return "catalogoEscrito/form";
    }
    
         @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoEscrito catalogoEscrito = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoEscrito = escrito.findOneCatalogoEscrito(id);
          
        } else {
            return "redirect:/catalogoEscrito/listar";
        }
        model.put("catalogoEscrito",catalogoEscrito);
        model.put("titulo", "Editar tipo Escrito");
       
        return "catalogoEscrito/form";
    }
    
     @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(CatalogoEscrito catalogoEscrito, SessionStatus status)
    {
        escrito.saveCatalogoEscrito(catalogoEscrito);
        status.setComplete();
        return "redirect:/catalogoEscrito/listar";
    }
    
   
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            escrito.deleteCatalogoEscrito(id);
        }
        return "redirect:/catalogoEscrito/listar";
    }
    
    
    
}
