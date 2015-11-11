/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EULEN.COMPUTOS.FUNCIONES;

/**
 *
 * @author jmsanchez
 */
public class Utiles {
    public String convertirNumeroMesaNombreMes(int pNumMes){
        String wRetNombreMes = "";
        switch (pNumMes){
            case -1:
               wRetNombreMes ="Noviembre Año Anterior";
               break;
            case 0:
               wRetNombreMes ="Diciembre Año Anterior";
               break;
            case 1:
               wRetNombreMes ="Enero";
               break;
            case 2:
               wRetNombreMes ="Febrero";
               break;
            case 3:
               wRetNombreMes ="Marzo";
               break;
            case 4:
               wRetNombreMes ="Abril";
               break;
            case 5:
               wRetNombreMes ="Mayo";
               break;
            case 6:
               wRetNombreMes ="Junio";
               break;
            case 7:
               wRetNombreMes ="Julio";
               break;
            case 8:
               wRetNombreMes ="Agosto";
               break;
            case 9:
               wRetNombreMes ="Septiembre";
               break;
            case 10:
               wRetNombreMes ="Octubre";
               break;
            case 11:
               wRetNombreMes ="Noviembre";
               break;
            case 12:
               wRetNombreMes ="Diciembre";
               break;
            default:
               wRetNombreMes ="ERROR NUMERO MES";
               break;
        }
        return wRetNombreMes;
    }
    public int convertirNombreMesaNumeroMes(String pNombreMes){
        int wRetNombreMes = 0;
        String wMes = pNombreMes.toUpperCase();
        if (wMes.equals("ENERO")){
           wRetNombreMes = 1; 
        } else {
            if (wMes.equals("FEBRERO")){
               wRetNombreMes = 2; 
            } else {
                if (wMes.equals("MARZO")){
                   wRetNombreMes = 3; 
                } else {
                    if (wMes.equals("ABRIL")){
                       wRetNombreMes = 4; 
                    } else {
                        if (wMes.equals("MAYO")){
                           wRetNombreMes = 5; 
                        } else {
                            if (wMes.equals("JUNIO")){
                               wRetNombreMes = 6; 
                            } else {
                                if (wMes.equals("JULIO")){
                                   wRetNombreMes = 7; 
                                } else {
                                    if (wMes.equals("AGOSTO")){
                                       wRetNombreMes = 8; 
                                    } else {
                                        if (wMes.equals("SEPTIEMBRE")){
                                           wRetNombreMes = 9; 
                                        } else {
                                            if (wMes.equals("OCTUBRE")){
                                               wRetNombreMes = 10; 
                                            } else {
                                                if (wMes.equals("NOVIEMBRE")){
                                                   wRetNombreMes = 11; 
                                                } else {
                                                    if (wMes.equals("DICIEMBRE")){
                                                       wRetNombreMes = 11; 
                                                    } 
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return wRetNombreMes;
    }
}
