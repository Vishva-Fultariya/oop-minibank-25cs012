
abstract class Shape {

    abstract double area();
}

class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}

public class ShapeAreas {

    public static void main(String[] args) {

        // Create different shape objects
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(10, 5),
            new Triangle(8, 6)
        };

        double totalArea = 0;
        double largestArea = 0;
        String largestShape = "";

        System.out.println("===== SHAPE AREA CALCULATOR =====");

        // Calculate areas using polymorphism
        for (Shape shape : shapes) {

            double currentArea = shape.area();

            System.out.printf("Area: %.2f%n", currentArea);

            totalArea += currentArea;

            if (currentArea > largestArea) {
                largestArea = currentArea;

                if (shape instanceof Circle) {
                    largestShape = "Circle";
                } else if (shape instanceof Rectangle) {
                    largestShape = "Rectangle";
                } else if (shape instanceof Triangle) {
                    largestShape = "Triangle";
                }
            }
        }

        System.out.println("--------------------------------");

        System.out.printf("Total Area: %.2f%n", totalArea);
        System.out.printf("Largest Shape: %s (%.2f)%n",
                largestShape, largestArea);
    }
}
