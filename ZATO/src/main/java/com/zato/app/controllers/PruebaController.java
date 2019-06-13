/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.ItemPrueba;
import com.zato.app.entidades.Prueba;

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
@RequestMapping("/prueba")
@SessionAttributes("prueba")
public class PruebaController {
    
    
     @Autowired
    private IService IService;
    
     @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Pruebas");
        model.addAttribute("pruebas",IService.findAllPruebas());
       
        return "prueba/listar";
    }
    
    
    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Prueba prueba = new Prueba();
        model.put("prueba", prueba);
        model.put("titulo", "Datos de la prueba");
        model.put("tipos",IService.findAlltipoprueba());
        return "prueba/form";
    }
    
    
    @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
         Prueba prueba = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            prueba  = IService.findOnePrueba(id);
          
        } else {
            return "redirect:/prueba/listar";
        }
        
        model.put("titulo", "Editar Prueba");
         model.put("prueba", prueba);
        model.put("tipos",IService.findAlltipoprueba());
        model.put("p",prueba.getCatalogoTipoPrueba().getPkCatTipoPrueba());
        return "prueba/form";
    }
    
    
    
     @RequestMapping(value="/form",method=RequestMethod.POST)
    public String guardar(Prueba prueba, SessionStatus status)
    {
        IService.savePrueba(prueba);
        status.setComplete();
        return "redirect:/prueba/listar";
    }
    
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            IService.deletePrueba(id);
        }
        return "redirect:/prueba/listar";
    }
    
    //Metodos para items
    
    
    @GetMapping("/items/{id}")
    public String items(@PathVariable(value="id") Prueba id,Model model)
    {
        Prueba prueba=null;
        model.addAttribute("titulo", "Listado de preguntas");
        model.addAttribute("prueba",id);
        model.addAttribute("items",IService.findItemPruebabyPrueba(id));
       
        return "prueba/items";
    }
    
    
    @RequestMapping(value="/items/nuevo/{id}",method=RequestMethod.GET)
    public String crearItems(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        ItemPrueba item = new ItemPrueba();
        Prueba prueba=null;
        model.put("prueba", IService.findOnePrueba(id));
        model.put("item", item);
        model.put("titulo", "Datos de nueva pregunta");
       
        return "prueba/items/form";
    }
    
     @RequestMapping(value="/items/form",method=RequestMethod.POST)
    public String guardarItem(ItemPrueba itemprueba, SessionStatus status)
    {
        IService.saveItem(itemprueba);
        status.setComplete();
        return "redirect:/prueba/items/{id}";
    }
     
    
}
