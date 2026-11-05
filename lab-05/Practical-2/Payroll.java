
abstract class Employee {

    protected String name;
    protected int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
        System.out.printf("Salary: Rs. %.2f%n",
                calculateSalary());
    }
}

class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(String name, int id,
                            double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id,
                             int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class Payroll {

    public static void main(String[] args) {

        Employee[] employees = {
            new FullTimeEmployee("Vishva", 101, 30000),
            new PartTimeEmployee("Dhruvi", 102, 80, 200),
            new FullTimeEmployee("Madhav", 103, 40000)
        };

        double totalPayroll = 0;

        System.out.println("===== EMPLOYEE PAYROLL =====");

        for (Employee employee : employees) {

            employee.displayDetails();

            totalPayroll += employee.calculateSalary();

            if (employee instanceof FullTimeEmployee) {
                System.out.println("Type: Full-Time Employee");
            } else if (employee instanceof PartTimeEmployee) {
                System.out.println("Type: Part-Time Employee");
            }

            System.out.println("----------------------------");
        }

        System.out.printf("Total Payroll: Rs. %.2f%n",
                totalPayroll);
    }
}
