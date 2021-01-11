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
public class LecturaXml {
     // Método para encontrar el NumEpleado del empleado
    public String empleado (String uuid, String directorioOrigen) {
        String empleado = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("NumEmpleado")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("NumEmpleado");
		int numI = num + 13;
		int numF = num + 18;
		empleado = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return empleado;
    }
    
    // Método para encontrar el nombre del empleado
    public String nombre (String linea) {
        String nombreEmpleado = "";
        int numI = 0;
	int numF = 0;
        boolean encontrado = false;
        boolean encontradoUno = false;
        int pos = 0;
        int posUno = 0;
        
        pos=pos+1;
        if(linea.contains("Nombre=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
	}
        
        if(encontrado == false) {
            pos = 0;
        }
        
        if(pos != 0) {
            int num = linea.indexOf("Nombre=");
            numI = num + 8;
        }
        else {
            System.out.println("No encontrado");
        }
        
        posUno = posUno+1;
        if(linea.contains("UsoCFDI")) {
            System.out.println("Si se encontró la linea");
            encontradoUno = true;
	}
        
        if(encontradoUno == false) {
            posUno = 0;
        }
        
        if(posUno != 0) {
            int num = linea.indexOf("UsoCFDI=");
            numF = num - 2;
            nombreEmpleado = linea.substring(numI, numF);
            System.out.println("Nombre: " + nombreEmpleado);
        }
        else {
            System.out.println("No encontrado");
        }
        return nombreEmpleado;
    }
    
    // Método para encontrar el valor del rfc 
    public String rfc (String linea) {
        String rfc = "";
        
        boolean encontrado = false;
        int pos = 0;
            
        pos=pos+1;
        if(linea.contains("Rfc")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
	}
			
        if(encontrado == false) {
            pos = 0;
        }
        if(pos != 0) {
            int num = linea.indexOf("Rfc");
            int numI = num + 5;
            int numF = num + 18;
            rfc = linea.substring(numI, numF);
        }
        else {
            System.out.println("No encontrado");
        }
        return rfc;
    }
    
    // Método para encontrar el valor del curp
    public String curp (String uuid, String directorioOrigen) {
        String curp = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("Curp")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("Curp");
		int numI = num + 6;
		int numF = num + 24;
		curp = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return curp;
    }
    
    // Método para encontrar el valor del NumSeguridadSocial
    public String nss (String uuid, String directorioOrigen) {
        String nss = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("NumSeguridadSocial")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("NumSeguridadSocial");
		int numI = num + 20;
		int numF = num + 31;
		nss = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return nss;
    }
    
    // Método para encontrar el valor del Departamento
    public String departamento (String linea) {
        String departamento = "";
        
        int numI = 0;
	int numF = 0;
        boolean encontrado = false;
        boolean encontradoUno = false;
        int pos = 0;
        int posUno = 0;
        
        pos=pos+1;
        if(linea.contains("Departamento=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
	}
        
        if(encontrado == false) {
            pos = 0;
        }
        
        if(pos != 0) {
            int num = linea.indexOf("Departamento=");
            numI = num + 14;
        }
        else {
            System.out.println("No encontrado");
        }
        
        posUno = posUno+1;
        if(linea.contains("PeriodicidadPago=")) {
            System.out.println("Si se encontró la linea");
            encontradoUno = true;
	}
        
        if(encontradoUno == false) {
            posUno = 0;
        }
        
        if(posUno != 0) {
            int num = linea.indexOf("PeriodicidadPago=");
            numF = num - 2;
            departamento = linea.substring(numI, numF);
            System.out.println("Nombre: " + departamento);
        }
        else {
            System.out.println("No encontrado");
        }
        return departamento;
    }
    
    // Método para encontrar el valor del FechaPago
    public String fechaPago (String uuid, String directorioOrigen) {
        String fechaPago = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("FechaPago")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("FechaPago");
		int numI = num + 11;
		int numF = num + 21;
		fechaPago = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return fechaPago;
    }
    
    // Método para encontrar el valor del FechaInicialPago
    public String fechaInicialPago (String uuid, String directorioOrigen) {
        String fechaInicialPago = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("FechaInicialPago")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("FechaInicialPago");
		int numI = num + 18;
		int numF = num + 28;
		fechaInicialPago = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return fechaInicialPago;
    }
    
    // Método para encontrar el valor del FechaFinalPago
    public String fechaFinalPago (String uuid, String directorioOrigen) {
        String fechaFinalPago = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("FechaFinalPago")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("FechaFinalPago");
		int numI = num + 16;
		int numF = num + 26;
		fechaFinalPago = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return fechaFinalPago;
    }
    
    // Método para encontrar el valor del NumDiasPagados
    public String numDiasPagados (String uuid, String directorioOrigen) {
        String numDiasPagados = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("NumDiasPagados")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("NumDiasPagados");
		int numI = num + 16;
		int numF = num + 18;
		numDiasPagados = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return numDiasPagados;
    }
    
    // Método para encontrar el valor de la Periodicidad del pago
    public String periodicidadPago (String uuid, String directorioOrigen) {
        String periodicidadPago = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("PeriodicidadPago")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("PeriodicidadPago");
		int numI = num + 18;
		int numF = num + 20;
		periodicidadPago = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return periodicidadPago;
    }
    
    // Método para encontrar el valor de la Periodicidad del Saladio Diario Integrado
    public String salarioDiarioIntegrado (String uuid, String directorioOrigen) {
        String salarioDiarioIntegrado = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            boolean encontradoUno = false;
            Iterator<String> iter = linea.iterator();
            Iterator<String> iterUno = linea.iterator();
            String curItem = "";
            String curItemUno = "";
            int pos = 0;
            int posUno = 0;
            int numI = 0;
            int numF = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("SalarioDiarioIntegrado")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("SalarioDiarioIntegrado");
		numI = num + 24;
		//int numF = num + 30;
		//salarioDiarioIntegrado = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
            
            while(iterUno.hasNext()==true) {
                posUno=posUno+1;
                curItemUno = (String)iterUno.next();
                if(curItemUno.contains("TipoRegimen")) {
                    System.out.println("Si se encontró la linea");
                    encontradoUno = true;
                    break;
		}
            }
			
            if(encontradoUno == false) {
		posUno = 0;
            }
            if(posUno != 0) {
		int num = curItem.indexOf("TipoRegimen");
		numF = num - 2;
		salarioDiarioIntegrado = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return salarioDiarioIntegrado;
    }
    
    // Método para determinar la catorcena que le corresponde al pago, hace falta el listado del fechaFinalPago
    public String noCatorcena(String fechaFinalPago) {
        String noCatorcena = "";
        if(fechaFinalPago.equals("2018-01-14") || (fechaFinalPago.equals("2019-01-13"))){
            noCatorcena = String.valueOf(1);
        }
        if(fechaFinalPago.equals("2018-01-28") || (fechaFinalPago.equals("2019-01-27"))){
            noCatorcena = String.valueOf(2);
        }
        if(fechaFinalPago.equals("2018-02-11") || (fechaFinalPago.equals("2019-02-10"))){
            noCatorcena = String.valueOf(3);
        }
        if(fechaFinalPago.equals("2018-02-25") || (fechaFinalPago.equals("2019-02-24"))){
            noCatorcena = String.valueOf(4);
        }
        if(fechaFinalPago.equals("2018-03-11") || (fechaFinalPago.equals("2019-03-10"))){
            noCatorcena = String.valueOf(5);
        }
        if(fechaFinalPago.equals("2018-03-25") || (fechaFinalPago.equals("2019-03-24"))){
            noCatorcena = String.valueOf(6);
        }
        if(fechaFinalPago.equals("2018-04-08") || (fechaFinalPago.equals("2019-04-07"))){
            noCatorcena = String.valueOf(7);
        }
        if(fechaFinalPago.equals("2018-04-22") || (fechaFinalPago.equals("2019-04-21"))){
            noCatorcena = String.valueOf(8);
        }
        if(fechaFinalPago.equals("2018-05-06") || (fechaFinalPago.equals("2019-05-05"))){
            noCatorcena = String.valueOf(9);
        }
        if(fechaFinalPago.equals("2018-05-20") || (fechaFinalPago.equals("2019-05-19"))){
            noCatorcena = String.valueOf(10);
        }
        if(fechaFinalPago.equals("2018-06-03") || (fechaFinalPago.equals("2019-06-02"))){
            noCatorcena = String.valueOf(11);
        }
        if(fechaFinalPago.equals("2018-06-17") || (fechaFinalPago.equals("2019-06-16"))){
            noCatorcena = String.valueOf(12);
        }
        if(fechaFinalPago.equals("2018-07-01") || (fechaFinalPago.equals("2019-06-30"))){
            noCatorcena = String.valueOf(13);
        }
        if(fechaFinalPago.equals("2018-07-15") || (fechaFinalPago.equals("2019-07-14"))){
            noCatorcena = String.valueOf(14);
        }
        if(fechaFinalPago.equals("2018-07-29") || (fechaFinalPago.equals("2019-07-28"))){
            noCatorcena = String.valueOf(15);
        }
        if(fechaFinalPago.equals("2018-08-12") || (fechaFinalPago.equals("2019-08-11"))){
            noCatorcena = String.valueOf(16);
        }
        if(fechaFinalPago.equals("2018-08-26") || (fechaFinalPago.equals("2019-08-25"))){
            noCatorcena = String.valueOf(17);
        }
        if(fechaFinalPago.equals("2018-09-09") || (fechaFinalPago.equals("2019-09-08"))){
            noCatorcena = String.valueOf(18);
        }
        if(fechaFinalPago.equals("2018-09-23") || (fechaFinalPago.equals("2019-09-22"))){
            noCatorcena = String.valueOf(19);
        }
        if(fechaFinalPago.equals("2018-10-07") || (fechaFinalPago.equals("2019-10-06"))){
            noCatorcena = String.valueOf(20);
        }
        if(fechaFinalPago.equals("2018-10-21") || (fechaFinalPago.equals("2019-10-20"))){
            noCatorcena = String.valueOf(21);
        }
        if(fechaFinalPago.equals("2018-11-04") || (fechaFinalPago.equals("2019-11-03"))){
            noCatorcena = String.valueOf(22);
        }
        if(fechaFinalPago.equals("2018-11-18") || (fechaFinalPago.equals("2019-11-17"))){
            noCatorcena = String.valueOf(23);
        }
        if(fechaFinalPago.equals("2018-12-02") || (fechaFinalPago.equals("2019-11-01"))){
            noCatorcena = String.valueOf(24);
        }
        if(fechaFinalPago.equals("2018-12-16") || (fechaFinalPago.equals("2019-12-15"))){
            noCatorcena = String.valueOf(25);
        }
        if(fechaFinalPago.equals("2018-12-30") || (fechaFinalPago.equals("2019-12-29"))){
            noCatorcena = String.valueOf(26);
        }
        
        return noCatorcena;
    }
    
    // Método para encontrar el valor del Método de Pago
    public String metodoPago(String uuid, String directorioOrigen) {
        String metodoPago = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("MetodoPago")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("MetodoPago");
		int numI = num + 12;
		int numF = num + 15;
		metodoPago = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return metodoPago;
    }
    
    // Método para encontrar el valor de la moneda
    public String moneda(String uuid, String directorioOrigen) {
        String moneda = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("Moneda")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("Moneda");
		int numI = num + 8;
		int numF = num + 11;
		moneda = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return moneda;
    }
    
    // Método para encontrar el valor del deducido
    public String deducido(String uuid, String directorioOrigen) {
        String deducido = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("Descuento")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("Descuento");
		int numI = num + 11;
		int numF = num + 18;
		deducido = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return deducido;
    }
    
    // Método para encontrar el valor del NoCertificado
    public String noCertificado(String uuid, String directorioOrigen) {
        String noCertificado = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("NoCertificado")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("NoCertificado");
		int numI = num + 15;
		int numF = num + 35;
		noCertificado = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return noCertificado;
    }
    
    // Método para encontrar el valor del NoCertificadoSat
    public String noCertificadoSat(String uuid, String directorioOrigen) {
        String noCertificadoSat = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("NoCertificadoSAT")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("NoCertificadoSAT");
		int numI = num + 18;
		int numF = num + 38;
		noCertificadoSat = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return noCertificadoSat;
    }
    
    // Método para encontrar el valor del FechaTimbrado
    public String fechaTimbrado(String uuid, String directorioOrigen) {
        String fechaTimbrado = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("FechaTimbrado")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("FechaTimbrado");
		int numI = num + 15;
		int numF = num + 34;
		fechaTimbrado = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return fechaTimbrado;
    }
    
    // Método para encontrar el valor del SelloCFD
    public String selloCfd(String uuid, String directorioOrigen) {
        String selloCfd = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("SelloCFD")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("SelloCFD");
		int numI = num + 10;
		int numF = num + 354;
		selloCfd = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return selloCfd;
    }
    
    // Método para encontrar el valor del SelloSAT
    public String selloSat(String uuid, String directorioOrigen) {
        String selloSat = "";
        String archivo = uuid.concat(".xml");
        
        try {
            List<String> linea = Files.readAllLines(Paths.get(directorioOrigen + archivo));
            
            boolean encontrado = false;
            Iterator<String> iter = linea.iterator();
            String curItem = "";
            int pos = 0;
            
            while(iter.hasNext()==true) {
                pos=pos+1;
                curItem = (String)iter.next();
                if(curItem.contains("SelloSAT")) {
                    System.out.println("Si se encontró la linea");
                    encontrado = true;
                    break;
		}
            }
			
            if(encontrado == false) {
		pos = 0;
            }
            if(pos != 0) {
		int num = curItem.indexOf("SelloSAT");
		int numI = num + 10;
		int numF = num + 354;
		selloSat = curItem.substring(numI, numF);
            }
            else {
		System.out.println("No encontrado");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return selloSat;
    }
    
    // Método para encontrar el importe de las deducciones
    public String importeDeducciones(String linea) {
        String importe = "";
        int numI = 0;
	int numF = 0;
        boolean encontrado = false;
        int pos = 0;
        
        pos=pos+1;
        if(linea.contains("Concepto=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
	}
        
        if(encontrado == false) {
            pos = 0;
        }
        
        if(pos != 0) {
            int num = linea.indexOf("Concepto=");
            numF = num - 2;
            importe = linea.substring(numI, numF);
            //System.out.println("Importe: " + importe);
        }
        else {
            System.out.println("No encontrado");
        }
        return importe;
    }
    
    // Método para encontrar el concepto de las deducciones
    public String conceptoDeducciones (String linea) {
        String conceptoDeducciones = "";
        int numI = 0;
	int numF = 0;
        boolean encontrado = false;
        boolean encontradoUno = false;
        int pos = 0;
        int posUno = 0;
        
        pos=pos+1;
        if(linea.contains("Concepto=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
	}
        
        if(encontrado == false) {
            pos = 0;
        }
        
        if(pos != 0) {
            int num = linea.indexOf("Concepto=");
            numI = num + 10;
        }
        else {
            System.out.println("No encontrado");
        }
        
        posUno = posUno+1;
        if(linea.contains("Clave=")) {
            System.out.println("Si se encontró la linea");
            encontradoUno = true;
	}
        
        if(encontradoUno == false) {
            posUno = 0;
        }
        
        if(posUno != 0) {
            int num = linea.indexOf("Clave=");
            numF = num - 2;
            conceptoDeducciones = linea.substring(numI, numF);
            //System.out.println("Nombre: " + conceptoDeducciones);
        }
        else {
            System.out.println("No encontrado");
        }
        return conceptoDeducciones;
    }
    
    // Método para encontrar el clave de las deducciones
    public String claveDeducciones (String linea) {
        String claveDeducciones = "";
        int numI = 0;
	int numF = 0;
        boolean encontrado = false;
        boolean encontradoUno = false;
        int pos = 0;
        int posUno = 0;
        
        pos=pos+1;
        if(linea.contains("Clave=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
	}
        
        if(encontrado == false) {
            pos = 0;
        }
        
        if(pos != 0) {
            int num = linea.indexOf("Clave=");
            numI = num + 7;
        }
        else {
            System.out.println("No encontrado");
        }
        
        posUno = posUno+1;
        if(linea.contains("TipoDeduccion=")) {
            System.out.println("Si se encontró la linea");
            encontradoUno = true;
	}
        
        if(encontradoUno == false) {
            posUno = 0;
        }
        
        if(posUno != 0) {
            int num = linea.indexOf("TipoDeduccion=");
            numF = num - 2;
            claveDeducciones = linea.substring(numI, numF);
            //System.out.println("Clave: " + claveDeducciones);
        }
        else {
            System.out.println("No encontrado");
        }
        return claveDeducciones;
    }
    
    // Método para encontrar el TipoDeduccion de las deducciones
    public String tipoDeduccion (String linea) {
        String tipoDeduccion = "";
        
        boolean encontrado = false;
        int pos = 0;
            
        pos=pos+1;
        if(linea.contains("TipoDeduccion=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
	}
			
        if(encontrado == false) {
            pos = 0;
        }
        if(pos != 0) {
            int num = linea.indexOf("TipoDeduccion=");
            int numI = num + 15;
            int numF = num + 18;
            tipoDeduccion = linea.substring(numI, numF);
            //System.out.println("tipoDeduccion: " + tipoDeduccion);
        }
        else {
            System.out.println("No encontrado");
        }
        return tipoDeduccion;
    }
    
    // Método para encontrar el concepto de las percepiones
    public String conceptoPercepciones (String linea) {
        String conceptoPercepciones = "";
        int numI = 0;
	int numF = 0;
        boolean encontrado = false;
        boolean encontradoUno = false;
        int pos = 0;
        int posUno = 0;
        
        pos=pos+1;
        if(linea.contains("Concepto=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
	}
        
        if(encontrado == false) {
            pos = 0;
        }
        
        if(pos != 0) {
            int num = linea.indexOf("Concepto=");
            numI = num + 10;
        }
        else {
            System.out.println("No encontrado");
        }
        
        posUno = posUno+1;
        if(linea.contains("Clave=")) {
            System.out.println("Si se encontró la linea");
            encontradoUno = true;
	}
        
        if(encontradoUno == false) {
            posUno = 0;
        }
        
        if(posUno != 0) {
            int num = linea.indexOf("Clave=");
            numF = num - 2;
            conceptoPercepciones = linea.substring(numI, numF);
            //System.out.println("Nombre: " + conceptoDeducciones);
        }
        else {
            System.out.println("No encontrado");
        }
        return conceptoPercepciones;
    }
    
    // Método para encontrar el clave de las percepciones
    public String clavePercepciones (String linea) {
        String clavePercepciones = "";
        int numI = 0;
	int numF = 0;
        boolean encontrado = false;
        boolean encontradoUno = false;
        int pos = 0;
        int posUno = 0;
        
        pos=pos+1;
        if(linea.contains("Clave=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
	}
        
        if(encontrado == false) {
            pos = 0;
        }
        
        if(pos != 0) {
            int num = linea.indexOf("Clave=");
            numI = num + 7;
        }
        else {
            System.out.println("No encontrado");
        }
        
        posUno = posUno+1;
        if(linea.contains("TipoPercepcion=")) {
            System.out.println("Si se encontró la linea");
            encontradoUno = true;
	}
        
        if(encontradoUno == false) {
            posUno = 0;
        }
        
        if(posUno != 0) {
            int num = linea.indexOf("TipoPercepcion=");
            numF = num - 2;
            clavePercepciones = linea.substring(numI, numF);
            //System.out.println("Clave: " + claveDeducciones);
        }
        else {
            System.out.println("No encontrado");
        }
        return clavePercepciones;
    }
    
    // Método para encontrar el TipoDeduccion de las deducciones
    public String tipoPercepcion (String linea) {
        String tipoPercepcion = "";
        
        boolean encontrado = false;
        int pos = 0;
            
        pos=pos+1;
        if(linea.contains("TipoPercepcion=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
	}
			
        if(encontrado == false) {
            pos = 0;
        }
        if(pos != 0) {
            int num = linea.indexOf("TipoPercepcion=");
            int numI = num + 16;
            int numF = num + 19;
            tipoPercepcion = linea.substring(numI, numF);
            //System.out.println("tipoDeduccion: " + tipoDeduccion);
        }
        else {
            System.out.println("No encontrado");
        }
        return tipoPercepcion;
    }
    
    // Método para encontrar el importe exento de las percepciones
    public String importeExentoPercepciones(String linea) {
        String importe = "";
        int numI = 0;
	int numF = 0;
        boolean encontrado = false;
        int pos = 0;
        int posUno = 0;
        System.out.println("linea: " + linea);
        pos=pos+1;
        if(linea.contains("Exento=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
            numI = pos + 7;
	}
        
        if(encontrado == false) {
            pos = 0;
        }
        
        if(pos != 0) {
            int num = linea.indexOf("ImporteGravado=");
            numF = num - 2;
            importe = linea.substring(numI, numF);
            //System.out.println("Importe: " + importe);
        }
        else {
            System.out.println("No encontrado");
        }
        return importe;
    }
    
    // Método para encontrar el importe gravado de las percepciones
    public String importeGravadoPercepciones(String linea) {
        String importe = "";
        int numI = 0;
	int numF = 0;
        boolean encontrado = false;
        int pos = 0;
        
        pos=pos+1;
        if(linea.contains("ImporteGravado=")) {
            System.out.println("Si se encontró la linea");
            encontrado = true;
            numI = linea.indexOf("ImporteGravado=");
            numI = numI + 16;
	}
        
        if(encontrado == false) {
            pos = 0;
        }
        
        if(pos != 0) {
            int num = linea.indexOf("Concepto=");
            numF = num - 2;
            importe = linea.substring(numI, numF);
            //System.out.println("Importe: " + importe);
        }
        else {
            System.out.println("No encontrado");
        }
        return importe;
    }
}
