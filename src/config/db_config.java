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

                public static void connect(){
                    Connection conn = null;
                    try{
                        String url = "jdbc:sqlite:src/config/db.db";
                        
                        conn = DriverManager.getConnection(url);
                        System.out.println("Yep");
                    } catch(SQLException e){
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
                }
                    
}
