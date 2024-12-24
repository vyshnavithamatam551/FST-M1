import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class Activity2 {

	@Test
	public void notEnoughFunds() {
		BankAccount bk=new BankAccount(9);
		assertThrows(NotEnoughFundsException.class, () -> bk.withdraw(10));
	}
	
	@Test
	public void enoughFunds() {
	    BankAccount bk1 = new BankAccount(100);
	    assertDoesNotThrow(() -> bk1.withdraw(100));
	}
}
