/**
*
*
*
**/

package account;

import static config.db_config.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import static views.home.c_balance;

/**
 *
 * @author Loki
 */
public class account_ops {
public static String c_holder;
    public static double updateBalance_w(double balance, double withdraw){
        account.balance = account.balance - withdraw;
        return account.balance;
    }
    
    public static double updateBalance_d(double balance, double deposit){
        account.balance = account.balance + deposit;
        return account.balance;
    }
    
   
    
    public static boolean getLogged(int a_number, int a_pin){
                    Connection conn = null;
                    try{
                        String url = "jdbc:sqlite:src/config/db.db";
                        
                        conn = DriverManager.getConnection(url);
                        String sql = "SELECT * FROM accounts WHERE number = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, a_number);
            ResultSet rs = pstmt.executeQuery();
            
            // loop
            rs.next();
            int db_number = rs.getInt("number");
            int db_pin = rs.getInt("pin");
            if(a_number == db_number && a_pin == db_pin){
                return true;
            } else {
                return false;
            }
        } catch(SQLException e){
            return false;
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
                            return false;
                        }
                    }
                    return false;
                }
    
    public static String getHolder(int a_number){
                    Connection conn = null;
                    try{
                        String url = "jdbc:sqlite:src/config/db.db";
                        
                        conn = DriverManager.getConnection(url);
                        String sql = "SELECT * FROM accounts WHERE number = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, a_number);
            ResultSet rs = pstmt.executeQuery();
            
            // loop
            rs.next();
            String c_holder = rs.getString("holder");
            return c_holder;
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
                    return c_holder;
                }
    
    public static double getBalance(int a_number){
                    Connection conn = null;
                    try{
                        String url = "jdbc:sqlite:src/config/db.db";
                        
                        conn = DriverManager.getConnection(url);
                        String sql = "SELECT * FROM accounts WHERE number = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, a_number);
            ResultSet rs = pstmt.executeQuery();
            
            // loop
            rs.next();
            double c_balance = rs.getDouble("balance");
            return c_balance;
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
                    return c_balance;
                }
    
    public static double updateBalance(int c_number, double c_balance){
                    Connection conn = null;
                    try{
                        String url = "jdbc:sqlite:src/config/db.db";
                        
                        conn = DriverManager.getConnection(url);
                       String sql ="UPDATE accounts SET balance = ? WHERE number = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setDouble(1, c_balance);
            pstmt.setInt(2, c_number);
            pstmt.executeUpdate();
            return c_balance;
        } catch(SQLException e){
            System.out.println(e.getMessage());
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

                    return c_balance;
                }
    
    public static double updateBalance_D(int c_number, double c_balance){
                    Connection conn = null;
                    try{
                        String url = "jdbc:sqlite:src/config/db.db";
                        
                        conn = DriverManager.getConnection(url);
                       String sql ="UPDATE accounts SET balance = ? WHERE number = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setDouble(1, c_balance);
            pstmt.setInt(2, c_number);
            pstmt.executeUpdate();
            return c_balance;
        } catch(SQLException e){
            System.out.println(e.getMessage());
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

                    return c_balance;
                }
    
    
    
    public static void main(String[] args) {
        
       
    }
}

