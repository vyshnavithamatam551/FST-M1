import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class Activity2 {

	@Test
	public static void notEnoughFunds() {
		BankAccount bk=new BankAccount(9);
		assertThrows(NotEnoughFundsException.class, () -> bk.withdraw(10));
	}
	
	@Test
	void enoughFunds() {
	    BankAccount account = new BankAccount(100);
	    assertDoesNotThrow(() -> account.withdraw(100));
	}
}
