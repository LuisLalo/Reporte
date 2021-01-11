/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.reporte;

/**
 *
 * @author Luis Lalo
 */
public class Percepciones {
    private String importeExento;
    private String importeGravado;
    private String concepto;
    private String clave;
    private String tipoPercepcion;
    
    public Percepciones(){
        
    }

    public String getImporteExento() {
        return importeExento;
    }

    public void setImporteExento(String importeExento) {
        this.importeExento = importeExento;
    }

    public String getImporteGravado() {
        return importeGravado;
    }

    public void setImporteGravado(String importeGravado) {
        this.importeGravado = importeGravado;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoPercepcion() {
        return tipoPercepcion;
    }

    public void setTipoPercepcion(String tipoPercepcion) {
        this.tipoPercepcion = tipoPercepcion;
    }

    @Override
    public String toString() {
        return "Percepciones{" + "importeExento=" + importeExento + ", importeGravado=" + importeGravado + ", concepto=" + concepto + ", clave=" + clave + ", tipoPercepcion=" + tipoPercepcion + '}';
    }
}
