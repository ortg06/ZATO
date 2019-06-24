/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.HabilidadLinguisticaCv;
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
@SessionAttributes("HabilidadLingCv")
public class HabilidadLingCvController {
    
     @Autowired
    private IService hablingCvService;
    @Autowired
    private IService CvService; 
    @Autowired
    private IService catalogopondService; 
     @Autowired
    private IService catalogoidiomaService;
    
    BigDecimal numcv=null;
    
    HabilidadLinguisticaCv habilidadlingCv = new HabilidadLinguisticaCv();
    Cv cv = new Cv();
    
    
  
  
     @RequestMapping(value="HabilidadLinguisticaCv/formhlc/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numcv=id;
        model.put("habilidadlingCv", habilidadlingCv);
        model.put("titulo", "Idiomas");
        model.put("catPonderacion",catalogopondService.findAllPonderacion());
        model.put("catIdioma",catalogoidiomaService.findAllCatIdioma());
        
        return "HabilidadLinguisticaCv/formhlc";
    }
    
     
    
     @RequestMapping(value="HabilidadLinguisticaCv/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            habilidadlingCv = hablingCvService.findOneHabLingCv(id);
          
        } else {
            return "redirect:/Cv/verCv";
        }
        model.put("habilidadlingCv", habilidadlingCv);
        model.put("titulo", "Actualizar Idiomas");
        return "HabilidadLinguisticaCv/formhlc";
    } 
    
    @RequestMapping(value="HabilidadLinguisticaCv/formhlc",method=RequestMethod.POST)
    public String guardar(HabilidadLinguisticaCv habilidadlingCv, SessionStatus status)
    {
        cv=CvService.findOneCv(numcv);
        habilidadlingCv.setCv(cv);//id cv
        
        hablingCvService.saveHabLingCv(habilidadlingCv);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv/"+numcv;
    }
    
    
     @RequestMapping(value = "HabilidadLinguisticaCv/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            hablingCvService.deleteHabLingCv(id);
        }
        return "redirect:/Cv/verCv"+numcv;
    }
    
}
