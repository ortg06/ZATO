/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Candidato;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.ExperienciaLaboral;
import java.math.BigDecimal;
import java.util.Date;

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
@RequestMapping("/Experiencia")
@SessionAttributes("Experiencia")
public class ExperienciaLaboralController {
    
      @Autowired
    private IService experienciaService;
    @Autowired
    private IService CvService; 
    BigDecimal num=null;
    
    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Experiencia Laboral");
        model.addAttribute("experiencia",experienciaService.findAllExp());
       
        return "Experiencia/listar";
    }
  
     @RequestMapping(value="/formexp",method=RequestMethod.GET)
    public String crear( Map<String,Object> model)
    {
        ExperienciaLaboral experiencia = new ExperienciaLaboral();
       
        model.put("experiencia", experiencia);
        
        model.put("titulo", "Experiencia Laboral");
        return "Experiencia/formexp";
    }
    
     @RequestMapping(value="/formexp/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id, Map<String,Object> model)
    {
        ExperienciaLaboral experiencia = new ExperienciaLaboral();
        Cv cv = new Cv();
        num=id;
        model.put("experiencia", experiencia);
        model.put("cv",cv);
        model.put("titulo", "Experiencia Laboral");
        return "Experiencia/formexp";
    }
    
     @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        ExperienciaLaboral experiencia = null;
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            experiencia = experienciaService.findOneExp(id);
          
        } else {
            return "redirect:/Experiencia/listar";
        }
        model.put("experiencia", experiencia);
        model.put("titulo", "Actualizar Experiencia");
        return "Experiencia/formexp";
    } 
    
    @RequestMapping(value="/formexp",method=RequestMethod.POST)
    public void guardar(ExperienciaLaboral experiencia, SessionStatus status)
    {
        Cv cv= new Cv();
        cv=CvService.findOneCv(num);
        experiencia.setCv(cv);//id candidato
        
        CvService.saveExp(experiencia);
        status.setComplete();
        cv.getPkCv();
        
        //return "redirect:/candidato/ver/"+num;
    }
    
    
     @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            CvService.deleteExp(id);
        }
        return "redirect:/submenu/listar";
    }
    

    
}
