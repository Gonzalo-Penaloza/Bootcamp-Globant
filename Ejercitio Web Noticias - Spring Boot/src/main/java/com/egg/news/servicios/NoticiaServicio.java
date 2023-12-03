/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.news.servicios;

import com.egg.news.entidades.Noticia;
import com.egg.news.repositorios.NoticiaRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Taddeu's
 */
@Service
public class NoticiaServicio {
    
    @Autowired
    private NoticiaRepositorio noticiaRepositorio;
    
    @Transactional
    public Noticia crearNoticia(String titulo, String cuerpo) throws Exception{
        validar(titulo, cuerpo);
        
        Noticia noticia = new Noticia();
        
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        noticia.setAlta(new Date());
        
        return noticiaRepositorio.save(noticia);
    }
    
    @Transactional
    public void modificarNoticia(String id, String titulo, String cuerpo){
        Optional<Noticia> resp = noticiaRepositorio.findById(id);
        Noticia noticia = new Noticia();
          
        if(resp.isPresent()){
            noticia = resp.get();          
            //Agregamos nuevas modificaciones
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            //Persistimos la modificacion
            noticiaRepositorio.save(noticia);
        }
    }
    
    @Transactional
    public void eliminarNoticia(String id){
        Optional<Noticia> resp = noticiaRepositorio.findById(id);
          
        if(resp.isPresent()){
            Noticia noticia = resp.get();
            noticiaRepositorio.delete(noticia);
        }
    }
    
    public List<Noticia> listarNoticias(){
        List<Noticia> lista = new ArrayList();
        
        lista = noticiaRepositorio.findAll();
        
        return lista;
    }
       
    public Noticia getOne(String id){
        return noticiaRepositorio.getOne(id);
    }
    
    public Noticia buscarUltimaNoticia(){
        List<Noticia> noticias = noticiaRepositorio.buscarUltimaNoticia();
        
        return noticias.isEmpty() ? null : noticias.get(0);
    }
    
    private void validar(String titulo, String cuerpo) throws Exception{
        if(titulo.isEmpty() || titulo == null) throw new Exception("El titulo no puede estar vacio");     
        
        if(cuerpo.isEmpty() || cuerpo == null) throw new Exception("El cuerpo no puede estar vacio");     
    }
}
