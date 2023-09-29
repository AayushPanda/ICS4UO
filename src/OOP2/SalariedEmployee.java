package OOP2;

public class SalariedEmployee extends Employee{

    private double hourlyRate;

    public SalariedEmployee(String employeeID, String name, String birthdate, String hireDate, String endDate, double hourlyRate){
        super(employeeID, name, birthdate, hireDate, endDate);
    }

    public double getDoublePay(int hoursWorked){
        return this.collectPay(hoursWorked) * 2;
    }

    public double collectPay(int hoursWorked){
        return this.hourlyRate * hoursWorked;
    }

    public double getHourlyRate(){
        return this.hourlyRate;
    }

    public void setHourlyRate(double hourlyRate){
        this.hourlyRate = hourlyRate;
    }

}
