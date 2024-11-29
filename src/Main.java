import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Add Savings Account");
            System.out.println("2. Add Current Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Add Interest (Savings Only)");
            System.out.println("7. List All Accounts");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String saNumber = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String saHolder = scanner.nextLine();
                    System.out.print("Enter Initial Balance ($): ");
                    double saBalance = scanner.nextDouble();
                    System.out.print("Enter Interest Rate (%): ");
                    double saRate = scanner.nextDouble();
                    bank.addAccount(new SavingsAccount(saNumber, saHolder, saBalance, saRate));
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String caNumber = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String caHolder = scanner.nextLine();
                    System.out.print("Enter Initial Balance ($): ");
                    double caBalance = scanner.nextDouble();
                    System.out.print("Enter Overdraft Limit ($): ");
                    double caLimit = scanner.nextDouble();
                    bank.addAccount(new CurrentAccount(caNumber, caHolder, caBalance, caLimit));
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String depositNumber = scanner.nextLine();
                    BankAccount depositAccount = bank.findAccount(depositNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter Amount to Deposit ($): ");
                        double depositAmount = scanner.nextDouble();
                        depositAccount.deposit(depositAmount);
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String withdrawNumber = scanner.nextLine();
                    BankAccount withdrawAccount = bank.findAccount(withdrawNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter Amount to Withdraw ($): ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    String balanceNumber = scanner.nextLine();
                    BankAccount balanceAccount = bank.findAccount(balanceNumber);
                    if (balanceAccount != null) {
                        System.out.println("Current Balance: $" + balanceAccount.getBalance());
                    }
                    break;

                case 6:
                    System.out.print("Enter Account Number: ");
                    String interestNumber = scanner.nextLine();
                    BankAccount interestAccount = bank.findAccount(interestNumber);
                    if (interestAccount instanceof SavingsAccount) {
                        ((SavingsAccount) interestAccount).addInterest();
                    } else {
                        System.out.println("Interest can only be added to Savings Accounts.");
                    }
                    break;

                case 7:
                    bank.listAccounts();
                    break;

                case 8:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
