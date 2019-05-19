/**
 *
 * @author Alex
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("catalogoPonderacion")
public class CatalogoPonderacionController{

    @Autowired
    private IService catalogoPonderacionService;

    @RequestMapping(value="/listarCatalogoPonderacion", method = RequestMethod.GET)
    public String listarCatalogoPonderacion(Model model)
    {
        model.addAttribute("titulo", "Catalogo de Ponderaciones");
        
        return "listarCatalogoPonderacion";
    }



 }