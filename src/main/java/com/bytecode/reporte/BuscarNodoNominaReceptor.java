/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.reporte;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Luis Lalo
 */
public class BuscarNodoNominaReceptor {
    public String nominaReceptor (String uuid, String directorioOrigen){
        String resultado = "";
        String archivo = uuid.concat(".xml");
        int numI = 0;
	int numF = 0;
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            boolean encontradoUno = false;
            Iterator<String> iter = linea.iterator();
            Iterator<String> iterUno = linea.iterator();
            String curItem = "";
            String curItemUno = "";
            String curItemReceptor = "";
            int pos = 0;
            int posUno = 0;
            
            // Se busca cfdi:Receptor
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("<nomina12:Receptor SalarioDiarioIntegrado=")) {
                    System.out.println("Si se encontró el texto <nomina12:Receptor SalarioDiarioIntegrado=");
                    encontrado = true;
                    break;
		}
            }
            // Se busca /cfdi:Receptor
            while(iterUno.hasNext()==true) {
                posUno=posUno+1;
                curItemUno = (String)iterUno.next();
                if(curItemUno.contains(">")) {
                    System.out.println("Si se encontró el texto >");
                    encontradoUno = true;
                    break;
		}
            }
            
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("<nomina12:Receptor SalarioDiarioIntegrado=");
		numI = num;
                
		System.out.println("Int num: " + num);
                System.out.println("Int numI: " + numI);
		//nombre = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
            if(encontradoUno == false) {
		posUno = 0;
            }
            if(posUno != 0) {
		int num = curItem.indexOf(">");
		numF = num + 1;
                System.out.println("Int numI: " + numI);
                System.out.println("Int numF: " + numF);
		resultado = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
            System.out.println("String: " + resultado);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
