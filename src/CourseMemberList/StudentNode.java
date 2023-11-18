package CourseMemberList;

public class StudentNode {
    
    private Student student;
    private StudentNode next;

    public StudentNode(Student student){
        this.student = student;
        this.next = null;
    }

    public StudentNode(Student student, StudentNode next){
        this.student = student;
        this.next = next;
    }

    public Student getStudent(){
        return student;
    }

    public StudentNode getNext(){
        return next;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    public void setNext(StudentNode next){
        this.next = next;
    }

    public String toString(){
        return student.toString();
    }

    
}