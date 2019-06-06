package com.zato.app.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import com.zato.app.Servicios.IService;
import com.zato.app.dao.ICandidatoDao;
import com.zato.app.entidades.Candidato;

import org.apache.tomcat.util.codec.binary.Base64;
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

    BigDecimal num = null;

    // se crea el elemento DAO para llamada al procedimiento
    @Autowired
    ICandidatoDao repo;

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
        model.put("generos", candidatoService.findAllcatalogoGenero());
        model.put("municipios", candidatoService.findAllmun());

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

            try {

                byte[] content = foto.getBytes();
                candidato.setFotoCandidato(content);
                candidatoService.saveCandidato(candidato);

                // LLAMADA AL PROCEDIMIENTO: actualizarperfilcandidato
                // parametros: (LLAVE CANDIDATO, LLAVE PERFIL)
                repo.updatePerfilCandidato(candidato.getPkCandidato(), num);

                status.setComplete();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }

        candidatoService.saveCandidato(candidato);
        // LLAMADA AL PROCEDIMIENTO: actualizarperfilcandidato
        // parametros: (LLAVE CANDIDATO, LLAVE PERFIL)
        repo.updatePerfilCandidato(candidato.getPkCandidato(), num);

        status.setComplete();

        return "redirect:/candidato/listar";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") BigDecimal id) {
        // se compara si el ID es mayor que cero
        if (id.compareTo(BigDecimal.ZERO) > 0) {
            candidatoService.deleteCandidato(id);
        }
        return "redirect:/candidato/listar";
    }

    @RequestMapping(value = "/ver/{id}")
    public String ver(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {
        Candidato candidato = candidatoService.findCandidato(id);

        String imagen64 = Base64.encodeBase64String(candidato.getFotoCandidato());
        model.put("candidato", candidato);
        model.put("imagen", imagen64);
        model.put("titulo",
                "Perfil Usuario : " + candidato.getNombreCandidato() + " " + candidato.getApellidoCandidato());
        return "Candidato/ver";
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String crearCandidato(@PathVariable(value = "id") BigDecimal id, Map<String, Object> model) {
        Candidato candidato = new Candidato();
        num = id;
        model.put("candidato", candidato);
        model.put("titulo", "Datos de Candidato");
        model.put("generos", candidatoService.findAllcatalogoGenero());
        model.put("municipios", candidatoService.findAllmun());

        return "candidato/form";

    }

}
