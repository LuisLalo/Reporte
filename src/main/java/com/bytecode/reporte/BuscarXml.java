/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.reporte;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Luis Lalo
 */
public class BuscarXml {
    public boolean buscarRuta(String uuid) throws IOException, SQLException {
        String IMAGE_SRC = uuid.concat("_Cbb.bmp");
        String nombreArchivo = uuid.concat(".xml");
        String directorioOrigen = "C:\\OrigenPdf\\";
        String directorioDestino = "C:\\DestinoPdf\\";
        File folder = new File(directorioOrigen);
	File[] listOfFiles = folder.listFiles();
	//String archivo;
	
	//for (File file : listOfFiles) {
          //  String nombre = file.getName();
            
            //String nombreArchivo = nombre;
            String nombreArchivoGenerado = uuid.concat(".pdf");
            //System.out.println("Nombre obtenido de file: " + nombre);
            //System.out.println("Nombre archivo: " + nombreArchivo);
	    //if (nombreArchivo.equals(nombre)) {
                String pconcepto1 = "", pconcepto2 = "", pconcepto3 = "", pconcepto4 = "", pconcepto5 = "", pconcepto6 = "", pconcepto7 = "", pconcepto8 = "", pconcepto9 = "", pconcepto10 = "", pconcepto11 = "", pconcepto12 = "", pconcepto13 = "", pconcepto14 = "", pconcepto15 = "", pconcepto16 = "", pconcepto17 = "", pconcepto18 = "";
                String pImporte1 = "", pImporte2 = "", pImporte3 = "", pImporte4 = "", pImporte5 = "", pImporte6 = "", pImporte7 = "", pImporte8 = "", pImporte9 = "", pImporte10 = "", pImporte11 = "", pImporte12 = "", pImporte13 = "", pImporte14 = "", pImporte15 = "", pImporte16 = "", pImporte17 = "", pImporte18 = "";
	        String pclave1 = "",  pclave2 = "",  pclave3 = "",  pclave4 = "",  pclave5 = "",  pclave6 = "",  pclave7 = "",  pclave8 = "",  pclave9 = "",  pclave10 = "",  pclave11 = "",  pclave12 = "",  pclave13 = "",  pclave14 = "",  pclave15 = "",  pclave16 = "",  pclave17 = "",  pclave18 = "";
                String pTipoPercepcion1 = "", pTipoPercepcion2 = "", pTipoPercepcion3 = "", pTipoPercepcion4 = "", pTipoPercepcion5 = "", pTipoPercepcion6 = "", pTipoPercepcion7 = "", pTipoPercepcion8 = "", pTipoPercepcion9 = "", pTipoPercepcion10 = "", pTipoPercepcion11 = "", pTipoPercepcion12 = "", pTipoPercepcion13 = "", pTipoPercepcion14 = "", pTipoPercepcion15 = "", pTipoPercepcion16 = "", pTipoPercepcion17 = "", pTipoPercepcion18 = "";
                
                String dimporte1 = "", dimporte2 = "", dimporte3 = "", dimporte4 = "", dimporte5 = "", dimporte6 = "", dimporte7 = "", dimporte8 = "", dimporte9 = "", dimporte10 = "", dimporte11 = "", dimporte12 = "", dimporte13 = "", dimporte14 = "", dimporte15 = "", dimporte16 = "", dimporte17 = "", dimporte18 = ""; 
                String dconcepto1 = "", dconcepto2 = "", dconcepto3 = "", dconcepto4 = "", dconcepto5 = "", dconcepto6 = "", dconcepto7 = "", dconcepto8 = "", dconcepto9 = "", dconcepto10 = "", dconcepto11 = "", dconcepto12 = "", dconcepto13 = "", dconcepto14 = "", dconcepto15 = "", dconcepto16 = "", dconcepto17 = "", dconcepto18 = "";
                String dclave1 = "", dclave2 = "", dclave3 = "", dclave4 = "", dclave5 = "", dclave6 = "", dclave7 = "", dclave8 = "", dclave9 = "", dclave10 = "", dclave11 = "", dclave12 = "", dclave13 = "", dclave14 = "", dclave15 = "", dclave16 = "", dclave17 = "", dclave18 = "";
                String dTipoDediccion1 = "", dTipoDediccion2 = "", dTipoDediccion3 = "",dTipoDediccion4 = "", dTipoDediccion5 = "", dTipoDediccion6 = "", dTipoDediccion7 = "", dTipoDediccion8 = "", dTipoDediccion9 = "", dTipoDediccion10 = "", dTipoDediccion11 = "", dTipoDediccion12 = "", dTipoDediccion13 = "", dTipoDediccion14 = "", dTipoDediccion15 = "", dTipoDediccion16 = "", dTipoDediccion17 = "", dTipoDediccion18 = "";
                
                String total = "", deposito = "", percibido = "", deducido = "", vales = "";
                //System.out.println(file.getName());
	        //nombreArchivo = file.getName();
                // El archivo se encontró en la carpeta
                //System.out.println("El archivo si se encontró en la carpeta");
                // Se crea el objeto para leer el xml
	        LecturaXml lx = new LecturaXml();
	        String empleado = lx.empleado(uuid, directorioOrigen);
		//System.out.println("Empleado: " + empleado);
                // Se busca el nodo receptor para obtener el nombre y rfc del empleado
                BuscarNodoReceptor bnr = new BuscarNodoReceptor();
                String linea = bnr.receptor(uuid, directorioOrigen);
                String nombreEmpleado = lx.nombre(linea);
                String rfc = lx.rfc(linea);
                String curp = lx.curp(uuid, directorioOrigen);
                //System.out.println("Curp: " + curp);
                String nss = lx.nss(uuid, directorioOrigen);
                //System.out.println("NSS: " + nss);
                BuscarNodoNominaReceptor bnnr = new BuscarNodoNominaReceptor();
                String nominaReceptor = bnnr.nominaReceptor(uuid, directorioOrigen);
                String departamento = lx.departamento(nominaReceptor);
                //System.out.println("Departamento: " + departamento);
                String fechaPago = lx.fechaPago(uuid, directorioOrigen);
                //System.out.println("FechaPago: " + fechaPago);
                String fechaInicialPago = lx.fechaInicialPago(uuid, directorioOrigen);
                //System.out.println("FechaInicialPago: " + fechaInicialPago);
                String fechaFinalPago = lx.fechaFinalPago(uuid, directorioOrigen);
                //System.out.println("FechaFinalPago: " + fechaFinalPago);
                String numDiasPagados = lx.numDiasPagados(uuid, directorioOrigen);
                //System.out.println("NumDiasPagados: " + numDiasPagados);
                String periodicidadPago = lx.periodicidadPago(uuid, directorioOrigen);
                //System.out.println("PeriodicidadPago: " + periodicidadPago);
                // Método falta pulirlo para incluir los salarios de mas de mil pesos
                String salarioDiarioIntegrado = lx.salarioDiarioIntegrado(uuid, directorioOrigen);
                //System.out.println("SalarioDiarioIntegrado: " + salarioDiarioIntegrado);
                String noCatorcena = lx.noCatorcena(fechaFinalPago);
                //System.out.println("NoCatorcena: " + noCatorcena);
                String metodoPago = lx.metodoPago(uuid, directorioOrigen);
                //System.out.println("MetodoPago: " + metodoPago);
                String moneda = lx.moneda(uuid, directorioOrigen);
                //System.out.println("Moneda: " + moneda);
                //Percepciones
                BuscarPercepciones bp = new BuscarPercepciones();
                ArrayList<Percepciones> listaPercepciones = bp.buscarPercepciones(uuid, directorioOrigen);
                System.out.println("Array listaPercepciones: " + listaPercepciones);
                
                SumatoriaPercepciones sm = new SumatoriaPercepciones();
                ArrayList<String> sumaPercepcion = sm.sumaPercepcionesExentoGravado(listaPercepciones);
                int tPercepciones = listaPercepciones.size();
                                
                if (tPercepciones == 1){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                }
                
                if (tPercepciones == 2){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                }
                
                if (tPercepciones == 3){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                }
                
                if (tPercepciones == 4){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                }
                
                if (tPercepciones == 5){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                }
                
                if (tPercepciones == 6){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                }
                
                if (tPercepciones == 7){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                }
                
                if (tPercepciones == 8){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                    
                    pImporte8 = sumaPercepcion.get(7);
                    pconcepto8 = listaPercepciones.get(7).getConcepto();
                    pclave8 = listaPercepciones.get(7).getClave();
                    pTipoPercepcion8 = listaPercepciones.get(7).getTipoPercepcion();
                }
                
                if (tPercepciones == 9){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                    
                    pImporte8 = sumaPercepcion.get(7);
                    pconcepto8 = listaPercepciones.get(7).getConcepto();
                    pclave8 = listaPercepciones.get(7).getClave();
                    pTipoPercepcion8 = listaPercepciones.get(7).getTipoPercepcion();
                    
                    pImporte9 = sumaPercepcion.get(8);
                    pconcepto9 = listaPercepciones.get(8).getConcepto();
                    pclave9 = listaPercepciones.get(8).getClave();
                    pTipoPercepcion9 = listaPercepciones.get(8).getTipoPercepcion();
                }
                
                if (tPercepciones == 10){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                    
                    pImporte8 = sumaPercepcion.get(7);
                    pconcepto8 = listaPercepciones.get(7).getConcepto();
                    pclave8 = listaPercepciones.get(7).getClave();
                    pTipoPercepcion8 = listaPercepciones.get(7).getTipoPercepcion();
                    
                    pImporte9 = sumaPercepcion.get(8);
                    pconcepto9 = listaPercepciones.get(8).getConcepto();
                    pclave9 = listaPercepciones.get(8).getClave();
                    pTipoPercepcion9 = listaPercepciones.get(8).getTipoPercepcion();
                    
                    pImporte10 = sumaPercepcion.get(9);
                    pconcepto10 = listaPercepciones.get(9).getConcepto();
                    pclave10 = listaPercepciones.get(9).getClave();
                    pTipoPercepcion10 = listaPercepciones.get(9).getTipoPercepcion();
                }
                
                if (tPercepciones == 11){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                    
                    pImporte8 = sumaPercepcion.get(7);
                    pconcepto8 = listaPercepciones.get(7).getConcepto();
                    pclave8 = listaPercepciones.get(7).getClave();
                    pTipoPercepcion8 = listaPercepciones.get(7).getTipoPercepcion();
                    
                    pImporte9 = sumaPercepcion.get(8);
                    pconcepto9 = listaPercepciones.get(8).getConcepto();
                    pclave9 = listaPercepciones.get(8).getClave();
                    pTipoPercepcion9 = listaPercepciones.get(8).getTipoPercepcion();
                    
                    pImporte10 = sumaPercepcion.get(9);
                    pconcepto10 = listaPercepciones.get(9).getConcepto();
                    pclave10 = listaPercepciones.get(9).getClave();
                    pTipoPercepcion10 = listaPercepciones.get(9).getTipoPercepcion();
                    
                    pImporte11 = sumaPercepcion.get(10);
                    pconcepto11 = listaPercepciones.get(10).getConcepto();
                    pclave11 = listaPercepciones.get(10).getClave();
                    pTipoPercepcion11 = listaPercepciones.get(10).getTipoPercepcion();
                }
                if (tPercepciones == 12){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                    
                    pImporte8 = sumaPercepcion.get(7);
                    pconcepto8 = listaPercepciones.get(7).getConcepto();
                    pclave8 = listaPercepciones.get(7).getClave();
                    pTipoPercepcion8 = listaPercepciones.get(7).getTipoPercepcion();
                    
                    pImporte9 = sumaPercepcion.get(8);
                    pconcepto9 = listaPercepciones.get(8).getConcepto();
                    pclave9 = listaPercepciones.get(8).getClave();
                    pTipoPercepcion9 = listaPercepciones.get(8).getTipoPercepcion();
                    
                    pImporte10 = sumaPercepcion.get(9);
                    pconcepto10 = listaPercepciones.get(9).getConcepto();
                    pclave10 = listaPercepciones.get(9).getClave();
                    pTipoPercepcion10 = listaPercepciones.get(9).getTipoPercepcion();
                    
                    pImporte11 = sumaPercepcion.get(10);
                    pconcepto11 = listaPercepciones.get(10).getConcepto();
                    pclave11 = listaPercepciones.get(10).getClave();
                    pTipoPercepcion11 = listaPercepciones.get(10).getTipoPercepcion();
                    
                    pImporte12 = sumaPercepcion.get(11);
                    pconcepto12 = listaPercepciones.get(11).getConcepto();
                    pclave12 = listaPercepciones.get(11).getClave();
                    pTipoPercepcion12 = listaPercepciones.get(11).getTipoPercepcion();
                    
                }
                if (tPercepciones == 13){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                    
                    pImporte8 = sumaPercepcion.get(7);
                    pconcepto8 = listaPercepciones.get(7).getConcepto();
                    pclave8 = listaPercepciones.get(7).getClave();
                    pTipoPercepcion8 = listaPercepciones.get(7).getTipoPercepcion();
                    
                    pImporte9 = sumaPercepcion.get(8);
                    pconcepto9 = listaPercepciones.get(8).getConcepto();
                    pclave9 = listaPercepciones.get(8).getClave();
                    pTipoPercepcion9 = listaPercepciones.get(8).getTipoPercepcion();
                    
                    pImporte10 = sumaPercepcion.get(9);
                    pconcepto10 = listaPercepciones.get(9).getConcepto();
                    pclave10 = listaPercepciones.get(9).getClave();
                    pTipoPercepcion10 = listaPercepciones.get(9).getTipoPercepcion();
                    
                    pImporte11 = sumaPercepcion.get(10);
                    pconcepto11 = listaPercepciones.get(10).getConcepto();
                    pclave11 = listaPercepciones.get(10).getClave();
                    pTipoPercepcion11 = listaPercepciones.get(10).getTipoPercepcion();
                    
                    pImporte12 = sumaPercepcion.get(11);
                    pconcepto12 = listaPercepciones.get(11).getConcepto();
                    pclave12 = listaPercepciones.get(11).getClave();
                    pTipoPercepcion12 = listaPercepciones.get(11).getTipoPercepcion();
                    
                    pImporte13 = sumaPercepcion.get(12);
                    pconcepto13 = listaPercepciones.get(12).getConcepto();
                    pclave13 = listaPercepciones.get(12).getClave();
                    pTipoPercepcion13 = listaPercepciones.get(12).getTipoPercepcion();
                }
                
                if (tPercepciones == 14){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                    
                    pImporte8 = sumaPercepcion.get(7);
                    pconcepto8 = listaPercepciones.get(7).getConcepto();
                    pclave8 = listaPercepciones.get(7).getClave();
                    pTipoPercepcion8 = listaPercepciones.get(7).getTipoPercepcion();
                    
                    pImporte9 = sumaPercepcion.get(8);
                    pconcepto9 = listaPercepciones.get(8).getConcepto();
                    pclave9 = listaPercepciones.get(8).getClave();
                    pTipoPercepcion9 = listaPercepciones.get(8).getTipoPercepcion();
                    
                    pImporte10 = sumaPercepcion.get(9);
                    pconcepto10 = listaPercepciones.get(9).getConcepto();
                    pclave10 = listaPercepciones.get(9).getClave();
                    pTipoPercepcion10 = listaPercepciones.get(9).getTipoPercepcion();
                    
                    pImporte11 = sumaPercepcion.get(10);
                    pconcepto11 = listaPercepciones.get(10).getConcepto();
                    pclave11 = listaPercepciones.get(10).getClave();
                    pTipoPercepcion11 = listaPercepciones.get(10).getTipoPercepcion();
                    
                    pImporte12 = sumaPercepcion.get(11);
                    pconcepto12 = listaPercepciones.get(11).getConcepto();
                    pclave12 = listaPercepciones.get(11).getClave();
                    pTipoPercepcion12 = listaPercepciones.get(11).getTipoPercepcion();
                    
                    pImporte13 = sumaPercepcion.get(12);
                    pconcepto13 = listaPercepciones.get(12).getConcepto();
                    pclave13 = listaPercepciones.get(12).getClave();
                    pTipoPercepcion13 = listaPercepciones.get(12).getTipoPercepcion();

                    pImporte14 = sumaPercepcion.get(13);
                    pconcepto14 = listaPercepciones.get(13).getConcepto();
                    pclave14 = listaPercepciones.get(13).getClave();
                    pTipoPercepcion14 = listaPercepciones.get(13).getTipoPercepcion();
                }
                
                if (tPercepciones == 15){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                    
                    pImporte8 = sumaPercepcion.get(7);
                    pconcepto8 = listaPercepciones.get(7).getConcepto();
                    pclave8 = listaPercepciones.get(7).getClave();
                    pTipoPercepcion8 = listaPercepciones.get(7).getTipoPercepcion();
                    
                    pImporte9 = sumaPercepcion.get(8);
                    pconcepto9 = listaPercepciones.get(8).getConcepto();
                    pclave9 = listaPercepciones.get(8).getClave();
                    pTipoPercepcion9 = listaPercepciones.get(8).getTipoPercepcion();
                    
                    pImporte10 = sumaPercepcion.get(9);
                    pconcepto10 = listaPercepciones.get(9).getConcepto();
                    pclave10 = listaPercepciones.get(9).getClave();
                    pTipoPercepcion10 = listaPercepciones.get(9).getTipoPercepcion();
                    
                    pImporte11 = sumaPercepcion.get(10);
                    pconcepto11 = listaPercepciones.get(10).getConcepto();
                    pclave11 = listaPercepciones.get(10).getClave();
                    pTipoPercepcion11 = listaPercepciones.get(10).getTipoPercepcion();
                    
                    pImporte12 = sumaPercepcion.get(11);
                    pconcepto12 = listaPercepciones.get(11).getConcepto();
                    pclave12 = listaPercepciones.get(11).getClave();
                    pTipoPercepcion12 = listaPercepciones.get(11).getTipoPercepcion();
                    
                    pImporte13 = sumaPercepcion.get(12);
                    pconcepto13 = listaPercepciones.get(12).getConcepto();
                    pclave13 = listaPercepciones.get(12).getClave();
                    pTipoPercepcion13 = listaPercepciones.get(12).getTipoPercepcion();

                    pImporte14 = sumaPercepcion.get(13);
                    pconcepto14 = listaPercepciones.get(13).getConcepto();
                    pclave14 = listaPercepciones.get(13).getClave();
                    pTipoPercepcion14 = listaPercepciones.get(13).getTipoPercepcion();

                    pImporte15 = sumaPercepcion.get(14);
                    pconcepto15 = listaPercepciones.get(14).getConcepto();
                    pclave15 = listaPercepciones.get(14).getClave();
                    pTipoPercepcion15 = listaPercepciones.get(14).getTipoPercepcion();
                }
                
                if (tPercepciones == 16){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                    
                    pImporte8 = sumaPercepcion.get(7);
                    pconcepto8 = listaPercepciones.get(7).getConcepto();
                    pclave8 = listaPercepciones.get(7).getClave();
                    pTipoPercepcion8 = listaPercepciones.get(7).getTipoPercepcion();
                    
                    pImporte9 = sumaPercepcion.get(8);
                    pconcepto9 = listaPercepciones.get(8).getConcepto();
                    pclave9 = listaPercepciones.get(8).getClave();
                    pTipoPercepcion9 = listaPercepciones.get(8).getTipoPercepcion();
                    
                    pImporte10 = sumaPercepcion.get(9);
                    pconcepto10 = listaPercepciones.get(9).getConcepto();
                    pclave10 = listaPercepciones.get(9).getClave();
                    pTipoPercepcion10 = listaPercepciones.get(9).getTipoPercepcion();
                    
                    pImporte11 = sumaPercepcion.get(10);
                    pconcepto11 = listaPercepciones.get(10).getConcepto();
                    pclave11 = listaPercepciones.get(10).getClave();
                    pTipoPercepcion11 = listaPercepciones.get(10).getTipoPercepcion();
                    
                    pImporte12 = sumaPercepcion.get(11);
                    pconcepto12 = listaPercepciones.get(11).getConcepto();
                    pclave12 = listaPercepciones.get(11).getClave();
                    pTipoPercepcion12 = listaPercepciones.get(11).getTipoPercepcion();
                    
                    pImporte13 = sumaPercepcion.get(12);
                    pconcepto13 = listaPercepciones.get(12).getConcepto();
                    pclave13 = listaPercepciones.get(12).getClave();
                    pTipoPercepcion13 = listaPercepciones.get(12).getTipoPercepcion();

                    pImporte14 = sumaPercepcion.get(13);
                    pconcepto14 = listaPercepciones.get(13).getConcepto();
                    pclave14 = listaPercepciones.get(13).getClave();
                    pTipoPercepcion14 = listaPercepciones.get(13).getTipoPercepcion();

                    pImporte15 = sumaPercepcion.get(14);
                    pconcepto15 = listaPercepciones.get(14).getConcepto();
                    pclave15 = listaPercepciones.get(14).getClave();
                    pTipoPercepcion15 = listaPercepciones.get(14).getTipoPercepcion();

                    pImporte16 = sumaPercepcion.get(15);
                    pconcepto16 = listaPercepciones.get(15).getConcepto();
                    pclave16 = listaPercepciones.get(15).getClave();
                    pTipoPercepcion16 = listaPercepciones.get(15).getTipoPercepcion();
                }
                
                if (tPercepciones >= 17){
                    pImporte1 = sumaPercepcion.get(0);
                    pconcepto1 = listaPercepciones.get(0).getConcepto();
                    pclave1 = listaPercepciones.get(0).getClave();
                    pTipoPercepcion1 = listaPercepciones.get(0).getTipoPercepcion();
                    
                    pImporte2 = sumaPercepcion.get(1);
                    pconcepto2 = listaPercepciones.get(1).getConcepto();
                    pclave2 = listaPercepciones.get(1).getClave();
                    pTipoPercepcion2 = listaPercepciones.get(1).getTipoPercepcion();
                    
                    pImporte3 = sumaPercepcion.get(2);
                    pconcepto3 = listaPercepciones.get(2).getConcepto();
                    pclave3 = listaPercepciones.get(2).getClave();
                    pTipoPercepcion3 = listaPercepciones.get(2).getTipoPercepcion();
                    
                    pImporte4 = sumaPercepcion.get(3);
                    pconcepto4 = listaPercepciones.get(3).getConcepto();
                    pclave4 = listaPercepciones.get(3).getClave();
                    pTipoPercepcion4 = listaPercepciones.get(3).getTipoPercepcion();
                    
                    pImporte5 = sumaPercepcion.get(4);
                    pconcepto5 = listaPercepciones.get(4).getConcepto();
                    pclave5 = listaPercepciones.get(4).getClave();
                    pTipoPercepcion5 = listaPercepciones.get(4).getTipoPercepcion();
                    
                    pImporte6 = sumaPercepcion.get(5);
                    pconcepto6 = listaPercepciones.get(5).getConcepto();
                    pclave6 = listaPercepciones.get(5).getClave();
                    pTipoPercepcion6 = listaPercepciones.get(5).getTipoPercepcion();
                    
                    pImporte7 = sumaPercepcion.get(6);
                    pconcepto7 = listaPercepciones.get(6).getConcepto();
                    pclave7 = listaPercepciones.get(6).getClave();
                    pTipoPercepcion7 = listaPercepciones.get(6).getTipoPercepcion();
                    
                    pImporte8 = sumaPercepcion.get(7);
                    pconcepto8 = listaPercepciones.get(7).getConcepto();
                    pclave8 = listaPercepciones.get(7).getClave();
                    pTipoPercepcion8 = listaPercepciones.get(7).getTipoPercepcion();
                    
                    pImporte9 = sumaPercepcion.get(8);
                    pconcepto9 = listaPercepciones.get(8).getConcepto();
                    pclave9 = listaPercepciones.get(8).getClave();
                    pTipoPercepcion9 = listaPercepciones.get(8).getTipoPercepcion();
                    
                    pImporte10 = sumaPercepcion.get(9);
                    pconcepto10 = listaPercepciones.get(9).getConcepto();
                    pclave10 = listaPercepciones.get(9).getClave();
                    pTipoPercepcion10 = listaPercepciones.get(9).getTipoPercepcion();
                    
                    pImporte11 = sumaPercepcion.get(10);
                    pconcepto11 = listaPercepciones.get(10).getConcepto();
                    pclave11 = listaPercepciones.get(10).getClave();
                    pTipoPercepcion11 = listaPercepciones.get(10).getTipoPercepcion();
                    
                    pImporte12 = sumaPercepcion.get(11);
                    pconcepto12 = listaPercepciones.get(11).getConcepto();
                    pclave12 = listaPercepciones.get(11).getClave();
                    pTipoPercepcion12 = listaPercepciones.get(11).getTipoPercepcion();
                    
                    pImporte13 = sumaPercepcion.get(12);
                    pconcepto13 = listaPercepciones.get(12).getConcepto();
                    pclave13 = listaPercepciones.get(12).getClave();
                    pTipoPercepcion13 = listaPercepciones.get(12).getTipoPercepcion();

                    pImporte14 = sumaPercepcion.get(13);
                    pconcepto14 = listaPercepciones.get(13).getConcepto();
                    pclave14 = listaPercepciones.get(13).getClave();
                    pTipoPercepcion14 = listaPercepciones.get(13).getTipoPercepcion();

                    pImporte15 = sumaPercepcion.get(14);
                    pconcepto15 = listaPercepciones.get(14).getConcepto();
                    pclave15 = listaPercepciones.get(14).getClave();
                    pTipoPercepcion15 = listaPercepciones.get(14).getTipoPercepcion();

                    pImporte16 = sumaPercepcion.get(15);
                    pconcepto16 = listaPercepciones.get(15).getConcepto();
                    pclave16 = listaPercepciones.get(15).getClave();
                    pTipoPercepcion16 = listaPercepciones.get(15).getTipoPercepcion();

                    pImporte17 = sumaPercepcion.get(16);
                    pconcepto17 = listaPercepciones.get(16).getConcepto();
                    pclave17 = listaPercepciones.get(16).getClave();
                    pTipoPercepcion17 = listaPercepciones.get(16).getTipoPercepcion();
                }
                
                //Deducciones
                BuscarDeducciones bd = new BuscarDeducciones();
                ArrayList<Deducciones> listaDeducciones = bd.buscarDeducciones(uuid, directorioOrigen);
                int tDeducciones = listaDeducciones.size();
                System.out.println("Tamaño deducciones: " + tDeducciones);
                
                if (tDeducciones == 1){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                }
                
                if (tDeducciones == 2){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                }
                
                if (tDeducciones == 3){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                }
                
                if (tDeducciones == 4){
                    System.out.println("entra a la opcion 4 de las deducciones");
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    System.out.println("sale de la opcion 4 de las deducciones");
                }
                
                if (tDeducciones == 5){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                }
                
                if (tDeducciones == 6){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                }
                
                if (tDeducciones == 7){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                }
                
                if (tDeducciones == 8){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                    
                    dimporte8 = listaDeducciones.get(7).getImporte();
                    dconcepto8 = listaDeducciones.get(7).getConcepto();
                    dclave8 = listaDeducciones.get(7).getClave();
                    dTipoDediccion8 = listaDeducciones.get(7).getTipoDeduccion();
                }
                
                if (tDeducciones == 9){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                    
                    dimporte8 = listaDeducciones.get(7).getImporte();
                    dconcepto8 = listaDeducciones.get(7).getConcepto();
                    dclave8 = listaDeducciones.get(7).getClave();
                    dTipoDediccion8 = listaDeducciones.get(7).getTipoDeduccion();
                    
                    dimporte9 = listaDeducciones.get(8).getImporte();
                    dconcepto9 = listaDeducciones.get(8).getConcepto();
                    dclave9 = listaDeducciones.get(8).getClave();
                    dTipoDediccion9 = listaDeducciones.get(8).getTipoDeduccion();
                }
                
                if (tDeducciones == 10){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                    
                    dimporte8 = listaDeducciones.get(7).getImporte();
                    dconcepto8 = listaDeducciones.get(7).getConcepto();
                    dclave8 = listaDeducciones.get(7).getClave();
                    dTipoDediccion8 = listaDeducciones.get(7).getTipoDeduccion();
                    
                    dimporte9 = listaDeducciones.get(8).getImporte();
                    dconcepto9 = listaDeducciones.get(8).getConcepto();
                    dclave9 = listaDeducciones.get(8).getClave();
                    dTipoDediccion9 = listaDeducciones.get(8).getTipoDeduccion();
                    
                    dimporte10 = listaDeducciones.get(9).getImporte();
                    dconcepto10 = listaDeducciones.get(9).getConcepto();
                    dclave10 = listaDeducciones.get(9).getClave();
                    dTipoDediccion10 = listaDeducciones.get(9).getTipoDeduccion();
                }
                
                if (tDeducciones == 11){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                    
                    dimporte8 = listaDeducciones.get(7).getImporte();
                    dconcepto8 = listaDeducciones.get(7).getConcepto();
                    dclave8 = listaDeducciones.get(7).getClave();
                    dTipoDediccion8 = listaDeducciones.get(7).getTipoDeduccion();
                    
                    dimporte9 = listaDeducciones.get(8).getImporte();
                    dconcepto9 = listaDeducciones.get(8).getConcepto();
                    dclave9 = listaDeducciones.get(8).getClave();
                    dTipoDediccion9 = listaDeducciones.get(8).getTipoDeduccion();
                    
                    dimporte10 = listaDeducciones.get(9).getImporte();
                    dconcepto10 = listaDeducciones.get(9).getConcepto();
                    dclave10 = listaDeducciones.get(9).getClave();
                    dTipoDediccion10 = listaDeducciones.get(9).getTipoDeduccion();
                    
                    dimporte11 = listaDeducciones.get(10).getImporte();
                    dconcepto11 = listaDeducciones.get(10).getConcepto();
                    dclave11 = listaDeducciones.get(10).getClave();
                    dTipoDediccion11 = listaDeducciones.get(10).getTipoDeduccion();
                    
                }
                
                if (tDeducciones == 12){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                    
                    dimporte8 = listaDeducciones.get(7).getImporte();
                    dconcepto8 = listaDeducciones.get(7).getConcepto();
                    dclave8 = listaDeducciones.get(7).getClave();
                    dTipoDediccion8 = listaDeducciones.get(7).getTipoDeduccion();
                    
                    dimporte9 = listaDeducciones.get(8).getImporte();
                    dconcepto9 = listaDeducciones.get(8).getConcepto();
                    dclave9 = listaDeducciones.get(8).getClave();
                    dTipoDediccion9 = listaDeducciones.get(8).getTipoDeduccion();
                    
                    dimporte10 = listaDeducciones.get(9).getImporte();
                    dconcepto10 = listaDeducciones.get(9).getConcepto();
                    dclave10 = listaDeducciones.get(9).getClave();
                    dTipoDediccion10 = listaDeducciones.get(9).getTipoDeduccion();
                    
                    dimporte11 = listaDeducciones.get(10).getImporte();
                    dconcepto11 = listaDeducciones.get(10).getConcepto();
                    dclave11 = listaDeducciones.get(10).getClave();
                    dTipoDediccion11 = listaDeducciones.get(10).getTipoDeduccion();
                    
                    dimporte12 = listaDeducciones.get(11).getImporte();
                    dconcepto12 = listaDeducciones.get(11).getConcepto();
                    dclave12 = listaDeducciones.get(11).getClave();
                    dTipoDediccion12 = listaDeducciones.get(11).getTipoDeduccion();
                }
                
                if (tDeducciones == 13){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                    
                    dimporte8 = listaDeducciones.get(7).getImporte();
                    dconcepto8 = listaDeducciones.get(7).getConcepto();
                    dclave8 = listaDeducciones.get(7).getClave();
                    dTipoDediccion8 = listaDeducciones.get(7).getTipoDeduccion();
                    
                    dimporte9 = listaDeducciones.get(8).getImporte();
                    dconcepto9 = listaDeducciones.get(8).getConcepto();
                    dclave9 = listaDeducciones.get(8).getClave();
                    dTipoDediccion9 = listaDeducciones.get(8).getTipoDeduccion();
                    
                    dimporte10 = listaDeducciones.get(9).getImporte();
                    dconcepto10 = listaDeducciones.get(9).getConcepto();
                    dclave10 = listaDeducciones.get(9).getClave();
                    dTipoDediccion10 = listaDeducciones.get(9).getTipoDeduccion();
                    
                    dimporte11 = listaDeducciones.get(10).getImporte();
                    dconcepto11 = listaDeducciones.get(10).getConcepto();
                    dclave11 = listaDeducciones.get(10).getClave();
                    dTipoDediccion11 = listaDeducciones.get(10).getTipoDeduccion();
                    
                    dimporte12 = listaDeducciones.get(11).getImporte();
                    dconcepto12 = listaDeducciones.get(11).getConcepto();
                    dclave12 = listaDeducciones.get(11).getClave();
                    dTipoDediccion12 = listaDeducciones.get(11).getTipoDeduccion();
                    
                    dimporte13 = listaDeducciones.get(12).getImporte();
                    dconcepto13 = listaDeducciones.get(12).getConcepto();
                    dclave13 = listaDeducciones.get(12).getClave();
                    dTipoDediccion13 = listaDeducciones.get(12).getTipoDeduccion();
                }
                
                if (tDeducciones == 14){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                    
                    dimporte8 = listaDeducciones.get(7).getImporte();
                    dconcepto8 = listaDeducciones.get(7).getConcepto();
                    dclave8 = listaDeducciones.get(7).getClave();
                    dTipoDediccion8 = listaDeducciones.get(7).getTipoDeduccion();
                    
                    dimporte9 = listaDeducciones.get(8).getImporte();
                    dconcepto9 = listaDeducciones.get(8).getConcepto();
                    dclave9 = listaDeducciones.get(8).getClave();
                    dTipoDediccion9 = listaDeducciones.get(8).getTipoDeduccion();
                    
                    dimporte10 = listaDeducciones.get(9).getImporte();
                    dconcepto10 = listaDeducciones.get(9).getConcepto();
                    dclave10 = listaDeducciones.get(9).getClave();
                    dTipoDediccion10 = listaDeducciones.get(9).getTipoDeduccion();
                    
                    dimporte11 = listaDeducciones.get(10).getImporte();
                    dconcepto11 = listaDeducciones.get(10).getConcepto();
                    dclave11 = listaDeducciones.get(10).getClave();
                    dTipoDediccion11 = listaDeducciones.get(10).getTipoDeduccion();
                    
                    dimporte12 = listaDeducciones.get(11).getImporte();
                    dconcepto12 = listaDeducciones.get(11).getConcepto();
                    dclave12 = listaDeducciones.get(11).getClave();
                    dTipoDediccion12 = listaDeducciones.get(11).getTipoDeduccion();
                    
                    dimporte13 = listaDeducciones.get(12).getImporte();
                    dconcepto13 = listaDeducciones.get(12).getConcepto();
                    dclave13 = listaDeducciones.get(12).getClave();
                    dTipoDediccion13 = listaDeducciones.get(12).getTipoDeduccion();

                    dimporte14 = listaDeducciones.get(13).getImporte();
                    dconcepto14 = listaDeducciones.get(13).getConcepto();
                    dclave14 = listaDeducciones.get(13).getClave();
                    dTipoDediccion14 = listaDeducciones.get(13).getTipoDeduccion();
                }
                
                if (tDeducciones == 15){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                    
                    dimporte8 = listaDeducciones.get(7).getImporte();
                    dconcepto8 = listaDeducciones.get(7).getConcepto();
                    dclave8 = listaDeducciones.get(7).getClave();
                    dTipoDediccion8 = listaDeducciones.get(7).getTipoDeduccion();
                    
                    dimporte9 = listaDeducciones.get(8).getImporte();
                    dconcepto9 = listaDeducciones.get(8).getConcepto();
                    dclave9 = listaDeducciones.get(8).getClave();
                    dTipoDediccion9 = listaDeducciones.get(8).getTipoDeduccion();
                    
                    dimporte10 = listaDeducciones.get(9).getImporte();
                    dconcepto10 = listaDeducciones.get(9).getConcepto();
                    dclave10 = listaDeducciones.get(9).getClave();
                    dTipoDediccion10 = listaDeducciones.get(9).getTipoDeduccion();
                    
                    dimporte11 = listaDeducciones.get(10).getImporte();
                    dconcepto11 = listaDeducciones.get(10).getConcepto();
                    dclave11 = listaDeducciones.get(10).getClave();
                    dTipoDediccion11 = listaDeducciones.get(10).getTipoDeduccion();
                    
                    dimporte12 = listaDeducciones.get(11).getImporte();
                    dconcepto12 = listaDeducciones.get(11).getConcepto();
                    dclave12 = listaDeducciones.get(11).getClave();
                    dTipoDediccion12 = listaDeducciones.get(11).getTipoDeduccion();
                    
                    dimporte13 = listaDeducciones.get(12).getImporte();
                    dconcepto13 = listaDeducciones.get(12).getConcepto();
                    dclave13 = listaDeducciones.get(12).getClave();
                    dTipoDediccion13 = listaDeducciones.get(12).getTipoDeduccion();

                    dimporte14 = listaDeducciones.get(13).getImporte();
                    dconcepto14 = listaDeducciones.get(13).getConcepto();
                    dclave14 = listaDeducciones.get(13).getClave();
                    dTipoDediccion14 = listaDeducciones.get(13).getTipoDeduccion();

                    dimporte15 = listaDeducciones.get(14).getImporte();
                    dconcepto15 = listaDeducciones.get(14).getConcepto();
                    dclave15 = listaDeducciones.get(14).getClave();
                    dTipoDediccion15 = listaDeducciones.get(14).getTipoDeduccion();
                }
                
                if (tDeducciones == 16){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                    
                    dimporte8 = listaDeducciones.get(7).getImporte();
                    dconcepto8 = listaDeducciones.get(7).getConcepto();
                    dclave8 = listaDeducciones.get(7).getClave();
                    dTipoDediccion8 = listaDeducciones.get(7).getTipoDeduccion();
                    
                    dimporte9 = listaDeducciones.get(8).getImporte();
                    dconcepto9 = listaDeducciones.get(8).getConcepto();
                    dclave9 = listaDeducciones.get(8).getClave();
                    dTipoDediccion9 = listaDeducciones.get(8).getTipoDeduccion();
                    
                    dimporte10 = listaDeducciones.get(9).getImporte();
                    dconcepto10 = listaDeducciones.get(9).getConcepto();
                    dclave10 = listaDeducciones.get(9).getClave();
                    dTipoDediccion10 = listaDeducciones.get(9).getTipoDeduccion();
                    
                    dimporte11 = listaDeducciones.get(10).getImporte();
                    dconcepto11 = listaDeducciones.get(10).getConcepto();
                    dclave11 = listaDeducciones.get(10).getClave();
                    dTipoDediccion11 = listaDeducciones.get(10).getTipoDeduccion();
                    
                    dimporte12 = listaDeducciones.get(11).getImporte();
                    dconcepto12 = listaDeducciones.get(11).getConcepto();
                    dclave12 = listaDeducciones.get(11).getClave();
                    dTipoDediccion12 = listaDeducciones.get(11).getTipoDeduccion();
                    
                    dimporte13 = listaDeducciones.get(12).getImporte();
                    dconcepto13 = listaDeducciones.get(12).getConcepto();
                    dclave13 = listaDeducciones.get(12).getClave();
                    dTipoDediccion13 = listaDeducciones.get(12).getTipoDeduccion();

                    dimporte14 = listaDeducciones.get(13).getImporte();
                    dconcepto14 = listaDeducciones.get(13).getConcepto();
                    dclave14 = listaDeducciones.get(13).getClave();
                    dTipoDediccion14 = listaDeducciones.get(13).getTipoDeduccion();

                    dimporte15 = listaDeducciones.get(14).getImporte();
                    dconcepto15 = listaDeducciones.get(14).getConcepto();
                    dclave15 = listaDeducciones.get(14).getClave();
                    dTipoDediccion15 = listaDeducciones.get(14).getTipoDeduccion();

                    dimporte16 = listaDeducciones.get(15).getImporte();
                    dconcepto16 = listaDeducciones.get(15).getConcepto();
                    dclave16 = listaDeducciones.get(15).getClave();
                    dTipoDediccion16 = listaDeducciones.get(15).getTipoDeduccion();
                }
                
                if (tDeducciones >= 17){
                    dimporte1 = listaDeducciones.get(0).getImporte();
                    dconcepto1 = listaDeducciones.get(0).getConcepto();
                    dclave1 = listaDeducciones.get(0).getClave();
                    dTipoDediccion1 = listaDeducciones.get(0).getTipoDeduccion();
                    
                    dimporte2 = listaDeducciones.get(1).getImporte();
                    dconcepto2 = listaDeducciones.get(1).getConcepto();
                    dclave2 = listaDeducciones.get(1).getClave();
                    dTipoDediccion2 = listaDeducciones.get(1).getTipoDeduccion();
                    
                    dimporte3 = listaDeducciones.get(2).getImporte();
                    dconcepto3 = listaDeducciones.get(2).getConcepto();
                    dclave3 = listaDeducciones.get(2).getClave();
                    dTipoDediccion3 = listaDeducciones.get(2).getTipoDeduccion();
                    
                    dimporte4 = listaDeducciones.get(3).getImporte();
                    dconcepto4 = listaDeducciones.get(3).getConcepto();
                    dclave4 = listaDeducciones.get(3).getClave();
                    dTipoDediccion4 = listaDeducciones.get(3).getTipoDeduccion();
                    
                    dimporte5 = listaDeducciones.get(4).getImporte();
                    dconcepto5 = listaDeducciones.get(4).getConcepto();
                    dclave5 = listaDeducciones.get(4).getClave();
                    dTipoDediccion5 = listaDeducciones.get(4).getTipoDeduccion();
                    
                    dimporte6 = listaDeducciones.get(5).getImporte();
                    dconcepto6 = listaDeducciones.get(5).getConcepto();
                    dclave6 = listaDeducciones.get(5).getClave();
                    dTipoDediccion6 = listaDeducciones.get(5).getTipoDeduccion();
                    
                    dimporte7 = listaDeducciones.get(6).getImporte();
                    dconcepto7 = listaDeducciones.get(6).getConcepto();
                    dclave7 = listaDeducciones.get(6).getClave();
                    dTipoDediccion7 = listaDeducciones.get(6).getTipoDeduccion();
                    
                    dimporte8 = listaDeducciones.get(7).getImporte();
                    dconcepto8 = listaDeducciones.get(7).getConcepto();
                    dclave8 = listaDeducciones.get(7).getClave();
                    dTipoDediccion8 = listaDeducciones.get(7).getTipoDeduccion();
                    
                    dimporte9 = listaDeducciones.get(8).getImporte();
                    dconcepto9 = listaDeducciones.get(8).getConcepto();
                    dclave9 = listaDeducciones.get(8).getClave();
                    dTipoDediccion9 = listaDeducciones.get(8).getTipoDeduccion();
                    
                    dimporte10 = listaDeducciones.get(9).getImporte();
                    dconcepto10 = listaDeducciones.get(9).getConcepto();
                    dclave10 = listaDeducciones.get(9).getClave();
                    dTipoDediccion10 = listaDeducciones.get(9).getTipoDeduccion();
                    
                    dimporte11 = listaDeducciones.get(10).getImporte();
                    dconcepto11 = listaDeducciones.get(10).getConcepto();
                    dclave11 = listaDeducciones.get(10).getClave();
                    dTipoDediccion11 = listaDeducciones.get(10).getTipoDeduccion();
                    
                    dimporte12 = listaDeducciones.get(11).getImporte();
                    dconcepto12 = listaDeducciones.get(11).getConcepto();
                    dclave12 = listaDeducciones.get(11).getClave();
                    dTipoDediccion12 = listaDeducciones.get(11).getTipoDeduccion();
                    
                    dimporte13 = listaDeducciones.get(12).getImporte();
                    dconcepto13 = listaDeducciones.get(12).getConcepto();
                    dclave13 = listaDeducciones.get(12).getClave();
                    dTipoDediccion13 = listaDeducciones.get(12).getTipoDeduccion();

                    dimporte14 = listaDeducciones.get(13).getImporte();
                    dconcepto14 = listaDeducciones.get(13).getConcepto();
                    dclave14 = listaDeducciones.get(13).getClave();
                    dTipoDediccion14 = listaDeducciones.get(13).getTipoDeduccion();

                    dimporte15 = listaDeducciones.get(14).getImporte();
                    dconcepto15 = listaDeducciones.get(14).getConcepto();
                    dclave15 = listaDeducciones.get(14).getClave();
                    dTipoDediccion15 = listaDeducciones.get(14).getTipoDeduccion();

                    dimporte16 = listaDeducciones.get(15).getImporte();
                    dconcepto16 = listaDeducciones.get(15).getConcepto();
                    dclave16 = listaDeducciones.get(15).getClave();
                    dTipoDediccion16 = listaDeducciones.get(15).getTipoDeduccion();

                    dimporte17 = listaDeducciones.get(16).getImporte();
                    dconcepto17 = listaDeducciones.get(16).getConcepto();
                    dclave17 = listaDeducciones.get(16).getClave();
                    dTipoDediccion17 = listaDeducciones.get(16).getTipoDeduccion();
                }
                
                // Método para tener la sumatoria de las percepciones sin la ayuda para despensa familiar
                SumatoriaPercepciones sp = new SumatoriaPercepciones();
                double sumatoriaPercepciones = sp.sumatoriaPercepciones(listaPercepciones);
                String valorS = "";
                if((sumatoriaPercepciones % 1) == 0) {
                    DecimalFormat numberFormat = new DecimalFormat("###,###.##");
                    valorS = numberFormat.format(sumatoriaPercepciones);
                    String decimales = ".00";
                    valorS=valorS+decimales;
                    percibido = valorS;
                }
                else {
                    DecimalFormat numberFormat = new DecimalFormat("###,###.##");
                    valorS = numberFormat.format(sumatoriaPercepciones);
                    percibido = valorS;
                }
                
                // Método para obtener el valor de los vales (Ayuda para despensa familiar)
                double despensa = sp.vales(listaPercepciones);
                valorS = "";
                if((despensa % 1) == 0) {
                    DecimalFormat numberFormat = new DecimalFormat("###,###.##");
                    valorS = numberFormat.format(despensa);
                    String decimales = ".00";
                    valorS=valorS+decimales;
                    vales = valorS;
                }
                else {
                    DecimalFormat numberFormat = new DecimalFormat("###,###.##");
                    valorS = numberFormat.format(despensa);
                    vales = valorS;
                }                
                
                // Método para tener la sumatoria de las deduciones
                SumatoriaDeducciones sd = new SumatoriaDeducciones();
                double sumatoriaDeducciones = sd.sumatoriaDeducciones(listaDeducciones);
                valorS = "";
                if((sumatoriaDeducciones % 1) == 0) {
                    DecimalFormat numberFormat = new DecimalFormat("###,###.##");
                    valorS = numberFormat.format(sumatoriaDeducciones);
                    String decimales = ".00";
                    valorS=valorS+decimales;
                    deducido = valorS;
                }
                else {
                    DecimalFormat numberFormat = new DecimalFormat("###,###.##");
                    valorS = numberFormat.format(sumatoriaDeducciones);
                    deducido = valorS;
                }
                
                // Se obtiene el total del total
                double totalAPagar = sumatoriaPercepciones + despensa - sumatoriaDeducciones;
                valorS = "";
                if((totalAPagar % 1) == 0) {
                    DecimalFormat numberFormat = new DecimalFormat("###,###.##");
                    valorS = numberFormat.format(totalAPagar);
                    String decimales = ".00";
                    valorS=valorS+decimales;
                    total = valorS;
                }
                else {
                    DecimalFormat numberFormat = new DecimalFormat("###,###.##");
                    valorS = numberFormat.format(totalAPagar);
                    total = valorS;
                }
                
                // Se obtiene el total del depósito
                double depositoAPagar = sumatoriaPercepciones - sumatoriaDeducciones;
                valorS = "";
                if((depositoAPagar % 1) == 0) {
                    DecimalFormat numberFormat = new DecimalFormat("###,###.##");
                    valorS = numberFormat.format(depositoAPagar);
                    String decimales = ".00";
                    valorS=valorS+decimales;
                    deposito = valorS;
                }
                else {
                    DecimalFormat numberFormat = new DecimalFormat("###,###.##");
                    valorS = numberFormat.format(depositoAPagar);
                    deposito = valorS;
                }    
                
                // Hace falta método para el deposito o cheque
                // Hace falta método para los vales
                String noCertificado = lx.noCertificado(uuid, directorioOrigen);
                //System.out.println("NoCertificado: " + noCertificado);
                String noCertificadoSat = lx.noCertificadoSat(uuid, directorioOrigen);
                //System.out.println("NoCertificadoSat: " + noCertificadoSat);
                String fechaTimbrado = lx.fechaTimbrado(uuid, directorioOrigen);
                //System.out.println("FechaTimbrado: " + fechaTimbrado);
                String selloCfd = lx.selloCfd(uuid, directorioOrigen);
                //System.out.println("SelloCFD: " + selloCfd);
                String selloSat = lx.selloSat(uuid, directorioOrigen);
                //System.out.println("SelloSAT: " + selloSat);
                String cadenaOriginal = "||1.1|".concat(uuid).concat("|").concat("FechaTimbado").concat("|").concat(selloCfd).concat("|").concat(noCertificadoSat).concat("|");
                //System.out.println("CadenaOriginal: " + cadenaOriginal);
                
                String host = "jdbc:mysql://localhost:3306/bd_sgc?autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "chiquitamama";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                Connection conn = DriverManager.getConnection(host, username, password);
            
                try {
                    String sourceFileName = "C:\\Users\\UABC-16653387\\Documents\\NetBeansProjects\\Reporte\\src\\main\\java\\com\\bytecode\\reporte\\Usuario.jasper";            
                    File fileUno = new File(sourceFileName);
                    
                    JasperReport factura = (JasperReport)JRLoader.loadObject(fileUno);
                    Map<String, Object> parameters = new HashMap();
                    //parameters.clear();
                    parameters.put("empleado", empleado);
                    parameters.put("nombreEmpleado", nombreEmpleado);
                    parameters.put("rfc", rfc);
                    parameters.put("curp",curp);
                    parameters.put("nss",nss);
                    parameters.put("departamento",departamento);
                    parameters.put("fechaPago", fechaPago);
                    parameters.put("fechaInicialPago", fechaInicialPago);
                    parameters.put("fechaFinalPago", fechaFinalPago);
                    parameters.put("numDiasPagados", numDiasPagados);
                    parameters.put("periodicidadPago", periodicidadPago);
                    parameters.put("salarioDiarioIntegrado", salarioDiarioIntegrado);
                    parameters.put("noCatorcena", noCatorcena);
                    parameters.put("metodoPago", metodoPago);
                    parameters.put("moneda", moneda);
                    parameters.put("percibido", percibido);
                    parameters.put("deducido", deducido);
                    parameters.put("vales", vales);
                    parameters.put("noCertificado", noCertificado);
                    parameters.put("uuid", uuid);
                    parameters.put("noCertificadoSat", noCertificadoSat);
                    parameters.put("fechaTimbrado", fechaTimbrado);
                    parameters.put("selloCfd", selloCfd);
                    parameters.put("selloSat", selloSat);
                    parameters.put("cadenaOriginal", cadenaOriginal);
                    parameters.put("total", total);
                    parameters.put("IMAGE_SRC", directorioOrigen + IMAGE_SRC);
                    parameters.put("deposito", deposito);
                    parameters.put("pImporte1", pImporte1);
                    parameters.put("pImporte2", pImporte2);
                    parameters.put("pImporte3", pImporte3);
                    parameters.put("pImporte4", pImporte4);
                    parameters.put("pImporte5", pImporte5);
                    parameters.put("pImporte6", pImporte6);
                    parameters.put("pImporte7", pImporte7);
                    parameters.put("pImporte8", pImporte8);
                    parameters.put("pImporte9", pImporte9);
                    parameters.put("pImporte10", pImporte10);
                    parameters.put("pImporte11", pImporte11);
                    parameters.put("pImporte12", pImporte12);
                    parameters.put("pImporte13", pImporte13);
                    parameters.put("pImporte14", pImporte14);
                    parameters.put("pImporte15", pImporte15);
                    parameters.put("pImporte16", pImporte16);
                    parameters.put("pImporte17", pImporte17);
                    parameters.put("pconcepto1", pconcepto1);
                    parameters.put("pconcepto2", pconcepto2);
                    parameters.put("pconcepto3", pconcepto3);
                    parameters.put("pconcepto4", pconcepto4);
                    parameters.put("pconcepto5", pconcepto5);
                    parameters.put("pconcepto6", pconcepto6);
                    parameters.put("pconcepto7", pconcepto7);
                    parameters.put("pconcepto8", pconcepto8);
                    parameters.put("pconcepto9", pconcepto9);
                    parameters.put("pconcepto10", pconcepto10);
                    parameters.put("pconcepto11", pconcepto11);
                    parameters.put("pconcepto12", pconcepto12);
                    parameters.put("pconcepto13", pconcepto13);
                    parameters.put("pconcepto14", pconcepto14);
                    parameters.put("pconcepto15", pconcepto15);
                    parameters.put("pconcepto16", pconcepto16);
                    parameters.put("pconcepto17", pconcepto17);
                    parameters.put("pclave1", pclave1);
                    parameters.put("pclave2", pclave2);
                    parameters.put("pclave3", pclave3);
                    parameters.put("pclave4", pclave4);
                    parameters.put("pclave5", pclave5);
                    parameters.put("pclave6", pclave6);
                    parameters.put("pclave7", pclave7);
                    parameters.put("pclave8", pclave8);
                    parameters.put("pclave9", pclave9);
                    parameters.put("pclave10", pclave10);
                    parameters.put("pclave11", pclave11);
                    parameters.put("pclave12", pclave12);
                    parameters.put("pclave13", pclave13);
                    parameters.put("pclave14", pclave14);
                    parameters.put("pclave15", pclave15);
                    parameters.put("pclave11", pclave11);
                    parameters.put("pclave12", pclave12);
                    parameters.put("pclave13", pclave13);
                    parameters.put("pclave14", pclave14);
                    parameters.put("pclave15", pclave15);
                    parameters.put("pclave16", pclave16);
                    parameters.put("pclave17", pclave17);
                    parameters.put("pTipoPercepcion1", pTipoPercepcion1);
                    parameters.put("pTipoPercepcion2", pTipoPercepcion2);
                    parameters.put("pTipoPercepcion3", pTipoPercepcion3);
                    parameters.put("pTipoPercepcion4", pTipoPercepcion4);
                    parameters.put("pTipoPercepcion5", pTipoPercepcion5);
                    parameters.put("pTipoPercepcion6", pTipoPercepcion6);
                    parameters.put("pTipoPercepcion7", pTipoPercepcion7);
                    parameters.put("pTipoPercepcion8", pTipoPercepcion8);
                    parameters.put("pTipoPercepcion9", pTipoPercepcion9);
                    parameters.put("pTipoPercepcion10", pTipoPercepcion10);
                    parameters.put("pTipoPercepcion11", pTipoPercepcion11);
                    parameters.put("pTipoPercepcion12", pTipoPercepcion12);
                    parameters.put("pTipoPercepcion13", pTipoPercepcion13);
                    parameters.put("pTipoPercepcion14", pTipoPercepcion14);
                    parameters.put("pTipoPercepcion15", pTipoPercepcion15);
                    parameters.put("pTipoPercepcion16", pTipoPercepcion16);
                    parameters.put("pTipoPercepcion17", pTipoPercepcion17);
                    parameters.put("dimporte1", dimporte1);
                    parameters.put("dimporte2", dimporte2);
                    parameters.put("dimporte3", dimporte3);
                    parameters.put("dimporte4", dimporte4);
                    parameters.put("dimporte5", dimporte5);
                    parameters.put("dimporte6", dimporte6);
                    parameters.put("dimporte7", dimporte7);
                    parameters.put("dimporte8", dimporte8);
                    parameters.put("dimporte9", dimporte9);
                    parameters.put("dimporte10", dimporte10);
                    parameters.put("dimporte11", dimporte11);
                    parameters.put("dimporte12", dimporte12);
                    parameters.put("dimporte13", dimporte13);
                    parameters.put("dimporte14", dimporte14);
                    parameters.put("dimporte15", dimporte15);
                    parameters.put("dimporte16", dimporte16);
                    parameters.put("dimporte17", dimporte17);
                    parameters.put("dconcepto1", dconcepto1);
                    parameters.put("dconcepto2", dconcepto2);
                    parameters.put("dconcepto3", dconcepto3);
                    parameters.put("dconcepto4", dconcepto4);
                    parameters.put("dconcepto5", dconcepto5);
                    parameters.put("dconcepto6", dconcepto6);
                    parameters.put("dconcepto7", dconcepto7);
                    parameters.put("dconcepto8", dconcepto8);
                    parameters.put("dconcepto9", dconcepto9);
                    parameters.put("dconcepto10", dconcepto10);
                    parameters.put("dconcepto11", dconcepto11);
                    parameters.put("dconcepto12", dconcepto12);
                    parameters.put("dconcepto13", dconcepto13);
                    parameters.put("dconcepto14", dconcepto14);
                    parameters.put("dconcepto15", dconcepto15);
                    parameters.put("dconcepto16", dconcepto16);
                    parameters.put("dconcepto17", dconcepto17);
                    parameters.put("dclave1", dclave1);
                    parameters.put("dclave2", dclave2);
                    parameters.put("dclave3", dclave3);
                    parameters.put("dclave4", dclave4);
                    parameters.put("dclave5", dclave5);
                    parameters.put("dclave6", dclave6);
                    parameters.put("dclave7", dclave7);
                    parameters.put("dclave8", dclave8);
                    parameters.put("dclave9", dclave9);
                    parameters.put("dclave10", dclave10);
                    parameters.put("dclave11", dclave11);
                    parameters.put("dclave12", dclave12);
                    parameters.put("dclave13", dclave13);
                    parameters.put("dclave14", dclave14);
                    parameters.put("dclave15", dclave15);
                    parameters.put("dclave16", dclave16);
                    parameters.put("dclave17", dclave17);
                    parameters.put("dTipoDediccion1", dTipoDediccion1);
                    parameters.put("dTipoDediccion2", dTipoDediccion2);
                    parameters.put("dTipoDediccion3", dTipoDediccion3);
                    parameters.put("dTipoDediccion4", dTipoDediccion4);
                    parameters.put("dTipoDediccion5", dTipoDediccion5);
                    parameters.put("dTipoDediccion6", dTipoDediccion6);
                    parameters.put("dTipoDediccion7", dTipoDediccion7);
                    parameters.put("dTipoDediccion8", dTipoDediccion8);
                    parameters.put("dTipoDediccion9", dTipoDediccion9);
                    parameters.put("dTipoDediccion10", dTipoDediccion10);
                    parameters.put("dTipoDediccion11", dTipoDediccion11);
                    parameters.put("dTipoDediccion12", dTipoDediccion12);
                    parameters.put("dTipoDediccion13", dTipoDediccion13);
                    parameters.put("dTipoDediccion14", dTipoDediccion14);
                    parameters.put("dTipoDediccion15", dTipoDediccion15);
                    parameters.put("dTipoDediccion16", dTipoDediccion16);
                    parameters.put("dTipoDediccion17", dTipoDediccion17);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(factura, parameters, conn);
                    //JasperViewer jv = new JasperViewer(jasperPrint, false);
                    //jv.setTitle("Recibo Nómina");
                    //jv.setVisible(true);
                    JasperExportManager.exportReportToPdfFile(jasperPrint, directorioDestino + nombreArchivoGenerado);
                    conn.close();


                } catch (JRException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
                return true;
	    //}
            //else {
            //    System.out.println("El archivo no se encontró en la carpeta");
            //}
	//}
        //return false;
    }
}
