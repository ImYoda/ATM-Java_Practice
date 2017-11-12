/**
*
*
*
**/

package account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static views.home.c_balance;

/**
 *
 * @author Loki
 */
public class get_receivers {
    public static String srec;
    public static String u_holder;
    public static int frec;
    public static int get_receivers(int c_number){
         Connection conn = null;
                    try{
                        String url = "jdbc:sqlite:src/config/db.db";
                        
                        conn = DriverManager.getConnection(url);
                        String sql = "SELECT * FROM accounts WHERE number != ?";
                         try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, c_number);
            ResultSet rs = pstmt.executeQuery();
            Object [] recs = {0,0};
            Object [] recs2 = {0,0};
            int i = 0;
            // loop
           while(rs.next()){
                if(i<=1){
            u_holder = rs.getString("holder");
            int u_number = rs.getInt("number");
                             recs[i] = u_holder;
                             recs2[i] = u_number;
                             i++;
                }
           }
           

Object receiver = JOptionPane.showInputDialog(null,"Seleccion un usuario", "Elegir",JOptionPane.QUESTION_MESSAGE,null,recs, recs[0]);
                              
                              srec = String.valueOf(receiver);
                              int op1 = Integer.parseInt(String.valueOf(recs2[0]));
                              System.out.println(op1);
                              int op2 = Integer.parseInt(String.valueOf(recs2[1]));
                              System.out.println(op2);
                              String nop1 = String.valueOf(recs[0]);
                              String nop2 = String.valueOf(recs[1]);
                              if(srec==nop1){
                                  frec = op1;
                              } else {
                                  frec = op2;
                              }
                              
                             return frec;
        } catch(SQLException e){
        }
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
                    return frec;
                    

    }
    
}
