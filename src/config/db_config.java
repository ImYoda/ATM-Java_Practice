/**
*
*
*
**/

package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Loki
 */
public class db_config {

                public static Connection connect(){
                    String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                
                    } catch(ClassNotFoundException |SQLException e){
                        System.out.println(e.getMessage());
                    } finally {
                        try{
                            if(conn != null){
                                conn.close();
                            }
                        } catch(SQLException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
            return conn;
                }
                public static void main(String[] args) {
        connect();
    }
                    
}
