/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.news.servicios;

import com.egg.news.entidades.Administrador;
import com.egg.news.entidades.Periodista;
import com.egg.news.entidades.Usuario;
import com.egg.news.enumeraciones.Rol;
import com.egg.news.repositorios.AdministradorRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Taddeu's
 */
@Service
public class AdministradorServicio {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private PeriodistaServicio periodistaServicio;
    @Autowired
    private AdministradorRepositorio adminRepositorio;
    @Autowired
    private NoticiaServicio noticiaServicio;

    public void registrar(String nombre, String email, String password, String password2) throws Exception {
        validar(nombre, email, password, password2);

        Administrador admin = new Administrador();

        admin.setNombre(nombre);
        admin.setEmail(email);
        admin.setPassword(new BCryptPasswordEncoder().encode(password));
        admin.setAlta(new Date());
        admin.setRol(Rol.ADMIN);
        admin.setActivo(Boolean.TRUE);

        adminRepositorio.save(admin);
    }

    public void crearNoticia(String periodistaId, String titulo, String cuerpo) throws Exception {
        noticiaServicio.crearNoticia(titulo, cuerpo);
    }

    public void modificarNoticia(String id, String titulo, String cuerpo) {
        noticiaServicio.modificarNoticia(id, titulo, cuerpo);
    }

    public void eliminarNoticia(String id) {
        noticiaServicio.eliminarNoticia(id);
    }

    public void convertirUsuarioAPeriodista(String id) {
        Optional<Usuario> optionalUsuario = usuarioServicio.buscarPorId(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            Periodista periodista = new Periodista();

            // Copiar atributos comunes
            periodista.setId(usuario.getId());
            periodista.setNombre(usuario.getNombre());
            periodista.setEmail(usuario.getEmail());
            periodista.setPassword(usuario.getPassword());
            periodista.setAlta(usuario.getAlta());
            periodista.setActivo(usuario.getActivo());
            // Copiar otros atributos específicos de Periodista
            periodista.setRol(Rol.PERIODISTA);
            periodista.setMisNoticias(new ArrayList<>());
            periodista.setSueldoMensual(1000);

            usuarioServicio.eliminar(usuario);
            periodistaServicio.registrar(periodista);
        }
    }

    @Transactional
    public void convertirPeriodistaAUsuario(String id) {
        Optional<Periodista> optionalPeriodista = periodistaServicio.buscarPorId(id);

        if (optionalPeriodista.isPresent()) {
            Periodista periodista = optionalPeriodista.get();
            Usuario usuario = new Usuario();

            // Copiar atributos comunes
            usuario.setId(periodista.getId());
            usuario.setNombre(periodista.getNombre());
            usuario.setEmail(periodista.getEmail());
            usuario.setPassword(periodista.getPassword());
            usuario.setAlta(periodista.getAlta());
            usuario.setActivo(periodista.getActivo());
            // Copiar otros atributos específicos de Usuario
            usuario.setRol(Rol.USER);
            // ... otros atributos de Usuario*/

            periodistaServicio.eliminarPeriodista(periodista);
            usuarioServicio.registrar(usuario);
        }
    }


    private void validar(String nombre, String email, String password, String password2) throws Exception {

        if (nombre.isEmpty() || nombre == null) {
            throw new Exception("El nombre no puede ser nulo o estar vacio");
        }

        if (email.isEmpty() || email == null) {
            throw new Exception("El email no puede ser nulo o estar vacio");
        }

        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new Exception("La contraseña no puede estar vacia, y debe tener más de 5 digitos");
        }

        if (!password.equals(password2)) {
            throw new Exception("Las contraseñas ingresadas deben ser iguales");
        }

    }

}
