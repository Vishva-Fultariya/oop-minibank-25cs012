
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {

        System.out.println("===== COLUMN MAPPER =====");

        // Test 1: All columns are available
        System.out.println("\nTest 1: Complete Student Data");

        StudentRecord student1 = new StudentRecord();

        String header1 = "Student Name,Email,Age";
        String data1 = "Vishva,vishva@gmail.com,18";

        ArrayList<String> warnings1 =
                ColumnMapper.populate(student1, header1, data1);

        System.out.println(student1);

        if (warnings1.isEmpty()) {
            System.out.println("All columns mapped successfully.");
        } else {
            for (String warning : warnings1) {
                System.out.println(warning);
            }
        }

        // Test 2: Email column is missing
        System.out.println("\nTest 2: Missing Column");

        StudentRecord student2 = new StudentRecord();

        String header2 = "Student Name,Age";
        String data2 = "Dhruvi,22";

        ArrayList<String> warnings2 =
                ColumnMapper.populate(student2, header2, data2);

        System.out.println(student2);

        if (warnings2.isEmpty()) {
            System.out.println("All columns mapped successfully.");
        } else {
            for (String warning : warnings2) {
                System.out.println("Warning: " + warning);
            }
        }
    }
}
