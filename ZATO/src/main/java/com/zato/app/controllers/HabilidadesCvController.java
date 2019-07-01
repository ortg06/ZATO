/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.HabilidadesCv;
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
@SessionAttributes("HabilidadesCv")
public class HabilidadesCvController {
    
     @Autowired
    private IService habilidadesCvService;
    @Autowired
    private IService CvService; 
    @Autowired
    private IService catalogoHabilidadService;
    @Autowired
    private IService catalogoCategoriaService;
    
    BigDecimal numcv=null;
    
    HabilidadesCv habilidadesCv = new HabilidadesCv();
    Cv cv = new Cv();
    
    
  
  
     @RequestMapping(value="HabilidadesCv/formhabcv/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numcv=id;
        habilidadesCv = new HabilidadesCv();
        model.put("habilidadesCv", habilidadesCv);
        model.put("titulo", "Conocimientos y Habilidades");
        model.put("catCategoria",catalogoCategoriaService.findAllcategoriaHabilidad());
        model.put("catHabilidad",catalogoHabilidadService.findAllCatHabilidad());
        
        return "HabilidadesCv/formhabcv";
    }
    
     
    
     @RequestMapping(value="HabilidadesCv/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            habilidadesCv = habilidadesCvService.findOneHabCv(id);
          
        } else {
            return "redirect:/Cv/verCv";
        }
        numcv = habilidadesCv.getCv().getPkCv();
        model.put("habilidadesCv", habilidadesCv);
        model.put("titulo", "Actualizar Conocimiento / Habilidad");
        model.put("catCategoria",catalogoCategoriaService.findAllcategoriaHabilidad());
        model.put("catHabilidad",catalogoHabilidadService.findAllCatHabilidad());
        return "HabilidadesCv/formhabcv";
    } 
    
    @RequestMapping(value="HabilidadesCv/formhabcv",method=RequestMethod.POST)
    public String guardar(HabilidadesCv habilidadesCv, SessionStatus status)
    {
        cv=CvService.findOneCv(numcv);
        habilidadesCv.setCv(cv);//id cv
        
        habilidadesCvService.saveHabCv(habilidadesCv);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv/"+numcv;
    }
    
    
     @RequestMapping(value = "HabilidadesCv/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            habilidadesCvService.deleteHabCv(id);
        }
        return "redirect:/Cv/verCv/"+numcv;
    }
    
}
