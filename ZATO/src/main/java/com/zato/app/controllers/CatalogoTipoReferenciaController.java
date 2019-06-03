/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoTipoReferencia;
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
 * @author Dell
 */
@Controller
@RequestMapping("/catalogoTipoReferencia")
@SessionAttributes("catalogoTipoReferencia")
public class CatalogoTipoReferenciaController {
    
    @Autowired
    private IService tipoReferencia;
    
     @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Catálogo Categoria Habilidad");
        model.addAttribute("catalogoTipoReferencias",tipoReferencia.findAllCatalogoTipoReferencia());
       
        return "catalogoTipoReferencia/listar";
    }
    
     
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoTipoReferencia catalogoTipoReferencia = new CatalogoTipoReferencia();
        model.put("catalogoTipoReferencia", catalogoTipoReferencia);
        model.put("titulo", "Datos de Tipo de Referencia");
        
        return "catalogoTipoReferencia/form";
    }
    
         @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        CatalogoTipoReferencia catalogoTipoReferencia = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogoTipoReferencia = tipoReferencia.findOneCatalogoTipoReferencia(id);
          
        } else {
            return "redirect:/catalogoTipoReferencia/listar";
        }
        model.put("catalogoTipoReferencia",catalogoTipoReferencia);
        model.put("titulo", "Editar Categoria de Habilidad");
       
        return "catalogoTipoReferencia/form";
    }
    
     @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(CatalogoTipoReferencia catalogoTipoReferencia, SessionStatus status)
    {
        tipoReferencia.saveCatalogoTipoReferencia(catalogoTipoReferencia);
        status.setComplete();
        return "redirect:/catalogoTipoReferencia/listar";
    }
    
   
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            tipoReferencia.deleteCatalogoTipoReferencia(id);
        }
        return "redirect:/catalogoTipoReferencia/listar";
    }
    
    
}
