/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.Evento;
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
@SessionAttributes("Evento")
public class EventoController {
    
     @Autowired
    private IService eventoService;
    @Autowired
    private IService CvService; 
    @Autowired
    private IService paisService; 
    
    BigDecimal numcv=null;
    
    Evento evento = new Evento();
    Cv cv = new Cv();
    
    
  
  
     @RequestMapping(value="Evento/formeven/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numcv=id;
        model.put("evento", evento);
        model.put("titulo", "Eventos");
        model.put("pais",paisService.findAll());
        
        return "Evento/formeven";
    }
    
     
    
     @RequestMapping(value="Evento/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            evento = eventoService.findOneEvento(id);
          
        } else {
            return "redirect:/Cv/verCv";
        }
        numcv = evento.getCv().getPkCv();
        model.put("evento", evento);
        model.put("pais",paisService.findAll());
        model.put("titulo", "Actualizar Evento");
        return "Evento/formeven";
    } 
    
    @RequestMapping(value="Evento/formeven",method=RequestMethod.POST)
    public String guardar(Evento evento, SessionStatus status)
    {
        cv=CvService.findOneCv(numcv);
        evento.setCv(cv);//id cv
        
        eventoService.saveEvento(evento);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv/"+numcv;
    }
    
    
     @RequestMapping(value = "Evento/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            eventoService.deleteEvento(id);
        }
        return "redirect:/Cv/verCv/"+numcv;
    }
    
}
