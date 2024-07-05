package OOP2;

public abstract class Worker{

    private String name;
    private String birthdate;
    protected String endDate;

    public Worker(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate; // yyyy-mm-dd
    }

    public abstract double collectPay();

    public void terminate(String endDate){
        this.endDate = endDate;
    }   

    public int getAge(){
        int birthyear = Integer.parseInt(this.birthdate.substring(0, 4));
        int birthmonth = Integer.parseInt(this.birthdate.substring(5, 7));
        int birthday = Integer.parseInt(this.birthdate.substring(8, 10));
        int currentyear = Integer.parseInt(java.time.LocalDate.now().toString().substring(0, 4));
        int currentmonth = Integer.parseInt(java.time.LocalDate.now().toString().substring(5, 7));
        int currentday = Integer.parseInt(java.time.LocalDate.now().toString().substring(8, 10));
        int age = currentyear - birthyear;
        if (currentmonth < birthmonth){
            age -= 1;
        } else if (currentmonth == birthmonth){
            if (currentday < birthday){
                age -= 1;
            }
        }
        return age;
    }

    // Getters and Setters

    public String getName() {
        return this.name;
    }

    public String getBirthdate() {
        return this.birthdate;
    }   

    public String getEndDate() {
        return this.endDate;
    }       

    public void setName(String name) {
        this.name = name;
    }   

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}