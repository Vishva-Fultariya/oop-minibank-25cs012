# MiniBank – Object Oriented Programming

## Course Information

- **Course:** Object Oriented Programming
- **Course Code:** CEUE203
- **Academic Year:** 2026–27
- **Semester:** 3
- **Language:** Java
- **JDK Version:** 21

## About This Repository

This repository contains the practical implementations and MiniBank project developed as part of the OOP (Java) course.

The repository is divided into two parts:

- **Part A:** Practice programs for each laboratory.
- **Part B:** MiniBank, a semester-long console banking application.

## Repository Structure

```text
oop-minibank-25cs012/
│
├── lab-01/
│   ├── Practical-1/
│   │   └── VendingMachine.java
│   ├── Practical-2/
│   │   └── TollBooth.java
│   └── Practical-3/
│       └── RPSLS.java
│
├── lab-02/
│   ├── Practical-1/
│   │   └── Thermostat.java
│   ├── Practical-2/
│   │   └── CinemaShow.java
│   └── Practical-3/
│       └── ParkingLot.java
│
├── lab-03/
│   ├── Practical-1/
│   │   ├── Point.java
│   │   └── Driver.java
│   ├── Practical-2/
│   │   ├── Card.java
│   │   └── Driver.java
│   └── Practical-3/
│       ├── Fraction.java
│       └── Driver.java
│
├── lab-04/
│   ├── Practical-1/
│   │   ├── PasswordChecker.java
│   │   └── Driver.java
│   ├── Practical-2/
│   │   ├── ChatFilter.java
│   │   └── Driver.java
│   └── Practical-3/
│       ├── TemplateFiller.java
│       └── Driver.java
│
├── lab-05/
│   ├── Practical-1/
│   │   └── ShapeAreas.java
│   ├── Practical-2/
│   │   └── Payroll.java
│   └── Practical-3/
│       └── MediaLateFees.java
│
├── Miniproject/
│   └── src/
│       ├── MiniBank.java
│       ├── Customer.java
│       ├── Account.java
│       ├── SavingsAccount.java
│       ├── CurrentAccount.java
│       ├── FixedDepositAccount.java
│       ├── Validator.java
│       ├── TransactionType.java
│       ├── Command.java
│       ├── CommandParser.java
│       └── StatementFormatter.java
│
├── .gitignore
└── README.md
```

## Lab 01 – Part A

1. **Vending Machine** – Enum and Switch Expression.
2. **Toll Booth** – Record and Switch Expression.
3. **Rock-Paper-Scissors-Lizard-Spock** – Enum and Random.

## Lab 01 – Part B

MiniBank initial implementation:

- BankInfo record.
- MenuOption enum.
- Menu-driven console interface.
- Scanner for user input.
- Switch expressions.
- Input validation and EXIT functionality.

## Lab 02 – Part A

1. **Smart Thermostat** – Constructors, static members and encapsulation.
2. **Cinema Show** – Constructor overloading, static variables and seat booking.
3. **Parking Lot** – Object-oriented parking management and static revenue.

## Lab 02 – Part B

MiniBank enhancements:

- Customer class with automatically generated customer IDs.
- Account class with automatically generated account numbers.
- Encapsulated account balance.
- Constructor overloading and constructor chaining.
- Deposit and withdrawal operations.
- Array of Account objects.
- Balance and account information getters.

## Lab 03 – Part A

1. **Distinct Points** – Overriding `equals()` and `hashCode()` to identify distinct Point objects.
2. **Duplicate Card Check** – Comparing Card objects using `equals()` and `hashCode()`.
3. **Fraction** – Fraction reduction using GCD and equality comparison.

## Lab 03 – Part B

MiniBank enhancements:

- Overriding `toString()` to display account information.
- Overriding `equals()` to compare accounts using account numbers.
- Overriding `hashCode()` based on account numbers.
- Implementing a public static nested Address class inside Customer.
- Address field, setter and getter in Customer.
- Implementing object cloning using `Cloneable` and `clone()`.
- Demonstrating the `instanceof` operator.
- Demonstrating shallow cloning of Customer objects.

## Lab 04 – Part A

1. **Password Strength Checker** – Validating password strength using String methods and regular expressions.
   - Checks minimum length, uppercase letters, digits and special characters.
   - Classifies passwords as Weak, Medium or Strong.

2. **Chat-Log Filter** – Filtering chat messages using String methods and StringBuilder.
   - Reads a search keyword from the user.
   - Splits log entries into time, username and message.
   - Performs case-insensitive keyword searching.
   - Skips malformed log entries.
   - Builds a matching report using StringBuilder.

3. **Template Filler** – Replacing placeholders using Regular Expressions.
   - Uses Pattern and Matcher classes.
   - Identifies placeholders in a template.
   - Replaces placeholders with corresponding values.
   - Handles missing values using `[?]`.
   - Builds the final output using StringBuilder.

## Lab 04 – Part B

MiniBank enhancements:

- **Validator class:** Validates mobile numbers, email addresses, PAN numbers and IFSC codes using compiled regular expressions.
- **TransactionType enum:** Defines DEPOSIT, WITHDRAW and TRANSFER transaction types.
- **Command record:** Stores transaction type, account number and transaction amount.
- **CommandParser class:** Parses transaction commands and converts them into Command records.
- **StatementFormatter class:** Generates formatted account statements using StringBuilder.
- **MiniBank integration:** Demonstrates validation, command parsing and account statement generation.

## Lab 05 – Part A

1. **Shape Areas** – Abstract classes, inheritance and polymorphism.
   - Implements an abstract Shape class.
   - Uses Circle, Rectangle and Triangle subclasses.
   - Demonstrates method overriding and runtime polymorphism.
   - Calculates individual areas, total area and the largest shape.

2. **Employee Payroll** – Abstract classes, constructors, `super` and `instanceof`.
   - Implements an abstract Employee class.
   - Uses FullTimeEmployee and PartTimeEmployee subclasses.
   - Demonstrates constructor chaining and method overriding.
   - Calculates individual salaries and total payroll.
   - Identifies employee types using `instanceof`.

3. **Media Late Fees** – Inheritance and polymorphism.
   - Implements an abstract Media class.
   - Uses Book, DVD and Magazine subclasses.
   - Calculates late fees using overridden methods.
   - Demonstrates runtime polymorphism using a Media array.

## Lab 05 – Part B

MiniBank enhancements:

- Converted Account into an abstract class.
- Created SavingsAccount, CurrentAccount and FixedDepositAccount subclasses.
- Implemented account-specific interest calculation.
- Savings Account interest rate: 4%.
- Current Account interest rate: 0%.
- Fixed Deposit Account interest rate: 7%.
- Demonstrated runtime polymorphism using an Account array.
- Demonstrated pattern matching with `instanceof`.
- Integrated the new account types into the existing MiniBank application.

## Requirements

- Java Development Kit (JDK) 21.
- Visual Studio Code or another Java IDE.
- Git.

## How to Compile and Run

Run these commands from the repository root using PowerShell.

### Lab 01 – Part A

**Vending Machine**

```powershell
javac .\lab-01\Practical-1\VendingMachine.java
java -cp .\lab-01\Practical-1 VendingMachine
```

**Toll Booth**

```powershell
javac .\lab-01\Practical-2\TollBooth.java
java -cp .\lab-01\Practical-2 TollBooth
```

**Rock-Paper-Scissors-Lizard-Spock**

```powershell
javac .\lab-01\Practical-3\RPSLS.java
java -cp .\lab-01\Practical-3 RPSLS
```

### Lab 02 – Part A

**Smart Thermostat**

```powershell
javac .\lab-02\Practical-1\Thermostat.java
java -cp .\lab-02\Practical-1 Thermostat
```

**Cinema Show**

```powershell
javac .\lab-02\Practical-2\CinemaShow.java
java -cp .\lab-02\Practical-2 CinemaShow
```

**Parking Lot**

```powershell
javac .\lab-02\Practical-3\ParkingLot.java
java -cp .\lab-02\Practical-3 ParkingLot
```

### Lab 03 – Part A

**Distinct Points**

```powershell
cd .\lab-03\Practical-1
javac *.java
java Driver
cd ..\..
```

**Duplicate Card Check**

```powershell
cd .\lab-03\Practical-2
javac *.java
java Driver
cd ..\..
```

**Fraction**

```powershell
cd .\lab-03\Practical-3
javac *.java
java Driver
cd ..\..
```

### Lab 04 – Part A

**Password Strength Checker**

```powershell
cd .\lab-04\Practical-1
javac *.java
java Driver
cd ..\..
```

**Chat-Log Filter**

```powershell
cd .\lab-04\Practical-2
javac *.java
java Driver
cd ..\..
```

**Template Filler**

```powershell
cd .\lab-04\Practical-3
javac *.java
java Driver
cd ..\..
```

### Lab 05 – Part A

**Shape Areas**

```powershell
cd .\lab-05\Practical-1
javac *.java
java ShapeAreas
cd ..\..
```

**Employee Payroll**

```powershell
cd .\lab-05\Practical-2
javac *.java
java Payroll
cd ..\..
```

**Media Late Fees**

```powershell
cd .\lab-05\Practical-3
javac *.java
java MediaLateFees
cd ..\..
```

### MiniBank – Part B

Compile and run all MiniBank source files:

```powershell
cd .\Miniproject\src
javac *.java
java MiniBank
cd ..\..
```

## Git Tags

The following Git tags mark the completion of each laboratory:

- `lab-01` – Lab 01 completed.
- `lab-02` – Lab 02 completed.
- `lab-03` – Lab 03 completed.
- `lab-04` – Lab 04 completed.
- `lab-05` – Lab 05 completed.

## Author

**Vishva Fultariya**

B.Tech – Computer Science and Engineering  
CHARUSAT
