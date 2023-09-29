package OOP2;

public class HourlyEmployee extends Employee{

    private double annualSalary;
    private int paymentsPerYear;

    public HourlyEmployee(String employeeID, String name, String birthdate, String hireDate, String endDate, double annualSalary, int paymentsPerYear){
        super(employeeID, name, birthdate, hireDate, endDate);
        this.annualSalary = annualSalary;
        this.paymentsPerYear = paymentsPerYear;
    }

    public void retire(){
        this.terminate();
    }

    public double collectPay(){
        return this.annualSalary / this.paymentsPerYear;
    }

    public double getAnnualSalary(){
        return this.annualSalary;
    }

    public int getPaymentsPerYear(){
        return this.paymentsPerYear;
    }

    public void setAnnualSalary(double annualSalary){
        this.annualSalary = annualSalary;
    }

    public void setPaymentsPerYear(int paymentsPerYear){
        this.paymentsPerYear = paymentsPerYear;
    }


}
