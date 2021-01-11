/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.reporte;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luis Lalo
 */
public class App {
    public static void main(String [] args) throws IOException, SQLException {
        /*String uuid = "";
        
        // Variables para la conexion a la base de datos de SQL Server
        String host = "jdbc:sqlserver://;database=TimbradoNominaAYA;integratedSecurity=true;";
	String username = "sa";
	String password = "Compac2013";
        String textoExtra = "nomina01-2018";
        try {
            //Cargar el driver de SQL Server
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	
            //Sentencia para la conexión a la base de datos
            Connection connection = DriverManager.getConnection(host, username, password);
		
            //Código para hacer el query a la base de datos y ejecutarlo
            PreparedStatement preparedStatement = connection.prepareStatement("select uuid from ControlFacturasAYA where UUID in('B7F8DB7F-2B2A-4257-94DD-766B66EEEB12','9FC7E787-3A7B-41C0-AAD0-1ED93A704608','66AF5C17-03F1-443A-A20C-CAD2C72B5641','11203D99-4878-421B-BAE3-5E7532F0245A','CF2A3A64-6FDB-49D8-A02C-4F7C4405A056') and TextoExtra3 = ?");
            //PreparedStatement preparedStatement = connection.prepareStatement("select uuid from ControlFacturasAYA where TextoExtra3 = ?");
            preparedStatement.setString(1, textoExtra);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            int cont = 0;
            while(resultSet.next()) {
                uuid = resultSet.getString(1);
                cont++;
                BuscarXml bx = new BuscarXml();
                boolean resultado = bx.buscarRuta();
                if(resultado) {
                    //System.out.println("Valor resultado: " + resultado);
                    
                }
                else {
                    System.out.println("No se encontró UUID: " + uuid);
                }
            }
            // Se cierra la conexión a la base de datos
            connection.close();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }*/
        
        String directorioOrigen = "C:\\OrigenPdf\\";
        File folder = new File(directorioOrigen);
	File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if (file.isFile()) {
                // Se valida que si el archivo es *.bmp
                String nombreArchivo = file.getName();
                System.out.println("NombreArchivo: " + nombreArchivo);
                if(nombreArchivo.contains("_Cbb.bmp")){
                    System.out.println("El archivo no es un xml");
                }
                else {
                    // Se toma el nombre para obtener el uuid
                    String uuid = file.toString();
                    uuid = uuid.replaceAll(".xml", "");
                    uuid = uuid.replaceAll("C:\\\\OrigenPdf\\\\", "");
                    System.out.println("uuid: " + uuid);
                    BuscarXml bx = new BuscarXml();
                    boolean resultado = bx.buscarRuta(uuid);    
                    MoverArchivoProcesado map = new MoverArchivoProcesado();
                    Boolean res = map.moverArchivo(uuid);
                }
            }
        }
    }
}
