package ACTIVITY5;

public class AccountEnhanced {

    private static final double MIN_BALANCE_SAVINGS = 500.0;
    private static final double MIN_BALANCE_CURRENT = 1000.0;
    private static final int MIN_AGE = 18;

    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status;
    private Integer pin;

    public AccountEnhanced(int accountNumber, String name, int age, double initialBalance, String accountType) {
        try {
            if (age < MIN_AGE) throw new IllegalArgumentException("Age must be at least 18");
            if (!accountType.equalsIgnoreCase("Savings") && !accountType.equalsIgnoreCase("Current")) {
                throw new IllegalArgumentException("Invalid account type");
            }
            double minBalance = accountType.equalsIgnoreCase("Savings") ? MIN_BALANCE_SAVINGS : MIN_BALANCE_CURRENT;
            if (initialBalance < minBalance) throw new IllegalArgumentException("Initial balance below minimum");

            this.accountNumber = accountNumber;
            this.name = name;
            this.age = age;
            this.accountType = accountType;
            this.balance = initialBalance;
            this.status = "Active";
            this.pin = null;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void deposit(double amount) throws InvalidAmountException, InactiveAccountException {
        try {
            validateActive();
            if (amount <= 0) throw new InvalidAmountException("Deposit amount must be positive");
            balance += amount;
        } catch (InactiveAccountException | InvalidAmountException e) {
            throw e;
        }
    }

    public void withdraw(double amount, int enteredPin)
            throws InvalidAmountException, InvalidPinException,
                   InsufficientBalanceException, MinimumBalanceViolationException, InactiveAccountException {
        try {
            validateActive();
            if (!hasPin() || !verifyPin(enteredPin)) throw new InvalidPinException("Invalid PIN");
            if (amount <= 0) throw new InvalidAmountException("Withdrawal amount must be positive");
            if (amount > balance) throw new InsufficientBalanceException("Insufficient balance");

            double minBalance = getMinimumBalance();
            if (balance - amount < minBalance) throw new MinimumBalanceViolationException("Minimum balance violation");

            balance -= amount;
        } catch (InactiveAccountException | InvalidPinException |
                 InvalidAmountException | InsufficientBalanceException |
                 MinimumBalanceViolationException e) {
            throw e;
        }
    }

    public void closeAccount() {
        try {
            if (status.equals("Inactive")) throw new IllegalStateException("Account already closed");
            status = "Inactive";
        } catch (IllegalStateException e) {
            throw e;
        }
    }

    public void reopenAccount() {
        try {
            if (status.equals("Active")) throw new IllegalStateException("Account already active");
            status = "Active";
        } catch (IllegalStateException e) {
            throw e;
        }
    }

    public void setPin(int pin) {
        try {
            if (pin < 1000 || pin > 9999) throw new IllegalArgumentException("PIN must be 4 digits");
            this.pin = pin;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    // ===== Helper Methods =====
    private void validateActive() throws InactiveAccountException {
        if (!status.equals("Active")) throw new InactiveAccountException("Account is inactive");
    }

    private double getMinimumBalance() {
        return accountType.equalsIgnoreCase("Savings") ? MIN_BALANCE_SAVINGS : MIN_BALANCE_CURRENT;
    }

    public boolean verifyPin(int pin) {
        return this.pin != null && this.pin == pin;
    }

    public boolean hasPin() {
        return this.pin != null;
    }

    // ===== Getters =====
    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public String getStatus() { return status; }
}
