/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;
import libreria.utilidades.Utilidades;

/**
 *
 * @author Taddeu's
 */
public class LibroServicio {
    private final LibroDAO dao;
    private final AutorServicio aS;
    private final EditorialServicio eS;

    public LibroServicio() {
        this.dao = new LibroDAO();
        this.eS = new EditorialServicio();
        this.aS = new AutorServicio();
    }
    
    public void crearLibro(){
        Scanner sc = new Scanner(System.in, "UTF-8").useDelimiter("\n");

        System.out.println("Ingrese el ISBN del libro a registrar:");
        String ISBN = sc.next();
        
        System.out.println("Ingrese el titulo:");
        String titulo = sc.next();
        
        System.out.println("Ingrese el anio:");
        String anio = sc.next();  
        
        System.out.println("Ingrese el total de ejemplares:");
        String totalEj = sc.next();
        
        System.out.println("El libro esta en condiciones para prestamos? S/N:");
        String cond = sc.next();
        
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
            Autor autor = aS.buscarAutorPorParametro("nombre");
            Editorial editorial = eS.buscarEditorialPorParametro("nombre");
            
            Libro libro = new Libro(Long.parseLong(ISBN), titulo, Integer.parseInt(anio), Integer.parseInt(totalEj), 0, Integer.parseInt(totalEj), Boolean.parseBoolean(alta), autor, editorial);
       
            dao.guardarLibro(libro);
        } catch (Exception e) {
            System.out.println("Algo anda mal");
        }
    }
    
    public void eliminarLibro(){
        try {
            System.out.println("Ingrese el ISBN:");
            String ISBN = Utilidades.validarInputParametro();
            
            Libro libro = dao.buscarLibroPorISBN(Long.parseLong(ISBN));
            dao.eliminarLibro(libro);
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA");
        }
    }
    
    public void modificarLibro(){
        try {
            System.out.println("Ingrese el ISBN:");
            String ISBN = Utilidades.validarInputParametro();
            
            Libro libro = dao.buscarLibroPorISBN(Long.parseLong(ISBN));
            dao.modificarLibro(libro);
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA");
        }
    }
    
    public void modificarLibro(Libro libro){
        try {
            if(libro != null) dao.modificarLibro(libro);
            
            System.out.println("Libro #" + libro.getIsbn() + " modificado.");
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA");
        }
    }
    
    
    public Libro buscarLibroPorISBN(Long isbn){
        try {
            Libro libro = dao.buscarLibroPorISBN(isbn);
            return libro;
        } catch (Exception e) {
            System.out.println("No existe tal libro");
            return null;
        }
    }
    
    private Collection<Libro> listarLibros(){
        try {
            Collection<Libro> libros = dao.listarLibros();
            
            return libros;
        } catch (Exception e) {
            System.out.println("NO hay libros");
            return null;
        }
    }
    
    //TODO Metodos
    
    public void imprimirLibros(){
        try {
            Collection<Libro> libros = listarLibros();
            
            if(libros.isEmpty()){
                System.out.println("No hay libros registrados en la base");
            }
            
            for(Libro a: libros){
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA");
        }
    }
    
    
    public void darLibroDeAlta(Long isbn){
        try {
            Libro libro = buscarLibroPorISBN(isbn);
            
            if(libro.getAlta().equals(Boolean.TRUE)) {
                System.out.println("El libro ya esta dado de alta en el sistema");
            } else {
                libro.setAlta(Boolean.TRUE);
                System.out.println("Libro dado de alta con exito!");
            }
            
            dao.modificarLibro(libro);
        } catch (Exception e) {
            System.out.println("MAL MAAL MAL");
        }
    }
    
    public void darLibroDeBaja(Long isbn){
        try {
            Libro libro = buscarLibroPorISBN(isbn);
            
            if(libro.getAlta().equals(Boolean.TRUE)) {
                libro.setAlta(Boolean.FALSE);
                System.out.println("Libro dado de baja con exito!");
            } else {
                System.out.println("El libro ya esta dado de baja en el sistema");
            }
            
            dao.modificarLibro(libro);
        } catch (Exception e) {
            System.out.println("MAL MAAL MAL");
        }
    }
    
    public Libro buscarLibroPorParametro(String parametro) throws Exception{
        try{
            System.out.print("Ingrese el " + parametro + " del libro:");
            String valorParametro = Utilidades.validarInputParametro();
            
            Libro libro  = dao.buscarLibroPorParametro(parametro, valorParametro);
            
            return libro;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirLibroPorParametro(String parametro){
        try { 
            Libro libro = buscarLibroPorParametro(parametro);
            
            if(libro == null){
                System.out.println("No se encontro el libro");
            } else {
                System.out.println(libro);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
       
    public Libro buscarLibroPorObjeto(String tipoObjeto, String parametro){
        try{
            
            System.out.print("Ingrese el " + parametro + " de " + tipoObjeto + " del libro:");
            String valorParametro = Utilidades.validarInputParametro();
            
            Libro libro  = dao.buscarLibroPorObjeto(tipoObjeto, parametro, valorParametro);
            
            return libro;
        } catch (Exception e) {
            System.out.println("ERROR SISTEMA");
            return null;
        }
    }
    
    public void imprimirLibroPorObjeto(String tipoObjeto, String parametro){
        try { 
            Libro libro = buscarLibroPorObjeto(tipoObjeto, parametro);
            
            if(libro == null){
                System.out.println("No se encontro el libro");
            } else {
                System.out.println(libro);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void verificarEjemplares(Libro libro) throws Exception{
        Integer ejRestantes = libro.getEjemplaresRestantes();
        
        if(ejRestantes<=0) throw new Exception("No hay ejemplares disponibles para el prestamo.");
        
    }
    
    public void actualizarEjemplaresLibro(Libro libro, String tipo) throws Exception{
        if(libro == null) throw new Exception("El libro es invalido o no existe");
            
        try{
            switch (tipo){
                case "prestamo":
                    libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);       
                    break;
                case "devolucion":
                    libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() - 1);
                    break;
                default:
                    System.out.println("Acción incorrecta.");
            }
            
            libro.setEjemplaresRestantes(libro.getEjemplares() - libro.getEjemplaresPrestados());
            
            modificarLibro(libro);
        } catch (NumberFormatException e){
            System.out.println("No se pudo actualizar los ejemplares");
        }         
    }   
}
