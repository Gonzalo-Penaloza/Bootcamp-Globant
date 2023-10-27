package EJ01.Entidades;

import EJ01.Entidades.Perro;

public class Persona {
    private String nombre;
    private String apellido;
    private String documento;
    private Perro perro;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.perro = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    @Override
    public String toString() {

        if(perro != null){
            return "Persona{" +
                    "Nombre: " + nombre + '\'' +
                    ", Apellido: " + apellido + '\'' +
                    ", Documento: " + documento + '\'' +
                    ", Perro asignado :  " + perro.getNombre();
        } else {
            return "Persona{" +
                    "Nombre: " + nombre + '\'' +
                    ", Apellido: " + apellido + '\'' +
                    ", Documento: " + documento + '\'' +
                    ", Perro asignado : - ";
        }

    }
}
