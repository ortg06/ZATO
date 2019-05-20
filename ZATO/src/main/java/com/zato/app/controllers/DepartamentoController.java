/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;


import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Departamento;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Oscar
 */
@Controller
@RequestMapping("/departamento")
@SessionAttributes("departamento")
public class DepartamentoController {
    
    @Autowired
    private IService departamentoService;
    @Autowired
    private IService paisService;
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Departamentos");
        model.addAttribute("departamentos",departamentoService.findAlldep());
       
        return "departamento/listar";
    }
    
    
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Departamento departamento = new Departamento();
        model.put("departamento", departamento);
        model.put("titulo", "Datos del Departamento");
        model.put("paises",paisService.findAll());
        return "departamento/formdep";
    }
    
    
     @RequestMapping(value="/formdep",method=RequestMethod.POST)
    public String guardar(Departamento departamento, SessionStatus status)
    {
        departamentoService.saveDepto(departamento);
        status.setComplete();
        return "redirect:/departamento/listar";
    }
    
}
