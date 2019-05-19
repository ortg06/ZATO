/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.entidades.Pais;

import java.lang.ProcessBuilder.Redirect;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.zato.app.Servicios.IService;

/**
 *
 * @author Alex
 */

@Controller
@SessionAttributes("pais")
public class PaisController {
    
    @Autowired
     private IService paisService;
    
    @RequestMapping(value="/listarPais",method=RequestMethod.GET)
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Paises");
        model.addAttribute("paises",paisService.findAll());
        return "pais/listar";
    }
    
    @RequestMapping(value="/formPais",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Pais pais = new Pais();
        model.put("pais", pais);
        model.put("titulo", "Datos del Pais");
        return "pais/form";
    }
    
     @RequestMapping(value="/formPais/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        Pais pais = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            pais = paisService.findOne(id);
        } else {
            return "redirect:/listarPais";
        }
        model.put("pais", pais);
        model.put("titulo", "Editar Cliente");
        return "pais/form";
    }
    
    @RequestMapping(value="/form1",method=RequestMethod.POST)
    public String guardar(Pais pais, SessionStatus status)
    {
        paisService.save(pais);
        status.setComplete();
        return "redirect:/listarPais";
    }

    @RequestMapping(value = "/eliminarPais/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            paisService.delete(id);
        }
        return "redirect:/listarPais";
    }
}
