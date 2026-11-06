
public class TestCases {

    @Run
    public void testAddition() {

        int result = 10 + 20;

        System.out.println("Addition Test: " + result);
    }

    @Run
    public void testSubtraction() {

        int result = 50 - 20;

        System.out.println("Subtraction Test: " + result);
    }

    @Run
    public void testMultiplication() {

        int result = 5 * 4;

        System.out.println("Multiplication Test: " + result);
    }

    public void testDivision() {

        int result = 20 / 5;

        System.out.println("Division Test: " + result);
    }

    public void displayMessage() {

        System.out.println("This method is not marked with @Run.");
    }
}
