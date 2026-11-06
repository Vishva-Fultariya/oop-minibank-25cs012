
public class StudentRecord {

    @Column(name = "Student Name")
    private String studentName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Age")
    private int age;

    public StudentRecord() {
    }

    @Override
    public String toString() {
        return "Student Name: " + studentName +
               "\nEmail: " + email +
               "\nAge: " + age;
    }
}
