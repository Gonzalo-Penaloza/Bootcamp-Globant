/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.news.entidades;

import com.egg.news.enumeraciones.Rol;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Taddeu's
 */
@Entity
public class Administrador extends Usuario{

    public Administrador() {
    }
    
    
    public Administrador(String id, String nombre, String email, String password, Date alta, Rol rol, Boolean activo) {
        super(id, nombre, email, password, alta, rol, activo);
    }         
}
