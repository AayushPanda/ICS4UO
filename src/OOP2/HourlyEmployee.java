package OOP2;

public class HourlyEmployee extends Employee{

    private double hourlyRate;

    public HourlyEmployee(String employeeID, String name, String birthdate, String hireDate, double hourlyRate){
        super(employeeID, name, birthdate, hireDate);
        this.hourlyRate = hourlyRate;
    }

    public double collectPay(int hoursWorked){
        return this.hourlyRate * hoursWorked;
    }

    public double getDoublePay(int hoursWorked){
        return this.collectPay(hoursWorked)*2;
    }

    public String toString(){
        return "Employee ID: " + this.getEmployeeID() + "\nName: " + this.getName() + "\nBirthdate: " + this.getBirthdate() + "\nHire Date: " + this.getHireDate() + "\nHourly Rate: " + this.hourlyRate;
    }

    // Getters and Setters

    public double getHourlyRate(){
        return this.hourlyRate;
    }

    public void setHourlyRate(double hourlyRate){
        this.hourlyRate = hourlyRate;
    }

}