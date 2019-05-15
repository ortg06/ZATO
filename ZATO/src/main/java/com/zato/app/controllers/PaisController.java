/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.dao.IPaisDao;
import com.zato.app.entidades.Pais;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Alex
 */

@Controller  
public class PaisController {
    
    @Autowired
    IPaisDao paisDao;
    
    @RequestMapping(value="/listar",method=RequestMethod.GET)
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Paises");
        model.addAttribute("paises",paisDao.findAll());
        return "listar";
    }
    
    @RequestMapping(value="/form")
    public String crear(Map<String,Object> model)
    {
        Pais pais = new Pais();
        model.put("pais", pais);
        model.put("titulo", "Datos del Pais");
        return "form";
    }
    
    @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(Pais pais)
    {
        paisDao.save(pais);
        return "redirect:listar";
    }
}
