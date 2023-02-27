package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private final static int FEE_PER_TRANSACTION = 1;

    private final SimpleBankAccount simpleBankAccount;

    public SimpleBankAccountWithAtm(final AccountHolder accountHolder, final double balance) {
        this.simpleBankAccount = new SimpleBankAccount(accountHolder, balance);
    }

    @Override
    public AccountHolder getHolder() {
        return this.simpleBankAccount.getHolder();
    }

    @Override
    public double getBalance() {
        return this.simpleBankAccount.getBalance();
    }

    @Override
    public void deposit(final int userID, final double amount) {
        this.simpleBankAccount.deposit(userID, amount - FEE_PER_TRANSACTION);
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        this.simpleBankAccount.withdraw(userID, amount + FEE_PER_TRANSACTION);
    }
}
