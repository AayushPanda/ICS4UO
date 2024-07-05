package OOP2;

public abstract class Employee extends Worker{

    private String employeeID; // String to allow for custom format as needed, that is not necessarily a number
    private String hireDate;


    public Employee(String employeeID, String name, String birthdate, String hireDate){
        super(name, birthdate);
        this.employeeID = employeeID;
        this.hireDate = hireDate;
    }

    // Getters and Setters

    public String getEmployeeID(){
        return this.employeeID;
    }

    public String getHireDate(){
        return this.hireDate;
    }

    public void setEmployeeID(String employeeID){
        this.employeeID = employeeID;
    }

    public void setHireDate(String hireDate){
        this.hireDate = hireDate;
    }

}