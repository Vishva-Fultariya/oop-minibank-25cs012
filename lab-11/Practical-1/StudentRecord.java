
import java.io.Serializable;

public class StudentRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int rollNumber;

    // This field will not be saved during serialization
    private transient String temporaryNote;

    public StudentRecord(String name, int rollNumber, String temporaryNote) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.temporaryNote = temporaryNote;
    }

    public void display() {

        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Temporary Note: " + temporaryNote);
    }
}
