
public class Driver {

    public static void main(String[] args) {

        // Create Fraction objects
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 6);

        // Display reduced fractions
        System.out.println("Fraction 1: " + f1);
        System.out.println("Fraction 2: " + f2);
        System.out.println("Fraction 3: " + f3);

        // Compare fractions
        System.out.println("1/2 equals 2/4: " + f1.equals(f2));
        System.out.println("1/2 equals 3/6: " + f1.equals(f3));
        System.out.println("2/4 equals 3/6: " + f2.equals(f3));
    }
}
