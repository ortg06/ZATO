/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Departamento;
import com.zato.app.entidades.Municipio;
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
 * @author Oscar
 */
@Controller
@RequestMapping("municipio")
@SessionAttributes("municipio")
public class MunicipioController {
    
    @Autowired    
    private IService municipioService; 
     @Autowired    
    private IService paisService; 
      @Autowired    
    private IService departamentoService; 
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Municipios");
        model.addAttribute("municipios",municipioService.findAllmun());
        
        return "municipio/listar";
    }
    
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Municipio municipio = new Municipio();
        model.put("municipio", municipio);
        model.put("titulo", "Datos del Municipio");
        model.put("paises",paisService.findAll());
        model.put("departamentos",departamentoService.findAlldep());
        return "municipio/formMun";
    }
    
     @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        Municipio municipio = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            municipio = municipioService.findOneMunicipio(id);
          
        } else {
            return "redirect:/departamento/listar";
        }
        model.put("municipio", municipio);
        model.put("titulo", "Editar Municipio");
        model.put("paises",paisService.findAll());
        model.put("departamentos",departamentoService.findAlldep());
        return "municipio/formMun";
    }
    
    
    
    
     @RequestMapping(value="/formMun",method=RequestMethod.POST)
    public String guardar(Municipio municipio, SessionStatus status)
    {
        municipioService.saveMun(municipio);
        status.setComplete();
        return "redirect:/municipio/listar";
    }
    
    
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            municipioService.deleteMunicipio(id);
        }
        return "redirect:/municipio/listar";
    }
    
   
}
