/*
 * Acerca.java
 */

package EULEN.COMPUTOS.VISTAS;

import java.awt.Toolkit;
import org.jdesktop.application.Action;
import EULEN.COMPUTOS.DATA.DB_COMPUTO;
import EULEN.COMPUTOS.FUNCIONES.Utiles;
import java.awt.Color;

public class Acerca extends javax.swing.JDialog {
    java.sql.ResultSet rs;
    private DB_COMPUTO BD;
    private Utiles util;

    public Acerca(java.awt.Frame parent) {
        super(parent);
        initComponents();
        actualizarFechaUltimaImportaciondeVisualPlan();
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("ImagenUsuarioReloj.jpg")));
        getRootPane().setDefaultButton(closeButton);
    }

    @Action public void closeAboutBox() {
        dispose();
    }
private void actualizarFechaUltimaImportaciondeVisualPlan(){
    String wAño = "";
    String wMes = "";
    this.jLbl_FechaUltimaImportacionDatos.setText("");
    util = new Utiles();
    try{
        BD = new DB_COMPUTO();
        String strsql = "SELECT NM_AÑO, NM_MES FROM COMPUTOS.COMPUTOS group by nm_año, nm_mes ORDER BY NM_AÑO, NM_MES DESC;";
        rs=BD.Consulta(strsql);
        rs.first();
        wAño = rs.getString("NM_AÑO");
        wMes = util.convertirNumeroMesaNombreMes(rs.getInt("NM_MES"));
        this.jLbl_FechaUltimaImportacionDatos.setText("Datos Actualizados a " + wMes + " de "+ wAño +".");
        this.jLbl_FechaUltimaImportacionDatos.setFont(new java.awt.Font("Dialog", 1, 22));
        this.jLbl_FechaUltimaImportacionDatos.setForeground(Color.red);
        BD.cerrarConexion();
    }
    catch (Exception e) {
       System.out.println(e.toString());
    }     
}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        javax.swing.JLabel appTitleLabel = new javax.swing.JLabel();
        javax.swing.JLabel versionLabel = new javax.swing.JLabel();
        javax.swing.JLabel appVersionLabel = new javax.swing.JLabel();
        javax.swing.JLabel vendorLabel = new javax.swing.JLabel();
        javax.swing.JLabel appVendorLabel = new javax.swing.JLabel();
        javax.swing.JLabel appDescLabel = new javax.swing.JLabel();
        javax.swing.JLabel imageLabel = new javax.swing.JLabel();
        javax.swing.JLabel imageLabel1 = new javax.swing.JLabel();
        jLbl_FechaUltimaImportacionDatos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(EULEN.COMPUTOS.VISTAS.App.class).getContext().getResourceMap(Acerca.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setModal(true);
        setName("aboutBox"); // NOI18N
        setResizable(false);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(EULEN.COMPUTOS.VISTAS.App.class).getContext().getActionMap(Acerca.class, this);
        closeButton.setAction(actionMap.get("closeAboutBox")); // NOI18N
        closeButton.setText(resourceMap.getString("closeButton.text")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N

        appTitleLabel.setFont(new java.awt.Font("Dialog", 1, 36));
        appTitleLabel.setForeground(resourceMap.getColor("appDescLabel.foreground")); // NOI18N
        appTitleLabel.setText(resourceMap.getString("Application.title")); // NOI18N
        appTitleLabel.setName("appTitleLabel"); // NOI18N

        versionLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        versionLabel.setForeground(resourceMap.getColor("appDescLabel.foreground")); // NOI18N
        versionLabel.setText(resourceMap.getString("versionLabel.text")); // NOI18N
        versionLabel.setName("versionLabel"); // NOI18N

        appVersionLabel.setFont(resourceMap.getFont("appVersionLabel.font")); // NOI18N
        appVersionLabel.setForeground(resourceMap.getColor("appDescLabel.foreground")); // NOI18N
        appVersionLabel.setText(resourceMap.getString("Application.version")); // NOI18N
        appVersionLabel.setName("appVersionLabel"); // NOI18N

        vendorLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        vendorLabel.setForeground(resourceMap.getColor("appDescLabel.foreground")); // NOI18N
        vendorLabel.setText(resourceMap.getString("vendorLabel.text")); // NOI18N
        vendorLabel.setName("vendorLabel"); // NOI18N

        appVendorLabel.setFont(resourceMap.getFont("appVendorLabel.font")); // NOI18N
        appVendorLabel.setForeground(resourceMap.getColor("appDescLabel.foreground")); // NOI18N
        appVendorLabel.setText(resourceMap.getString("Application.vendor")); // NOI18N
        appVendorLabel.setName("appVendorLabel"); // NOI18N

        appDescLabel.setFont(resourceMap.getFont("appDescLabel.font")); // NOI18N
        appDescLabel.setForeground(resourceMap.getColor("appDescLabel.foreground")); // NOI18N
        appDescLabel.setText(resourceMap.getString("appDescLabel.text")); // NOI18N
        appDescLabel.setName("appDescLabel"); // NOI18N

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setIcon(resourceMap.getIcon("Lbl_LogoEulen.icon")); // NOI18N
        imageLabel.setName("Lbl_LogoEulen"); // NOI18N

        imageLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel1.setIcon(resourceMap.getIcon("Lbl_Reloj.icon")); // NOI18N
        imageLabel1.setName("Lbl_Reloj"); // NOI18N

        jLbl_FechaUltimaImportacionDatos.setFont(resourceMap.getFont("jLbl_FechaUltimaImportacionDatos.font")); // NOI18N
        jLbl_FechaUltimaImportacionDatos.setForeground(resourceMap.getColor("jLbl_FechaUltimaImportacionDatos.foreground")); // NOI18N
        jLbl_FechaUltimaImportacionDatos.setText(resourceMap.getString("jLbl_FechaUltimaImportacionDatos.text")); // NOI18N
        jLbl_FechaUltimaImportacionDatos.setName("jLbl_FechaUltimaImportacionDatos"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(appTitleLabel)
                            .addComponent(appDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLbl_FechaUltimaImportacionDatos)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vendorLabel)
                                    .addComponent(versionLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(appVersionLabel)
                                    .addComponent(appVendorLabel))
                                .addGap(164, 164, 164))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(imageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appTitleLabel)
                        .addGap(6, 6, 6)
                        .addComponent(appDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(versionLabel)
                            .addComponent(appVersionLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vendorLabel)
                            .addComponent(appVendorLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jLbl_FechaUltimaImportacionDatos)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closeButton)
                    .addComponent(imageLabel))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLbl_FechaUltimaImportacionDatos;
    // End of variables declaration//GEN-END:variables
   
}
