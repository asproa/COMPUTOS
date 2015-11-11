/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EULEN.COMPUTOS.FUNCIONES;

import java.awt.Font;
import javax.swing.JTable;

/**
 *
 * @author jmsanchez
 */
public class FuncionesObjetoJTable {

    public void establecerFontyCaracteristicasdeJTabla(JTable pTable, String pNombreFuente, String pTipo, int pTamaño){
       Font fuente = new  Font ( pNombreFuente ,  Font.PLAIN ,  pTamaño );
        if (pTipo.toUpperCase().equals("NORMAL")){         
           fuente = new  Font ( pNombreFuente ,  Font.PLAIN ,  pTamaño );
        } else {
           if (pTipo.toUpperCase().equals("NEGRITA")){         
               fuente = new  Font ( pNombreFuente ,  Font.BOLD ,  pTamaño );
           } else {
               if (pTipo.toUpperCase().equals("CURSIVA")){         
                  fuente = new  Font ( pNombreFuente ,  Font.ITALIC ,  pTamaño ); 
               } else {
                  fuente = new  Font ( pNombreFuente ,  Font.PLAIN ,  pTamaño ); 
               }
           }
        }   
        pTable.setFont (fuente);
   } 
   public void establecerAnchoColumna(JTable pTable, int pNumColumna, int pAncho){
        pTable.getColumnModel().getColumn(pNumColumna).setMinWidth( pAncho);
        pTable.getColumnModel().getColumn(pNumColumna).setPreferredWidth( pAncho);
        pTable.getColumnModel().getColumn(pNumColumna).setMaxWidth( pAncho);
   }   
}
