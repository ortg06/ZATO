/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoPuesto;
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


@Controller
@RequestMapping("/CatalogoPuesto")
@SessionAttributes("catalogopuesto")
public class CatalogoPuestoController {
    
     @Autowired
    private IService PuestoService;
    @Autowired
    private IService CategoriaService; 
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Puestos");
        model.addAttribute("puestos",PuestoService.findAllCatPuesto());
       
        return "CatalogoPuesto/listar";
    }
  
     @RequestMapping(value="/formP",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        CatalogoPuesto catalogopuesto = new CatalogoPuesto();
        model.put("catalogopuesto", catalogopuesto);
        model.put("titulo", "Datos del Puesto");
        model.put("categoria",CategoriaService.findAllCategorias());
        return "CatalogoPuesto/formP";
    }
    
     @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
            CatalogoPuesto catalogopuesto = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            catalogopuesto = PuestoService.findOneCatPuesto(id);
          
        } else {
            return "redirect:/CatalogoPuesto/listar";
        }
        model.put("catalogopuesto", catalogopuesto);
        model.put("titulo", "Editar Submenu");
        model.put("categorias",CategoriaService.findAllCategorias());
        model.put("p",catalogopuesto.getCatalogoCategoria().getPkCatalogoCategoria());
        return "CatalogoPuesto/formP";
    } 
    
    @RequestMapping(value="/formP",method=RequestMethod.POST)
    public String guardar(CatalogoPuesto catalogopuesto, SessionStatus status)
    {
        PuestoService.saveCatPuesto(catalogopuesto);
        status.setComplete();
        return "redirect:/CatalogoPuesto/listar";
    }
    
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            PuestoService.deleteCatPuesto(id);
        }
        return "redirect:/CatalogoPuesto/listar";
    }
    
    
}
