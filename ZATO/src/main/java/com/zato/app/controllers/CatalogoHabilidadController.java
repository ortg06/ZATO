/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoHabilidad;
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
@RequestMapping("/CatalogoHabilidad")
@SessionAttributes("catalogoabilidad")
public class CatalogoHabilidadController {
    
     @Autowired
    private IService habilidadService;
    @Autowired
    private IService categoriahabService;
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Habilidades");
        model.addAttribute("habilidades",habilidadService.findAllCatHabilidad());
       
        return "CatalogoHabilidad/listar";
    }
    
    
    @RequestMapping(value="/formH",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoHabilidad catalogohabilidad = new CatalogoHabilidad();
        model.put("catalogohabilidad", catalogohabilidad);
        model.put("titulo", "Datos de la Habilidad");
        model.put("catalogoCategoriaHabilidad",categoriahabService.findAllcategoriaHabilidad());
        return "CatalogoHabilidad/formH";
    }
    
    
    @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoHabilidad catalogohabilidad = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogohabilidad = habilidadService.findOneCatHabilidad(id);
          
        } else {
            return "redirect:/CatalogoHabilidad/listar";
        }
        model.put("catalogohabilidad", catalogohabilidad);
        model.put("titulo", "Editar Habilidad");
        model.put("catalogoCategoriaHabilidad",categoriahabService.findAllcategoriaHabilidad());
        model.put("ch",catalogohabilidad.getCatalogoCategoriaHabilidad().getPkCategoriaHabilidad());
        return "CatalogoHabilidad/formH";
    }
    
    
    
     @RequestMapping(value="/formH",method=RequestMethod.POST)
    public String guardar(CatalogoHabilidad catalogohabilidad, SessionStatus status)
    {
        habilidadService.saveCatHabilidad(catalogohabilidad);
        status.setComplete();
        return "redirect:/CatalogoHabilidad/listar";
    }
    
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            habilidadService.deleteCatHabilidad(id);
        }
        return "redirect:/CatalogoHabilidad/listar";
    }
    
    
}
