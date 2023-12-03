/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.news.servicios;

import com.egg.news.entidades.Usuario;
import com.egg.news.enumeraciones.Rol;
import com.egg.news.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Taddeu's
 */
@Service
public class UsuarioServicio implements UserDetailsService{
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void registrar(Usuario u){       
        usuarioRepositorio.save(u);
    }
    
    @Transactional
    public void registrar(String nombre, String email, String password, String password2) throws Exception{
        validar(nombre, email, password, password2);
        
        Usuario usuario = new Usuario();
        
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setAlta(new Date());
        usuario.setRol(Rol.USER);
        usuario.setActivo(Boolean.TRUE);
        
        usuarioRepositorio.save(usuario);
    }
    
    public Usuario buscarPorEmail(String email){
        return usuarioRepositorio.buscarPorEmail(email);
    }
    
    public void eliminar(Usuario usuario){
        usuarioRepositorio.delete(usuario);
    }
    
    private void validar(String nombre, String email, String password, String password2) throws Exception{ 
        
        if(nombre.isEmpty() || nombre == null) throw new Exception("El nombre no puede ser nulo o estar vacio");
        
        if(email.isEmpty() || email == null) throw new Exception("El email no puede ser nulo o estar vacio");
        
        if(password.isEmpty() || password == null || password.length() <= 5) throw new Exception("La contraseña no puede estar vacia, y debe tener más de 5 digitos");
        
        if(!password.equals(password2)) throw new Exception("Las contraseñas ingresadas deben ser iguales");
        
    }
    
    public Usuario getOne(String id){
        return usuarioRepositorio.getOne(id);
    }
    
    public Optional<Usuario> buscarPorId(String id){
        return usuarioRepositorio.findById(id);
    }
    
    
    
    public List<Usuario> listaUsuarios(){
        return usuarioRepositorio.findAll();
    }
    
    public void modificarUsuario(Usuario user){
        usuarioRepositorio.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.buscarPorEmail(username);
        
        if(usuario != null){
            List<GrantedAuthority> permisos = new ArrayList();
            
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            
            permisos.add(p);      
            
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            
            HttpSession session = attr.getRequest().getSession(true);
            
            session.setAttribute("usuariosession", usuario);
            
            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        } else {
            return null;
        }
    }
}
