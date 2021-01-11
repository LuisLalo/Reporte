/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.reporte;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author UABC-16653387
 */
public class MoverArchivoProcesado {
    
    public boolean moverArchivo(String uuid) {
        String directorioOrigen = "C:\\OrigenPdf\\";
        String directorioDestino = "C:\\ProcesadoPdf\\";
        String nombreXml = uuid.concat(".xml");
        String nombreBmp = uuid.concat("_Cbb.bmp");
        boolean resultado = false;
        
        // Método para mover el archivo xml
        Path FROM = Paths.get(directorioOrigen + nombreXml);
	    Path TO = Paths.get(directorioDestino + nombreXml);
	    //overwrite existing file, if exists
	    CopyOption[] options = new CopyOption[]{
	      //StandardCopyOption.REPLACE_EXISTING,
	      //StandardCopyOption.COPY_ATTRIBUTES
	      StandardCopyOption.REPLACE_EXISTING
	    }; 
	    try {
                //Files.move(Paths.get(dirOrigen, dirDestino), StandardCopyOption.REPLACE_EXISTING);
		Files.move(FROM, TO, options);
            } 
            catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }
        
            // Método para mover el archivo xml
        FROM = Paths.get(directorioOrigen + nombreBmp);
	    TO = Paths.get(directorioDestino + nombreBmp);
	    //overwrite existing file, if exists
	    CopyOption[] optionsBmp = new CopyOption[]{
	      //StandardCopyOption.REPLACE_EXISTING,
	      //StandardCopyOption.COPY_ATTRIBUTES
	      StandardCopyOption.REPLACE_EXISTING
	    }; 
	    try {
                //Files.move(Paths.get(dirOrigen, dirDestino), StandardCopyOption.REPLACE_EXISTING);
		Files.move(FROM, TO, optionsBmp);
            } 
            catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }
        return resultado;
    }
}
