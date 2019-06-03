package com.zato.app.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Candidato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/candidato")
@SessionAttributes("candidato")
public class CandidatoController {

    @Autowired
    private IService candidatoService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Candidato");
        model.addAttribute("candidatos", candidatoService.findAllCandidato());

        return "Candidato/listar";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String crear(Map<String, Object> model) {
        Candidato candidato = new Candidato();
        model.put("candidato", candidato);
        model.put("titulo", "Datos de Candidato");

        return "candidato/form";

    }

    @RequestMapping(value = "/editar/{id}")
    public String editar(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {
        Candidato candidato = null;

        // se compara si el ID es mayor que cero
        if (id.compareTo(BigDecimal.ZERO) > 0) {
            candidato = candidatoService.findCandidato(id);

        } else {
            return "redirect:/candidato/listar";
        }

        model.put("candidato", candidato);
        model.put("titulo", "Editar Candidato");
        return "candidato/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Candidato candidato, @RequestParam("file") MultipartFile foto, SessionStatus status) {

        if (!foto.isEmpty()) {

            Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
            String rootPath = directorioRecursos.toFile().getAbsolutePath();
            try {
                byte[] bytes = foto.getBytes();
                Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                //candidato.setFotoCandidato(foto.getOriginalFilename());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }

        candidatoService.saveCandidato(candidato);
        status.setComplete();
        return "redirect:/candidato/listar";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") BigDecimal id)
    {
         //se compara si el ID es mayor que cero
         if(id.compareTo(BigDecimal.ZERO)>0)
         {
             candidatoService.deleteCandidato(id);
         }
         return "redirect:/candidato/listar";
    }


}

