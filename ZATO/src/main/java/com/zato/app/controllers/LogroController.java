/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.Logro;
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
@SessionAttributes("Logro")
public class LogroController {
    
     @Autowired
    private IService logroService;
    @Autowired
    private IService CvService; 
    
    
    BigDecimal numcv=null;
    
    Logro logro = new Logro();
    Cv cv = new Cv();
    
    
  /*  @GetMapping("/Cv/verCv/{id}")
    public String listar(@PathVariable(value="id") Cv id,Model model)
    {
        cv=null;
        model.addAttribute("cv",id);
        model.addAttribute("logro",logroService.findCvbyLogro(cv));
       
        return "Cv/verCv";
    }*/
  
     @RequestMapping(value="Logro/formlo/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numcv=id;
        model.put("logro", logro);
        model.put("titulo", "Logros");
        
        return "Logro/formlo";
    }
    
     
    
     @RequestMapping(value="Logro/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            logro = logroService.findOneLogro(id);
          
        } else {
            return "redirect:/Cv/verCv";
        }
        model.put("logro", logro);
        model.put("titulo", "Actualizar Logro");
        return "Logro/formlo";
    } 
    
    @RequestMapping(value="Logro/formlo",method=RequestMethod.POST)
    public String guardar(Logro logro, SessionStatus status)
    {
        cv=CvService.findOneCv(numcv);
        logro.setCv(cv);//id cv
        
        logroService.saveLogro(logro);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv";
    }
    
    
     @RequestMapping(value = "Logro/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            logroService.deleteLogro(id);
        }
        return "redirect:/Cv/verCv";
    }
    
    
    
}
