/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;


import com.zato.app.Servicios.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Oscar
 */
@Controller
@RequestMapping("/departamento")
public class DepartamentoController {
    
    @Autowired
    private IService DepartamentoService;
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Departamentos");
        model.addAttribute("departamentos",DepartamentoService.findAlldep());
        return "departamento/listar";
    }
    
}
