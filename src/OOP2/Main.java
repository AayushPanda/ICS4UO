package OOP2;

public class Main {
    public static void main(String[] args) {
        SalariedEmployee semp = new SalariedEmployee("1234", "John Doe", "1990-01-01", "2010-01-01", 100000, 12);
        HourlyEmployee hemp = new HourlyEmployee("5678", "Jane Doe", "1995-01-01", "2015-01-01", 50);

        // Test class methods for SalariedEmployee
        System.out.println(semp.toString());
        System.out.println("Collect Pay: " + semp.collectPay());
        semp.retire();
        System.out.println("Is Retired: " + semp.getIsRetired());
        System.out.println("End Date: " + semp.getEndDate());

        System.out.println();

        // Test class methods for HourlyEmployee
        System.out.println(hemp.toString());
        System.out.println("Collect Pay: " + hemp.collectPay(40));
        System.out.println("Double Pay: " + hemp.getDoublePay(40));
        semp.terminate("2020-01-01");
        System.out.println("End Date: " + semp.getEndDate());
        
        // Test all superclass methods
        System.out.println();
        System.out.println("Name: " + semp.getName());
        System.out.println("Birthdate: " + semp.getBirthdate());
        System.out.println("Age: " + semp.getAge());
        System.out.println("Employee ID: " + semp.getEmployeeID());
        System.out.println("Hire Date: " + semp.getHireDate());
    }
}
