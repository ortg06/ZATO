/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoGenero;
import com.zato.app.entidades.CatalogoTipoPrueba;
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
 * @author ecampos
 */
@Controller
@RequestMapping("/catalogoGenero")
@SessionAttributes("catalogoGenero")
public class CatalogoGeneroController {
    
    @Autowired
    private IService catalogoGeneroService;
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Catálogo de Generos");
        model.addAttribute("generos",catalogoGeneroService.findAllcatalogoGenero());
       
        return "catalogoGenero/listar";
    }
    
    
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoGenero catalogoGenero = new CatalogoGenero();
        model.put("catalogoGenero", catalogoGenero);
        model.put("titulo", "Datos del Genero");
        
        return "catalogoGenero/form";
    }
    
         @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoGenero catalogoGenero = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
           catalogoGenero = catalogoGeneroService.findOnecatalogoGenero(id);
          
        } else {
            return "redirect:/catalogoGenero/listar";
        }
        model.put("catalogoGenero",catalogoGenero);
        model.put("titulo", "Editar Genero");
       
        return "catalogoGenero/form";
    }
    
     @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(CatalogoGenero catalogoGenero, SessionStatus status)
    {
       catalogoGeneroService.savecatalogoGenero(catalogoGenero);
        status.setComplete();
        return "redirect:/catalogoGenero/listar";
    }
    
   
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoGeneroService.deletecatalogoGenero(id);
        }
        return "redirect:/catalogoGenero/listar";
    }
    
}
