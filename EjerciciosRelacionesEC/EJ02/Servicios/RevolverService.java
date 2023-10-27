package EJ02.Servicios;

import EJ02.Entidades.RevolverDeAgua;

public class RevolverService {
    private RevolverDeAgua revolver;

    public RevolverService() {
        this.revolver = new RevolverDeAgua();
    }

    public void llenarRevolver(){
        revolver.setPosActual((int) (Math.random()*6));
        revolver.setPosAgua((int) (Math.random()*6));
    }

    public boolean mojar(){
        return revolver.getPosActual() == revolver.getPosAgua();
    }

    public void siguienteChorro(){
        if(revolver.getPosActual() == 5) {
            revolver.setPosActual(0);
        } else {
            revolver.setPosActual(revolver.getPosActual()+1);
        }
    }

    @Override
    public String toString() {
        return "--------RevolverDeAgua--------\n" +
                "Posicion Actual: " + revolver.getPosActual() + "\n" +
                "Posicion de Agua: " + revolver.getPosAgua() ;
    }
    
}
