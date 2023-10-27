package EJ04;

public class Main {
    public static void main(String[] args) {
        PeliculaService plSrv = new PeliculaService();

        plSrv.registrarPelicula();
        plSrv.mostrarPeliculas();
        //plSrv.mostrarMayorQue(1);
        plSrv.ordenarPorDuracionDesc();
        plSrv.ordenarPorDuracionAsc();
        plSrv.ordenarTitulosAlfab();
        plSrv.ordenarDirectorAlfab();
    }
}

