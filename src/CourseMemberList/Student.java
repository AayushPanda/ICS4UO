package CourseMemberList;

import java.lang.String;

public class Student {
    private int id;
    private String firstName;
    private String lastName;


    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return String.format("{Student ID: " + "%06d", id) + ", lastName: " + lastName + ", firstName: " + firstName + "}";
    }

    public void setId(int id){
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

}
