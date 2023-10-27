package EJ14_POO;

import java.util.Scanner;

//      14. Una tienda que vende teléfonos móviles quiere tener registro de cada producto que
//        posee en un sistema computacional. Para ello, crearemos un programa donde se pueda
//        almacenar cada producto con su información. Crear una entidad Movil con los atributos
//        marca, precio, modelo, memoriaRam, almacenamiento y codigo. El atributo código será
//        un arreglo numérico de dimensión 7 (siete) donde cada subíndice alojará un número
//        correspondiente al código. A continuación, se implementarán los siguientes métodos:
//         Un constructor por defecto.
//         Un constructor con todos los atributos como parámetro.
//         Métodos getters y setters de cada atributo.
//         Método cargarCelular(): se solicita al usuario que ingrese los datos necesarios para
//        instanciar un objeto Celular y poder cargarlo en nuestro programa.
//         Método ingresarCodigo(): este método permitirá ingresar el código completo de siete
//        números de un celular. Para ello, puede utilizarse un bucle repetitivo
public class Movil {
    private String marca;
    private double precio;
    private String modelo;
    private String memoriaRam;
    private String almacenamiento;
    private int[] codigo = new int[7];
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Movil() {
    }

    public Movil(String marca, double precio, String modelo, String memoriaRam, String almacenamiento) {
        this.marca = marca;
        this.precio = precio;
        this.modelo = modelo;
        this.memoriaRam = memoriaRam;
        this.almacenamiento = almacenamiento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(String memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public void cargarCelular(){

        System.out.println("Ingrese la marca del celular: ");
        setMarca(leer.next());
        System.out.println("Ingrese el modelo de celular: ");
        setModelo(leer.next());
        System.out.println("Ingrese la memoria ram: ");
        setMemoriaRam(leer.next());
        System.out.println("Ingrese el almacenamiento interno: ");
        setAlmacenamiento(leer.next());
        System.out.println("Ingrese el precio: ");
        setPrecio(leer.nextDouble());

        ingresarCodigo();

        System.out.println("Celular cargado con exito!");
    }

    private void ingresarCodigo(){
        int length = codigo.length;

        System.out.println("Ingrese el codigo del celular numero por numero: ");
        for (int i = 0; i < length; i++) {
            this.codigo[i] = leer.nextInt();
        }
    }

    public String toString(){
        return "Marca: " + marca + "\nModelo: " + modelo + "\nMemoria RAM: " + memoriaRam + "GB\nAlmacenamiento: " +
                almacenamiento + "GB\nPrecio: $" + precio;
    }
}
