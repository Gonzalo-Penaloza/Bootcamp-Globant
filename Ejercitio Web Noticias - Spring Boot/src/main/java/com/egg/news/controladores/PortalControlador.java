/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.news.controladores;

import com.egg.news.entidades.Usuario;
import com.egg.news.enumeraciones.Rol;
import com.egg.news.servicios.AdministradorServicio;
import com.egg.news.servicios.PeriodistaServicio;
import com.egg.news.servicios.UsuarioServicio;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Taddeu's
 */
@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private PeriodistaServicio periodistaServicio;
    @Autowired
    private AdministradorServicio adminServicio;

    @GetMapping("/")
    public String inicio(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            Usuario usuario = usuarioServicio.buscarPorEmail(userDetail.getUsername());

            if (usuario != null) {
                model.addAttribute("usuario", usuario);
            }
        }

        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar(ModelMap model) {
        Rol[] roles = Rol.values();
        
        model.addAttribute("roles", roles);
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email,
            @RequestParam String password, @RequestParam String password2, Rol rol, ModelMap modelo) {
        try {
            
            if(rol.equals(Rol.PERIODISTA)){
                periodistaServicio.registrar(nombre, email, password, password2);
            } else if(rol.equals(Rol.ADMIN)){
                adminServicio.registrar(nombre, email, password, password2);
            } else {
                usuarioServicio.registrar(nombre, email, password, password2);
            }
            
            modelo.put("exito", "Usuario registrado correctamente!");

            return "inicio.html";
        } catch (Exception ex) {
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            return "registro.html";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            modelo.put("error", "Usuario o contraseña incorrectos!");
        }
        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_PERIODISTA','ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session, ModelMap model) {
        Usuario logged = (Usuario) session.getAttribute("usuariosession");

        if (logged != null && logged.getRol() != null && logged.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        }
        
        model.addAttribute("usuario", logged);

        return "inicio.html";
    }
    

    @GetMapping("/acceso-denegado")
    public String accesoDenegado() {
        return "redirect:/inicio"; // Redirecciona a /inicio en caso de acceso denegado
    }

}
