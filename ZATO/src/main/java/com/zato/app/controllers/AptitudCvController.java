/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;


import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.AptitudCv;
import com.zato.app.entidades.Cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("AptitudCv")
public class AptitudCvController {
    
    @Autowired
    private IService aptitudCvService;
    @Autowired
    private IService CvService; 
    @Autowired
    private IService catalogoAptitudService; 
    
    BigDecimal numcv=null;
    
    AptitudCv aptitudCv = new AptitudCv();
    Cv cv = new Cv();
    
    
  
  
     @RequestMapping(value="AptitudCv/formaptc/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numcv=id;
        model.put("aptitudCv", aptitudCv);
        model.put("titulo", "Aptitudes");
        model.put("cataptitud",catalogoAptitudService.findAllCatalogoAptitud());
        
        return "AptitudCv/formaptc";
    }
    
     
    
     @RequestMapping(value="AptitudCv/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            aptitudCv = aptitudCvService.findOneAptCv(id);
          
        } else {
            return "redirect:/Cv/verCv";
        }
        model.put("aptitudCv", aptitudCv);
        model.put("titulo", "Actualizar Aptitud");
        return "AptitudCv/formaptc";
    } 
    
    @RequestMapping(value="AptitudCv/formaptc",method=RequestMethod.POST)
    public String guardar(AptitudCv aptitudCv, SessionStatus status)
    {
        cv=CvService.findOneCv(numcv);
        aptitudCv.setCv(cv);//id cv
        
        aptitudCvService.saveAptCv(aptitudCv);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv/"+numcv;
    }
    
    
     @RequestMapping(value = "AptitudCv/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            aptitudCvService.deleteAptCv(id);
        }
        return "redirect:/Cv/verCv"+numcv;
    }
}
