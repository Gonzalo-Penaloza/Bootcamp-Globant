/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.news.controladores;

import com.egg.news.entidades.Noticia;
import com.egg.news.entidades.Periodista;
import com.egg.news.entidades.Usuario;
import com.egg.news.enumeraciones.Rol;
import com.egg.news.servicios.AdministradorServicio;
import com.egg.news.servicios.NoticiaServicio;
import com.egg.news.servicios.PeriodistaServicio;
import com.egg.news.servicios.UsuarioServicio;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("/admin")
public class AdminControlador {
    
    @Autowired
    private UsuarioServicio usuarioService;
    
    @Autowired
    private NoticiaServicio noticiaService;
    
    @Autowired
    private PeriodistaServicio periodistaService;
    
    @Autowired
    private AdministradorServicio adminServicio;
          
    @GetMapping("/dashboard")
    public String panelAdministrativo(ModelMap model){ 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        Usuario usuario = this.usuarioService.buscarPorEmail(userDetail.getUsername());
        
        if(usuario != null) model.addAttribute("usuario", usuario);

        Noticia noticia = noticiaService.buscarUltimaNoticia();
        
        if(noticia != null) model.addAttribute("noticia", noticia);
        
        return "panel";
    }
    
    @GetMapping("/lista-usuarios")
    public String showUserList(ModelMap model){
        List<Usuario> users = usuarioService.listaUsuarios();
        
        model.addAttribute("usuarios", users);
        
        return "/admin/usuarios_list";
    }
    
    @GetMapping("/modificar/{id}")
    public String modificarUser(@PathVariable String id,ModelMap model){
        Usuario user = usuarioService.getOne(id);
        
        Rol[] roles = {Rol.USER,Rol.PERIODISTA};
        
        model.addAttribute("usuario", user);
        model.addAttribute("roles", roles);
        
        return "/admin/usuario_modificar";
    }
    
    @PostMapping("/modificar/{id}")
    public String modificarUser(@PathVariable String id, String nombre, @DateTimeFormat(pattern = "yyyy-MM-dd") Date alta, Boolean activo, Rol rol,ModelMap model){
        Usuario user = usuarioService.getOne(id);
        
        user.setNombre(nombre);
        user.setAlta(alta);
        user.setActivo(activo);
        user.setRol(rol);
        
        usuarioService.modificarUsuario(user);
        
        return "redirect:/admin/lista-usuarios";
    }
    
    
    @GetMapping("/permisos/{id}/{rol}")
    public String editarPermisos(@PathVariable String id,@PathVariable String rol, ModelMap model){
        Rol rolConvert = Rol.valueOf(rol);
        
        if(rolConvert.equals(Rol.USER)){
            Usuario user  = usuarioService.getOne(id);
            model.addAttribute("usuario", user);
        }
        
        if(rolConvert.equals(Rol.PERIODISTA)){
            Periodista periodista = periodistaService.getOne(id);
            model.addAttribute("usuario", periodista);
        }
        
        Rol[] roles = {Rol.USER,Rol.PERIODISTA};
        
        model.addAttribute("roles", roles);
        
        return "/admin/usuario_permisos";
    }
    
    @PostMapping("/permisos/{id}")
    public String editarPermisos(@PathVariable String id, Rol rol){
        if(rol.equals(Rol.USER)){  
            adminServicio.convertirPeriodistaAUsuario(id);
            
            return "redirect:/admin/lista-usuarios";
        }
        
        if(rol.equals(Rol.PERIODISTA)){
            adminServicio.convertirUsuarioAPeriodista(id);
            
            return "redirect:/admin/lista-usuarios";
        }
        
        
        return "redirect:/admin/usuario_permisos";
    }
    
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id){
        Usuario user = usuarioService.getOne(id);
        
        usuarioService.eliminar(user);
        
        return "redirect:/admin/lista-usuarios";
    }
}
    

