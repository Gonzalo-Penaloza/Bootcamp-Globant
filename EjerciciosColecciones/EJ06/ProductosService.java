package EJ06;

//      6.Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
//        productos que venderemos y el precio que tendrán. Además, se necesita que la
//        aplicación cuente con las funciones básicas.
//        Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
//        eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
//        Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
//        Realizar un menú para lograr todas las acciones previamente mencionadas.

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ProductosService {
    HashMap<String,Double> listaDeProductos = new HashMap<>();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private boolean isActive = true;

    public void menu(){
        while(isActive){
            System.out.println("Bienvenido al sistema de productos, ingrese la operacion a realizar...");
            System.out.println("1. Registrar productos");
            System.out.println("2. Modificar precio de producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar lista de productos");
            System.out.println("5. Salir");
            int choice = leer.nextInt();
            switch (choice){
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    modificarPrecio();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    mostrarProductos();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema... Hasta la proxima!");
                    isActive = false;
                    break;
            }
        }
    }

    private void registrarProducto(){
        while(true){
            System.out.println("Ingrese el nombre del producto:");
            String nombre = leer.next();

            System.out.println("Ingrese el precio del producto:");
            double precio = leer.nextDouble();

            listaDeProductos.put(nombre,precio);
            System.out.println("Producto registrado con exito!");

            if(!continuar()) return;
        }
    }

    private void modificarPrecio(){
        System.out.println("Ingrese el nombre del producto a modificar precio:");
        String answer = leer.next();

        if(buscarProducto(answer)){
            System.out.println("Ingrese el nuevo precio del producto:");
            Double nuevoPrecio = leer.nextDouble();
            listaDeProductos.replace(answer,nuevoPrecio);
        }
    }

    private void eliminarProducto(){
        System.out.println("Ingrese el nombre del producto a eliminar:");
        String answer = leer.next();

        if(buscarProducto(answer)) listaDeProductos.remove(answer);
    }

    private void mostrarProductos(){
        int cont = 1;

        for (Map.Entry<String, Double> entry : listaDeProductos.entrySet()){
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(cont + ". " + key + " ........ $" + value);
            cont++;
        }
    }

    private boolean buscarProducto(String nombre){
        if(listaDeProductos.containsKey(nombre)) return true;

        System.out.println("El producto no se encuentra registrado en la lista!");
        return false;
    }

    private boolean continuar(){
        while (true) {
            System.out.println("¿Desea guardar otro producto? (S/N)");
            String answer = leer.next();

            if (answer.equalsIgnoreCase("S")) {
                return true; // El usuario desea guardar otro país.
            } else if (answer.equalsIgnoreCase("N")) {
                return false; // El usuario no desea guardar otro país.
            } else {
                System.out.println("Respuesta inválida. Por favor, ingrese 'S' o 'N'.");
            }
        }
    }
}
