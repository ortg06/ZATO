/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Empresa;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author ecampos
 */
@Controller
@RequestMapping("empresa")
@SessionAttributes("empresa")
public class EmpresaController {
    
      @Autowired    
    private IService IService; 

       @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Empresas Registradas");
        model.addAttribute("empresas",IService.findAllempresa());
        
        return "empresa/listar";
    }
    
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Empresa empresa = new Empresa();
        model.put("empresa", empresa);
        model.put("titulo", "Datos de la Empresa");
        model.put("sectores",IService.findAllSectores());
        model.put("tipos",IService.findAllTipoEmpresas());
        model.put("municipios",IService.findAllmun());
               
        return "empresa/formEmp";
    }
    
}
