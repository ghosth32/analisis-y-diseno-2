/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Shumpe
 */
public class Conexion {

    static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:derby://localhost:1527/Restaurante";
    String user = "root";
    String pass = "root";
    private Connection conexion = null;
    public boolean conectado = false;
    private Statement instruccion;
    public ResultSet Resultados;
    public ResultSetMetaData metaDatos;
    public int numeroDeFilas;

    public Conexion() {
    }//fin de constructor sin parametros

    /**
     * 
     * @param consulta
     * @throws SQLException 
     */
    public Conexion(String consulta) throws SQLException {
        establecerConsulta(consulta);
    }//fin del constructor

    /**
     * 
     * Metodo que se conecta a la base de datos
     */
    public void ConectarBD() {
        try {
            //Class.forName( CONTROLADOR );
            conexion = DriverManager.getConnection(URL, user, pass);
            instruccion = conexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            conectado = true;
        } // fin de try
        catch (SQLException excepcionSql) {
            excepcionSql.printStackTrace();
            System.exit(1);
        } // fin de catch
    }//fin del metodo Conectar

    /**
     * Metodo para establecer una consulta
     */
    public void establecerConsulta(String consulta)
            throws SQLException, IllegalStateException {
        ConectarBD();
        // verifica que est� disponible la conexi�n a la base de datos
        if (!conectado) {
            throw new IllegalStateException("No hay conexion a la base de datos");
        }

        // especifica la consulta y la ejecuta     
        Resultados = instruccion.executeQuery(consulta);

        // obtiene metadatos para el objeto ResultSet
        metaDatos = Resultados.getMetaData();

        // determina el n�mero de filas en el objeto ResultSet
        Resultados.last();                   // avanza a la �ltima fila
        numeroDeFilas = Resultados.getRow();  // obtiene el n�mero de fila
    } // fin del m�todo establecerConsulta

    
    /**
     * 
     * Metodo para finalizar la conexion a la base de datos
     */
    public void finalizarConexion(){
    try{
    conexion.close();
    conectado = false;
        }catch(Exception e){
        }
    }//fin metodo terminar coneccion
    
    /**
     * 
     * Metodo que recibe de parametro una Instrucción SQL para Editar o Insertar
     * un nuevo Dato a una tabla de la base de datos.
     */
    public void update(String sql) 
    throws SQLException, IllegalStateException {
        ConectarBD();
      // verifica que est� disponible la conexi�n a la base de datos
      if ( !conectado) {
            throw new IllegalStateException( "No hay conexion a la base de datos" );
        } 
      instruccion.executeUpdate( sql );
    }//fin del metodo editar
    
    /** 
     * 
     * Ejecuta la actualizacion de la tabla dado los valores de actualizacion
     * y el ID del registro a afectar
     */
    public boolean update(String tabla, String valores, String id, String IdName){
        ConectarBD();
        boolean res = false;        
        String sql = "UPDATE "+tabla+" SET "+valores+" WHERE "+IdName+" = " + id;
        try {
            instruccion.executeUpdate( sql );
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }//fin del Update con 2 parametros
    
    public void Eliminar(String tabla, String IdName, String id){
        ConectarBD();
        String sql = "DELETE FROM "+tabla+" WHERE "+IdName+" =" + id;
        try {
            instruccion.executeUpdate( sql );
         }catch(SQLException e){            
            JOptionPane.showMessageDialog( null, "NO SE PUEDE ELIMINAR ESTE ELEMENTO "
                    + "DEBIDO A QUE ES USADO POR OTRA TABLA COMO REFERENCIA DE DATOS",
                    "Error en base de datos", 
                    JOptionPane.ERROR_MESSAGE );
            System.out.println(e.getMessage());
        }
    }//fin del metodo Eliminar
    
}//fin de la clase Conexion
