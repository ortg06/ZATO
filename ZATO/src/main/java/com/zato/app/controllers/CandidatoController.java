package com.zato.app.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

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

    CvController cvcontroller = new CvController();

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
        model.put("paises", candidatoService.findAll());
        model.put("departamentos", candidatoService.findAlldep());
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

        model.put("d", candidato.getMunicipio().getDepartamento().getPkDepartamento());

        model.put("p", candidato.getMunicipio().getDepartamento().getPais().getPkPais());
        model.put("paises", candidatoService.findAll());
        model.put("departamentos", candidatoService.findAlldep());
        model.put("municipios", candidatoService.findAllmun());
        model.put("generos", candidatoService.findAllcatalogoGenero());
        model.put("candidato", candidato);
        model.put("g", candidato.getCatalogoGenero().getPkGenero());
        model.put("titulo", "Editar Candidato");
        return "candidato/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Candidato candidato, @RequestParam("file") MultipartFile foto, SessionStatus status) {

        if (!foto.isEmpty() ) {

            try {

                byte[] content = foto.getBytes();
                Blob blob = new SerialBlob(content);
                candidato.setFotoCandidato(blob);
                candidatoService.saveCandidato(candidato);

                // LLAMADA AL PROCEDIMIENTO: actualizarperfilcandidato
                // parametros: (LLAVE CANDIDATO, LLAVE PERFIL)
                repo.updatePerfilCandidato(candidato.getPkCandidato(), num);

                status.setComplete();
            } catch (IOException e) {

                e.printStackTrace();
            } catch (SerialException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        candidatoService.saveCandidato(candidato);
        // LLAMADA AL PROCEDIMIENTO: actualizarperfilcandidato
        // parametros: (LLAVE CANDIDATO, LLAVE PERFIL)
        //repo.updatePerfilCandidato(candidato.getPkCandidato(), num);

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
        //Municipio municipio = candidatoService.findOneMunicipio(candidato.getMunicipio().getPkMunicipio());
       // Departamento departamento = candidatoService.findOneDepartamento(municipio.getDepartamento().getPkDepartamento());
       // Pais pais = candidatoService.findOne(departamento.getPais().getPkPais());

        int blobLenght;
        try {
            blobLenght = (int) candidato.getFotoCandidato().length();
            byte[] blobAsBytes = candidato.getFotoCandidato().getBytes(1, blobLenght);
            String imagen64 = Base64.encodeBase64String(blobAsBytes);
            model.put("candidato", candidato);
            model.put("imagen", imagen64);
            model.put("titulo",
            "Perfil Usuario : " + candidato.getNombreCandidato() + " " + candidato.getApellidoCandidato());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
   
     
        
       // model.put("nombrePais",candidato.getMunicipio().getDepartamento().getPais().getNombrePais());
        //model.put("departamento",municipio.getDepartamento().getPkDepartamento());
        
        

        //listar cv
        cvcontroller.listar(candidato, (Model) model);
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
        model.put("paises",candidatoService.findAll());
        model.put("departamentos",candidatoService.findAlldep());

        return "candidato/form";

    }

}
