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
├── lab-02/
├── lab-03/
├── lab-04/
├── lab-05/
│
├── lab-06/
│   ├── Practical-1/
│   │   └── RemoteControl.java
│   ├── Practical-2/
│   │   └── NotificationSenders.java
│   └── Practical-3/
│       ├── src/
│       │   ├── app/
│       │   │   └── DiscountEngine.java
│       │   └── discount/
│       │       └── DiscountRule.java
│       ├── manifest.txt
│       └── DiscountEngine.jar
│
├── Miniproject/
│   ├── src/
│   │   ├── model/
│   │   │   ├── Account.java
│   │   │   ├── SavingsAccount.java
│   │   │   ├── CurrentAccount.java
│   │   │   ├── FixedDepositAccount.java
│   │   │   ├── Customer.java
│   │   │   ├── Transactable.java
│   │   │   ├── InterestBearing.java
│   │   │   └── Premium.java
│   │   │
│   │   ├── util/
│   │   │   ├── Validator.java
│   │   │   ├── TransactionType.java
│   │   │   ├── Command.java
│   │   │   ├── MenuOption.java
│   │   │   └── BankInfo.java
│   │   │
│   │   └── service/
│   │       ├── MiniBank.java
│   │       ├── CommandParser.java
│   │       ├── StatementFormatter.java
│   │       └── WithdrawRule.java
│   │
│   ├── manifest.txt
│   └── MiniBank.jar
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

## Lab 06 – Part A

1. **Remote Control System** – Interfaces, default methods, arrays of interface references, anonymous classes and lambda expressions.

   - Defines a `Switchable` interface with `on()`, `off()` and `toggle()`.
   - Implements Fan and Light devices.
   - Demonstrates runtime polymorphism using a `Switchable` array.
   - Defines a functional interface for device switching permissions.
   - Demonstrates the permission rule using both an anonymous class and a lambda expression.

2. **Notification Sender System** – Functional interfaces, lambda expressions and marker interfaces.

   - Defines a functional `Notifier` interface.
   - Implements Email and SMS notification senders using lambda expressions.
   - Broadcasts messages through an array of notification senders.
   - Defines an `Urgent` marker interface.
   - Demonstrates additional notifications for urgent senders.

3. **Discount Engine** – Functional interfaces, lambda expressions, packages and runnable JAR creation.

   - Defines a functional `DiscountRule` interface.
   - Implements discount rules using lambda expressions.
   - Allows the user to select a discount rule at runtime.
   - Applies selected discounts to a list of prices.
   - Calculates the final total and savings.
   - Organises the program into `app` and `discount` packages.
   - Builds and executes a runnable JAR.

## Lab 06 – Part B

MiniBank enhancements:

- Created the `Transactable` interface for deposit and withdrawal operations.
- Updated Account to implement `Transactable`.
- Created the `InterestBearing` interface with default methods for yearly and monthly interest calculations.
- Created the functional `WithdrawRule` interface.
- Demonstrated withdrawal rules using an anonymous class and a lambda expression.
- Created the `Premium` marker interface and implemented it in FixedDepositAccount.
- Organised the MiniBank application into three packages:
  - `model` – Account-related classes and interfaces.
  - `util` – Validation, transaction types, commands and supporting definitions.
  - `service` – Main application, command parsing, statement formatting and withdrawal rules.
- Demonstrated static imports for Validator methods.
- Created a manifest specifying the main class.
- Built and successfully executed the runnable `MiniBank.jar`.

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

### Lab 06 – Part A

**Remote Control System**

```powershell
cd .\lab-06\Practical-1
javac RemoteControl.java
java RemoteControl
cd ..\..
```

**Notification Sender System**

```powershell
cd .\lab-06\Practical-2
javac NotificationSenders.java
java NotificationSenders
cd ..\..
```

**Discount Engine – Run from JAR**

```powershell
java -jar .\lab-06\Practical-3\DiscountEngine.jar
```

To compile the Discount Engine from source:

```powershell
cd .\lab-06\Practical-3
New-Item -ItemType Directory -Force out
javac -d out src\discount\DiscountRule.java src\app\DiscountEngine.java
java -cp out app.DiscountEngine
cd ..\..
```

### MiniBank – Part B

**Run the prebuilt runnable JAR**

```powershell
java -jar .\Miniproject\MiniBank.jar
```

**Compile from source**

```powershell
cd .\Miniproject
New-Item -ItemType Directory -Force build
$files = Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName }
javac -d build $files
```

**Run the compiled application**

```powershell
java -cp build service.MiniBank
cd ..
```

## Git Tags

The following Git tags mark the completion of each laboratory:

- `lab-01` – Lab 01 completed.
- `lab-02` – Lab 02 completed.
- `lab-03` – Lab 03 completed.
- `lab-04` – Lab 04 completed.
- `lab-05` – Lab 05 completed.
- `lab-06` – Lab 06 completed.

## Author

**Vishva Fultariya**

B.Tech – Computer Science and Engineering  
CHARUSAT
