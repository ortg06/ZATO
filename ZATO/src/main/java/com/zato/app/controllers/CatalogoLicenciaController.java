/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoLicencia;
import com.zato.app.entidades.CatalogoTipoPrueba;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author ecampos
 */
@Controller
@RequestMapping("/catalogoLicencia")
@SessionAttributes("catalogoLicencia")
public class CatalogoLicenciaController {
    
    
     @Autowired
    private IService licenciaService;
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Catálogo Tipo de Prueba");
        model.addAttribute("licencias", licenciaService.findAllcatalogoLicencia());
       
        return "catalogoLicencia/listar";
    }
    
    
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoLicencia catalogoLicencia = new CatalogoLicencia();
        model.put("catalogoLicencia", catalogoLicencia);
        model.put("titulo", "Datos Tipo de Licencia");
        
        return "catalogoLicencia/form";
    }
    
     @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoLicencia catalogoLicencia = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoLicencia = licenciaService.findOnecatalogoLicencia(id);
          
        } else {
            return "redirect:/catalogoLicencia/listar";
        }
        model.put("catalogoLicencia",catalogoLicencia);
        model.put("titulo", "Editar Tipo de Licencia");
       
        return "catalogoLicencia/form";
    }
    
     @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(CatalogoLicencia catalogoLicencia, SessionStatus status)
    {
       licenciaService.savecatalogoLicencia(catalogoLicencia);
        status.setComplete();
        return "redirect:/catalogoLicencia/listar";
    }
    
   
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            licenciaService.deletecatalogoLicencia(id);
        }
        return "redirect:/catalogoLicencia/listar";
    }
    
    
}
