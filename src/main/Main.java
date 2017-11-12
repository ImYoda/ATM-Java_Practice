/**
*
*
*
**/

package main;
import account.account;
import static account.account_ops.updateBalance_w;
/**
 *
 * @author Loki
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        account a1 = new account(13844900, 1596, "Rycks",150.50,"11/19",1);
        account a2 = new account(14079345, 0215, "Jaz", 750.77,"11/20",1);
        account a3 = new account(15964855, 1425, "John Doe", 99999.99, "04/21", 1);
        
        
        double withdraw = 35.5;
        System.out.println("Balance de "+a1.holder+" antes del retiro: "+a1.balance+" .");
        updateBalance_w(a1.balance, withdraw);
        System.out.println("Balance de "+a1.holder+" después del retiro: "+a1.balance+" .");
        withdraw = 50.00;
        System.out.println("Balance de "+a2.holder+" antes del retiro: "+a2.balance+" .");
        updateBalance_w(a2.balance, withdraw);
        System.out.println("Balance de "+a2.holder+" después del retiro: "+a2.balance+" .");
        
        
        
        
    }

}
