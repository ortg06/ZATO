/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.CursoCapacitacion;
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
@SessionAttributes("CursoCapacitacion")
public class CursoCapacitacionController {
    
     @Autowired
    private IService cursoCapService;
    @Autowired
    private IService CvService; 
    
    
    BigDecimal numcv=null;
    
    CursoCapacitacion cursocapacitacion = new CursoCapacitacion();
    Cv cv = new Cv();
    
    
  
  
     @RequestMapping(value="CursoCapacitacion/formcc/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        cursocapacitacion = new CursoCapacitacion();
        numcv=id;
        model.put("cursocapacitacion", cursocapacitacion);
        model.put("titulo", "Cursos y Capacitaciones");
        
        return "CursoCapacitacion/formcc";
    }
    
     
    
     @RequestMapping(value="CursoCapacitacion/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            cursocapacitacion = cursoCapService.findOneCursoCap(id);
          
        } else {
            return "redirect:/Cv/verCv";
        }
        numcv = cursocapacitacion.getCv().getPkCv();
        
        model.put("cursocapacitacion", cursocapacitacion);
        model.put("titulo", "Actualizar Curso y Capacitaciones");
        return "CursoCapacitacion/formcc";
    } 
    
    @RequestMapping(value="CursoCapacitacion/formcc",method=RequestMethod.POST)
    public String guardar(CursoCapacitacion cursocap, SessionStatus status)
    {
        cv=CvService.findOneCv(numcv);
        cursocap.setCv(cv);//id cv
        
        cursoCapService.saveCursoCap(cursocap);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv/"+numcv;
    }
    
    
     @RequestMapping(value = "CursoCapacitacion/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            cursoCapService.deleteCursoCap(id);
        }
        return "redirect:/Cv/verCv/"+numcv;
    }
    
    
}
