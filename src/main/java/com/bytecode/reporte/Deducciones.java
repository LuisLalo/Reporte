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
public class Deducciones {
    private String importe;
    private String concepto;
    private String clave;
    private String tipoDeduccion;
    
    public Deducciones() {
        
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
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

    public String getTipoDeduccion() {
        return tipoDeduccion;
    }

    public void setTipoDeduccion(String tipoDeduccion) {
        this.tipoDeduccion = tipoDeduccion;
    }

    @Override
    public String toString() {
        return "Deducciones{" + "importe=" + importe + ", concepto=" + concepto + ", clave=" + clave + ", tipoDeduccion=" + tipoDeduccion + '}';
    }
}
