/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoGradoAcademico;
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
@RequestMapping("/catalogoGradoAcademico")
@SessionAttributes("catalogoGradoAcademico")
public class CatalogoGradoAcademicoController{
    
    @Autowired
    private IService gradoAcademico;
    
     @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Catálogo Categoria Habilidad");
        model.addAttribute("gradosAcademicos",gradoAcademico.findAllCatalogoGradoAcademico());
       
        return "catalogoGradoAcademico/listar";
    }
    
     
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoGradoAcademico catalogoGradoAcademico = new CatalogoGradoAcademico();
        model.put("catalogoGradoAcademico", catalogoGradoAcademico);
        model.put("titulo", "Datos de Grado Academico");
        
        return "catalogoGradoAcademico/form";
    }
    
         @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoGradoAcademico catalogoGradoAcademico = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoGradoAcademico = gradoAcademico.findOneCatalogoGradoAcademico(id);
          
        } else {
            return "redirect:/catalogoGradoAcademico/listar";
        }
        model.put("catalogoGradoAcademico",catalogoGradoAcademico);
        model.put("titulo", "Editar Categoria de Habilidad");
       
        return "catalogoGradoAcademico/form";
    }
    
     @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(CatalogoGradoAcademico catalogoGradoAcademico, SessionStatus status)
    {
        gradoAcademico.saveCatalogoGradoAcademico(catalogoGradoAcademico);
        status.setComplete();
        return "redirect:/catalogoGradoAcademico/listar";
    }
    
   
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            gradoAcademico.deleteCatalogoGradoAcademico(id);
        }
        return "redirect:/catalogoGradoAcademico/listar";
    }
    
    
}
