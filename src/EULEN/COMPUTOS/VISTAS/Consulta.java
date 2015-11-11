/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Consulta.java
 *
 * Created on 08-may-2014, 12:25:21
 */
package EULEN.COMPUTOS.VISTAS;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import EULEN.COMPUTOS.FUNCIONES.OperacionesConJTables;
import EULEN.COMPUTOS.FUNCIONES.Utiles;
import EULEN.COMPUTOS.FUNCIONES.Matematicas;
import EULEN.COMPUTOS.DATA.DB_COMPUTO;
import EULEN.COMPUTOS.FUNCIONES.FuncionesObjetoJTable;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;
import java.text.MessageFormat;

/**
 *
 * @author jmsanchez
 */
public class Consulta extends javax.swing.JDialog {
    private OperacionesConJTables tablasOperaciones;
    private Utiles util;
    private java.sql.ResultSet rs;
    private DB_COMPUTO BD;
    private FuncionesObjetoJTable funcJTable;
    private Matematicas funcionMatematica;
        
    /** Creates new form Consulta */
    public Consulta(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("ImagenUsuarioReloj.jpg")));
        setResizable(true);
        Dimension d = this.getToolkit().getScreenSize();
        Double alto = d.height -(d.height * 0.04);
        int x =  alto.intValue();
        this.setSize(d.width,x);
        System.out.println("Ancho de pantalla : "+ d.width);
        System.out.println("Alto de pantalla : "+ d.height);
        cargarComboAños();
        cargarComboMeses(this.jCmb_Años.getSelectedItem().toString());
        jTable1.setRowHeight(24 + 12);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtn_Cerrar = new javax.swing.JButton();
        jBtn_ConsultarHorasBajoComputo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCmb_Años = new javax.swing.JComboBox();
        jCmb_Meses = new javax.swing.JComboBox();
        jBtn_ImprimirInforme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(EULEN.COMPUTOS.VISTAS.App.class).getContext().getResourceMap(Consulta.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Gestor", "DNI / CONTRATO", "Nombre Empleado", "Bajo Computo Mes1", "Bajo Computo Mes2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTable1.columnModel.title4")); // NOI18N
        jTable1.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTable1.columnModel.title1")); // NOI18N
        jTable1.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTable1.columnModel.title0")); // NOI18N
        jTable1.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTable1.columnModel.title2")); // NOI18N
        jTable1.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTable1.columnModel.title3")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        jBtn_Cerrar.setText(resourceMap.getString("jBtn_Cerrar.text")); // NOI18N
        jBtn_Cerrar.setName("jBtn_Cerrar"); // NOI18N
        jBtn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_CerrarActionPerformed(evt);
            }
        });

        jBtn_ConsultarHorasBajoComputo.setText(resourceMap.getString("jBtn_ConsultarHorasBajoComputo.text")); // NOI18N
        jBtn_ConsultarHorasBajoComputo.setName("jBtn_ConsultarHorasBajoComputo"); // NOI18N
        jBtn_ConsultarHorasBajoComputo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ConsultarHorasBajoComputoActionPerformed(evt);
            }
        });

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jCmb_Años.setName("jCmb_Años"); // NOI18N
        jCmb_Años.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCmb_AñosItemStateChanged(evt);
            }
        });
        jCmb_Años.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCmb_AñosFocusLost(evt);
            }
        });

        jCmb_Meses.setMaximumRowCount(15);
        jCmb_Meses.setName("jCmb_Meses"); // NOI18N
        jCmb_Meses.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jCmb_MesesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCmb_MesesFocusLost(evt);
            }
        });

        jBtn_ImprimirInforme.setText(resourceMap.getString("jBtn_ImprimirInforme.text")); // NOI18N
        jBtn_ImprimirInforme.setName("jBtn_ImprimirInforme"); // NOI18N
        jBtn_ImprimirInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ImprimirInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtn_ImprimirInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jBtn_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCmb_Años, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCmb_Meses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtn_ConsultarHorasBajoComputo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jCmb_Años, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jCmb_Meses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtn_ConsultarHorasBajoComputo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_ImprimirInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_ConsultarHorasBajoComputoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ConsultarHorasBajoComputoActionPerformed
       int numMes_Cuadrante_a_Preparar;
       int numMesQuery;
       String keyVariable = "";
       Boolean esElPrimerRegistrodelaConsulta = true;
       final int numMesesporAño = 12;
       tablasOperaciones = new OperacionesConJTables();
       util = new Utiles();
       //List cellDataList = new ArrayList();
       
       String wAño = this.jCmb_Años.getSelectedItem().toString();
       String wMes = String.valueOf(util.convertirNombreMesaNumeroMes(this.jCmb_Meses.getSelectedItem().toString()));
       numMes_Cuadrante_a_Preparar = Integer.parseInt(wMes);
       
       String wTituloColumna1 = util.convertirNumeroMesaNombreMes(numMes_Cuadrante_a_Preparar).toUpperCase();
       String wTituloColumna2 = "";
       if (numMes_Cuadrante_a_Preparar == 12){
          wTituloColumna2 = wTituloColumna1;
       } else {
         wTituloColumna2 = util.convertirNumeroMesaNombreMes(numMes_Cuadrante_a_Preparar + 1).toUpperCase();
       }  
       CargarConfiguraciondeTabla(this.jTable1,wTituloColumna1, wTituloColumna2);
       DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
       for (int i = modelo.getRowCount()-1; i >= 0 ; i--){
           modelo.removeRow(i);
       }
       //modelo.addRow( new String[5]);
       
       jTable1.setModel(modelo);
       
       // Para dimensionar el siguiente array le quito 2 por
       // Quito 1 porque el indice empieza en 0 (cero) y 
       // otro pues el último mes que tengo datos es el mes anterior al que se quiere preparar
       String[][] arrayDatosResultSet;
       try{
            BD = new DB_COMPUTO();
            String strsql = "SELECT ";
            strsql = strsql + " EMPLEADOS.NM_GESTOR, COMPUTOS.NM_AÑO, COMPUTOS.NM_MES, COMPUTOS.TX_DNI, COMPUTOS.TX_NUM_CONTRATO, EMPLEADOS.TX_APELLIDO1, EMPLEADOS.TX_APELLIDO2, EMPLEADOS.TX_NOMBRE,";
            strsql = strsql + " COMPUTOS.NM_HORAS_DEFECTO_ANTES, COMPUTOS.NM_HORAS_DEFECTO, COMPUTOS.NM_HORAS_DEDUCIDAS";
            strsql = strsql + " FROM COMPUTOS, EMPLEADOS, GESTORES";
            strsql = strsql + " WHERE ";
            if (!EULEN.COMPUTOS.VISTAS.Main.wNombreUsuario.equals("Administrador del Programa")){
               strsql = strsql + " GESTORES.NM_GESTOR = " + EULEN.COMPUTOS.VISTAS.Main.wNombreUsuario + " AND ";
            }
            strsql = strsql + " EMPLEADOS.NM_GESTOR = GESTORES.NM_GESTOR";
            strsql = strsql + " AND COMPUTOS.TX_DNI = EMPLEADOS.TX_DNI";
            strsql = strsql + " AND NM_AÑO = " + wAño;
            strsql = strsql + " AND NM_MES <= " + numMes_Cuadrante_a_Preparar;
            strsql = strsql + " AND TX_TIPO_HORAS = 'Normales:'";
            strsql = strsql + " ORDER BY NM_GESTOR, COMPUTOS.TX_DNI + COMPUTOS.TX_NUM_CONTRATO, NM_AÑO, NM_MES";
            rs=BD.Consulta(strsql);
            rs.last();
            int numRegs = rs.getRow();
            // El número de columnas es el número de meses más 1 ya que voy a despreciar el inidce cero de la tabla de forma
            // que cada numero de mes coicida con indice en la tabla
            // esta tabla-array se emplea una vez por cada empleado de la tabla de BD.
            // de forma que tengo todos los datos del año de cada empleado 
            // y es aquí donde voy calculando los saldos: es decir las horas defecto que les van quedando pendientes o arrastre.
            // la segunda dimensión del array tiene por dimensión el número de campos (de la tabla DB) que quiero incluir
            // En el siguiente proceso cada vez que se trata de un DNI nuevo o un numero de contrato nuevo, se almacena la información con los saldos del empleado actual,
            // se inicializa el array y la clave compuesta por DNI + Numero de Contrato (para el caso de un empleado cause alta, baja, alta,etc)
            arrayDatosResultSet = new String [numMesesporAño+1][12]; // Porque los meses son 12 pero como empieza en el cero y necesito los indices del 1 al 12, por lo tanto sumo 2 uno del cero y otro del 12.
            arrayDatosResultSet = inicializarArray(arrayDatosResultSet);
            rs.beforeFirst();
            // La fila cero (0) se desprecia, para provocar que coincida numero de fila = numero de mes.
            int indiceFila = 1;
            keyVariable = "";
            esElPrimerRegistrodelaConsulta = true;
            while(rs.next()){
               if (keyVariable.equals(rs.getString("COMPUTOS.TX_DNI") + rs.getString("COMPUTOS.TX_NUM_CONTRATO"))){ 
                   indiceFila = rs.getInt("COMPUTOS.NM_MES");
                   arrayDatosResultSet[indiceFila][0] = rs.getString("EMPLEADOS.NM_GESTOR");    
                   arrayDatosResultSet[indiceFila][1] = rs.getString("COMPUTOS.NM_AÑO");
                   arrayDatosResultSet[indiceFila][2] = rs.getString("COMPUTOS.NM_MES");
                   arrayDatosResultSet[indiceFila][3] = rs.getString("COMPUTOS.TX_DNI") + " / " + rs.getString("COMPUTOS.TX_NUM_CONTRATO");
                   arrayDatosResultSet[indiceFila][4] = rs.getString("EMPLEADOS.TX_APELLIDO1");
                   arrayDatosResultSet[indiceFila][5] = rs.getString("EMPLEADOS.TX_APELLIDO2");               
                   arrayDatosResultSet[indiceFila][6] = rs.getString("EMPLEADOS.TX_NOMBRE");               
                   arrayDatosResultSet[indiceFila][7] = rs.getString("COMPUTOS.NM_HORAS_DEFECTO_ANTES");               
                   arrayDatosResultSet[indiceFila][8] = rs.getString("COMPUTOS.NM_HORAS_DEFECTO");               
                   arrayDatosResultSet[indiceFila][9] = rs.getString("COMPUTOS.NM_HORAS_DEDUCIDAS");
                   //indiceFila++;
               } else {
               if (!esElPrimerRegistrodelaConsulta){
                      arrayDatosResultSet = aplicarAlgoritmoalEmpleado(arrayDatosResultSet);
                      modelo = añadirEstosDatosalControlTabla(arrayDatosResultSet, numMes_Cuadrante_a_Preparar, modelo);
                      arrayDatosResultSet = inicializarArray(arrayDatosResultSet);
                   } else {
                     esElPrimerRegistrodelaConsulta = false;                       
                   }
                   indiceFila = rs.getInt("COMPUTOS.NM_MES");
                   keyVariable = rs.getString("COMPUTOS.TX_DNI") + rs.getString("COMPUTOS.TX_NUM_CONTRATO");
                   arrayDatosResultSet[indiceFila][0] = rs.getString("EMPLEADOS.NM_GESTOR");    
                   arrayDatosResultSet[indiceFila][1] = rs.getString("COMPUTOS.NM_AÑO");
                   arrayDatosResultSet[indiceFila][2] = rs.getString("COMPUTOS.NM_MES");
                   arrayDatosResultSet[indiceFila][3] = rs.getString("COMPUTOS.TX_DNI") + " / " + rs.getString("COMPUTOS.TX_NUM_CONTRATO");
                   arrayDatosResultSet[indiceFila][4] = rs.getString("EMPLEADOS.TX_APELLIDO1");
                   arrayDatosResultSet[indiceFila][5] = rs.getString("EMPLEADOS.TX_APELLIDO2");               
                   arrayDatosResultSet[indiceFila][6] = rs.getString("EMPLEADOS.TX_NOMBRE");               
                   arrayDatosResultSet[indiceFila][7] = rs.getString("COMPUTOS.NM_HORAS_DEFECTO_ANTES");               
                   arrayDatosResultSet[indiceFila][8] = rs.getString("COMPUTOS.NM_HORAS_DEFECTO");               
                   arrayDatosResultSet[indiceFila][9] = rs.getString("COMPUTOS.NM_HORAS_DEDUCIDAS");
                   arrayDatosResultSet[indiceFila][10] = "0"; // Saldo o Mueren
                   arrayDatosResultSet[indiceFila][11] = "0"; 
                   //indiceFila++;   
               } 
            } 
            arrayDatosResultSet = aplicarAlgoritmoalEmpleado(arrayDatosResultSet);
            modelo = añadirEstosDatosalControlTabla(arrayDatosResultSet, numMes_Cuadrante_a_Preparar, modelo);
            BD.cerrarConexion();
            
            jTable1.setModel(modelo);
            if (this.jTable1.getRowCount()>=1){
                
               modelo = redondearHoras(modelo);
               jTable1.setModel(modelo);
            } else {
            //   CargarConfiguraciondeTabla(this.jTable1,wTituloColumna1, wTituloColumna2);
            }
            int wTamañoLetra = 18;
            FuncionesObjetoJTable funcJTable = new FuncionesObjetoJTable();
            funcJTable.establecerFontyCaracteristicasdeJTabla(jTable1, "Dialog", "NORMAL", wTamañoLetra);
            TableRowSorter sorter = new TableRowSorter(modelo);
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jTable1.setAutoscrolls(true);
            //jTable1.setAutoCreateRowSorter(true);
            jTable1.setRowSorter(sorter);
            jTable1.setAutoResizeMode(1);
            
        }
        catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,  "ERROR: " + e.toString(),"INFORMACIÓN DE ERROR", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.toString()+"\n"+ e);
        } 
       
    }//GEN-LAST:event_jBtn_ConsultarHorasBajoComputoActionPerformed

    private void jBtn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_CerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBtn_CerrarActionPerformed

    private void jBtn_ImprimirInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ImprimirInformeActionPerformed
        try {
          MessageFormat headerFormat = new MessageFormat("HORAS DEFECTO. AÑO " +  this.jCmb_Años.getSelectedItem().toString() + ", MES " + this.jCmb_Meses.getSelectedItem().toString());
          MessageFormat footerFormat = new MessageFormat("LISTADO SOLICITADO POR EL GESTOR " + EULEN.COMPUTOS.VISTAS.Main.wNombreUsuario +".");
          jTable1.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
          //  this.jTable1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtn_ImprimirInformeActionPerformed

    private void jCmb_AñosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCmb_AñosItemStateChanged
        // TODO add your handling code here:
        //cargarComboMeses(this.jCmb_Años.getSelectedItem().toString());
    }//GEN-LAST:event_jCmb_AñosItemStateChanged

    private void jCmb_MesesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCmb_MesesFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jCmb_MesesFocusLost

    private void jCmb_MesesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCmb_MesesFocusGained
        // TODO add your handling code here:
            
    }//GEN-LAST:event_jCmb_MesesFocusGained

    private void jCmb_AñosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCmb_AñosFocusLost
        // TODO add your handling code here:
        cargarComboMeses(this.jCmb_Años.getSelectedItem().toString());
    }//GEN-LAST:event_jCmb_AñosFocusLost

private void cargarTabla(List cellDataList){
   for (int i = 0; i < cellDataList.size(); i++) {
       List cellTempList = (List) cellDataList.get(i);
       for (int j = 0; j < cellTempList.size(); j++){
           HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
           String stringCellValue = hssfCell.toString();
           System.out.print(stringCellValue + "\t");
       }
       System.out.println();
   }
}
private void cargarComboMeses(String pAño){
    this.jCmb_Meses.removeAllItems();
    this.jCmb_Meses.setSelectedIndex(-1);
    int nMes = 0;
    util = new Utiles();
    try{
        BD = new DB_COMPUTO();
        String strsql ="SELECT NM_MES FROM COMPUTOS.COMPUTOS WHERE NM_AÑO = " + pAño + " GROUP BY NM_MES;";
        rs=BD.Consulta(strsql);
        rs.beforeFirst();
        while (rs.next()){
           nMes = rs.getInt("NM_MES");
           this.jCmb_Meses.addItem(util.convertirNumeroMesaNombreMes(nMes));
        }
        //Teniendo en cuenta que se puede querer preparar el cuadrante de horas de un mes mas al ultimo mes que tengamos en la base de datos
        //entonces sumamos un mes más de los que disponemos para hacer esta previsión
        if (nMes < 12){
           nMes++;
        }
        this.jCmb_Meses.addItem(util.convertirNumeroMesaNombreMes(nMes));
        BD.cerrarConexion();
    }
    catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null,  "ERROR: " + e.toString(),"INFORMACIÓN DE ERROR", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    } 
}
private void cargarComboAños(){
    this.jCmb_Años.removeAllItems();
    this.jCmb_Años.setSelectedIndex(-1);
    try{
        BD = new DB_COMPUTO();
        String strsql ="SELECT NM_AÑO FROM COMPUTOS.COMPUTOS GROUP BY NM_AÑO;";
        rs=BD.Consulta(strsql);
        int numRegs;
        numRegs = rs.getRow();
        rs.beforeFirst();
        while (rs.next()) {
           this.jCmb_Años.addItem(rs.getString("NM_AÑO"));
        }
        BD.cerrarConexion();
    }
    catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null,  "ERROR: " + e.toString(),"INFORMACIÓN DE ERROR", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    } 
}
 private void CargarConfiguraciondeTabla(JTable pTabla,String pTituloColumnaMes1, String pTituloColumnaMes2){
      org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(EULEN.COMPUTOS.VISTAS.App.class).getContext().getResourceMap(Consulta.class);  
      pTabla.setFont(resourceMap.getFont("pTabla.font"));  
      pTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                //{null, null, null, null, null}
            },
            new String [] {
                "Gestor", "DNI / CONTRATO", "Nombre Empleado", "HORAS QUE MUEREN en " + pTituloColumnaMes1, "HORAS QUE MUEREN en " + pTituloColumnaMes2
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    
    private String[][] aplicarAlgoritmoalEmpleado(String[][] pArrayDatosResultSet) {
        int numMes;
        int enero = 1;
        int febrero = 2;
        int mesenCurso = 0;
        final int columnaNumeroMes = 2;
        final int columnaDefectoAntes = 7;
        final int columnaDefectoMes = 8;
        final int columnaDeducidasMes = 9;
        final int columnaSaldo = 10;
        // empiezo el for en 1 pues el indice cero no se contempla pues el mes cero no existe.
        try {
        for (int x = 1; x < pArrayDatosResultSet.length-1; x++){
            System.out.println("Indice del For: --> " + x);
            if (!pArrayDatosResultSet[x][columnaNumeroMes].equals("0")){
                numMes = Integer.parseInt(pArrayDatosResultSet[x][columnaNumeroMes]);
                mesenCurso = numMes;
                System.out.println("Mes: --> " + numMes);
                switch (numMes){
                    case 1:
                        enero = x;
                        pArrayDatosResultSet[enero][columnaSaldo] = pArrayDatosResultSet[enero][columnaDefectoMes];  // saldo enero
                        System.out.println("Saldo Enero: --> " + pArrayDatosResultSet[enero][columnaSaldo]);
                        break;
                    case 2:
                        febrero = x;
                        if (Double.parseDouble(pArrayDatosResultSet[febrero][columnaDefectoMes]) != 0 ){
                           // El indice es cero pues es el primer mes del array, es decir el mes 1 ó Enero 
                           pArrayDatosResultSet[enero][columnaSaldo] = pArrayDatosResultSet[enero][columnaSaldo]; // saldo enero
                           pArrayDatosResultSet[febrero][columnaSaldo] = pArrayDatosResultSet[febrero][columnaDefectoMes]; // saldo febrero
                        } else {
                           pArrayDatosResultSet[enero][columnaSaldo] = String.valueOf(Double.parseDouble(pArrayDatosResultSet[enero][columnaSaldo]) - Double.parseDouble(pArrayDatosResultSet[febrero][columnaDefectoMes]));  // saldo enero
                        }
                        System.out.println("Saldo Enero: --> " + pArrayDatosResultSet[enero][columnaSaldo]);
                        System.out.println("Saldo Febrero: --> " + pArrayDatosResultSet[febrero][columnaSaldo]);
                        break;
                    default: // Cualquier mes que no sea Enero ni febrero.
                        //mesenCurso = x;
                        System.out.println("Mes en Curso - 2: --> " + (mesenCurso - 2));
                        System.out.println("Mes en Curso - 1: --> " + (mesenCurso - 1));
                        System.out.println("Mes en Curso    : --> " + (mesenCurso));
                        if(Double.parseDouble(pArrayDatosResultSet[mesenCurso][columnaDefectoMes]) != 0){
                           pArrayDatosResultSet[mesenCurso - 2][columnaSaldo] = pArrayDatosResultSet[mesenCurso - 2][columnaSaldo];
                           pArrayDatosResultSet[mesenCurso - 1][columnaSaldo] = pArrayDatosResultSet[mesenCurso - 1][columnaSaldo];
                        } else{
                           pArrayDatosResultSet[mesenCurso - 2][columnaSaldo] = String.valueOf(Double.parseDouble(pArrayDatosResultSet[mesenCurso - 2][columnaSaldo]) - Double.parseDouble(pArrayDatosResultSet[mesenCurso][columnaDeducidasMes])); 
                           if(Double.parseDouble(pArrayDatosResultSet[mesenCurso - 2][columnaSaldo]) < 0){ // si el saldo es negativo
                               pArrayDatosResultSet[mesenCurso - 1][columnaSaldo] = String.valueOf(Double.parseDouble(pArrayDatosResultSet[mesenCurso - 1][columnaSaldo]) + Double.parseDouble(pArrayDatosResultSet[mesenCurso - 2][columnaSaldo])); 
                               pArrayDatosResultSet[mesenCurso - 2][columnaSaldo] = "0";
                           } else {
                              pArrayDatosResultSet[mesenCurso - 1][columnaSaldo] = pArrayDatosResultSet[mesenCurso - 1][columnaSaldo]; 
                           }
                        }
                        pArrayDatosResultSet[mesenCurso][columnaSaldo] = pArrayDatosResultSet[mesenCurso][columnaDefectoMes];
                        System.out.println("Saldo Mes en Curso - 2: --> " + pArrayDatosResultSet[mesenCurso - 2][columnaSaldo]);
                        System.out.println("Saldo Mes en Curso - 1: --> " + pArrayDatosResultSet[mesenCurso - 1][columnaSaldo]);
                        System.out.println("Saldo Mes en Curso    : --> " + pArrayDatosResultSet[mesenCurso][columnaSaldo]);
                         break;
                } // fin switch       
            } // fin if
        } // fin for    
        } catch (Exception e){
            System.out.println(e.toString());
        }
        return pArrayDatosResultSet;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
                Consulta dialog = new Consulta(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Cerrar;
    private javax.swing.JButton jBtn_ConsultarHorasBajoComputo;
    private javax.swing.JButton jBtn_ImprimirInforme;
    private javax.swing.JComboBox jCmb_Años;
    private javax.swing.JComboBox jCmb_Meses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel añadirEstosDatosalControlTabla(String[][] pArrayDatosResultSet, int pNumMes_Cuadrante_a_Preparar, DefaultTableModel pModelo) {
        
        String[] arrayRegistroDB = new String[5];
        switch (pNumMes_Cuadrante_a_Preparar){
            case 1:
                // Si DNI <> 0
                /*
                if (!pArrayDatosResultSet[1][3].toString().equals("0")) {
                arrayRegistroDB[0] = pArrayDatosResultSet[1][0]; // NOMBRE DEL GESTOR
                arrayRegistroDB[1] = pArrayDatosResultSet[1][3]; // DNI
                arrayRegistroDB[2] = pArrayDatosResultSet[1][4] + " " + pArrayDatosResultSet[1][5] + ", " + pArrayDatosResultSet[1][6]; // APELLIDOS Y NOMBRE DEL EMPLEADO
                arrayRegistroDB[3] = "0"; // SALDO O MUEREN
                arrayRegistroDB[4] = "0";
                pModelo.addRow(arrayRegistroDB);  
                }
                break;
                 * 
                 */
            case 2:    
                if (!pArrayDatosResultSet[1][3].toString().equals("0")) {
                arrayRegistroDB[0] = pArrayDatosResultSet[1][0]; // NOMBRE DEL GESTOR
                arrayRegistroDB[1] = pArrayDatosResultSet[1][3]; // DNI
                arrayRegistroDB[2] = pArrayDatosResultSet[1][4] + " " + pArrayDatosResultSet[1][5] + ", " + pArrayDatosResultSet[1][6]; // APELLIDOS Y NOMBRE DEL EMPLEADO
                arrayRegistroDB[3] = "0"; // SALDO O MUEREN
                arrayRegistroDB[4] = pArrayDatosResultSet[1][10]; // MUEREN+1 = DefectoAntes - (Saldo ó Mueren)
                try {
                    pModelo.addRow(arrayRegistroDB);
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
                }
                break;
            case 3:    
                for (int j = 0; j < pArrayDatosResultSet.length-1; j++) {
                if (Integer.parseInt(pArrayDatosResultSet[j][2]) == pNumMes_Cuadrante_a_Preparar - 2 && !pArrayDatosResultSet[j][3].toString().equals("0") ){
                    arrayRegistroDB[0] = pArrayDatosResultSet[j][0]; // NOMBRE DEL GESTOR
                    arrayRegistroDB[1] = pArrayDatosResultSet[j][3]; // DNI
                    arrayRegistroDB[2] = pArrayDatosResultSet[j][4] + " " + pArrayDatosResultSet[j][5] + ", " + pArrayDatosResultSet[j][6]; // APELLIDOS Y NOMBRE DEL EMPLEADO
                    arrayRegistroDB[3] = pArrayDatosResultSet[j][10]; // SALDO O MUEREN
                    arrayRegistroDB[4] = pArrayDatosResultSet[j+1][10]; // SALDO O MUEREN+1
                    /*
                    if (Double.parseDouble(pArrayDatosResultSet[j][7]) - Double.parseDouble(pArrayDatosResultSet[j][10]) > 0){
                       arrayRegistroDB[4] = String.valueOf(Double.parseDouble(pArrayDatosResultSet[j][7]) - Double.parseDouble(pArrayDatosResultSet[j][10])); // MUEREN+1 = DefectoAntes - (Saldo ó Mueren)
                    } else {
                       arrayRegistroDB[4] = "0";
                    } 
                     * 
                     */
                    try {
                        pModelo.addRow(arrayRegistroDB);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
        }
           break;     
            default:
        for (int j = 0; j < pArrayDatosResultSet.length-1; j++) {
                if (Integer.parseInt(pArrayDatosResultSet[j][2]) == pNumMes_Cuadrante_a_Preparar - 2 && !pArrayDatosResultSet[j][3].toString().equals("0")){
                    arrayRegistroDB[0] = pArrayDatosResultSet[j][0]; // NOMBRE DEL GESTOR
                    arrayRegistroDB[1] = pArrayDatosResultSet[j][3]; // DNI
                    arrayRegistroDB[2] = pArrayDatosResultSet[j][4] + " " + pArrayDatosResultSet[j][5] + ", " + pArrayDatosResultSet[j][6]; // APELLIDOS Y NOMBRE DEL EMPLEADO
                    arrayRegistroDB[3] = pArrayDatosResultSet[j][10]; // SALDO O MUEREN
                    arrayRegistroDB[4] = pArrayDatosResultSet[j+1][10]; // SALDO O MUEREN+1
                    /*
                    if (Double.parseDouble(pArrayDatosResultSet[j][7]) - Double.parseDouble(pArrayDatosResultSet[j][10]) > 0){
                       arrayRegistroDB[4] = String.valueOf(Double.parseDouble(pArrayDatosResultSet[j][7]) - Double.parseDouble(pArrayDatosResultSet[j][10])); // MUEREN+1 = DefectoAntes - (Saldo ó Mueren)
                    } else {
                       arrayRegistroDB[4] = "0";
                    } 
                     * 
                     */
                    try {
                    pModelo.addRow(arrayRegistroDB);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
        }
           break;     
        } // fin del switch
        return pModelo;
    }

    private String[][] inicializarArray(String[][] pArrayDatosResultSet) {
        for (int x = 0; x < pArrayDatosResultSet.length-1; x++) {
            for (int y = 0; y < pArrayDatosResultSet[x].length-1 ; y++) {
                pArrayDatosResultSet[x][y] = "0";
            }
        }
        return pArrayDatosResultSet;
    }

   
    private DefaultTableModel redondearHoras(DefaultTableModel modelo) {
        funcionMatematica = new Matematicas();
        Double wValorRedondeado;
        try {
            if (this.jTable1.getRowCount()>=1){
            for (int i = modelo.getRowCount()-1; i >= 0 ; i--){
                wValorRedondeado = funcionMatematica.redondear(Double.parseDouble(modelo.getValueAt(i, 3).toString()),2);
                modelo.setValueAt(" ",i,3);
                modelo.setValueAt(wValorRedondeado,i,3);
                wValorRedondeado = funcionMatematica.redondear(Double.parseDouble(modelo.getValueAt(i, 4).toString()),2);
                modelo.setValueAt(" ",i,4);
                modelo.setValueAt(wValorRedondeado,i,4);
             }
            }
        }
        catch (Exception e) {
            //javax.swing.JOptionPane.showMessageDialog(null,  "ERROR: " + e.toString(),"INFORMACIÓN DE ERROR", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            System.out.println(e.toString()+"\n"+ e);
        } 
        //return modelo;
        return (DefaultTableModel) this.jTable1.getModel();
    }

    private void iniciarControlJTable() {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"NO HAY DATOS", "NO HAY DATOS", "NO HAY DATOS", "NO HAY DATOS", "NO HAY DATOS"},
                
            },
            new String [] {
                "Gestor", "DNI / CONTRATO", "Nombre Empleado", "Bajo Computo Mes1", "Bajo Computo Mes2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }

    
   
}

