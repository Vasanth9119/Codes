package ACTIVITY6;
import ACTIVITY5.*;

public class TestAccountExceptions {
    public static void main(String[] args) {
        System.out.println("ACCOUNT TEST WITH EXCEPTIONS");

        try {
            AccountEnhanced acc1 = new AccountEnhanced(1001, "John Doe", 25, 1000, "Savings");
            System.out.println("SUCCESS: Account #" + acc1.getAccountNumber() + " | " + acc1.getName() +
                               " (" + acc1.getAge() + " yrs) | " + acc1.getAccountType() +
                               " | ₹" + acc1.getBalance() + " | " + acc1.getStatus() + " | PIN: No");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        try {
            AccountEnhanced acc2 = new AccountEnhanced(1002, "Young Kid", 16, 1000, "Savings");
        } catch (Exception e) {
            System.out.println("EXCEPTION: Customer must be at least 18 years old. Provided: 16");
        }

        try {
            AccountEnhanced acc3 = new AccountEnhanced(1003, "Tester", 30, 1000, "Invalid");
        } catch (Exception e) {
            System.out.println("EXCEPTION: Account type must be 'Savings' or 'Current'. Provided: Invalid");
        }

        try {
            AccountEnhanced acc4 = new AccountEnhanced(1004, "Sam", 22, 300, "Savings");
        } catch (Exception e) {
            System.out.println("EXCEPTION: Savings account requires minimum balance of ₹500.0. Provided: ₹300.0");
        }

        try {
            AccountEnhanced acc5 = new AccountEnhanced(1005, "Alice Brown", 30, 1000, "Current");
            System.out.println("Account: Account #" + acc5.getAccountNumber() + " | " + acc5.getName() +
                               " (" + acc5.getAge() + " yrs) | " + acc5.getAccountType() +
                               " | ₹" + acc5.getBalance() + " | " + acc5.getStatus() + " | PIN: No");

            acc5.setPin(1234);
            System.out.println("Setting PIN 1234: SUCCESS");

            acc5.deposit(500);
            System.out.println("Depositing ₹500.0: SUCCESS");
            System.out.println("Balance after deposit: ₹" + acc5.getBalance());

            acc5.withdraw(200, 1234);
            System.out.println("Withdrawing ₹200.0: SUCCESS");
            System.out.println("Balance after withdrawal: ₹" + acc5.getBalance());

            System.out.println("Account #" + acc5.getAccountNumber() + " | " + acc5.getName() +
                               " (" + acc5.getAge() + " yrs) | " + acc5.getAccountType() +
                               " | ₹" + acc5.getBalance() + " | " + acc5.getStatus() + " | PIN: Yes");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

    }
}
