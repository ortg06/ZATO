/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.Escrito;
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
@SessionAttributes("Escrito")
public class EscritoController {
   
    
      @Autowired
    private IService escritoService;
    @Autowired
    private IService CvService; 
    
    
    BigDecimal numcv=null;
    
    Escrito escrito = new Escrito();
    Cv cv = new Cv();
    
    
  
  
     @RequestMapping(value="Escrito/formesc/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numcv=id;
        model.put("escrito", escrito);
        model.put("titulo", "Escritos");
        
        return "Escrito/formesc";
    }
    
     
    
     @RequestMapping(value="Escrito/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            escrito = escritoService.findOneEsc(id);
          
        } else {
            return "redirect:/Cv/verCv";
        }
        model.put("escrito", escrito);
        model.put("titulo", "Actualizar escrito");
        return "Escrito/formesc";
    } 
    
    @RequestMapping(value="Escrito/formesc",method=RequestMethod.POST)
    public String guardar(Escrito escrito, SessionStatus status)
    {
        cv=CvService.findOneCv(numcv);
        escrito.setCv(cv);//id cv
        
        escritoService.saveEsc(escrito);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv";
    }
    
    
     @RequestMapping(value = "Escrito/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            escritoService.deleteEsc(id);
        }
        return "redirect:/Cv/verCv"+numcv;
    }
    
    
}
