/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.reporte;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Luis Lalo
 */
public class BuscarDeducciones {
    
    public ArrayList<Deducciones> buscarDeducciones(String uuid, String directorioOrigen){
        ArrayList<Deducciones> listaDeducciones = new ArrayList<Deducciones>();
        String deducciones = "";
        String archivo = uuid.concat(".xml");
        int numI = 0;
	int numF = 0;
        int contador = 0;
        Deducciones deduccion = new Deducciones();
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            //linea = linea.replaceAll("\n", "");
            //System.out.println("Linea: " + linea);
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            //System.out.println("iter: " + iter.toString());
            Iterator<String> iterUno = linea.iterator();
            String curItem = "";
            String curItemUno = "";
            int pos = 0;
            int posUno = 0;
            
            // Se busca cfdi:Receptor
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                //System.out.println("curItem: " + curItem);
                if(curItem.contains("<nomina12:Deduccion Importe=")) {
                    System.out.println("Si se encontró el texto <nomina12:Deduccion Importe=");
                    encontrado = true;
                    contador++;
                    System.out.println("Contador: " + contador);
                    deduccion = cantidadDeducciones(curItem);
                    listaDeducciones.add(deduccion);
                    //System.out.println("String deduccion: " + deduccion);
                    //System.out.println("String listaDeduccion: " + listaDeducciones);
		}
                
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return listaDeducciones;
    }
    
    public Deducciones cantidadDeducciones(String deducciones) {
        
        Deducciones deduccion = new Deducciones();
        int contador = 0;
        String textoBuscado = "<nomina12:Deduccion Importe=";
        String importe;
        String concepto;
        String clave;
        String tipoDeduccion;
        int pos = 0;
        boolean encontrado = false;
        int numI = 0;
        int numF = 0;
        
        //se busca la primera vez que aparece
        while(deducciones.contains(textoBuscado)) {
            importe = "";
            concepto = "";
            clave = "";
            tipoDeduccion = "";
	    deducciones = deducciones.substring(deducciones.indexOf(textoBuscado)+textoBuscado.length(),deducciones.length());
            
	    //System.out.println("String deducciones: " + deducciones);
            pos=pos+1;
            if(deducciones.contains("/>")){
                System.out.println("Si se encontró la linea />");
                encontrado = true;
            }
            if(encontrado == false){
                pos = 0;
            }
            System.out.println("Valor pos: " + pos);
            if(pos != 0) {
                int num = deducciones.indexOf("/>");
                System.out.println("Valor num: " + num);
                numF = num;
            }
            else {
                    System.out.println("No encontrado />");
            }
            String linea = deducciones.substring(numI+1, numF);
            //System.out.println("String linea: " + linea);
            // Se crea el objeto para obtener cada uno de las partes que integran la deducci{on
            LecturaXml lx = new LecturaXml();
            importe = lx.importeDeducciones(linea);
            //System.out.println("String importe: " + importe);
            concepto = lx.conceptoDeducciones(linea);
            //System.out.println("String concepto: " + concepto);
            clave = lx.claveDeducciones(linea);
            //System.out.println("String clave: " + clave);
            tipoDeduccion = lx.tipoDeduccion(linea);
            //System.out.println("String tipoDeduccion: " + tipoDeduccion);
            deduccion.setImporte(importe);
            deduccion.setConcepto(concepto);
            deduccion.setClave(clave);
            deduccion.setTipoDeduccion(tipoDeduccion);
            //System.out.println("Contador: " + contador);
            //System.out.println("Objeto deduccion: " + deduccion);
            contador++;
	    }
        //System.out.println("Contador deducciones: " + contador);
        return deduccion;
    }
}
