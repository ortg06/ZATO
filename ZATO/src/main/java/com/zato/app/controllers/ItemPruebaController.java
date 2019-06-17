/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.ItemPrueba;
import com.zato.app.entidades.Prueba;
import java.math.BigDecimal;
import java.util.Map;
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
 * @author Oscar
 */
@Controller
@RequestMapping("/prueba")
@SessionAttributes("itemprueba")
public class ItemPruebaController {
    
     BigDecimal num= null;
     private IService IService;
    /*
     @GetMapping("/items/{id}")
    public String listar(@PathVariable(value="id") Prueba id,Model model)
    {
       
        model.addAttribute("titulo", "Listado de preguntas");
        model.addAttribute("prueba",id);
        model.addAttribute("items",IService.findItemPruebabyPrueba(id));
       
        return "prueba/items";
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
    */
     
     
     @RequestMapping(value="/items/nuevo/{id}",method=RequestMethod.GET)
    
    public String crear(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        ItemPrueba item = new ItemPrueba();
        Prueba prueba=null;
        num=id;
       
        model.put("prueba", IService.findOnePrueba(id));
        model.put("item", item);
        model.put("titulo", "Nueva pregunta");
       
        return "prueba/formI";
    }
    
    @RequestMapping(value="/items/formItems",method=RequestMethod.POST)
    public String guardar(ItemPrueba itemprueba, SessionStatus status)
    {
        Prueba p=IService.findOnePrueba(num);
        IService.saveItem(itemprueba);
        itemprueba.setPrueba(p);
        status.setComplete();
        return "redirect:/prueba/listar";
    }
    
}
