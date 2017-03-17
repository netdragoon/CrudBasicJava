package javaapplication1.Models;
import java.sql.*;        
public class Connect
{
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/homestead";
    private static final String usuario = "root";
    private static final  String senha = "senha";
    private static java.sql.Connection con = null;
    
    public static  Connection getInstance() throws ClassNotFoundException, SQLException
    {
        if (con == null)
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url,usuario,senha);                
        }
        return con;
    }    
}
