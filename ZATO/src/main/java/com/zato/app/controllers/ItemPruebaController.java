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
 * @author Oscar
 */
@Controller
@RequestMapping("/prueba")
@SessionAttributes("itemprueba")
public class ItemPruebaController {
    
     BigDecimal num= null;
     @Autowired
     private IService IService;
    
     
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
        itemprueba.setPrueba(p);
        IService.saveItem(itemprueba);
        status.setComplete();
        return "redirect:/prueba/items/"+num;
    }
        
     //Metodos para opciones de items
    @GetMapping("/items/opciones/{id}")
    public String opciones(@PathVariable(value = "id") ItemPrueba id, Model model) {
        
        Prueba prueba = null;
        model.addAttribute("titulo", "Listado de opciones");
        model.addAttribute("item", id);
        model.addAttribute("opciones", IService.findOpcionesbyItemPrueba(id));

        return "prueba/opciones";
    }

}
