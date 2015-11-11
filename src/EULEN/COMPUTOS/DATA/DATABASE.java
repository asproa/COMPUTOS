/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EULEN.COMPUTOS.DATA;

import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JRResultSetDataSource;


/**
 *
 * @author jmsanchez
 */
public class DATABASE {
    private java.sql.Connection conexion;
    private java.sql.Connection conn;
    private java.sql.Statement sentenciaSQL;
    private java.sql.Statement insertSQL;
    private java.sql.Statement deleteSQL;
    private java.sql.Statement updateSQL;
    
    private java.sql.ResultSet rs;
    private String URL_DB ="jdbc:mysql://EULENSEG-SVR06:3306/Rondas";
    private String usuario ="root";
    private String contraseña ="Seguridad2012";
    
    public DATABASE() throws ClassNotFoundException, java.sql.SQLException, InstantiationException, IllegalAccessException {
        String controlador ="com.mysql.jdbc.Driver";
        Class.forName(controlador).newInstance();
        conectar();
    }
    public void conectar() throws java.sql.SQLException {
        // Base de Datos Local
        try{
            conexion=java.sql.DriverManager.getConnection(URL_DB,usuario,contraseña);
            sentenciaSQL=conexion.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
            insertSQL=conexion.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
            updateSQL=conexion.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
            deleteSQL=conexion.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
            System.out.println("\n Conexión Realizada con Exito. \n");
            System.out.println("Tablas de la Base de Datos");
        } catch(Exception e){
            //manejo de exception si se genera.
            javax.swing.JOptionPane.showMessageDialog(null,  e,"Error en Base de Datos", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
        }

    }
    public void cerrarConexion() throws java.sql.SQLException{
        if (rs!= null) rs.close();
        if (sentenciaSQL != null) sentenciaSQL.close();
        if (insertSQL != null) insertSQL.close();
        if (deleteSQL != null) deleteSQL.close();
        if (updateSQL != null) updateSQL.close();
        if (conexion != null) conexion.close();
        System.out.println("\n Conexión Cerrada.");
    }
    public java.sql.ResultSet Consulta (String strsql) throws java.sql.SQLException{
        System.out.println(strsql);
        rs=sentenciaSQL.executeQuery(strsql);
        return rs;
    }
    public void Insertar (String strsql) throws java.sql.SQLException{
        System.out.println(strsql);
        insertSQL.executeUpdate(strsql);
    }
    public void Actualizar (String strsql) throws java.sql.SQLException{
        System.out.println(strsql);
        updateSQL.executeUpdate(strsql);
    }
    public void Borrar (String strsql) throws java.sql.SQLException{
        System.out.println(strsql);
        deleteSQL.executeUpdate(strsql);
    }
    public void Proc_MySql_GenerarFechas(String wFecDesde,  String wFecHasta) throws java.sql.SQLException{
        String wUsuario = ""; // SIGO.MVC.VISTAS.Main.wNombreUsuario;
        try{
            CallableStatement sp = conexion.prepareCall("{ call GenerarFechas(?,?,?) }");
            sp.setString(1, wFecDesde);
            sp.setString (2, wFecHasta);
            sp.setString (3, wUsuario);
            sp.executeUpdate();
          //  conexion.commit();
        } catch(Exception e){
             System.out.println(e);
        }
} 
public void Proc_VaciarTablasTemporales() throws java.sql.SQLException{
        try{
            CallableStatement sp = conexion.prepareCall("{ call VaciarTablaTemporal() }");
            sp.executeUpdate();
        } catch(Exception e){
             System.out.println(e);
        }
} 

    public void generarReporte(java.sql.ResultSet pRS, String pModelodeInforme)throws java.sql.SQLException{
        Connection con = null;
        try{
            conn=java.sql.DriverManager.getConnection(URL_DB,usuario,contraseña);
            conn.setAutoCommit(false);

            JRResultSetDataSource rsData = new JRResultSetDataSource(pRS);
            JasperPrint jp = JasperFillManager.fillReport(pModelodeInforme,new HashMap(), rsData);
            JasperViewer jviewer = new JasperViewer(jp,false);
            jviewer.setVisible(true);

        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,  e,"Excepción", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
