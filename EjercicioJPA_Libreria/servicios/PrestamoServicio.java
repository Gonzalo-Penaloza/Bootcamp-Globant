/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.PrestamoDAO;
import libreria.utilidades.Utilidades;

/**
 *
 * @author Taddeu's
 */
public class PrestamoServicio {
    private final PrestamoDAO dao;
    private final LibroServicio lS;
    private final ClienteServicio cS;
    private Scanner sc;

    public PrestamoServicio() {
        this.dao = new PrestamoDAO();
        this.lS = new LibroServicio();
        this.cS = new ClienteServicio();
        this.sc = new Scanner(System.in, "UTF-8").useDelimiter("\n");
    }
       
    public void crearPrestamo(){    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Ingrese la fecha de inicio prestamo(YYYY-MM-DD):");
        String fechaIni = sc.next();
        
        System.out.println("Ingrese la fecha de fin prestamo(YYYY-MM-DD):");
        String fechaFin = sc.next();  
        
        try {        
            Cliente cliente = cS.buscarClientePorParametro("id");        
            Libro libro = lS.buscarLibroPorParametro("titulo");
            
            lS.verificarEjemplares(libro);   
            
            Prestamo prestamo = new Prestamo(sdf.parse(fechaIni), sdf.parse(fechaFin), libro, cliente);  
            
            dao.guardarPrestamo(prestamo);
            lS.actualizarEjemplaresLibro(libro, "prestamo"); 
            
            System.out.println("Prestamo registrado con exito!");
        } catch (Exception e) {
            System.out.println("Algo anda mal -> ERROR: " + e.toString());
        }
    }
    
    public void eliminarPrestamo(){
        try {     
            System.out.println("Ingrese el ID:");
            String id = Utilidades.validarInputParametro();
            
            Prestamo prestamo = dao.buscarPrestamoPorId(Integer.parseInt(id));
            
            if(prestamo == null) throw new Exception("Prestamo invalido o no existe, volviendo al menu anterior.");
  
            dao.eliminarPrestamo(prestamo);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void eliminarPrestamo(Prestamo prestamo){
        try {                 
            dao.eliminarPrestamo(prestamo);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
       
    public Prestamo buscarPrestamoPorId(Integer id){
        try {
            Prestamo prestamo = dao.buscarPrestamoPorId(id);
            return prestamo;
        } catch (Exception e) {
            System.out.println("No existe tal prestamo");
            return null;
        }
    }
    
    private Collection<Prestamo> listarPrestamos(){
        try {
            Collection<Prestamo> prestamos = dao.listarPrestamos();
            
            return prestamos;
        } catch (Exception e) {
            System.out.println("NO hay prestamos");
            return null;
        }
    }
    
    public Prestamo buscarPrestamoPorObjeto(String tipoObjeto, String parametro, String valor){
        try {
            Prestamo prestamo = dao.buscarPrestamoPorObjeto(tipoObjeto, parametro, parametro);
                   
            return prestamo;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //TODO Metodos
    
    public void imprimirPrestamos(){
        try {
            Collection<Prestamo> prestamos = listarPrestamos();
            
            if(prestamos.isEmpty()){
                System.out.println("No hay prestamos registrados actualmente.");
            } else {
                for(Prestamo a: prestamos){
                    System.out.println(a);
                } 
            } 
            System.out.println();          
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA");
        }
    }
    
    public void imprimirPrestamoPorId(){
        try {
            System.out.println("Ingrese el ID:");
            String id = Utilidades.validarInputParametro();
            
            Prestamo prestamo = buscarPrestamoPorId(Integer.parseInt(id));
            
            if(prestamo == null) throw new Exception("Prestamo invalido o no existe, vuelva a intentar.");
            
            System.out.println(prestamo);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void imprimirPrestamoPorObjeto(String tipoObjeto, String parametro){
        try {
            System.out.print("Ingrese el " + parametro + " de " + tipoObjeto + " del prestamo:");
            String valorParametro = Utilidades.validarInputParametro();
            
            Prestamo prestamo = buscarPrestamoPorObjeto(tipoObjeto, parametro, valorParametro);
            
            if(prestamo == null) throw new Exception("No se encontraron prestamos relacionados");
            
            System.out.println(prestamo);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void registrarDevolucion(){
        System.out.print("Ingrese el ID del prestamo:");
        Integer id = Integer.parseInt(Utilidades.validarInputParametro());
            
        try {
            Prestamo prestamo = buscarPrestamoPorId(id);
            Libro libro = prestamo.getLibro();
            
            eliminarPrestamo(prestamo);

            lS.actualizarEjemplaresLibro(libro, "devolucion");       
            lS.modificarLibro(libro);
            System.out.println("Devolucion registrada con exito.");
        } catch (Exception e) {
            System.out.println("No se pudo registrar la devolucion.");
        }
    }
}
