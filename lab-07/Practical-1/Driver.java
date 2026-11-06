
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {

        System.out.println("===== SIGNUP FORM VALIDATOR =====");

        SignupForm form1 = new SignupForm(
                "Vishva",
                "vishva@gmail.com",
                "password123"
        );

        SignupForm form2 = new SignupForm(
                "",
                "verylongemailaddress@example.com",
                "password123"
        );

        System.out.println("\nValidating Form 1:");

        ArrayList<String> errors1 = FormValidator.validate(form1);

        if (errors1.isEmpty()) {
            System.out.println("Form 1 is valid.");
        } else {
            for (String error : errors1) {
                System.out.println(error);
            }
        }

        System.out.println("\nValidating Form 2:");

        ArrayList<String> errors2 = FormValidator.validate(form2);

        if (errors2.isEmpty()) {
            System.out.println("Form 2 is valid.");
        } else {
            for (String error : errors2) {
                System.out.println(error);
            }
        }
    }
}
