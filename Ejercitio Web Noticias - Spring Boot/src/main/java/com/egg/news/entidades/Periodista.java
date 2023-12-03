/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.news.entidades;

import com.egg.news.enumeraciones.Rol;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Taddeu's
 */
@Entity
public class Periodista extends Usuario{
    @OneToMany
    @JoinColumn(name = "periodista_id")
    private List<Noticia> misNoticias;
    private Integer sueldoMensual;

    public Periodista() {
    }   

    public Periodista(String id, String nombre, String email, String password, Date alta, Rol rol, Boolean activo, List<Noticia> misNoticias, Integer sueldoMensual) {
        super(id, nombre, email, password, alta, rol, activo);
        this.misNoticias = misNoticias;
        this.sueldoMensual = sueldoMensual;
    }

    public List<Noticia> getMisNoticias() {
        return misNoticias;
    }

    public void setMisNoticias(List<Noticia> misNoticias) {
        this.misNoticias = misNoticias;
    }

    public Integer getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(Integer sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public String toString() {
        return super.toString() + "Periodista{" + "misNoticias=" + misNoticias + ", sueldoMensual=" + sueldoMensual + '}';
    }

    
  
    
}
