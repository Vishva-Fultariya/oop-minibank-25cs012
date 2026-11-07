
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Driver {

    public static void main(String[] args) {

        String fileName = "students.dat";

        // Create an array of StudentRecord objects
        StudentRecord[] students = {
            new StudentRecord("Vishva", 12, "Temporary Note 1"),
            new StudentRecord("Dhruvi", 13, "Temporary Note 2"),
            new StudentRecord("Madhav", 14, "Temporary Note 3")
        };

        // Save objects into a file
        try (ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream(fileName))) {

            out.writeObject(students);

            System.out.println("Student records saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving: " + e.getMessage());
            return;
        }

        // Load objects from the file
        try (ObjectInputStream in =
                new ObjectInputStream(new FileInputStream(fileName))) {

            StudentRecord[] loadedStudents =
                    (StudentRecord[]) in.readObject();

            System.out.println("\n===== LOADED STUDENT RECORDS =====");

            for (StudentRecord student : loadedStudents) {
                student.display();
                System.out.println();
            }

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error while loading: " + e.getMessage());
        }
    }
}
