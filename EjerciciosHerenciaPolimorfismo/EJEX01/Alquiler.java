package EJEX01;

import java.time.LocalDate;
import java.util.Scanner;

public class Alquiler {
    private String nombre;
    private String documento;
    private LocalDate fechaInicioAlquiler;
    private LocalDate fechaFinAlquiler;
    private boolean posicionAmarre;
    private VehiculoAcuatico barcoEnUso;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Alquiler() {
    }

    public Alquiler(String nombre, String documento, LocalDate fechaInicioAlquiler, LocalDate fechaFinAlquiler, boolean posicion, VehiculoAcuatico barcoEnUso) {
        this.nombre = nombre;
        this.documento = documento;
        this.fechaInicioAlquiler = fechaInicioAlquiler;
        this.fechaFinAlquiler = fechaFinAlquiler;
        this.posicionAmarre = posicion;
        this.barcoEnUso = barcoEnUso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getFechaInicioAlquiler() {
        return fechaInicioAlquiler;
    }

    public void setFechaInicioAlquiler(LocalDate fechaInicioAlquiler) {
        this.fechaInicioAlquiler = fechaInicioAlquiler;
    }

    public LocalDate getFechaFinAlquiler() {
        return fechaFinAlquiler;
    }

    public void setFechaFinAlquiler(LocalDate fechaFinAlquiler) {
        this.fechaFinAlquiler = fechaFinAlquiler;
    }

    public boolean getPosicion() {
        return posicionAmarre;
    }

    public void setPosicion(boolean posicion) {
        this.posicionAmarre = posicion;
    }

    public VehiculoAcuatico getBarcoEnUso() {
        return barcoEnUso;
    }

    public void setBarcoEnUso(VehiculoAcuatico barcoEnUso) {
        this.barcoEnUso = barcoEnUso;
    }

    public void crearAlquiler(){
        System.out.println("Ingrese el nombre del cliente:");
        this.nombre = leer.next();

        System.out.println("Ingrese el documento del cliente:");
        this.documento = leer.next();

        System.out.println("Ingrese la fecha de inicio del alquiler (AAAA-MM-DD):");
        int anioInicio = leer.nextInt();
        int mesInicio = leer.nextInt();
        int diaInicio = leer.nextInt();
        this.fechaInicioAlquiler = LocalDate.of(anioInicio,mesInicio,diaInicio);

        System.out.println("Ingrese la fecha de fin del alquiler (AAAA-MM-DD):");
        int anioFin = leer.nextInt();
        int mesFin = leer.nextInt();
        int diaFin = leer.nextInt();
        this.fechaFinAlquiler = LocalDate.of(anioFin,mesFin,diaFin);

        System.out.println("Esta amarrado? (S/N):");
        char answer = leer.next().charAt(0);
        while(true){
            if(answer == 's' || answer == 'n'){
                break;
            } else {
                answer = leer.next().charAt(0);
            }
        }
        switch (answer) {
            case 's':
                this.posicionAmarre = true;
                break;
            case 'n':
                this.posicionAmarre = false;
                break;
            default:
                break;
        }

        System.out.println("Ingrese el tipo de barco que desea alquilar(Velero/Bote/Yate)");
        String tipoBote = leer.next().toLowerCase();
        while(true){
            if(tipoBote.equals("velero") || tipoBote.equals("bote") || tipoBote.equals("yate")){
                break;
            } else {
                System.out.println("Ha ingresado una opcion incorrecta, intente nuevamente:");
                tipoBote = leer.next();
            }
        }

        this.barcoEnUso = crearBote(tipoBote);
    }

    public void precioAlquiler(){
        long diasDeOcupacion = fechaFinAlquiler.toEpochDay() - fechaInicioAlquiler.toEpochDay();

        System.out.println("El precio del alquiler seria un total de $" + diasDeOcupacion * barcoEnUso.calcularModulo());
    }

    public VehiculoAcuatico crearBote(String tipoBote){
        System.out.println("Ingrese la matricula del velero:");
        String matric = leer.next();
        System.out.println("Ingrese los metros de slora:");
        double slo = leer.nextDouble();
        System.out.println("Ingrese el año de fabricacion:");
        String anioFab = leer.next();

        if(tipoBote.equals("velero")){
            System.out.println("Ingrese la cantidad de velas:");
            int cantVelas = leer.nextInt();

            return new Velero(matric,slo,anioFab,cantVelas);
        } else if(tipoBote.equals("bote")){
            System.out.println("Ingrese la cantidad de CV:");
            double cantCV = leer.nextInt();

            return new Barco(matric,slo,anioFab,cantCV);
        } else {
            System.out.println("Ingrese la cantidad de CV:");
            double cantCV = leer.nextDouble();
            System.out.println("Ingrese la cantidad de camarotes del yate:");
            int cantCam = leer.nextInt();;

            return new Yate(matric,slo,anioFab,cantCV,cantCam);
        }
    }
}
