/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import libreria.servicios.MenuServicio;

/**
 *
 * @author Taddeu's
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MenuServicio menuServicio = new MenuServicio();
        menuServicio.showMenu();
    }
    
}
