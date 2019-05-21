/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
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
@RequestMapping("/catalogoTipoPrueba")
@SessionAttributes("catalogoTipoPrueba")
public class CatalogoTipoPruebaController {
    
    @Autowired
    private IService tipoPruebaService;
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Catálogo Tipo de Prueba");
        model.addAttribute("tipopruebas",tipoPruebaService.findAlltipoprueba());
       
        return "catalogoTipoPrueba/listar";
    }
    
    
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoTipoPrueba catalogoTipoPrueba = new CatalogoTipoPrueba();
        model.put("catalogoTipoPrueba", catalogoTipoPrueba);
        model.put("titulo", "Datos del Tipo de Prueba");
        
        return "catalogoTipoPrueba/form";
    }
    
         @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoTipoPrueba catalogoTipoPrueba = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoTipoPrueba = tipoPruebaService.findOnetprueba(id);
          
        } else {
            return "redirect:/catalogoTipoPrueba/listar";
        }
        model.put("catalogoTipoPrueba",catalogoTipoPrueba);
        model.put("titulo", "Editar Tipo de Prueba");
       
        return "catalogoTipoPrueba/form";
    }
    
     @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(CatalogoTipoPrueba catalogoTipoPrueba, SessionStatus status)
    {
        tipoPruebaService.savetipoprueba(catalogoTipoPrueba);
        status.setComplete();
        return "redirect:/catalogoTipoPrueba/listar";
    }
    
   
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            tipoPruebaService.deletetipoprueba(id);
        }
        return "redirect:/catalogoTipoPrueba/listar";
    }
    
    
}
