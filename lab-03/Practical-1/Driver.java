
public class Driver {

    public static void main(String[] args) {

        // Create an array of Point objects
        Point[] points = {
            new Point(1, 2),
            new Point(3, 4),
            new Point(1, 2),
            new Point(5, 6),
            new Point(3, 4)
        };

        int count = 0;

        // Count distinct points
        for (int i = 0; i < points.length; i++) {

            boolean isDuplicate = false;

            // Compare with previous points
            for (int j = 0; j < i; j++) {

                if (points[i].equals(points[j])) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                count++;
            }
        }

        // Display result
        System.out.println("Distinct: " + count);
    }
}
