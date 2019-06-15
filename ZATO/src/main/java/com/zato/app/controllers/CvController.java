/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Candidato;
import com.zato.app.entidades.Cv;
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
//@RequestMapping("/Cv")
@SessionAttributes("Cv")
public class CvController {
    
     @Autowired
    private IService CvService;
    @Autowired
    private IService CandidatoService; 
    BigDecimal num=null, numcv=null;
    
      @GetMapping("/candidato /ver")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Mis Curriculums");
        model.addAttribute("cv",CvService.findAllCv());
       
        return "candidato /ver";
    }
  
     @RequestMapping(value="Cv/formcv",method=RequestMethod.GET)
    public String crear( Map<String,Object> model)
    {
        Cv cv = new Cv();
       
        model.put("cv", cv);
        
        model.put("titulo", "Curriculum Vitae");
        return "Cv/formcv";
    }
    
     @RequestMapping(value="Cv/formcv/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id, Map<String,Object> model)
    {
        Cv cv = new Cv();
        Candidato candidato = new Candidato();
        num=id;
        model.put("cv", cv);
        model.put("candidato",candidato);
        model.put("titulo", "Curriculum Vitae");
        return "Cv/formcv";
    }
    
     @RequestMapping(value="Cv/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        Cv cv = null;
        id= numcv; 
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            cv = CvService.findOneCv(id);
          
        } else {
            return "redirect:/Cv/listar";
        }
        model.put("cv", cv);
        model.put("titulo", "Actualizar Curriculum");
        return "Cv/formcv";
    } 
    
    @RequestMapping(value="Cv/formcv",method=RequestMethod.POST)
    public String guardar(Cv cv, SessionStatus status)
    {
        Candidato candidato= new Candidato();
        candidato=CandidatoService.findCandidato(num);
        cv.setCandidato(candidato);//id candidato
        Date fecha = new Date();
        fecha.getDay();
        cv.setFechaRegistro(fecha);
        cv.setFechaActualizado(fecha);
        CvService.saveCv(cv);
        status.setComplete();
        cv.getPkCv();
        
        return "redirect:/Cv/formcv/";
    }
    
    
     @RequestMapping(value = "Cv/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
        id= numcv; 
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            CvService.deleteCv(id);
        }
        return "redirect:/Cv/listar";
    }
    
}
