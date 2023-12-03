/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.news.controladores;

import com.egg.news.entidades.Noticia;
import com.egg.news.servicios.NoticiaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Taddeu's
 */
@Controller
@RequestMapping("/noticia")
public class NoticiaControlador {
    @Autowired
    private NoticiaServicio noticiaServicio;
    
    @PreAuthorize("hasAnyRole('ROLE_PERIODISTA','ROLE_ADMIN')")
    @GetMapping("/crear-noticia")
    public String registrar(){
        return "noticias/noticia_form.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_PERIODISTA','ROLE_ADMIN')")
    @PostMapping("/crear-noticia-exito")
    public String registro(@RequestParam String titulo, @RequestParam String cuerpo, ModelMap model){
        try {
            noticiaServicio.crearNoticia(titulo, cuerpo);
            
            model.put("exito", "Se ha registrado la noticia correctamente!");
            return "redirect:/noticia/lista";
        } catch (Exception e) {        
            model.put("error", e.getMessage());
            
            return "noticias/noticia_form.html";
        }        
    }
    
    @GetMapping("/lista")
    public String lista(ModelMap model){
        List<Noticia> noticias = noticiaServicio.listarNoticias();
        
        model.addAttribute("noticias", noticias);
        return "noticias/noticia_list.html";
    }
      
    @PreAuthorize("hasAnyRole('ROLE_PERIODISTA','ROLE_ADMIN')")
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap model){
        model.put("noticia", noticiaServicio.getOne(id));
        
        return "noticias/noticia_modificar.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_PERIODISTA','ROLE_ADMIN')")
    @PostMapping("/modificar/{id}")
    public String modificarNoticia(@PathVariable String id, String titulo, String cuerpo, ModelMap model){
        try {
            noticiaServicio.modificarNoticia(id, titulo, cuerpo);
            
            model.put("exito", "La noticia se ha modificado correctamente!");
            
            return "redirect:/noticia/lista";
        } catch (Exception e) {
            model.put("error", e.getMessage());
            
            return "noticias/noticia_modificar.html";
        }
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/eliminar/{id}")
    public String eliminarNoticia(@PathVariable String id, ModelMap model){
        try {
            noticiaServicio.eliminarNoticia(id);
            
            model.put("exito", "La noticia se ha eliminado correctamente!");
            
            return "redirect:/noticia/lista";
        } catch (Exception e) {
            model.put("error", e.getMessage());
            
            return "noticias/noticia_modificar.html";
        }
    }
           
}
