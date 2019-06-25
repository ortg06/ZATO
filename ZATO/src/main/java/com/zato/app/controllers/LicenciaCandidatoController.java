/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.LicenciaCandidato;
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
@SessionAttributes("LicenciaCandidato")
public class LicenciaCandidatoController {
    
      @Autowired
    private IService licCandService;
    @Autowired
    private IService CvService; 
    @Autowired
    private IService catalogoLicenciaService; 
    
    BigDecimal numcv=null;
    
    LicenciaCandidato licenciacandidato = new LicenciaCandidato();
    Cv cv = new Cv();
    
    
  
  
     @RequestMapping(value="LicenciaCandidato/formlc/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numcv=id;
        model.put("licenciacandidato", licenciacandidato);
        model.put("titulo", "Licencia de Conducir");
        model.put("catLicencia",catalogoLicenciaService.findAllcatalogoLicencia());
        
        return "LicenciaCandidato/formlc";
    }
    
     
    
     @RequestMapping(value="LicenciaCandidato/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            licenciacandidato = licCandService.findOneLicCand(id);
          
        } else {
            return "redirect:/Cv/verCv";
        }
        model.put("licenciacandidato", licenciacandidato);
        model.put("titulo", "Actualizar Licencia de Conducir");
        return "LicenciaCandidato/formlc";
    } 
    
    @RequestMapping(value="LicenciaCandidato/formlc",method=RequestMethod.POST)
    public String guardar(LicenciaCandidato licenciacandidato, SessionStatus status)
    {
        cv=CvService.findOneCv(numcv);
        licenciacandidato.setCv(cv);//id cv
        
        licCandService.saveLicCand(licenciacandidato);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv/"+numcv;
    }
    
    
     @RequestMapping(value = "LicenciaCandidato/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            licCandService.deleteLicCand(id);
        }
        return "redirect:/Cv/verCv"+numcv;
    }
}
