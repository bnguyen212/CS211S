package unittesting;

import static org.junit.Assert.*;
import org.junit.*;

public class BankAccountTest {

    private BankAccount account;
    private final static int INITIAL_BALANCE = 100;
    private final static double THRESHOLD = 0.0001;

    public BankAccountTest() { } // a default constructor is required

    @Before
    public void setup() {
        System.out.println("In setup");
        account = new BankAccount(INITIAL_BALANCE);
    }

    @Test
    public void testDepositPositive() {
        System.out.println("In testDepositPositive");
        int value = 50;

        double beforeBalance = account.getBalance();
        account.deposit(value);
        double afterBalance = account.getBalance();
       
        assertEquals(beforeBalance + value, afterBalance, THRESHOLD);
    }

    @Test
    public void testDepositNegative() {
        System.out.println("In testDepositNegative");
        int value = -50;

        double beforeBalance = account.getBalance();
        account.deposit(value);
        double afterBalance = account.getBalance();
       
        assertEquals(beforeBalance, afterBalance, THRESHOLD);
    }

    @Test
    public void testDepositZero() {
        System.out.println("In testDepositZero");
        int value = 0;

        double beforeBalance = account.getBalance();
        account.deposit(value);
        double afterBalance = account.getBalance();
        
        assertEquals(beforeBalance, afterBalance, THRESHOLD);
    }

    @Test
    public void testWithdrawNegative() {
        System.out.println("In testWithdrawNegative");
        int value = -50;

        double beforeBalance = account.getBalance();
        account.withdraw(value);
        double result = account.getBalance();

        assertEquals(beforeBalance, result, THRESHOLD);
    }

    @Test
    public void testWithdrawPositive() {
        System.out.println("In testWithdrawPositive");
        int value = 50;

        double beforeBalance = account.getBalance();
        account.withdraw(value);
        double result = account.getBalance();
       
        assertEquals(beforeBalance-value, result, THRESHOLD);
    }
    
    @Test
    public void testWithdrawZero() {
        System.out.println("In testWithdrawZero");
        int value = 0;

        double beforeBalance = account.getBalance();
        account.withdraw(value);
        double result = account.getBalance();
       
        assertEquals(beforeBalance, result, THRESHOLD);
    }    

    @Test
    public void testWithdrawBalance() {
        System.out.println("In testWithdrawBalance");
        
        double beforeBalance = account.getBalance();
        account.withdraw(beforeBalance);
        double afterBalance = account.getBalance();
        
        assertEquals(0, afterBalance, THRESHOLD);
    }

}
