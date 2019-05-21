/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoCategoriaHabilidad;
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
@RequestMapping("/catalogoCategoriaHabilidad")
@SessionAttributes("catalogoCategoriaHabilidad")
public class CatalogoCategoriaHabilidadController {
    
    @Autowired
    private IService categoriaHabilidad;
    
     @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Catálogo Categoria Habilidad");
        model.addAttribute("habilidades",categoriaHabilidad.findAllcategoriaHabilidad());
       
        return "catalogoCategoriaHabilidad/listar";
    }
    
     
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoCategoriaHabilidad catalogoCategoriaHabilidad = new CatalogoCategoriaHabilidad();
        model.put("catalogoCategoriaHabilidad", catalogoCategoriaHabilidad);
        model.put("titulo", "Datos de Categoria Habilidad");
        
        return "catalogoCategoriaHabilidad/form";
    }
    
         @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoCategoriaHabilidad catalogoCategoriaHabilidad = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoCategoriaHabilidad = categoriaHabilidad.findOnecategoriaHabilidad(id);
          
        } else {
            return "redirect:/catalogoCategoriaHabilidad/listar";
        }
        model.put("catalogoCategoriaHabilidad",catalogoCategoriaHabilidad);
        model.put("titulo", "Editar Categoria de Habilidad");
       
        return "catalogoCategoriaHabilidad/form";
    }
    
     @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(CatalogoCategoriaHabilidad catalogoCategoriaHabilidad, SessionStatus status)
    {
        categoriaHabilidad.savecategoriaHabilidad(catalogoCategoriaHabilidad);
        status.setComplete();
        return "redirect:/catalogoCategoriaHabilidad/listar";
    }
    
   
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            categoriaHabilidad.deletecategoriaHabilidad(id);
        }
        return "redirect:/catalogoCategoriaHabilidad/listar";
    }
    
    
    
}
