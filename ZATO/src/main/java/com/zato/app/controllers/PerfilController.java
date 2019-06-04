/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Perfil;
import java.math.BigDecimal;

import java.util.Map;
import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.JpaSort.path;
import static org.springframework.data.jpa.domain.JpaSort.path;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes("perfil")
public class PerfilController {
    
    @Autowired
    private IService PerfilService;
    @Autowired
    private IService RolService;
    
     //tabla
    @RequestMapping(value="/Perfil/listar",method=RequestMethod.GET)
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de Usuarios");
        model.addAttribute("Perfil",PerfilService.findAllPerfil());
        return "perfil/listar";
    }
    
    //nuevo
     @RequestMapping(value="/Perfil/formPerfil",method=RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Perfil perfil = new Perfil();
        model.put("perfil", perfil);
        model.put("titulo", "Datos del Usuario");
        model.put("Rol", RolService.findAllRol());
        return "Perfil/formPerfil";
    }
    
      @RequestMapping(value="/Perfil/form",method=RequestMethod.GET)
    public String crearform(Map<String,Object> model)
    {
        Perfil perfil = new Perfil();
        model.put("perfil", perfil);
        model.put("titulo", "Registro de Candidatos");
        model.put("Rol", RolService.findAllRol());
        return "Perfil/form";
    }
    //editar
    @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") BigDecimal id, Map<String,Object> model)
    {
        
        Perfil perfil = null;
        //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            perfil = PerfilService.findOnePerfil(id);
        } else {
            return "redirect:/Perfil/listar";
        }
        model.put("perfil", perfil);
        model.put("titulo", "Editar Usuario");
        model.put("Rol", RolService.findAllRol());
        model.put("R",perfil.getRol().getPkRol());
        return "Perfil/formPerfil";
    }
    
    //INFORMACION
    @RequestMapping(value="/Perfil/formPerfil/{contrasena}}", method=RequestMethod.GET)
    public int  validarContra(@PathVariable (value="contrasena")String contra,Map<String,Object> model) {
 
        int resultado=0;
        
        
        return resultado;
    }
    
    //guardar Administrador
     @RequestMapping(value="/Perfil/formPerfil",method=RequestMethod.POST)
    public String guardarAdmin(Perfil perfil, SessionStatus status)
    {
       int tipop=3;
       BigDecimal tipo= new BigDecimal(tipop);
       perfil.setTipoPerfil(tipo);
       
    
       PerfilService.savePerfil(perfil);
        
        status.setComplete();
        return "redirect:/Perfil/listar";
    }
    
     /*  //guardar Candidato
     @RequestMapping(value="/Perfil/formCand",method=RequestMethod.POST)
    public String guardarCand(Perfil perfil, SessionStatus status)
    {
       int tipop=1;
       BigDecimal tipo= new BigDecimal(tipop);
         //perfil.setRol();
       
       perfil.setTipoPerfil(tipo);
       PerfilService.savePerfil(perfil);
        
        status.setComplete();
        return "redirect:/Candidato/form";
    }*/

      //guardar Empresa
     @RequestMapping(value="/Perfil/form",method=RequestMethod.POST)
    public String guardarEmp(Perfil perfil, SessionStatus status)
    {
       int tipop=2;
       BigDecimal tipo= new BigDecimal(tipop);
       
       perfil.setTipoPerfil(tipo);
       PerfilService.savePerfil(perfil);
        
        status.setComplete();
        return "redirect:/empresa/formEmp";
    }
   
    //eliminar
    @RequestMapping(value = "/Perfil/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
        if(id.compareTo(BigDecimal.ZERO)>0)
        {
            PerfilService.deleteRol(id);
        }
        return "redirect:/Perfil/listar";
    }
}
