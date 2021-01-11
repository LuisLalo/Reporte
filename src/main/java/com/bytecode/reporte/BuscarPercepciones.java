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
public class BuscarPercepciones {
    
    public ArrayList<Percepciones> buscarPercepciones(String uuid, String directorioOrigen){
        ArrayList<Percepciones> listaPercepciones = new ArrayList<Percepciones>();
        String percepciones = "";
        String archivo = uuid.concat(".xml");
        int numI = 0;
	int numF = 0;
        int contador = 0;
        Percepciones percepcion = new Percepciones();
        System.out.println("ENTRADA A METODO BUSCAR PERCEPCIONES");
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
                if(curItem.contains("<nomina12:Percepcion Importe")) {
                    System.out.println("Si se encontró el texto <nomina12:Percepcion Importe");
                    encontrado = true;
                    contador++;
                    System.out.println("Contador: " + contador);
                    percepcion = cantidadPercepciones(curItem);
                    listaPercepciones.add(percepcion);
                    System.out.println("String percepcion: " + percepcion);
                    System.out.println("String listaPercepcion: " + listaPercepciones);
		}
                
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return listaPercepciones;
    }
    
    public Percepciones cantidadPercepciones(String percepciones) {
        Percepciones percepcion = new Percepciones();
        int contador = 0;
        String textoBuscado = "<nomina12:Percepcion Importe";
        String importeExento;
        String importeGravado;
        String concepto;
        String clave;
        String tipoPercepcion;
        int pos = 0;
        int posUno = 0;
        boolean encontrado = false;
        boolean encontradoUno = false;
        int numI = 0;
        int numF = 0;
        System.out.println("String percepciones prueba: " + percepciones);
        //se busca la primera vez que aparece
        while(percepciones.contains(textoBuscado)) {
            importeExento = "";
            importeGravado = "";
            concepto = "";
            clave = "";
            tipoPercepcion = "";
	    percepciones = percepciones.substring(percepciones.indexOf(textoBuscado)+textoBuscado.length(),percepciones.length());
            
	    //System.out.println("String deducciones: " + deducciones);
            pos=pos+1;
            if((percepciones.contains("/>")) || (percepciones.contains(">"))){
                System.out.println("Si se encontró la linea />");
                encontrado = true;
            }// validación para identificar el elemento de Horas Extra

            if(encontrado == false){
                pos = 0;
            }

            System.out.println("Valor pos: " + pos);
            if(pos != 0) {
                if(percepciones.contains("/>")) {
                    int num = percepciones.indexOf("/>");
                    System.out.println("Valor num />: " + num);
                    numF = num;
                }
                else {
                    if(percepciones.contains(">")) {
                        int num = percepciones.indexOf(">");
                        System.out.println("Valor num />: " + num);
                        numF = num;
                    }
                }
                
            }
            else {
                    System.out.println("No encontrado />");
            }
            
            String linea = percepciones.substring(numI, numF);
            System.out.println("String linea: " + linea);
            // Se crea el objeto para obtener cada uno de las partes que integran la deducci{on
            LecturaXml lx = new LecturaXml();
            importeExento = lx.importeExentoPercepciones(linea);
            System.out.println("String importeExento: " + importeExento);
            importeGravado = lx.importeGravadoPercepciones(linea);
            System.out.println("String importeGravado: " + importeGravado);
            concepto = lx.conceptoPercepciones(linea);
            System.out.println("String concepto: " + concepto);
            clave = lx.clavePercepciones(linea);
            System.out.println("String clave: " + clave);
            tipoPercepcion = lx.tipoPercepcion(linea);
            System.out.println("String tipoPercepcion: " + tipoPercepcion);
            percepcion.setImporteExento(importeExento);
            percepcion.setImporteGravado(importeGravado);
            percepcion.setConcepto(concepto);
            percepcion.setClave(clave);
            percepcion.setTipoPercepcion(tipoPercepcion);
            System.out.println("Contador: " + contador);
            System.out.println("Objeto percepcion: " + percepcion);
            contador++;
	    }
        //System.out.println("Contador deducciones: " + contador);
        return percepcion;
    }
}
