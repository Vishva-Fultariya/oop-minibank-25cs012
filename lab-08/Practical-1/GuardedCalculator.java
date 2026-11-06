
import java.util.Scanner;

// Custom checked exception
class DivideByZeroException extends Exception {

    public DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean success = false;
        int attempts = 0;

        System.out.println("===== GUARDED CALCULATOR =====");

        // Continue until a valid calculation succeeds
        while (!success) {

            attempts++;

            try {

                System.out.print("\nEnter first number: ");
                double num1 = Double.parseDouble(sc.nextLine());

                System.out.print("Enter operator (+, -, *, /): ");
                String operator = sc.nextLine().trim();

                System.out.print("Enter second number: ");
                double num2 = Double.parseDouble(sc.nextLine());

                double result;

                switch (operator) {

                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "*":
                        result = num1 * num2;
                        break;

                    case "/":

                        if (num2 == 0) {
                            throw new DivideByZeroException(
                                "Cannot divide by zero!"
                            );
                        }

                        result = num1 / num2;
                        break;

                    default:
                        throw new IllegalArgumentException(
                            "Invalid operator!"
                        );
                }

                System.out.println("Result: " + result);

                success = true;

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid number! Please enter numeric values."
                );

            } catch (DivideByZeroException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            } finally {

                System.out.println(
                    "Calculation attempt " + attempts + " completed."
                );
            }
        }

        System.out.println("\nCalculation completed successfully.");

        sc.close();
    }
}
