
package utilidades;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author Victor
 */
public class conexion {
    
    static Connection conn=null;
    static Statement st=null;
    
    static String bd="portalgestion";
    static String usuario="root";
    static String password="";
    static String url="jdbc:mysql://localhost:3306/"+bd;
    
    //se crea una clase conexion para que sirva de enlace a la base de datos
    
    public static Connection enlace(Connection conn) throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, usuario, password);
        }catch(Exception e){
            System.out.println("error no conecta");
        }
        
        return conn;
    }
    
    // para preparar la conexion y ejecutar ls sentencias en BD
    
    public static Statement st(Statement st) throws SQLException{
        conn= enlace(conn);
        st= conn.createStatement();
        return st;
    }
}
