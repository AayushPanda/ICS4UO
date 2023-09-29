package OOP2;

public class Worker{
    private String name;
    private String birthDate;
    private String endDate;
    private Boolean isTerminated = false;
    private double wage;
    
    public Worker(String name, String birthdate, String endDate, boolean wage){
        this.name = name;
        this.birthDate = birthdate; // format: yyyy-mm-dd
        this.endDate = endDate;
    }

    public int getAge(){
        int year = Integer.parseInt(this.birthDate.substring(0, 4));
        int age = 2021 - year;
        return age;
    }

    public double collectPay(){
        return this.wage;
    };

    public void terminate(){
        isTerminated = true;
    };

    public Boolean getIsTerminated(){
        return this.isTerminated;
    }

    public String getName(){
        return this.name;
    }

    public String getBirthDate(){
        return this.birthDate;
    }

    public String getEndDate(){
        return this.endDate;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

}
