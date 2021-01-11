/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.reporte;

import java.util.ArrayList;

/**
 *
 * @author UABC-16653387
 */
public class SumatoriaDeducciones {
    
    // Método para obtener la sumatoria de las deducciones
    public double sumatoriaDeducciones(ArrayList<Deducciones> listaDeducciones){
        double deducido = 0.00, cantidad = 0.00;
        
        int contador = 0;
        
        while(contador < listaDeducciones.size()) {
            String importe = listaDeducciones.get(contador).getImporte();
            cantidad = Double.parseDouble(importe);
            deducido = deducido + cantidad;
            contador++;
        }
        System.out.println("Deducido: " + deducido);
        deducido = Math.round(deducido * 100) / 100d;
        System.out.println("Deducido: " + deducido);
        
        return deducido;
    }
}
