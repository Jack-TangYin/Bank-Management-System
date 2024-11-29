public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount >= -overdraftLimit)) {
            super.withdraw(amount);
        } else {
            System.out.println("Overdraft limit exceeded or invalid amount.");
        }
    }
}
