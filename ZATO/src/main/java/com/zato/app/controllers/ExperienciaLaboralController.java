/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoSectorEmpresa;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.ExperienciaLaboral;
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
//@RequestMapping("/Experiencia")
@SessionAttributes("experienciaLaboral")
public class ExperienciaLaboralController {
    
    @Autowired
    private IService experienciaService;
    @Autowired
    private IService CvService; 
    @Autowired
    private IService sectorService;
    
    BigDecimal numcv=null;
    
    ExperienciaLaboral experiencia = new ExperienciaLaboral();
    Cv cv = new Cv();
    CatalogoSectorEmpresa sector = new CatalogoSectorEmpresa();
    
    @GetMapping("/Cv/verCv/{id}")
    public String listar(@PathVariable(value="id") Cv id,Model model)
    {
        cv=null;
        model.addAttribute("cv",id);
        model.addAttribute("experiencia",experienciaService.findCvbyExperiencia(id));
       
        return "Cv/verCv";
    }
  
     @RequestMapping(value="experienciaLaboral/formexp/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        
        model.put("experiencia", experiencia);
        model.put("sector",sectorService.findAllSectores());
        model.put("titulo", "Experiencia Laboral");
        
        return "experienciaLaboral/formexp";
    }
    
     
    
     @RequestMapping(value="experienciaLaboral/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        experiencia = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            experiencia = experienciaService.findOneExp(id);
          
        } else {
            return "redirect:/Cv/verCv";
        }
        model.put("experiencia", experiencia);
        model.put("sector",sectorService.findAllSectores());
        model.put("titulo", "Actualizar Experiencia");
        return "experienciaLaboral/formexp";
    } 
    
    @RequestMapping(value="experienciaLaboral/formexp",method=RequestMethod.POST)
    public String guardar(ExperienciaLaboral experiencia, SessionStatus status)
    {
        cv=CvService.findOneCv(numcv);
        experiencia.setCv(cv);//id cv
        
        experienciaService.saveExp(experiencia);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv";
    }
    
    
     @RequestMapping(value = "experienciaLaboral/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            experienciaService.deleteExp(id);
        }
        return "redirect:/Cv/verCv";
    }
    

    
}
