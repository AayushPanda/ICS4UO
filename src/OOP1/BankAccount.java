package OOP1;

class BankAccount {
    private int accountNumber;
    private double balance;
    private String name;
    private String email;
    private PhoneNumber phoneNumber;

    public BankAccount(int accountNumber, double balance, String name, String email, PhoneNumber phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return String.format("Account Number: %d\nBalance: $%.2f\nName: %s\nEmail: %s\nPhone Number: %s", accountNumber, balance, name, email, phoneNumber);
    }

    public int deposit(double amount) {
        balance += amount;
        return 0;
    }

    public int withdraw(double amount) {
        if (balance - amount < 0) {
            return 1;
        } else {
            balance -= amount;
            return 0;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int setEmail(String email) {
        if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return 0;
        } else {
            return 1;
        }
    }

    public int setPhoneNumber(PhoneNumber phoneNumber) {
        if (phoneNumber.toString().matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$")) {
            this.phoneNumber = phoneNumber;
            return 0;
        } else {
            System.out.println("Invalid phone number.");
            return 1;
        }
    }


}