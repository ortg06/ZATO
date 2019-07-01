/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Candidato;
import com.zato.app.entidades.Cv;
import com.zato.app.entidades.Oferta;
import com.zato.app.entidades.Perfil;
import com.zato.app.entidades.Postulacion;
import java.util.Date;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



@Controller
@SessionAttributes("postulacion")
public class PostulacionController {
    
    @Autowired
     private IService postulacionService;
    @Autowired
     private IService cvService;
    @Autowired
     private IService candidatoService;
    @Autowired
     private IService ofertaService;
    Postulacion postulacion = new Postulacion();
    
    BigDecimal numof;
    
  @RequestMapping(value="postulacion/formpos/{id}",method=RequestMethod.GET)  //id de oferta
    public String crear( @PathVariable(value = "id") BigDecimal id, Map<String,Object> model, HttpSession session)
    {
        Cv cv = new Cv();
        Oferta oferta = new Oferta();
        
        Perfil perfil = (Perfil) session.getAttribute("Perfil");
        BigDecimal idcand = perfil.getCandidato().getPkCandidato();
        Candidato candidato = candidatoService.findCandidato(id);
        numof=id;
        model.put("cvs",cvService.findCandidatobyCv(candidato));
        model.put("postulacion",postulacion);
        model.put("titulo", "Aplicar Oferta");
        return "postulacion/formpos";
    }
    
    
     @RequestMapping(value="postulacion/formpos",method=RequestMethod.POST)
    public String guardar(Postulacion postulacion, SessionStatus status)
    {
        Oferta oferta = ofertaService.findOneOferta(numof);
        postulacion.setOferta(oferta);
        Date fecha = new Date();
        fecha.getDay();
        postulacion.setFechaPostulacion(fecha);
        postulacion.setEstado("Postulado");
        postulacionService.savePostulacion(postulacion);
        status.setComplete();
              
        return "redirect:/oferta/listar";
    }
}
