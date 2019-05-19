/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.dao.IPaisDao;
import com.zato.app.entidades.Pais;
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

/**
 *
 * @author Alex
 */

@Controller
@SessionAttributes("pais")
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
    
    @RequestMapping(value="/form",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Pais pais = new Pais();
        model.put("pais", pais);
        model.put("titulo", "Datos del Pais");
        return "form";
    }
    
     @RequestMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        Pais pais = null;
       
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            pais = paisDao.findOne(id);
        } else {
            return "redirect:/listar";
        }
        model.put("pais", pais);
        model.put("titulo", "Editar Cliente");
        return "form";
    }
    
    @RequestMapping(value="/form1",method=RequestMethod.POST)
    public String guardar(Pais pais, SessionStatus status)
    {
        paisDao.save(pais);
        status.setComplete();
        return "redirect:listar";
    }
}
