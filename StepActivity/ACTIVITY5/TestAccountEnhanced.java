package ACTIVITY5;

public class TestAccountEnhanced {
    public static void main(String[] args) {
        try {
            AccountEnhanced acc = new AccountEnhanced(101, "Vasanth", 20, 1000, "Savings");
            acc.setPin(1234);

            try {
                acc.deposit(-50);
            } catch (InvalidAmountException | InactiveAccountException e) {
                System.out.println("Deposit failed: " + e.getMessage());
            }

            try {
                acc.withdraw(600, 1234);
                System.out.println("Withdrawal successful. Balance: " + acc.getBalance());
            } catch (InvalidAmountException | InvalidPinException |
                     InsufficientBalanceException | MinimumBalanceViolationException |
                     InactiveAccountException e) {
                System.out.println("Withdrawal failed: " + e.getMessage());
            }

            try {
                acc.closeAccount();
                acc.deposit(100);
            } catch (Exception e) {
                System.out.println("Operation failed: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Account creation failed: " + e.getMessage());
        }
    }
}
