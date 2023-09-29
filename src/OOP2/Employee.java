package OOP2;

public abstract class Employee extends Worker{
    private String employeeID;
    private String hireDate;


    public Employee(String employeeID, String name, String birthdate, String hireDate, String endDate) {
        super(name, birthdate, endDate);
        this.employeeID = employeeID;
        this.hireDate = hireDate;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public String getHireDate() {
        return this.hireDate;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    
}
