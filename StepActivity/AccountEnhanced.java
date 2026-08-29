class AccountEnhanced {

    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status;
    private Integer pin;

    public AccountEnhanced(int accountNumber, String name, int age, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.age = (age<18)?18:age;

        if (!accountType.equalsIgnoreCase("Savings") &&!accountType.equalsIgnoreCase("Current")) {
            this.accountType = "Savings";
        } else {
            this.accountType = accountType;
        }

        if (this.accountType.equalsIgnoreCase("Savings") && initialBalance<500) {
            this.balance = 500;
        } else if (this.accountType.equalsIgnoreCase("Current") && initialBalance < 1000) {
            this.balance = 1000;
        } else {
            this.balance = initialBalance;
        }

        this.status = "Active";
        this.pin = null;       
    }

    boolean deposit(double amount) {
        if (!status.equals("Active")) return false;
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    boolean withdraw(double amount, int enteredPin) {
        if (!status.equals("Active")) return false;
        if (!hasPin() || !verifyPin(enteredPin)) return false;
        if (amount <= 0) return false;

        double minBalance = accountType.equalsIgnoreCase("Savings") ? 500 : 1000;
        if (balance - amount < minBalance) return false;

        balance -= amount;
        return true;
    }

    boolean closeAccount() {
        if (status.equals("Inactive")) return false;
        status = "Inactive";
        return true;
    }
    boolean reopenAccount() {
        if (status.equals("Active")) return false;
        status = "Active";
        return true;
    }
    boolean setPin(int pin) {
        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
            return true;
        }
        return false;
    }

    boolean verifyPin(int pin) {
        return this.pin != null && this.pin == pin;
    }

    boolean hasPin() {
        return this.pin != null;
    }

    int getAccountNumber() { 
        return accountNumber; 
        }
    String getName() { 
        return name; 
        }
    int getAge() { 
        return age; 
        }
    double getBalance() { 
        return balance; 
        }
    String getAccountType() { 
        return accountType; 
        }
    String getStatus() { 
        return status; 
        }

    void setName(String name) { 
        this.name = name; 
        }
    void setAge(int age) { 
        this.age = (age<18)?18:age; 
        }
}
