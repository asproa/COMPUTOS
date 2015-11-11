/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EULEN.COMPUTOS.MODELOS;

/**
 *
 * @author jmsanchez
 */
public class Gestor { 
    private int idGestor;
    private int numeroGestor;
    private String nombreGestor;

    public Gestor(int idGestor, int numeroGestor, String nombreGestor) {
        this.idGestor = idGestor;
        this.numeroGestor = numeroGestor;
        this.nombreGestor = nombreGestor;
    }
           
    public int getId() {
        return idGestor;
    }

    public void setidGestor(int id) {
        this.idGestor = id;
    }

    public String getNombreGestor() {
        return nombreGestor;
    }

    public void setNombreGestor(String nombreGestor) {
        this.nombreGestor = nombreGestor;
    }

    public int getNumeroGestor() {
        return numeroGestor;
    }

    public void setNumeroGestor(int numeroGestor) {
        this.numeroGestor = numeroGestor;
    }
}
