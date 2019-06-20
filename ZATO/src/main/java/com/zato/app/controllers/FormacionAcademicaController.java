/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoGradoAcademico;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.FormacionAcademica;
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
@SessionAttributes("gradoacademico")
public class FormacionAcademicaController {
    
    @Autowired
    private IService formacionService;
    @Autowired
    private IService CvService; 
    @Autowired
    private IService gradoAcademicoService;
    
    BigDecimal numcv=null;
    
    FormacionAcademica formacion = new FormacionAcademica();
    Cv cv = new Cv();
    CatalogoGradoAcademico gradoAcad = new CatalogoGradoAcademico();
    
    
     @RequestMapping(value="FormacionAcademica/formfa/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id,Map<String,Object> model)
    {
        numcv=id;
        model.put("formacion", formacion);
        model.put("gradoAcad",gradoAcademicoService.findAllCatalogoGradoAcademico());
        model.put("titulo", "Formacion Academica");
        
        return "FormacionAcademica/formfa";
    }
    
     
    
     @RequestMapping(value="FormacionAcademica/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
       
       
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            formacion = formacionService.findOneForAcad(id);
          
        } else {
            return "redirect:/Cv/verCv/"+numcv;
        }
        model.put("formacion", formacion);
        model.put("gradoAcad",gradoAcademicoService.findAllCatalogoGradoAcademico());
        model.put("titulo", "Actualizar Formacion Academica");
        return "FormacionAcademica/formfa";
    } 
    
    @RequestMapping(value="FormacionAcademica/formfa",method=RequestMethod.POST)
    public String guardar(FormacionAcademica formacion, SessionStatus status)
    {
        cv=CvService.findOneCv(numcv);
        formacion.setCv(cv);//id cv
        
        formacionService.saveForAcad(formacion);
        status.setComplete();
        
        
        return "redirect:/Cv/verCv/"+numcv;
    }
    
    
     @RequestMapping(value = "FormacionAcademica/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            formacionService.deleteForAcad(id);
        }
        return "redirect:/Cv/verCv/"+numcv;
    }
    
    
}
