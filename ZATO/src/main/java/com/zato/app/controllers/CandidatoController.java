package com.zato.app.controllers;

import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Candidato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/Candidato")
@SessionAttributes("candidato")
public class CandidatoController{

    @Autowired
    private IService candidatoService;

    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Candidato");
        model.addAttribute("candidatos", candidatoService.findAllCandidato());

        return "Candidato/listar";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String crear(Map<String,Object> model)
    {
        Candidato candidato = new Candidato();
        model.put("catalogo", candidato);
        model.put("titulo", "Datos de Candidato");

        return "Candidato/form";
        
    }

}

