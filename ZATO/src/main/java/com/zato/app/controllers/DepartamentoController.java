/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.dao.IDepartamentoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Oscar
 */
@Controller
public class DepartamentoController {
    
    @Autowired
    IDepartamentoDao DepartamentoDao;
    
    @RequestMapping(value="/departamentos",method=RequestMethod.GET)
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Departamentos");
        model.addAttribute("departamentos",DepartamentoDao.findAll());
        return "departamentos";
    }
    
}
