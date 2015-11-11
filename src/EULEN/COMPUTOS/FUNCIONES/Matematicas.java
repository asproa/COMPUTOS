/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EULEN.COMPUTOS.FUNCIONES;

/**
 *
 * @author jmsanchez
 */
public class Matematicas {
  public double redondear( double numero, int decimales ) {
    return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
  }

}
