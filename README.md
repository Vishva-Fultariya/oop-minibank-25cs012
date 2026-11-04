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

- **Part A:** Practice Programs for each laboratory.
- **Part B:** MiniBank, a semester-long console banking application.

## Repository Structure

```text
oop-minibank-25cs012/
│
├── lab-01/
│   ├── Practical-1/
│   ├── Practical-2/
│   └── Practical-3/
│
├── lab-02/
│   ├── Practical-1/
│   ├── Practical-2/
│   └── Practical-3/
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
├── Miniproject/
│   └── src/
│       ├── MiniBank.java
│       ├── Customer.java
│       └── Account.java
│
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

## Requirements

- Java Development Kit (JDK) 17 or above.
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

## Author

**Vishva Fultariya**

B.Tech – Computer Science and Engineering  
CHARUSAT