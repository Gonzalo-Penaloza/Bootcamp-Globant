package EJ04.Entidad;

public class Perro {
    private int id;
    private String nombre;
    private int edad;
    private String raza;
    private double tamanio;

    public Perro() {
    }

    public Perro(int id, String nombre, int edad, String raza, double tamanio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.tamanio = tamanio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return  "ID: " + id  + '\n' +
                "Nombre: " + nombre + '\n' +
                "Edad: " + edad + '\n' +
                "Raza: " + raza + '\n' +
                "Tamaño: " + tamanio;
    }
}
