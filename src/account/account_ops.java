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
import javax.swing.JOptionPane;
import static views.home.c_balance;

/**
 *
 * @author Loki
 */
public class account_ops {
public static String c_holder;
public static int id;
public static double the_balance;
public static double new_balance;
public static int id_sender;
public static double qty;
public static String t_holder;
public static Object[] tDetails = {0,0};
public static double s_balance;
public static int owner;
public static double oh_balance;
public static int ids;
public static String x_holder;
public static double x_holder2;
        
        public static double updateBalance_w(double balance, double withdraw){
        account.balance = account.balance - withdraw;
        return account.balance;
    }
    
    public static double updateBalance_d(double balance, double deposit){
        account.balance = account.balance + deposit;
        return account.balance;
    }
    
   
    
    public static boolean getLogged(int a_number, int a_pin){
                    String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
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
                    } catch(ClassNotFoundException | SQLException e){
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
                    String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
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
                   } catch(ClassNotFoundException | SQLException e){
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
                    
                        String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
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
                    } catch(ClassNotFoundException | SQLException e){
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
    
    public static double getBalance_D(int a_number){
                   String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
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
                    } catch(ClassNotFoundException | SQLException e){
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
                   String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
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
                    } catch(ClassNotFoundException | SQLException e){
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
                   String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
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
                   } catch(ClassNotFoundException | SQLException e){
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
     public static int insertTr(int c_number, int receiver, double qty){
                   String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                       String sql ="INSERT INTO transfers(sender, tow, qty) VALUES(?,?,?)";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setDouble(1, c_number);
            pstmt.setInt(2, receiver);
            pstmt.setDouble(3, qty);
            pstmt.executeUpdate();
        } catch(SQLException e){
            System.out.println("SQL1");
            System.out.println(e.getMessage());
        } 
        String sql2 ="SELECT * FROM transfers WHERE sender = ? AND tow = ? ";
            try(
            PreparedStatement pstmt2 = conn.prepareStatement(sql2)){
                    pstmt2.setInt(1, c_number);
                    pstmt2.setInt(2, receiver);
                    ResultSet rs = pstmt2.executeQuery();
                    rs.next();
                            id = rs.getInt("id");
                } catch(SQLException v0){
                    System.out.println("SQL2");
                    System.out.println(v0.getMessage());
                }
           String sql3 ="SELECT * FROM accounts WHERE number = ?";
            try(
            PreparedStatement pstmt3 = conn.prepareStatement(sql3)){
                    pstmt3.setInt(1, c_number);
                    ResultSet rs1 = pstmt3.executeQuery();
                    rs1.next();
                            the_balance = rs1.getDouble("balance");
                } catch(SQLException v1){
                    System.out.println("SQL3");
                    System.out.println(v1.getMessage());
                }
                 new_balance = the_balance - qty;
             String sql4 ="UPDATE accounts SET balance = ? WHERE number = ?";
            try(
            PreparedStatement pstmt4 = conn.prepareStatement(sql4)){
                    pstmt4.setDouble(1, new_balance);
                    pstmt4.setInt(2, c_number);
                    pstmt4.executeUpdate();
                   
                           
                } catch(SQLException v11){
                   System.out.println("SQL4");
                    System.out.println(v11.getMessage());
                } 
            String sql5 ="UPDATE accounts SET onhold_balance = ? WHERE number = ?";
            try(
            PreparedStatement pstmt5 = conn.prepareStatement(sql5)){
                    pstmt5.setDouble(1, qty);
                    pstmt5.setInt(2, c_number);
                    pstmt5.executeUpdate();
              
                           
                } catch(SQLException v111){
                    System.out.println("SQL5");
                    System.out.println(v111.getMessage());
                } 
            return id;
        
            
            
            // under here you can't add sql queries
                   } catch(ClassNotFoundException | SQLException e){
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

return id;
                }
     
     
     
       public static int getT_sender(int tid){
                   String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                        String sql = "SELECT * FROM transfers WHERE id = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, tid);
            ResultSet rs = pstmt.executeQuery();
            
            // loop
            rs.next();
             ids = rs.getInt("sender");
            
            return ids;
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
                    } catch(ClassNotFoundException | SQLException e){
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
                    return ids;
                }
       
       public static String getT_holder(int a){
                    String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                        String sql = "SELECT * FROM accounts WHERE number = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, a);
            ResultSet rs = pstmt.executeQuery();
            
            // loop
            rs.next();
            x_holder = rs.getString("holder");
            return x_holder;
        } catch(SQLException e){
        }
                    } catch(ClassNotFoundException | SQLException e){
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
                    return x_holder;
                }
      
     
     public static double getT_qty(int tid){
                    String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                        String sql = "SELECT * FROM transfers WHERE id = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, tid);
            ResultSet rs = pstmt.executeQuery();
            
            // loop
            rs.next();
            double x_qty = rs.getDouble("qty");
            return x_qty;
        } catch(SQLException e){
        }
                   } catch(ClassNotFoundException | SQLException e){
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
                    return x_holder2;
                }
     public static boolean releaseT(int tid, int u_number, double qty, int sender){
                   String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3204667";
            String user = "sql3204667";
            String pass = "EE4Vstz7Fa";
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                        String sql = "SELECT * FROM accounts WHERE number = ?";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, u_number);
            ResultSet rs = pstmt.executeQuery();
            
            // loop
            rs.next();
            s_balance = rs.getDouble("balance") + qty;
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
         String sql1 = "SELECT * FROM transfers WHERE id = ?";
        try(
                PreparedStatement pstmt1 = conn.prepareStatement(sql1)){
            pstmt1.setInt(1, tid);
            ResultSet rs1 = pstmt1.executeQuery();
            
            // loop
            rs1.next();
            owner = rs1.getInt("tow");
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        if(u_number==owner){
             String sql121 = "SELECT status FROM transfers WHERE id = ?";
        try(
                PreparedStatement pstmt121 = conn.prepareStatement(sql121)){            
            pstmt121.setInt(1, tid);
            ResultSet rs121 =pstmt121.executeQuery();
            rs121.next();
            oh_balance = rs121.getInt("status");
            
            // loop
            
            
        } catch(SQLException e1){
            System.out.println(e1.getMessage());
        } 
        
        if(oh_balance==0){
            JOptionPane.showMessageDialog(null,"Ya ha sido cobrada");
        } else {
        String sql2 = "UPDATE accounts SET balance = ? WHERE number = ?";
        try(
                PreparedStatement pstmt2 = conn.prepareStatement(sql2)){
            pstmt2.setDouble(1, s_balance);
            pstmt2.setInt(2, u_number);
            pstmt2.executeUpdate();
            
            // loop
            
            
        } catch(SQLException e1){
            System.out.println(e1.getMessage());
        } 
        
        
        
        String sql12 = "SELECT onhold_balance FROM accounts WHERE number = ?";
        try(
                PreparedStatement pstmt12 = conn.prepareStatement(sql12)){            
            pstmt12.setInt(1, sender);
            ResultSet rs12 =pstmt12.executeQuery();
            rs12.next();
            oh_balance = rs12.getDouble("onhold_balance") - qty;
            
            // loop
            
            
        } catch(SQLException e1){
            System.out.println(e1.getMessage());
        } 
        
        
        
        String sql7 = "UPDATE accounts SET onhold_balance = ? WHERE number = ?";
        try(
                PreparedStatement pstmt7 = conn.prepareStatement(sql7)){
            pstmt7.setDouble(1, oh_balance);
            pstmt7.setInt(2, sender);
            pstmt7.executeUpdate();
            
            // loop
            
            
        } catch(SQLException e17){
            System.out.println(e17.getMessage());
        } 
        
        String sql9 = "UPDATE transfers SET status = ? WHERE id = ?";
        int n_status = 0;
        try(
                PreparedStatement pstmt79 = conn.prepareStatement(sql9)){
            pstmt79.setDouble(1, n_status);
            pstmt79.setInt(2, tid);
            pstmt79.executeUpdate();
            
            // loop
            
            
        } catch(SQLException e17){
            System.out.println(e17.getMessage());
        } 
        
        
        return true;
        }
        } else {   
            return false;
        }
        
                 } catch(ClassNotFoundException | SQLException e){
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
                  return false;
                }
    
    
    
    public static void main(String[] args) {
    
    if(releaseT(81,14079345,150,13844900)==true){
        System.out.println("yep");
    } else {
        
        System.out.println("nope");
    }
       
    }
}

