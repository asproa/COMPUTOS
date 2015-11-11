/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EULEN.COMPUTOS.MODELOS;

/**
 *
 * @author jmsanchez
 */
public class Computo {
    private int idComputo;
    private int idEmpleado;
    private int añoComputo;
    private int mesComputo;
    private double horasDefectoComputo;
    private double horasDeducidasComputo;

    public Computo(int idComputo, int idEmpleado, int añoComputo, int mesComputo, double horasDefectoComputo, double horasDeducidasComputo) {
        this.idComputo = idComputo;
        this.idEmpleado = idEmpleado;
        this.añoComputo = añoComputo;
        this.mesComputo = mesComputo;
        this.horasDefectoComputo = horasDefectoComputo;
        this.horasDeducidasComputo = horasDeducidasComputo;
    }
    
    public int getAñoComputo() {
        return añoComputo;
    }

    public void setAñoComputo(int añoComputo) {
        this.añoComputo = añoComputo;
    }

    public double getHorasDeducidasComputo() {
        return horasDeducidasComputo;
    }

    public void setHorasDeducidasComputo(double horasDeducidasComputo) {
        this.horasDeducidasComputo = horasDeducidasComputo;
    }

    public double getHorasDefectoComputo() {
        return horasDefectoComputo;
    }

    public void setHorasDefectoComputo(double horasDefectoComputo) {
        this.horasDefectoComputo = horasDefectoComputo;
    }

    public int getIdComputo() {
        return idComputo;
    }

    public void setIdComputo(int idComputo) {
        this.idComputo = idComputo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getMesComputo() {
        return mesComputo;
    }

    public void setMesComputo(int mesComputo) {
        this.mesComputo = mesComputo;
    }
    
}
