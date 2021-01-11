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
public class SumatoriaPercepciones {
    
    // Se obtiene la sumatoria de las percepciones
    public double sumatoriaPercepciones(ArrayList<Percepciones>listaPercepciones) {
        double percibido = 0.00, cantidad = 0.00;
        int contador = 0;
        
        while(contador < listaPercepciones.size()) {
            if(!"029".equals(listaPercepciones.get(contador).getTipoPercepcion())) {
                String importeExento = listaPercepciones.get(contador).getImporteExento();
                String importeGravado = listaPercepciones.get(contador).getImporteGravado();
                cantidad = Double.parseDouble(importeExento) + Double.parseDouble(importeGravado);
                percibido = percibido + cantidad;
            }

            contador++;
        }
        //System.out.println("Percibido: " + percibido);
        percibido = Math.round(percibido * 100) / 100d;
        //System.out.println("Percibido: " + percibido);
        return percibido;
    }
    
    // Se obtiene el valor de los vales
    public double vales(ArrayList<Percepciones>listaPercepciones) {
        double vales = 0.00, cantidad = 0.00;
        int contador = 0;
        
        while(contador < listaPercepciones.size()) {
            if(listaPercepciones.get(contador).getTipoPercepcion().equals("029")) {
                String valesExento = listaPercepciones.get(contador).getImporteExento();
                String valesGravado = listaPercepciones.get(contador).getImporteGravado();
                cantidad = Double.parseDouble(valesExento) + Double.parseDouble(valesGravado);
                vales = vales + cantidad;
            }
            contador++;
        }
        //System.out.println("Percibido vales: " + vales);
        vales = Math.round(vales * 100) / 100d;
        //System.out.println("Percibido vales: " + vales);
        
        return vales;
    }
    
    // Se obtiene el método para sumar los importes de las percepciones exentas y gravadas
    public ArrayList<String> sumaPercepcionesExentoGravado(ArrayList<Percepciones>listaPercepciones){
        ArrayList<String> sumaPercepcion = new ArrayList<String>();
        double cantidad = 0.00;
        int contador = 0;
        
        while(contador < listaPercepciones.size()) {
            String importeExento = listaPercepciones.get(contador).getImporteExento();
            String importeGravado = listaPercepciones.get(contador).getImporteGravado();
            cantidad = Double.parseDouble(importeExento) + Double.parseDouble(importeGravado);
            cantidad = Math.round(cantidad * 100) / 100d;
            System.out.println("Cantidad sumada: " + cantidad);
            sumaPercepcion.add(Double.toString(cantidad));
            contador++;
        }
        return sumaPercepcion;
    }
}