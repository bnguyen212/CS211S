package unittesting;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BankAccountTestParamterized {
	
	private BankAccount account;
	private final static int INITIAL_BALANCE = 100;
	private final static double THRESHOLD = 0.0001;
	
	private double amount, balanceAfterDeposit, balanceAfterWithdrawal;
	
	public BankAccountTestParamterized(double amount, double balanceAfterDeposit, double balanceAfterWithdrawal) {
		this.balanceAfterDeposit = balanceAfterDeposit;
		this.balanceAfterWithdrawal = balanceAfterWithdrawal;
		this.amount = amount;
	}

    @Before
    public void setup() {
        System.out.println("In setup with new account");        
        account = new BankAccount(INITIAL_BALANCE);
    }
	
	@Parameters
	public static Collection<Object[]> getInputs() {
		return Arrays.asList(new Object[][] {
			{0, 100, 100},   // test case 0: amount is 0, after deposit balance is 100, after withdrawal balance is 100
			{-100, 100, 100},// test case 1
			{50, 150, 50},   // test case 2
			{100, 200, 0}    // test case 3
		});
	}
	
	@Test
	public void testDepositParameterized() {
		System.out.println("inside testDepositParameterized with amount: " + amount);
		account.deposit(amount);
		double result = account.getBalance();
		assertEquals(balanceAfterDeposit, result, THRESHOLD);
	}
	
	
	@Test
    public void testWithdrawalParameterized() {
        System.out.println("inside testWithdrawalParameterized with amount: " + amount);
        account.withdraw(amount);
        double result = account.getBalance();
        assertEquals(balanceAfterWithdrawal, result, THRESHOLD);
    }
	

	
	
	



}
