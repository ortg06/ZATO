/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoIdioma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes("catalogoidioma")
public class CatalogoIdiomaController {
    
    @Autowired
     private IService catIdiomaService;
    
    //tabla
    @RequestMapping(value="/CatalogoIdioma/listar",method=RequestMethod.GET)
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Idiomas");
        model.addAttribute("idiomas",catIdiomaService.findAllCatIdioma());
        return "catalogoidioma/listar";
    }
    
    //nuevo
     @RequestMapping(value="/CatalogoIdioma/form",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoIdioma catalogoidioma = new CatalogoIdioma();
        model.put("catalogoidioma", catalogoidioma);
        model.put("titulo", "Datos de idiomas");
        return "catalogoidioma/form";
    }
    
    //editar
    @RequestMapping(value="/CatalogoIdioma/form/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
        CatalogoIdioma catalogoidioma = null;
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoidioma = catIdiomaService.findOneCatIdioma(id);
        } else {
            return "redirect:/CatalogoIdioma/listar";
        }
        model.put("catalogoidioma", catalogoidioma);
        model.put("titulo", "Editar Idioma");
        return "catalogoidioma/form";
    }
    
    
    //guardar
     @RequestMapping(value="/CatalogoIdioma/form",method=RequestMethod.POST)
    public String guardar(CatalogoIdioma catalogoidioma, SessionStatus status)
    {
        
        catIdiomaService.saveCatIdioma(catalogoidioma);
        
        status.setComplete();
        return "redirect:/CatalogoIdioma/listar";
    }

    
    //eliminar
    @RequestMapping(value = "/CatalogoIdioma/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catIdiomaService.deleteCatIdioma(id);
        }
        return "redirect:/CatalogoIdioma/listar";
    }
}
