/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;

/**
 *
 * @author Taddeu's
 */
public class MenuServicio {

    private EditorialServicio editorialServicio;
    private AutorServicio autorServicio;
    private LibroServicio libroServicio;
    private ClienteServicio clienteServicio;
    private PrestamoServicio prestamoServicio;
    private Scanner scanner;

    public MenuServicio() {
        this.editorialServicio = new EditorialServicio();
        this.autorServicio = new AutorServicio();
        this.libroServicio = new LibroServicio();
        this.clienteServicio = new ClienteServicio();
        this.prestamoServicio = new PrestamoServicio();
        this.scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public void showMenu() {
        String choice = "";
        
        do {
            try {
                System.out.println("-----MENU LIBRERIA-----");
                System.out.println("1. Clientes");
                System.out.println("2. Prestamos");
                System.out.println("3. Libros");
                System.out.println("4. Autores");
                System.out.println("5. Editoriales");
                System.out.println("6. Salir");           

                System.out.print("Seleccione una opción: ");
                choice = scanner.next();

                switch (choice) {
                    case "1":
                        cargarMenuCliente();
                        break;
                    case "2":
                        cargarMenuPrestamo();
                        break;
                    case "3":
                        cargarMenuLibro();
                        break;
                    case "4":
                        cargarMenuAutor();
                        break;
                    case "5":
                        cargarMenuEditorial();
                        break;
                    case "0":
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        } while (!choice.equals("0"));
    }
    
    public void imprimirOpcionesGenerales(String parametro){
        System.out.println("-----"+parametro+"-----");
        System.out.println("1. Crear");
        System.out.println("2. Buscar");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");
    }
    
    public void cargarMenuLibro(){
        String choice;
        
        do{
            imprimirOpcionesGenerales("LIBRO");
            System.out.print("Seleccione una opción: ");
            choice = scanner.next();
        
            switch(choice){
                case "1":
                    libroServicio.crearLibro();
                    break;
                case "2":
                    cargarSubMenuLibro();
                    break;
                case "3":
                    libroServicio.modificarLibro();
                    break;
                case "4":
                    libroServicio.eliminarLibro();
                    break;
                case "5":
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (!choice.equals("0"));
    }

    public void cargarMenuAutor(){
        String choice;
        
        do{
            imprimirOpcionesGenerales("AUTOR");
            System.out.print("Seleccione una opción: ");
            choice = scanner.next();
        
            switch(choice){
                case "1":
                    autorServicio.crearAutor();
                    break;
                case "2":
                    cargarSubMenuAutor();
                    break;
                case "3":
                    autorServicio.modificarAutor();
                    break;
                case "4":
                    autorServicio.eliminarAutor();
                    break;
                case "5":
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (!choice.equals("0"));
    }
    
    public void cargarMenuCliente(){
        String choice;
        
        do{
            imprimirOpcionesGenerales("CLIENTE");
            System.out.print("Seleccione una opción: ");
            choice = scanner.next();
        
            switch(choice){
                case "1":
                    clienteServicio.crearCliente();
                    break;
                case "2":
                    cargarSubMenuCliente();
                    break;
                case "3":
                    clienteServicio.modificarCliente();
                    break;
                case "4":
                    clienteServicio.eliminarCliente();
                    break;
                case "5":
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (!choice.equals("0"));
    }
    
    public void cargarMenuPrestamo(){
        String choice;
        
        do{
            System.out.println("-----PRESTAMO-----");
            System.out.println("1. Crear");
            System.out.println("2. Buscar");
            System.out.println("3. Devolucion");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            choice = scanner.next();
        
            switch(choice){
                case "1":
                    prestamoServicio.crearPrestamo();
                    break;
                case "2":
                    cargarSubMenuPrestamo();
                    break;
                case "3":
                    prestamoServicio.registrarDevolucion();
                    break;
                case "0":
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (!choice.equals("0"));
    }
    
    public void cargarMenuEditorial(){
        String choice;
        
        do{
            imprimirOpcionesGenerales("EDITORIAL");
            choice = scanner.next();
        
            switch(choice){
                case "1":
                    editorialServicio.crearEditorial();
                    break;
                case "2":
                    cargarSubMenuEditorial();
                    break;
                case "3":
                    editorialServicio.modificarEditorial();
                    break;
                case "4":
                    editorialServicio.eliminarEditorial();
                    break;
                case "0":
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (!choice.equals("0"));
    }
  
    public void cargarSubMenuLibro(){
        String choice;
        
        do{
            System.out.println("1. Buscar libro/s por nombre de autor.");
            System.out.println("2. Buscar libro por ISBN");
            System.out.println("3. Buscar libro por titulo.");
            System.out.println("4. Buscar libro por nombre de Editorial");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            choice = scanner.next();
        
            switch(choice){
                case "1":
                    libroServicio.imprimirLibroPorObjeto("autor", "nombre");
                    break;
                case "2":
                    libroServicio.imprimirLibroPorParametro("isbn");
                    break;
                case "3":
                    libroServicio.imprimirLibroPorParametro("titulo");
                    break;
                case "4":
                    libroServicio.imprimirLibroPorObjeto("editorial", "nombre");
                    break;
                case "5":
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (!choice.equals("0"));
    }
    
    public void cargarSubMenuAutor(){
        String choice;
        
        do{
            System.out.println("1. Buscar autor por ID");
            System.out.println("2. Buscar autor por nombre");
            System.out.println("3. Listar todos los autores");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            choice = scanner.next();
        
            switch(choice){
                case "1":
                    autorServicio.imprimirAutorPorParametro("id");
                    break;
                case "2":
                    autorServicio.imprimirAutorPorParametro("nombre");
                    break;
                case "3":
                    autorServicio.imprimirAutores();
                    break;
                case "0":
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (!choice.equals("0"));
    }
    
    public void cargarSubMenuCliente(){
        String choice;
        
        do{
            System.out.println("1. Buscar cliente por ID");
            System.out.println("2. Buscar cliente por documento");
            System.out.println("3. Buscar cliente/s por nombre");
            System.out.println("4. Buscar cliente/s por apellido");
            System.out.println("5. Buscar cliente por telefono");
            System.out.println("6. Listar todos los clientes");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            choice = scanner.next();
        
            switch(choice){
                case "1":
                    clienteServicio.imprimirClientePorParametro("id");
                    break;
                case "2":
                    clienteServicio.imprimirClientePorParametro("documento");
                    break;
                case "3":
                    clienteServicio.imprimirClientePorParametro("nombre");
                    break;
                case "4":
                    clienteServicio.imprimirClientePorParametro("apellido");
                    break;
                case "5":
                    clienteServicio.imprimirClientePorParametro("telefono");
                    break;  
                case "6":
                    clienteServicio.imprimirClientes();
                    break;    
                case "0":
                    System.out.println("Regresando al menu anterior...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (!choice.equals("0"));
    }
    
    public void cargarSubMenuPrestamo(){
        String choice;
        
        do{
            System.out.println("1. Buscar prestamo por ID");
            System.out.println("2. Buscar prestamo/s por nombre de cliente");
            System.out.println("3. Listar todos los prestamos");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            choice = scanner.next();
        
            switch(choice){
                case "1":
                    prestamoServicio.imprimirPrestamoPorId();
                    break;
                case "2":
                    prestamoServicio.imprimirPrestamoPorObjeto("cliente", "nombre");
                    break; 
                case "3":
                    prestamoServicio.imprimirPrestamos();
                    break; 
                case "0":
                    System.out.println("Regresando al menu anterior...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (!choice.equals("0"));
    }
    
    public void cargarSubMenuEditorial(){
        String choice;
        
        do{
            System.out.println("1. Buscar editorial por ID");
            System.out.println("2. Buscar editorial por nombre");
            System.out.println("3. Listar todos las editoriales");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            choice = scanner.next();
        
            switch(choice){
                case "1":
                    editorialServicio.imprimirEditorialPorParametro("id");
                    break;
                case "2":
                    editorialServicio.imprimirEditorialPorParametro("nombre");
                    break;
                case "3":
                    editorialServicio.imprimirEditoriales();
                    break;
                case "0":
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (!choice.equals("0"));
        
        
    }
}
