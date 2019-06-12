/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Departamento;
import com.zato.app.entidades.Prueba;
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
@RequestMapping("/prueba")
@SessionAttributes("prueba")
public class ExamenController {
    
    
     @Autowired
    private IService IService;
    
     @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Pruebas");
        model.addAttribute("pruebas",IService.findAllPruebas());
       
        return "prueba/listar";
    }
    
    
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Prueba prueba = new Prueba();
        model.put("prueba", prueba);
        model.put("titulo", "Datos de la prueba");
        model.put("tipos",IService.findAlltipoprueba());
        return "prueba/form";
    }
    
    
    @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
         Prueba prueba = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            prueba  = IService.findOnePrueba(id);
          
        } else {
            return "redirect:/prueba/listar";
        }
        model.put("tipoPrueba",IService.findAlltipoprueba());
        model.put("titulo", "Editar Prueba");
        model.put("tp",prueba.getCatalogoTipoPrueba().getPkCatTipoPrueba());
        return "prueba/form";
    }
    
    
    
     @RequestMapping(value="/formdep",method=RequestMethod.POST)
    public String guardar(Prueba prueba, SessionStatus status)
    {
        IService.savePrueba(prueba);
        status.setComplete();
        return "redirect:/prueba/listar";
    }
    
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            IService.deletePrueba(id);
        }
        return "redirect:/prueba/listar";
    }
    
    
    
    
}
