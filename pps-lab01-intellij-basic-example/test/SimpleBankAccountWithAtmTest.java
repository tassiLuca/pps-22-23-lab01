import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.Test;

public class SimpleBankAccountWithAtmTest extends CommonsBankAccountTests {

    private SimpleBankAccountWithAtmTest() {
        super(new SimpleBankAccountWithAtm(new AccountHolder("Mario", "Rossi", 1), 0));
    }


    @Test
    void testDeposit() {
        testAmountAfterDeposit(100, 99);
    }

    @Test
    void testWrongDeposit() {
        testAmountAfterDeposit(100, 99);
        testAmountAfterDeposit(2, 50, 99);
    }

    @Test
    void testWithdraw() {
        testAmountAfterDeposit(100, 99);
        testAmountAfterWithdraw(70, 28);
    }

    @Test
    void testWrongWithdraw() {
        testAmountAfterDeposit(100, 99);
        testAmountAfterWithdraw(2, 70, 99);
    }
}
