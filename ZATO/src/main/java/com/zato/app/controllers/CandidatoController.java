package com.zato.app.controllers;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;

import com.zato.app.Servicios.IService;
import com.zato.app.entidades.Candidato;
import com.zato.app.hiber.HibernateUtil;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
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
    public String guardar(Candidato candidato, @RequestParam("fotoCandidato") MultipartFile foto, SessionStatus status) {

        
        if (!foto.isEmpty()) {
            // Session session = HibernateUtil.getSessionFactory().openSession();
            // session.beginTransaction();
            // InputStream inputStream =
            // candidato.getClass().getClassLoader().getResourceAsStream(foto.getOriginalFilename());
           
           /*  try {
                blob = Hibernate.getLobCreator(HibernateUtil.getSessionFactory().getCurrentSession())
                        .createBlob(foto.getInputStream(), foto.getSize());
            } catch (IOException e) {

                e.printStackTrace();
            }
            try {
                candidato.setFotoCandidato(blob.getBytes(0, (int) blob.length()));
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } */

           /*  try {
                byte[] content = foto.getBytes();
                InputStream inputStream = new ByteArrayInputStream(content);
                candidato.setFotoCandidato(inputStream);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } */
            //byte[] content;
            try {
                //content = foto.getBytes();
              /*   InputStream inputStream = foto.getInputStream();
            Blob blob = Hibernate.getLobCreator(HibernateUtil.getSessionFactory().getCurrentSession())
            .createBlob(inputStream, foto.getSize()); */
            candidato.setFotoCandidato(getBlobData(foto));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
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


    public Blob getBlobData(MultipartFile file) throws IOException, SQLException {
        byte[] bytes = file.getBytes();
        return new SerialBlob(bytes);
    }


}

