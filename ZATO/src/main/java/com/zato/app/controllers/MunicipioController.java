/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.dao.IMunicipioDao;
import com.zato.app.entidades.Municipio;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Oscar
 */
@Controller
@RequestMapping("municipio")
public class MunicipioController {
    @Autowired
            
    IMunicipioDao MunicipioDao;
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Municipios");
        model.addAttribute("municipios",MunicipioDao.findAll());
        return "municipio/listar";
    }
    

    
   
}
