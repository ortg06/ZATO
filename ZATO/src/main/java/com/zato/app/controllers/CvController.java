/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.AptitudCv;
import com.zato.app.entidades.Candidato;
import com.zato.app.entidades.CursoCapacitacion;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.Escrito;
import com.zato.app.entidades.Evento;
import com.zato.app.entidades.ExperienciaLaboral;
import com.zato.app.entidades.FormacionAcademica;
import com.zato.app.entidades.HabilidadLinguisticaCv;
import com.zato.app.entidades.HabilidadesCv;
import com.zato.app.entidades.Logro;
import com.zato.app.entidades.LicenciaCandidato;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import java.util.Map;
import org.apache.tomcat.util.codec.binary.Base64;
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
    private IService CvService, logroService, experienciaService,cursoCapService, escritoService, aptitudCvService;
    @Autowired
    private IService CandidatoService, habilidadesCvService, eventoService, formacionService,licCandService,hablingCvService; 
    BigDecimal numcand=null;
    
    Cv cv = new Cv();
    Candidato candidato = new Candidato();
    ExperienciaLaboral experiencia = new ExperienciaLaboral();
    Logro logro = new Logro();
    CursoCapacitacion cursocapacitacion =new CursoCapacitacion();
    Escrito escrito= new Escrito();
    AptitudCv aptitudcv = new AptitudCv();
    HabilidadesCv habilidadescv =new HabilidadesCv();
    Evento evento = new Evento();
    FormacionAcademica formacion = new FormacionAcademica();
    //LicenciaCandidato licCand = new LicenciaCandidato();
    HabilidadLinguisticaCv habilidadlingCv = new HabilidadLinguisticaCv();
    
       
    //------------------PESTANA DEL CANDIDATO--------------------------------------
    @GetMapping("/candidato/ver/{id}")
    public String listar(@PathVariable(value="id") Candidato id,Model model)
    {
        //Candidato candidato=null;
        model.addAttribute("candidato",id);
        model.addAttribute("cv",CvService.findCandidatobyCv(id));
       
        return "candidato/ver";
    }
   //--------------------- INGRESO DE DATOS AL CV ---------------------------------
      @GetMapping("/Cv/verCv/{id}")
    public String listar(@PathVariable(value="id") Cv id,Model model)
    {
       cv=id;
       
       model.addAttribute("cv",id);
       model.addAttribute("experiencia",experienciaService.findCvbyExperiencia(cv));
       model.addAttribute("formacion",formacionService.findCvbyForAcad(cv));
       model.addAttribute("cursocapacitacion",cursoCapService.findCvbyCursoCap(cv)); 
       model.addAttribute("habilidadlingCv",hablingCvService.findCvbyHabLingCv(cv));
       model.addAttribute("habilidadesCv",habilidadesCvService.findCvbyHabCv(cv));
       model.addAttribute("aptitudCv",aptitudCvService.findCvbyAptCv(cv));
       model.addAttribute("logro",logroService.findCvbyLogro(cv));
       model.addAttribute("evento",eventoService.findCvbyEvento(cv));
       model.addAttribute("escrito",escritoService.findCvbyEscrito(cv));
       
      
       
       
       //model.addAttribute("licCand",licCandService.findCvbyLicCand(cv));
      
        return "Cv/verCv";
    }
    
      @RequestMapping(value = "Cv/verCv/{id}")
    public String ver(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {
        
        cv= CvService.findOneCv(id);
        model.put("cv", cv);
        model.put("experiencia", experiencia);
        model.put("formacion", formacion);
        model.put("cursocapacitacion", cursocapacitacion);        
        model.put("habilidadlingCv", habilidadlingCv);
        model.put("habilidadesCv", habilidadescv);
        model.put("aptitudCv", aptitudcv);
        model.put("logro", logro);
        model.put("evento", evento);
        model.put("escrito", escrito); 
       
        
       
        
        //model.put("licCand", licCand);
        
        
        //listar secciones del cv
        listar(cv, (Model) model);
       
       
        
        return "Cv/verCv";
    }
    //-------------------FORMATO CV ----------------------------------------------
     
    @GetMapping("/Cv/cv/{id}")
    public String listarform(@PathVariable(value="id") Cv id,Model model)
    {
       cv=id;
       
       model.addAttribute("cv",id);
       model.addAttribute("experiencia",experienciaService.findCvbyExperiencia(cv));
       model.addAttribute("formacion",formacionService.findCvbyForAcad(cv));
       model.addAttribute("cursocapacitacion",cursoCapService.findCvbyCursoCap(cv)); 
       model.addAttribute("habilidadlingCv",hablingCvService.findCvbyHabLingCv(cv));
       model.addAttribute("habilidadesCv",habilidadesCvService.findCvbyHabCv(cv));
       model.addAttribute("aptitudCv",aptitudCvService.findCvbyAptCv(cv));
       model.addAttribute("logro",logroService.findCvbyLogro(cv));
       model.addAttribute("evento",eventoService.findCvbyEvento(cv));
       model.addAttribute("escrito",escritoService.findCvbyEscrito(cv));
       
       
       
       
       //model.addAttribute("licCand",licCandService.findCvbyLicCand(cv));
       
        return "Cv/cv";
    }
    
    @RequestMapping(value = "Cv/cv/{id}") // recibe id del cv
    public String cv(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {
        
        
        //cv= CvService.findOneCv(id);
        int blobLenght;
        //try {
            
           // blobLenght = (int) formatocand.getFotoCandidato().length();
            //byte[] blobAsBytes = formatocand.getFotoCandidato().getBytes(1, blobLenght);
            //String imagen64 = Base64.encodeBase64String(blobAsBytes);
             model.put("cv", cv);
             model.put("experiencia", experiencia);
             model.put("formacion", formacion);
             model.put("cursocapacitacion", cursocapacitacion); 
             model.put("habilidadlingCv", habilidadlingCv);
             model.put("habilidadesCv", habilidadescv);
             model.put("aptitudCv", aptitudcv);
             model.put("logro", logro);
             model.put("evento", evento);
             model.put("escrito", escrito);
             // model.put("imagen", imagen64);
           
        //} catch (SQLException e) {
            // TODO Auto-generated catch block
          //  e.printStackTrace();
        //}
        
        
       
        //model.put("experiencia", experiencia);
        
               
        
        
       
       
        
        //model.put("licCand", licCand);
       
        
        //listar secciones del cv
       // listar(cv, (Model) model);
       
       
        
        return "Cv/cv";
    }
    
    
    
     @RequestMapping(value="Cv/formcv/{id}",method=RequestMethod.GET)
    public String crear( @PathVariable(value = "id") BigDecimal id, Map<String,Object> model)
    {
        numcand=id;
        model.put("cv", cv);
        model.put("candidato",candidato);
        model.put("titulo", "Curriculum Vitae");
        return "Cv/formcv";
    }
    
     @RequestMapping(value="Cv/formcv/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        Cv cv = null;
        //id= numcv; 
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
        //cv y fechas no deben setearse aqui ya q ingreso y editar ocupar guardar
        BigDecimal idcv;
        candidato=CandidatoService.findCandidato(numcand);
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
         
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            CvService.deleteCv(id);
        }
        return "redirect:/candidato/ver";
    }
    
   
}
