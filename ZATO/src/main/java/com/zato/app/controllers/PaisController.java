/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Pais;
import com.zato.app.entidades.Prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Alex
 */

@Controller
@SessionAttributes("pais")
public class PaisController {
    
    @Autowired
     private IService paisService;
    
    @RequestMapping(value="/Pais/listar",method=RequestMethod.GET)
    public String listar(Model model)
    {

        Prueba prueba=null;
        BigDecimal num=BigDecimal.valueOf(1);
       
        prueba=paisService.findOnePrueba(num);


        model.addAttribute("titulo", "Listado de Paises");
        model.addAttribute("paises",paisService.findAll());
        return "pais/listar";
    }
    
    @RequestMapping(value="/Pais/form",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Pais pais = new Pais();
        model.put("pais", pais);
        model.put("titulo", "Datos del Pais");
        return "pais/form";
    }
    
     @RequestMapping(value="/Pais/form/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        Pais pais = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            pais = paisService.findOne(id);
        } else {
            return "redirect:/Pais/listar";
        }
        model.put("pais", pais);
        model.put("titulo", "Editar Cliente");
        return "pais/form";
    }
    
    @RequestMapping(value="/Pais/form1",method=RequestMethod.POST)
    public String guardar(Pais pais, SessionStatus status)
    {
        paisService.save(pais);
        status.setComplete();
        return "redirect:/Pais/listar";
    }

    @RequestMapping(value = "/Pais/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            paisService.delete(id);
        }
        return "redirect:/Pais/listar";
    }
}
