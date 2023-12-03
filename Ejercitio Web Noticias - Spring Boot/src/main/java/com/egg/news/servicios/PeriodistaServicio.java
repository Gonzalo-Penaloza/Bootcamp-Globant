/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.news.servicios;

import com.egg.news.entidades.Noticia;
import com.egg.news.entidades.Periodista;
import com.egg.news.entidades.Usuario;
import com.egg.news.enumeraciones.Rol;
import com.egg.news.repositorios.PeriodistaRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Taddeu's
 */
@Service
public class PeriodistaServicio {
    @Autowired
    private NoticiaServicio noticiaServicio;
    
    @Autowired
    private PeriodistaRepositorio periodistaRepositorio;
    
    public void registrar(Periodista p){      
        periodistaRepositorio.save(p);
    }
    
    public void registrar(String nombre, String email, String password, String password2) throws Exception{
        validar(nombre, email, password, password2);
        
        Periodista periodista = new Periodista();
        
        periodista.setNombre(nombre);
        periodista.setEmail(email);
        periodista.setPassword(new BCryptPasswordEncoder().encode(password));
        periodista.setAlta(new Date());
        periodista.setRol(Rol.PERIODISTA);
        periodista.setActivo(Boolean.TRUE);
        periodista.setMisNoticias(new ArrayList<>());
        periodista.setSueldoMensual(1000);
        
        periodistaRepositorio.save(periodista);
    }

    public void crearNoticia(String periodistaId, String titulo, String cuerpo) throws Exception{
        Noticia noticia = noticiaServicio.crearNoticia(titulo, cuerpo);
        
        Optional<Periodista> optionalPeriodista = periodistaRepositorio.findById(periodistaId);
        
        if(optionalPeriodista.isPresent()){
            Periodista periodista = optionalPeriodista.get();
            
            // Obtener la lista de noticias del periodista, agregar la nueva noticia y guardar
            List<Noticia> noticias = periodista.getMisNoticias();
            noticias.add(noticia);
            periodista.setMisNoticias(noticias);
            periodistaRepositorio.save(periodista);
        }
    }
    
    public void eliminarPeriodista(Periodista p){
        periodistaRepositorio.delete(p);
    }
    
    public Optional<Periodista> buscarPorId(String id){
        return periodistaRepositorio.findById(id);
    }
    
    public Periodista getOne(String id){
        return periodistaRepositorio.getOne(id);
    }
    
    public void modificarNoticia(String id, String titulo, String cuerpo){
        noticiaServicio.modificarNoticia(id, titulo, cuerpo);
    }
    
    private void validar(String nombre, String email, String password, String password2) throws Exception{ 
        
        if(nombre.isEmpty() || nombre == null) throw new Exception("El nombre no puede ser nulo o estar vacio");
        
        if(email.isEmpty() || email == null) throw new Exception("El email no puede ser nulo o estar vacio");
        
        if(password.isEmpty() || password == null || password.length() <= 5) throw new Exception("La contraseña no puede estar vacia, y debe tener más de 5 digitos");
        
        if(!password.equals(password2)) throw new Exception("Las contraseñas ingresadas deben ser iguales");
        
    }
}
