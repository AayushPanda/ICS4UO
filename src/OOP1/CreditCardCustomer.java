package OOP1;

class CreditCardCustomer{
    
    private String name;
    private String address;
    private String email;
    private PhoneNumber phoneNumber;
    private int creditCardNumber;
    private double creditLimit;
    private double balance;
    private double interestRate;
    private double monthPayments;
    private boolean defaultStatus;
    public double minMonthlyPaymentRate = 0.01;

    public CreditCardCustomer(String name, String address, String email, PhoneNumber phoneNumber, int creditCardNumber, double creditLimit, double balance, double interestRate){
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.interestRate = interestRate;
        this.defaultStatus = false;
    }
    
    public CreditCardCustomer(String name, String address, String email, PhoneNumber phoneNumber, int creditCardNumber, double balance, double interestRate){
        this(name, address, email, phoneNumber, creditCardNumber, 1000.00, balance, interestRate);
    }

    public String toString(){
        return String.format("Name: %s\nAddress: %s\nEmail: %s\nPhone Number: %s\nCredit Card Number: %d\nCredit Limit: $%.2f\nBalance: $%.2f\nInterest Rate: %.2f%%\nDefault status: %s", name, address, email, phoneNumber, creditCardNumber, creditLimit, balance, interestRate, defaultStatus);
    }

    public int payBalance(double amount){
        if (balance - amount < 0){
            return 1;
        } else {
            balance -= amount;
            this.monthPayments += amount;
            return 0;
        }
    }

    public int charge(double amount){
        if (balance + amount > creditLimit){
            return 1;
        } else {
            balance += amount;
            return 0;
        }
    }

    public void progressMonth(){
        balance += balance * interestRate;
        if (monthPayments < balance*minMonthlyPaymentRate){
            defaultStatus = true;
        } else {
            defaultStatus = false;
        }
        monthPayments = 0;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }

    public PhoneNumber getPhoneNumber(){
        return phoneNumber;
    }

    public int getCreditCardNumber(){
        return creditCardNumber;
    }

    public double getCreditLimit(){
        return creditLimit;
    }

    public double getBalance(){
        return balance;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public double getMonthPayments(){
        return monthPayments;
    }

    public boolean getDefaultStatus(){
        return defaultStatus;
    }

    public double getMinMonthlyPaymentRate(){
        return minMonthlyPaymentRate;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int setEmail(String email){
        if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.email = email;
            return 0;
        } else {
            return 1;
        }
    }

    public int setPhoneNumber(PhoneNumber phoneNumber){
        if (phoneNumber.toString().matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$")) {
            this.phoneNumber = phoneNumber;
            return 0;
        } else {
            return 1;
        }
    }

    public int setCreditLimit(double creditLimit){
        if (creditLimit < 0){
            return 1;
        } else {
            this.creditLimit = creditLimit;
            return 0;
        }
    }

    public int setInterestRate(double interestRate){
        if (interestRate < 0){
            interestRate = 0;
            return 0;
        } else if (interestRate > 1){
            interestRate = 1;
            return 0;
        } else {
            return 1;
        }
    }

    public void setMinMonthlyPaymentRate(double minMonthlyPaymentRate){
        this.minMonthlyPaymentRate = minMonthlyPaymentRate;
    }

    
}