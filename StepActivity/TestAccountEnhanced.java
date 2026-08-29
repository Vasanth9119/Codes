public class TestAccountEnhanced {
    public static void main(String[] args) {

        AccountEnhanced acc1 = new AccountEnhanced(1001, "John Doe", 25, 1000, "Savings");
        System.out.println(">>> Test 1: Valid Account Creation");
        displayAccount(acc1);

        System.out.println("\n>>> Test 2: Invalid Age (under 18)");
        AccountEnhanced acc2 = new AccountEnhanced(1002, "Young Kid", 16, 500, "Savings");
        displayAccount(acc2);

        System.out.println("\n>>> Test 3: Invalid Account Type");
        AccountEnhanced acc3 = new AccountEnhanced(1003, "Test User", 25, 500, "Invalid");
        displayAccount(acc3);

        System.out.println("\n>>> Test 4: Minimum Balance Enforcement on Creation");
        AccountEnhanced acc4 = new AccountEnhanced(1004, "Bob Wilson", 25, 300, "Savings");
        displayAccount(acc4);

        System.out.println("\n>>> Test 5: Withdrawal with Minimum Balance");
        AccountEnhanced acc5 = new AccountEnhanced(1005, "Alice Brown", 30, 1000, "Current");
        acc5.setPin(1234);
        System.out.println("Withdrawing Rs200: " + (acc5.withdraw(200, 1234) ? "SUCCESS" : "FAILED"));
        System.out.println("New balance: Rs." + acc5.getBalance());
        System.out.println("Withdrawing Rs900: " + (acc5.withdraw(900, 1234) ? "SUCCESS" : "FAILED"));
        System.out.println("Current balance: Rs." + acc5.getBalance());

        System.out.println("\n>>> Test 6: Account Status Management");
        AccountEnhanced acc6 = new AccountEnhanced(1006, "Charlie Green", 35, 2000, "Savings");
        System.out.println("Closing account: " + (acc6.closeAccount() ? "SUCCESS" : "FAILED"));
        System.out.println("Depositing Rs500 to closed account: " + (acc6.deposit(500) ? "SUCCESS" : "FAILED"));
        System.out.println("Reopening account: " + (acc6.reopenAccount() ? "SUCCESS" : "FAILED"));
        displayAccount(acc6);

        System.out.println("\n>>> Test 7: PIN Protection");
        AccountEnhanced acc7 = new AccountEnhanced(1007, "Diana Prince", 28, 1500, "Savings");
        System.out.println("Setting PIN 1234: " + (acc7.setPin(1234) ? "SUCCESS" : "FAILED"));
        System.out.println("Withdrawing Rs200 with correct PIN: " + (acc7.withdraw(200, 1234) ? "SUCCESS" : "FAILED"));
        System.out.println("Withdrawing Rs100 with incorrect PIN: " + (acc7.withdraw(100, 9999) ? "SUCCESS" : "FAILED"));
        System.out.println("\n>>> Test 8: All Accounts Summary");

        displayAccount(acc1);
        displayAccount(acc2);
        displayAccount(acc3);
        displayAccount(acc4);
        displayAccount(acc5);
        displayAccount(acc6);
        displayAccount(acc7);

        System.out.println("\nENHANCED TEST COMPLETED!");
    }
    private static void displayAccount(AccountEnhanced acc) {
        System.out.println("Account #" + acc.getAccountNumber() + " | " +acc.getName() + " (" + acc.getAge() + " yrs) | " + acc.getAccountType() + " | Rs." + acc.getBalance() + " | " +acc.getStatus() + " | PIN: " + (acc.hasPin() ? "Yes" : "No"));
    }
}
