package OOP2;

public class SalariedEmployee extends Employee{

    private double annualSalary;
    private boolean isRetired = false;
    private int paymentsPerYear;

    public SalariedEmployee(String employeeID, String name, String birthdate, String hireDate, double annualSalary, int paymentsPerYear){
        super(employeeID, name, birthdate, hireDate);
        this.annualSalary = annualSalary;
        this.paymentsPerYear = paymentsPerYear;
    }

    public void retire(){
        this.isRetired = true;
        this.terminate(java.time.LocalDate.now().toString());
    }

    public double collectPay(){
        return this.annualSalary / this.paymentsPerYear;
    }

    public String toString(){
        return "Employee ID: " + this.getEmployeeID() + "\nName: " + this.getName() + "\nBirthdate: " + this.getBirthdate() + "\nHire Date: " + this.getHireDate() + "\nAnnual Salary: " + this.annualSalary + "\nPayments Per Year: " + this.paymentsPerYear;
    }

    // Getters and Setters

    public boolean getIsRetired(){
        return this.isRetired;
    }

    public double getAnnualSalary(){
        return this.annualSalary;
    }

    public void setIsRetired(boolean isRetired){
        this.isRetired = isRetired;
        this.endDate = "N/A";
    }

    public void setAnnualSalary(double annualSalary){
        this.annualSalary = annualSalary;
    }
}

