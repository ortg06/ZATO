/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zato.app.controllers;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.CatalogoSectorEmpresa;
import com.zato.app.entidades.Departamento;
import com.zato.app.entidades.Empresa;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ecampos
 */
@Controller
@RequestMapping("empresa")
@SessionAttributes("empresa")
public class EmpresaController {

    @Autowired
    private IService IService;
    @Autowired
    private IService Sector;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Empresas Registradas");
        model.addAttribute("empresas", IService.findAllempresa());

        return "empresa/listar";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String crear(Map<String, Object> model) {
        Empresa empresa = new Empresa();
        model.put("empresa", empresa);
        model.put("titulo", "Datos de la Empresa");
        model.put("sectores", Sector.findAllSectores());
        model.put("tipos", IService.findAllTipoEmpresas());
        model.put("municipios", IService.findAllmun());

        return "empresa/formEmp";
    }

    @RequestMapping(value = "/formEmp", method = RequestMethod.POST)
    public String guardar(Empresa empresa, @RequestParam("file") MultipartFile foto, SessionStatus status) {
        if (!foto.isEmpty()) {

            try {

                byte[] content = foto.getBytes();
                empresa.setLogoEmpresa(content);
                IService.saveEmpresa(empresa);
                status.setComplete();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }

        return "redirect:/empresa/listar";
    }
}
