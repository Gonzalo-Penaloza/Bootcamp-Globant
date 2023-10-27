/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.utilidades;

import java.util.Scanner;

/**
 *
 * @author Taddeu's
 */
public class Utilidades {
    
    public static String validarInputParametro(){
        String valorParametro;
        Scanner sc = new Scanner(System.in, "UTF-8").useDelimiter("\n");
        
        do{
            valorParametro = sc.next();

            if(valorParametro == null || valorParametro.trim().isEmpty()){
                System.out.println("ERROR - El valor ingresado es invalido o esta vacio, intentelo nuevamente");
            } else {
                return valorParametro;
            }       
        } while (true);   
        
    }
}

