/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDAO;
import libreria.utilidades.Utilidades;

/**
 *
 * @author Taddeu's
 */
public class ClienteServicio {

    private ClienteDAO dao;
    private Scanner sc = new Scanner(System.in, "UTF-8").useDelimiter("\n");

    public ClienteServicio() {
        this.dao = new ClienteDAO();
    }

    public void crearCliente() {
        System.out.println("Ingrese el número de documento del cliente:");
        String documento = sc.next();

        System.out.println("Ingrese el nombre del cliente:");
        String nombre = sc.next();

        System.out.println("Ingrese el apellido del cliente:");
        String apellido = sc.next();

        System.out.println("Ingrese el teléfono del cliente:");
        String telefono = sc.next();

        try {
            Cliente cliente = new Cliente(Long.parseLong(documento), nombre, apellido, telefono);
            dao.guardarCliente(cliente);
            System.out.println("Cliente creado exitosamente.");
        } catch (Exception e) {
            System.out.println("Hubo un error al crear el cliente.");
        }
    }

    public void eliminarCliente() {
        try {
            System.out.println("Ingrese el ID:");
            String id = Utilidades.validarInputParametro();

            Cliente cliente = dao.buscarClientePorId(Integer.parseInt(id));

            dao.eliminarCliente(cliente);
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA");
        }
    }

    public void modificarCliente() {
        try {
            System.out.println("Ingrese el ID:");
            String id = Utilidades.validarInputParametro();

            Cliente cliente = dao.buscarClientePorId(Integer.parseInt(id));
            if (cliente == null) {
                throw new Exception("Cliente invalido o no existe");
            }

            String choice;

            do {
                System.out.println("Datos disponibles a modificar:");
                System.out.println("1. Documento");
                System.out.println("2. Nombre");
                System.out.println("3. Apellido");
                System.out.println("4. Telefono");
                System.out.println("0. Volver");
                choice = sc.next();

                switch (choice) {
                    case "1":
                        System.out.print("Documento actual: " + cliente.getDocumento());
                        System.out.print("Ingrese el nuevo documento:");
                        String documento = sc.next();

                        if (documento != null || documento.trim().isEmpty()) {
                            throw new Exception("El nuevo documento esta vacio o es invalido, volviendo al menu anterior...");
                        }

                        cliente.setDocumento(Long.parseLong(documento));

                        System.out.println("Cliente ID#" + cliente.getId() + " modificado con exito!");
                        break;
                    case "2":
                        System.out.print("Nombre actual: " + cliente.getNombre());
                        System.out.print("Ingrese el nuevo nombre:");
                        String nombre = sc.next();

                        if (nombre != null || nombre.trim().isEmpty()) {
                            throw new Exception("El nuevo nombre esta vacio o es invalido, volviendo al menu anterior...");
                        }

                        cliente.setNombre(nombre);

                        System.out.println("Cliente ID#" + cliente.getId() + " modificado con exito!");
                        break;
                    case "3":
                        System.out.print("Apellido actual: " + cliente.getApellido());
                        System.out.print("Ingrese el nuevo apellido:");
                        String apellido = sc.next();

                        if (apellido != null || apellido.trim().isEmpty()) {
                            throw new Exception("El nuevo apellido esta vacio o es invalido, volviendo al menu anterior...");
                        }

                        cliente.setNombre(apellido);

                        System.out.println("Cliente ID#" + cliente.getId() + " modificado con exito!");
                        break;
                    case "4":
                        System.out.print("Telefono actual: " + cliente.getTelefono());
                        System.out.print("Ingrese el nuevo telefono:");
                        String tel = sc.next();

                        if (tel != null || tel.trim().isEmpty()) {
                            throw new Exception("El nuevo apellido esta vacio o es invalido, volviendo al menu anterior...");
                        }

                        cliente.setTelefono(tel);

                        System.out.println("Cliente ID#" + cliente.getId() + " modificado con exito!");
                        break;
                    case "0":
                        System.out.println("Volviendo al menu anterior");
                    default:
                        System.out.println("Opcion invalida, vuelva a intentar");
                }
            } while (!choice.equals("0"));

            dao.modificarCliente(cliente);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public Cliente buscarClientePorId(Integer id) {
        try {
            Cliente cliente = dao.buscarClientePorId(id);
            return cliente;
        } catch (Exception e) {
            System.out.println("No existe tal cliente");
            return null;
        }
    }
    
    public Cliente buscarClientePorParametro(String parametro) {
        try {

            System.out.print("Ingrese el " + parametro + " del cliente:");
            String valorParametro = Utilidades.validarInputParametro();

            Cliente cliente = dao.buscarClientePorParametro(parametro, valorParametro);

            return cliente;
        } catch (Exception e) {
            System.out.println("ERROR SISTEMA");
            return null;
        }
    }

    private Collection<Cliente> listarClientes() {
        try {
            Collection<Cliente> clientes = dao.listarClientes();

            return clientes;
        } catch (Exception e) {
            System.out.println("NO hay clientes");
            return null;
        }
    }

    //TODO Metodos
    public void imprimirClientes() {
        try {
            Collection<Cliente> clientes = listarClientes();

            if (clientes.isEmpty()) {
                System.out.println("No hay clientes registrados en la base");
            } else {
                for (Cliente a : clientes) {
                    System.out.println(a);
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR DE SISTEMA");
        }
    }

    public void imprimirClientePorParametro(String parametro){
        try {
            Cliente cliente = buscarClientePorParametro(parametro);
            
            if(cliente == null) throw new Exception("Cliente invalido o no existe, vuelva a intentar.");
            
            System.out.println(cliente);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
