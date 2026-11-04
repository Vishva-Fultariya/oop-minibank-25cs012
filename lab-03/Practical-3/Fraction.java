
import java.util.Objects;

public class Fraction {

    // Private instance variables
    private int num;
    private int den;

    // Constructor
    public Fraction(int num, int den) {

        if (den == 0) {
            throw new IllegalArgumentException(
                "Denominator cannot be zero"
            );
        }

        // Handle negative denominator
        if (den < 0) {
            num = -num;
            den = -den;
        }

        // Reduce fraction using GCD
        int gcd = findGCD(Math.abs(num), den);

        this.num = num / gcd;
        this.den = den / gcd;
    }

    // Find Greatest Common Divisor
    private int findGCD(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // Display fraction
    @Override
    public String toString() {
        return num + "/" + den;
    }

    // Compare two fractions
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Fraction other = (Fraction) obj;

        return num == other.num && den == other.den;
    }

    // Generate hash code
    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }
}
