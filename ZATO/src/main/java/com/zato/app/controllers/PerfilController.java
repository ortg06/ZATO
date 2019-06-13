/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Perfil;
import com.zato.app.entidades.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    //----------------------------nuevo-------------------------------------------
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
    public String crearform( Map<String,Object> model)
    {
        Perfil perfil = new Perfil();
        model.put("perfil", perfil);
        model.put("titulo", "Registro de Candidatos");
        model.put("Rol", RolService.findAllRol());
        return "Perfil/form";
    }
    
      @RequestMapping(value="/Perfil/formE",method=RequestMethod.GET)
    public String crearformE(Map<String,Object> model)
    {
        Perfil perfil = new Perfil();
        model.put("perfil", perfil);
        model.put("titulo", "Registro de Empresas");
        model.put("Rol", RolService.findAllRol());
        return "Perfil/formE";
    }
    //--------------------------editar------------------------------------------
    @RequestMapping(value="/Perfil/formPerfil/{id}")
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
        model.put("r",perfil.getRol().getPkRol());
        return "Perfil/formPerfil";
    }
//-------------------GUARDAR -------------------------------------------------
    //guardar Administrador
     @RequestMapping(value="/Perfil/formPerfil",method=RequestMethod.POST)
    public String guardarAdmin( Perfil perfil, SessionStatus status)
    {
       int tipop=3;
       BigDecimal tipo= new BigDecimal(tipop);
       perfil.setTipoPerfil(tipo);
      
    
       PerfilService.savePerfil(perfil);
        
        status.setComplete();
        return "redirect:/Perfil/listar";
    }
    
       //guardar Candidato
     @RequestMapping(value="/Perfil/form",method=RequestMethod.POST)
    public String guardarCand(Perfil perfil, SessionStatus status)
    {
       int tipop=1; // aqui cambiar rol
       BigDecimal id;
       BigDecimal tipo= new BigDecimal(tipop);
       perfil.setTipoPerfil(tipo);
       Rol rol = new Rol();
       rol= RolService.findOneRol(tipo);
       perfil.setRol(rol);
       PerfilService.savePerfil(perfil);
        id= perfil.getPkUsuario();
        status.setComplete();
        
        return "redirect:/candidato/form/"+id;
    }

      //guardar Empresa
     @RequestMapping(value="/Perfil/formE",method=RequestMethod.POST)
    public String guardarEmp(Perfil perfil, SessionStatus status)
    {
       int tipop=9;// aqui cambiar rol
       BigDecimal tipo= new BigDecimal(tipop);
       BigDecimal id;
       perfil.setTipoPerfil(tipo);
       Rol rol = new Rol();
       rol= RolService.findOneRol(tipo);
       perfil.setRol(rol);
       PerfilService.savePerfil(perfil);
       id= perfil.getPkUsuario();
        status.setComplete();
    
        return "redirect:/empresa/nuevo/"+id;
    }
   
    //---------------------eliminar-----------------------------------------------
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
    
        
    //---------------------VALIDACIONES----------------------------------------
    public int  validarContra(String contraseña) {
 
        int resultado=0;
        
        
        return resultado;
    }
    
}
