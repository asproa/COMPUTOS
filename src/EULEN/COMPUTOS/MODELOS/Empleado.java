/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EULEN.COMPUTOS.MODELOS;

/**
 *
 * @author jmsanchez
 */
public class Empleado {
    private int idEmpleado;
    private int idGestor;
    private String nombreEmpleado;
    private String apellido1Empleado;
    private String apellido2Empleado;
    private String dniEmpleado;

    public Empleado(int idEmpleado, int idGestor, String nombreEmpleado, String apellido1Empleado, String apellido2Empleado, String dniEmpleado) {
        this.idEmpleado = idEmpleado;
        this.idGestor = idGestor;
        this.nombreEmpleado = nombreEmpleado;
        this.apellido1Empleado = apellido1Empleado;
        this.apellido2Empleado = apellido2Empleado;
        this.dniEmpleado = dniEmpleado;
    }
    
    public String getApellido1Empleado() {
        return apellido1Empleado;
    }

    public void setApellido1Empleado(String apellido1Empleado) {
        this.apellido1Empleado = apellido1Empleado;
    }

    public String getApellido2Empleado() {
        return apellido2Empleado;
    }

    public void setApellido2Empleado(String apellido2Empleado) {
        this.apellido2Empleado = apellido2Empleado;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(int idGestor) {
        this.idGestor = idGestor;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
    
}
