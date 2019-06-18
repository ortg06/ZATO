/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Candidato;
import com.zato.app.entidades.CursoCapacitacion;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.ExperienciaLaboral;
import com.zato.app.entidades.Logro;
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
    private IService CvService, logroService, experienciaService,cursoCapService;
    @Autowired
    private IService CandidatoService; 
    BigDecimal num=null, numcv=null;
    
    Cv cv = new Cv();
    Candidato candidato = new Candidato();
    ExperienciaLaboral experiencia = new ExperienciaLaboral();
    Logro logro = new Logro();
    CursoCapacitacion cursocapacitacion =new CursoCapacitacion();
    
    
       
    
    @GetMapping("/candidato/ver/{id}")
    public String listar(@PathVariable(value="id") Candidato id,Model model)
    {
        Candidato candidato=null;
        model.addAttribute("candidato",id);
        model.addAttribute("cv",CvService.findCandidatobyCv(id));
       
        return "candidato/ver";
    }
   
      @GetMapping("/Cv/verCv/{id}")
    public String listar(@PathVariable(value="id") Cv id,Model model)
    {
       cv=id;
       
       model.addAttribute("cv",id);
       model.addAttribute("logro",logroService.findCvbyLogro(cv));
       model.addAttribute("experiencia",experienciaService.findCvbyExperiencia(cv));
       model.addAttribute("cursocapacitacion",cursoCapService.findCvbyCursoCap(cv)); 
        return "Cv/verCv";
    }
    
   
         
     @RequestMapping(value="Cv/formcv/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id, Map<String,Object> model)
    {
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
            return "redirect:/candidato/ver";
        }
        model.put("cv", cv);
        model.put("titulo", "Actualizar Curriculum Vitae");
        return "Cv/formcv";
    } 
    
    @RequestMapping(value="Cv/formcv",method=RequestMethod.POST)
    public String guardar(Cv cv, SessionStatus status)
    {
        BigDecimal idcv;
        candidato=CandidatoService.findCandidato(num);
        cv.setCandidato(candidato);//id candidato
        Date fecha = new Date();
        fecha.getDay();
        cv.setFechaRegistro(fecha);
        cv.setFechaActualizado(fecha);
        CvService.saveCv(cv);
        status.setComplete();
        idcv=cv.getPkCv();
        
        return "redirect:/Cv/verCv/"+idcv;
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
        return "redirect:/candidato/ver";
    }
    
     @RequestMapping(value = "Cv/verCv/{id}")
    public String ver(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {
        
        cv= CvService.findOneCv(id);
        model.put("cv", cv);
        model.put("experiencia", experiencia);
        model.put("logro", logro);
        model.put("cursocapacitacion", cursocapacitacion);        
        
        //listar secciones del cv
        listar(cv, (Model) model);
       
       
        
        return "Cv/verCv";
    }
    
}
