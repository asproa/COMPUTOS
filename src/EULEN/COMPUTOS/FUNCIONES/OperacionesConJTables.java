/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EULEN.COMPUTOS.FUNCIONES;

import EULEN.COMPUTOS.VISTAS.Consulta;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jmsanchez
 */
public class OperacionesConJTables {
    public void vaciarJTable(JTable pJTable, DefaultTableModel pModeloTabla) {
        DefaultTableModel Oldmodelo = (DefaultTableModel) pJTable.getModel();
        for (int x = pJTable.getRowCount() - 1; x >= 0; x--) {
            Oldmodelo.removeRow(x);
        }
        pJTable.setModel(Oldmodelo);
    }
    
    public void cambiarTituloColumna(JTable pJTable, String pColumnName, String pNuevoTitulo) {
        pJTable.getColumn(pColumnName).setHeaderValue(pNuevoTitulo); 
        
    }
}
