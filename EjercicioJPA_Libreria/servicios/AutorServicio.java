/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;
import libreria.utilidades.Utilidades;

/**
 *
 * @author Taddeu's
 */
public class AutorServicio {
    private final AutorDAO dao;
    private Scanner sc = new Scanner(System.in, "UTF-8").useDelimiter("\n");

    public AutorServicio() {
        this.dao = new AutorDAO();
    }
    
    public void crearAutor(){
        System.out.println("Ingrese el nombre del autor a registrar:");
        String nombre = sc.next();
           
        System.out.println("Autor habilitado? S/N:");
        String cond = sc.next().toUpperCase();
        
        String alta = "";
        
        switch(cond){
            case "S": 
                alta = "true";
                break;
            case "N":
                alta = "false";
                break;
        }
            
        try {       
            Autor autor = new Autor(nombre,Boolean.parseBoolean(alta));
            dao.guardarAutor(autor);
        } catch (Exception e) {
            System.out.println("Algo anda mal");
        }
    }
    
    public void eliminarAutor(){
        try {
            System.out.println("Ingrese el ID:");
            String id = Utilidades.validarInputParametro();
            
            Autor autor = dao.buscarAutorPorId(Integer.parseInt(id));
            
            dao.eliminarAutor(autor);
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA");
        }
    }
    
    public void modificarAutor(){
        try {
            System.out.println("Ingrese el ID:");
            String id = Utilidades.validarInputParametro();
            
            Autor autor = dao.buscarAutorPorId(Integer.parseInt(id));       
            if(autor == null) throw new Exception("Autor invalido o no existe");
            
            String choice;
            
            do{
                System.out.println("Datos disponibles a modificar:");
                System.out.println("1. Nombre");
                System.out.println("0. Volver");
                choice = sc.next();
                
                switch(choice){
                    case "1":
                        System.out.print("Nombre actual: " + autor.getNombre());
                        System.out.print("Ingrese el nuevo nombre:");
                        String nombre = sc.next();
                        
                        if(nombre != null || nombre.trim().isEmpty()) throw new Exception("El nuevo nombre esta vacio o es invalido, volviendo al menu anterior...");
                        
                        autor.setNombre(nombre);
                        
                        System.out.println("AUTOR ID#" + autor.getId() + " modificado con exito!");
                        break;
                    case "2":
                        System.out.println("Volviendo al menu anterior...");
                    default:
                        System.out.println("Opcion invalida, vuelva a intentar");
                }
                
            } while (!choice.equals("0"));
            
            dao.modificarAutor(autor);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    
    public Autor buscarAutorPorId(Integer id){
        try {
            Autor autor = dao.buscarAutorPorId(id);
            return autor;
        } catch (Exception e) {
            System.out.println("No existe tal autor");
            return null;
        }
    }
    
    private Collection<Autor> listarAutores(){
        try {
            Collection<Autor> autores = dao.listarAutores();
            
            return autores;
        } catch (Exception e) {
            System.out.println("NO hay autores");
            return null;
        }
    }
    
    //TODO Metodos
    
    public void imprimirAutores(){
        try {
            Collection<Autor> autores = listarAutores();
            
            if(autores.isEmpty()){
                System.out.println("No hay autores registrados en la base");
            } else {
                for(Autor a: autores){
                    System.out.println(a);
                } 
            } 
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA");
        }
    }
    
    
    public void darAutorDeAlta(Integer id){
        try {
            Autor autor = buscarAutorPorId(id);
            
            if(autor.getAlta().equals(Boolean.TRUE)) {
                System.out.println("El autor ya esta dado de alta en el sistema");
            } else {
                autor.setAlta(Boolean.TRUE);
                System.out.println("Autor dado de alta con exito!");
            }
            
            dao.modificarAutor(autor);
        } catch (Exception e) {
            System.out.println("MAL MAAL MAL");
        }
    }
    
    public void darAutorDeBaja(Integer id){
        try {
            Autor autor = buscarAutorPorId(id);
            
            if(autor.getAlta().equals(Boolean.TRUE)) {
                autor.setAlta(Boolean.FALSE);
                System.out.println("Autor dado de baja con exito!");
            } else {
                System.out.println("El autor ya esta dado de baja en el sistema");
            }
            
            dao.modificarAutor(autor);
        } catch (Exception e) {
            System.out.println("MAL MAAL MAL");
        }
    }
    
    public Autor buscarAutorPorParametro(String parametro){
        try{
            System.out.print("Ingrese el " + parametro + " del del autor:");
            String valorParametro = Utilidades.validarInputParametro();
               
            Autor autor  = dao.buscarAutorPorParametro(parametro, valorParametro);
            
            return autor;
        } catch (Exception e) {
            System.out.println("ERROR SISTEMA");
            return null;
        }
    }
    
    public void imprimirAutorPorParametro(String parametro){
        try {
            Autor autor = buscarAutorPorParametro(parametro);
            
            if(autor == null){
                System.out.println("No se encontro el autor");
            } else {
                System.out.println(autor);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
