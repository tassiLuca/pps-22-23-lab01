import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.Test;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends CommonsBankAccountTests {

    private SimpleBankAccountTest() {
        super(new SimpleBankAccount(new AccountHolder("Mario", "Rossi", 1), 0));
    }

    @Test
    void testDeposit() {
        testAmountAfterDeposit(100, 100);
    }

    @Test
    void testWrongDeposit() {
        testAmountAfterDeposit(100, 100);
        testAmountAfterDeposit(2, 50, 100);
    }

    @Test
    void testWithdraw() {
        testAmountAfterDeposit(100, 100);
        testAmountAfterWithdraw(70, 30);
    }

    @Test
    void testWrongWithdraw() {
        testAmountAfterDeposit(100, 100);
        testAmountAfterWithdraw(2, 70, 100);
    }
}
