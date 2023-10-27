/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;
import libreria.utilidades.Utilidades;

/**
 *
 * @author Taddeu's
 */
public class EditorialServicio {
    private final EditorialDAO dao;
    private Scanner sc;

    public EditorialServicio() {
        this.dao = new EditorialDAO();
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }
    
    public void crearEditorial(){
        System.out.println("Ingrese el nombre de la editorial a registrar:");
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
            Editorial editorial = new Editorial(nombre,Boolean.parseBoolean(alta));
            dao.guardarEditorial(editorial);
        } catch (Exception e) {
            System.out.println("Algo anda mal -> " + e.toString());
        }
    }
    
    public void eliminarEditorial(){
        try {
            System.out.println("Ingrese el ID:");
            String id = Utilidades.validarInputParametro();
            
            Editorial editorial = dao.buscarEditorialPorId(Integer.parseInt(id));
            
            dao.eliminarEditorial(editorial);
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA -> " + e.toString());
        }
    }
    
    public void modificarEditorial(){
        try {
            System.out.println("Ingrese el ID:");
            String id = Utilidades.validarInputParametro();
            
            Editorial editorial = dao.buscarEditorialPorId(Integer.parseInt(id));       
            if(editorial == null) throw new Exception("Editorial invalido o no existe");
            
            String choice;
            
            do{
                System.out.println("Datos disponibles a modificar:");
                System.out.println("1. Nombre");
                System.out.println("0. Volver");
                choice = sc.next();
                
                switch(choice){
                    case "1":
                        System.out.print("Nombre actual: " + editorial.getNombre());
                        System.out.print("Ingrese el nuevo nombre:");
                        String nombre = sc.next();
                        
                        if(nombre != null || nombre.trim().isEmpty()) throw new Exception("El nuevo nombre esta vacio o es invalido, volviendo al menu anterior...");
                        
                        editorial.setNombre(nombre);
                        
                        System.out.println("EDITORIAL ID#" + editorial.getId() + " modificado con exito!");
                        break;
                    case "2":
                        System.out.println("Volviendo al menu anterior...");
                    default:
                        System.out.println("Opcion invalida, vuelva a intentar");
                }
                
            } while (!choice.equals("0"));
            
            dao.modificarEditorial(editorial);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    
    public Editorial buscarEditorialPorId(Integer id){
        try {
            Editorial editorial = dao.buscarEditorialPorId(id);
            return editorial;
        } catch (Exception e) {
            System.out.println("No existe tal editorial");
            return null;
        }
    }
    
    public Editorial buscarEditorialPorParametro(String parametro){
        try {
            System.out.print("Ingrese el " + parametro + " de la editorial:");
            String valorParametro = Utilidades.validarInputParametro();
            
            Editorial editorial  = dao.buscarEditorialPorParametro(parametro, valorParametro);
            
            return editorial;
        } catch (Exception e) {
            System.out.println("ERROR SISTEMA");
            return null;
        }
    }
    
    private Collection<Editorial> listarEditoriales(){
        try {
            Collection<Editorial> editoriales = dao.listarEditoriales();
            
            return editoriales;
        } catch (Exception e) {
            System.out.println("NO hay editoriales");
            return null;
        }
    }
    
    //TODO Metodos
    
    public void imprimirEditoriales(){
        try {
            Collection<Editorial> editoriales = listarEditoriales();
            
            if(editoriales.isEmpty()){
                System.out.println("No hay editoriales registrados en la base");
            } else {
                for(Editorial a: editoriales){
                    System.out.println(a);
                } 
            } 
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA");
        }
    }
    
    public void imprimirEditorialPorParametro(String parametro){
        try {
            Editorial editorial = buscarEditorialPorParametro(parametro);
            
            if(editorial == null) throw new Exception("Editorial invalida o no existe.");
            
            System.out.println(editorial);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    
    public void darEditorialDeAlta(Integer id){
        try {
            Editorial editorial = buscarEditorialPorId(id);
            
            if(editorial.getAlta().equals(Boolean.TRUE)) {
                System.out.println("El editorial ya esta dado de alta en el sistema");
            } else {
                editorial.setAlta(Boolean.TRUE);
                System.out.println("Editorial dado de alta con exito!");
            }
            
            dao.modificarEditorial(editorial);
        } catch (Exception e) {
            System.out.println("MAL MAAL MAL");
        }
    }
    
    public void darEditorialDeBaja(Integer id){
        try {
            Editorial editorial = buscarEditorialPorId(id);
            
            if(editorial.getAlta().equals(Boolean.TRUE)) {
                editorial.setAlta(Boolean.FALSE);
                System.out.println("Editorial dado de baja con exito!");
            } else {
                System.out.println("El editorial ya esta dado de baja en el sistema");
            }
            
            dao.modificarEditorial(editorial);
        } catch (Exception e) {
            System.out.println("MAL MAAL MAL");
        }
    }
    

    
}
