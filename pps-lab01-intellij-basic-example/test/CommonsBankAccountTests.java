import lab01.example.model.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class CommonsBankAccountTests {

    protected final BankAccount bankAccount;

    protected CommonsBankAccountTests(final BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }


    protected void testAmountAfterDeposit(final int userId, final double amount, final double expected) {
        this.bankAccount.deposit(userId, amount);
        assertEquals(expected, this.bankAccount.getBalance());
    }

    protected void testAmountAfterDeposit(final double amount, final double expected) {
        this.bankAccount.deposit(this.bankAccount.getHolder().getId(), amount);
        assertEquals(expected, this.bankAccount.getBalance());
    }

    protected void testAmountAfterWithdraw(final int userId, final double amount, final double expected) {
        this.bankAccount.withdraw(userId, amount);
        assertEquals(expected, this.bankAccount.getBalance());
    }

    protected void testAmountAfterWithdraw(final double amount, final double expected) {
        this.bankAccount.withdraw(this.bankAccount.getHolder().getId(), amount);
        assertEquals(expected, this.bankAccount.getBalance());
    }
}
