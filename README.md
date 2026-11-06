# MiniBank – Object Oriented Programming

## Course Information

- **Course:** Object Oriented Programming
- **Course Code:** CEUE203
- **Academic Year:** 2026–27
- **Semester:** 3
- **Programming Language:** Java
- **JDK Version:** 21
- **University:** CHARUSAT
- **Institute:** CSPIT
- **Department:** Computer Science and Engineering

## About This Repository

This repository contains the practical implementations and MiniBank project developed as part of the Object Oriented Programming (Java) course.

The repository is divided into two parts:

- **Part A – Practice Programs:** Individual practical programs implementing the concepts covered in each laboratory.
- **Part B – MiniBank Project:** A semester-long, menu-driven console banking application developed incrementally using Object-Oriented Programming concepts.

Each laboratory introduces new Java concepts and extends the MiniBank application with additional functionality.

## Repository Structure

The following structure shows the main source files, supporting files, and project folders. Generated `.class` files and build output are omitted because they are created during compilation.

```text
oop-minibank-25cs012/
│
├── lab-01/
│   ├── Practical-1/
│   │   └── VendingMachine.java
│   ├── Practical-2/
│   │   ├── TollBooth.java
│   │   └── Vehicle.java
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
│   │   ├── Driver.java
│   │   └── Point.java
│   ├── Practical-2/
│   │   ├── Card.java
│   │   └── Driver.java
│   └── Practical-3/
│       ├── Driver.java
│       └── Fraction.java
│
├── lab-04/
│   ├── Practical-1/
│   │   ├── Driver.java
│   │   └── PasswordChecker.java
│   ├── Practical-2/
│   │   ├── ChatFilter.java
│   │   └── Driver.java
│   └── Practical-3/
│       ├── Driver.java
│       └── TemplateFiller.java
│
├── lab-05/
│   ├── Practical-1/
│   │   └── ShapeAreas.java
│   ├── Practical-2/
│   │   └── Payroll.java
│   └── Practical-3/
│       └── MediaLateFees.java
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
├── lab-07/
│   ├── Practical-1/
│   │   ├── Driver.java
│   │   ├── FormValidator.java
│   │   ├── MaxLength.java
│   │   ├── NotBlank.java
│   │   └── SignupForm.java
│   │
│   ├── Practical-2/
│   │   ├── Driver.java
│   │   ├── MiniTestRunner.java
│   │   ├── Run.java
│   │   └── TestCases.java
│   │
│   └── Practical-3/
│       ├── Column.java
│       ├── ColumnMapper.java
│       ├── Driver.java
│       └── StudentRecord.java
│
├── lab-08/
│   ├── Practical-1/
│   │   └── GuardedCalculator.java
│   ├── Practical-2/
│   │   └── StockIssue.java
│   └── Practical-3/
│       └── TryWithResourcesDemo.java
│
├── lab-09/
│   ├── Practical-1/
│   │   └── CounterRace.java
│   ├── Practical-2/
│   │   └── SeatBookingRace.java
│   └── Practical-3/
│       └── SharedArraySum.java
│
├── lab-10/
│   ├── Practical-1/
│   │   └── ThreadPoolRunner.java
│   ├── Practical-2/
│   │   └── ProducerConsumer.java
│   └── Practical-3/
│       └── DeadlockDemo.java
│
├── Miniproject/
│   ├── src/
│   │   ├── exception/
│   │   │   ├── AccountNotFoundException.java
│   │   │   ├── BankException.java
│   │   │   ├── InsufficientFundsException.java
│   │   │   └── InvalidAmountException.java
│   │   │
│   │   ├── model/
│   │   │   ├── annotation/
│   │   │   │   ├── Id.java
│   │   │   │   ├── MaxLength.java
│   │   │   │   └── Positive.java
│   │   │   │
│   │   │   ├── Account.java
│   │   │   ├── CurrentAccount.java
│   │   │   ├── Customer.java
│   │   │   ├── FixedDepositAccount.java
│   │   │   ├── InterestBearing.java
│   │   │   ├── Premium.java
│   │   │   ├── SavingsAccount.java
│   │   │   └── Transactable.java
│   │   │
│   │   ├── service/
│   │   │   ├── AccountWorker.java
│   │   │   ├── AnnotationValidator.java
│   │   │   ├── BankTransaction.java
│   │   │   ├── CommandParser.java
│   │   │   ├── MiniBank.java
│   │   │   ├── StatementFormatter.java
│   │   │   ├── TimedTransferTask.java
│   │   │   ├── TransactionBuffer.java
│   │   │   ├── TransactionProcessor.java
│   │   │   ├── TransferDeadlockDemo.java
│   │   │   ├── UnsafeDepositDemo.java
│   │   │   └── WithdrawRule.java
│   │   │
│   │   └── util/
│   │       ├── BankInfo.java
│   │       ├── Command.java
│   │       ├── MenuOption.java
│   │       ├── TransactionType.java
│   │       └── Validator.java
│   │
│   ├── build/                  # Compiled Java classes (generated)
│   ├── manifest.txt
│   └── MiniBank.jar
│
├── .gitignore
└── README.md
```

---

## Lab 01 – Part A

1. **Vending Machine** – Enum and Switch Expression.

2. **Toll Booth** – Record and Switch Expression.

3. **Rock-Paper-Scissors-Lizard-Spock** – Enum and Random.

### Lab 01 – Part B

MiniBank initial implementation:

- Created the `BankInfo` record.
- Created the `MenuOption` enum.
- Implemented a menu-driven console interface.
- Used `Scanner` for user input.
- Demonstrated switch expressions.
- Implemented input validation and EXIT functionality.

## Lab 02 – Part A

1. **Smart Thermostat** – Constructors, static members and encapsulation.

2. **Cinema Show** – Constructor overloading, static variables and seat booking.

3. **Parking Lot** – Object-oriented parking management and static revenue.

### Lab 02 – Part B

MiniBank enhancements:

- Created the `Customer` class with automatically generated customer IDs.
- Created the `Account` class with automatically generated account numbers.
- Implemented encapsulation of account balance.
- Demonstrated constructor overloading and constructor chaining.
- Implemented deposit and withdrawal operations.
- Used an array of `Account` objects.
- Added balance and account information getters.

## Lab 03 – Part A

1. **Distinct Points** – Overriding `equals()` and `hashCode()` to identify distinct Point objects.

2. **Duplicate Card Check** – Comparing Card objects using `equals()` and `hashCode()`.

3. **Fraction** – Fraction reduction using GCD and equality comparison.

### Lab 03 – Part B

MiniBank enhancements:

- Overrode `toString()` to display account information.
- Overrode `equals()` to compare accounts using account numbers.
- Overrode `hashCode()` based on account numbers.
- Implemented a public static nested `Address` class inside `Customer`.
- Added an address field, setter and getter in `Customer`.
- Implemented object cloning using `Cloneable` and `clone()`.
- Demonstrated the `instanceof` operator.
- Demonstrated shallow cloning of Customer objects.

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

   - Uses `Pattern` and `Matcher` classes.
   - Identifies placeholders in a template.
   - Replaces placeholders with corresponding values.
   - Handles missing values using `[?]`.
   - Builds the final output using StringBuilder.

### Lab 04 – Part B

MiniBank enhancements:

- Created the `Validator` class to validate mobile numbers, email addresses, PAN numbers and IFSC codes.
- Created the `TransactionType` enum to define DEPOSIT, WITHDRAW and TRANSFER transaction types.
- Created the `Command` record to store transaction type, account number and transaction amount.
- Implemented the `CommandParser` class to parse transaction commands and convert them into Command records.
- Implemented the `StatementFormatter` class to generate formatted account statements.
- Integrated validation, command parsing and account statement generation into MiniBank.

## Lab 05 – Part A

1. **Shape Areas** – Abstract classes, inheritance and polymorphism.

   - Implements an abstract `Shape` class.
   - Uses Circle, Rectangle and Triangle subclasses.
   - Demonstrates method overriding and runtime polymorphism.
   - Calculates individual areas, total area and the largest shape.

2. **Employee Payroll** – Abstract classes, constructors, `super` and `instanceof`.

   - Implements an abstract `Employee` class.
   - Uses FullTimeEmployee and PartTimeEmployee subclasses.
   - Demonstrates constructor chaining and method overriding.
   - Calculates individual salaries and total payroll.
   - Identifies employee types using `instanceof`.

3. **Media Late Fees** – Inheritance and polymorphism.

   - Implements an abstract `Media` class.
   - Uses Book, DVD and Magazine subclasses.
   - Calculates late fees using overridden methods.
   - Demonstrates runtime polymorphism using a Media array.

### Lab 05 – Part B

MiniBank enhancements:

- Converted `Account` into an abstract class.
- Created `SavingsAccount`, `CurrentAccount` and `FixedDepositAccount` subclasses.
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

### Lab 06 – Part B

MiniBank enhancements:

- Created the `Transactable` interface for deposit and withdrawal operations.
- Updated `Account` to implement `Transactable`.
- Created the `InterestBearing` interface with default methods for yearly and monthly interest calculations.
- Created the functional `WithdrawRule` interface.
- Demonstrated withdrawal rules using an anonymous class and a lambda expression.
- Created the `Premium` marker interface and implemented it in `FixedDepositAccount`.
- Organised the MiniBank application into three packages:
  - `model` – Account-related classes and interfaces.
  - `util` – Validation, transaction types, commands and supporting definitions.
  - `service` – Main application, command parsing, statement formatting and withdrawal rules.
- Demonstrated static imports for Validator methods.
- Created a manifest specifying the main class.
- Built and executed the runnable `MiniBank.jar`.

## Lab 07 – Part A

1. **Signup Form Validator** – Custom annotations and Reflection.

   - Created the `@NotBlank` annotation to check whether a String field is blank.
   - Created the `@MaxLength` annotation to specify the maximum permitted String length.
   - Used Reflection to inspect fields and validate annotated values.
   - Displayed validation errors for invalid form data.

2. **Mini Test Runner** – Custom method annotations and Reflection.

   - Created the `@Run` method annotation.
   - Used Reflection to discover methods annotated with `@Run`.
   - Invoked the selected test methods dynamically.
   - Counted and displayed the total number of executed tests.

3. **Column Mapper** – Mapping data using annotations and Reflection.

   - Created the `@Column` annotation to associate object fields with column names.
   - Used Reflection to map header and data values to object fields.
   - Handled missing columns and displayed warnings.
   - Demonstrated automatic object population using annotated fields.

### Lab 07 – Part B

MiniBank enhancements:

- Added `@Override` to overridden methods and `@FunctionalInterface` to the `WithdrawRule` interface.
- Created a new `model.annotation` package for custom annotations.
- Created the `@Id` marker annotation for identifying fields.
- Created the `@Positive` annotation for validating positive numeric values.
- Created the `@MaxLength` annotation for restricting String field length.
- Applied `@Id` to the `accountNumber` field in `Account`.
- Applied `@Positive` to the `balance` field in `Account`.
- Applied `@MaxLength(10)` to the `ownerName` field in `Account`.
- Implemented the `AnnotationValidator` class using Java Reflection.
- Used Reflection to inspect annotations, access private fields and validate their values.
- Integrated custom annotation validation into MiniBank.
- Verified negative-balance validation, valid-account validation and maximum-length validation.

## Lab 08 – Part A

1. **Guarded Calculator** – Custom Exceptions, Input Validation and Exception Handling.

   - Created a custom checked `DivideByZeroException`.
   - Handled invalid numeric input using input parsing exception handling.
   - Validated arithmetic operators.
   - Implemented retry handling until a valid calculation is completed.
   - Used a `finally` block to display the number of attempts.

2. **Stock Issue** – Checked Exceptions and Exception Handling.

   - Created the custom `OutOfStockException` with shortfall information.
   - Created the custom `InvalidQuantityException`.
   - Implemented a `Warehouse` class to manage available stock.
   - Validated requested quantities before processing stock issues.
   - Displayed the stock shortfall when the requested quantity exceeds available stock.
   - Continued processing subsequent requests after handling an exception.
   - Displayed the remaining warehouse stock.

3. **Try-with-Resources Demo** – AutoCloseable and Resource Management.

   - Created a custom resource class implementing `AutoCloseable`.
   - Used try-with-resources to manage resource closure automatically.
   - Demonstrated resource closure even when an exception occurs.
   - Handled the original exception.
   - Demonstrated suppressed exceptions when resource closure also fails.
   - Used a `finally` block to display completion.

### Lab 08 – Part B

MiniBank enhancements:

- Created the `exception` package for custom banking exceptions.
- Created the checked `BankException` base class extending `Exception`.
- Implemented `InsufficientFundsException` with a `shortfall` field and getter.
- Created `AccountNotFoundException` for handling missing accounts.
- Created `InvalidAmountException` for rejecting non-positive transaction amounts.
- Updated `Account` to throw custom checked exceptions during deposit and withdrawal operations.
- Added validation to prevent deposits and withdrawals of zero or negative amounts.
- Implemented the `transfer(Account to, long amount)` method with exception handling.
- Added transfer validation for missing, inactive and identical accounts.
- Implemented rollback handling if the destination deposit fails after the source withdrawal.
- Used `try-catch-finally` to handle transfer errors and guarantee completion messages.
- Integrated exception handling into MiniBank account operations.
- Demonstrated account-not-found exception handling.
- Demonstrated insufficient-funds handling with shortfall calculation.
- Verified that an unsuccessful withdrawal does not modify the account balance.
- Verified that invalid deposits and withdrawals do not modify the account balance.
- Demonstrated try-with-resources using an `AutoCloseable` bank session.
- Verified automatic resource closure even when a banking exception occurs.

## Lab 09 – Part A

**CO4: Multithreading and Synchronization**

1. **Counter Race Condition** – Shared variables, concurrent execution and synchronization.

   - Implemented a shared counter accessed by multiple threads.
   - Demonstrated a race condition using unsynchronized increments.
   - Used synchronization to ensure accurate and consistent counter results.
   - Compared the expected counter value with the actual results.

2. **Seat Booking Race Condition** – Thread safety and synchronized methods.

   - Simulated concurrent seat booking with 10 threads competing for 5 available seats.
   - Demonstrated incorrect booking results caused by concurrent access.
   - Implemented synchronized booking to prevent overselling.
   - Verified that exactly 5 bookings succeed when synchronization is used.

3. **Shared Array Sum** – Concurrent data processing and thread-safe accumulation.

   - Divided a large array among multiple threads to calculate a shared sum.
   - Demonstrated incorrect results caused by unsynchronized updates to a shared variable.
   - Implemented synchronized accumulation to obtain the correct sum.
   - Used `AtomicLong` as an alternative thread-safe solution.
   - Compared the execution times of different approaches.

### Lab 09 – Part B

MiniBank enhancements:

- Implemented `AccountWorker` using the `Runnable` interface to perform repeated deposits concurrently.
- Updated account deposit, withdrawal and balance operations to use synchronization.
- Used multiple threads to perform concurrent deposits on a shared bank account.
- Used `join()` to wait for worker threads to finish execution.
- Demonstrated a lost-update race condition using a controlled unsynchronized deposit simulation.
- Used `CyclicBarrier` to coordinate concurrent operations in the race-condition demonstration.
- Tested concurrent withdrawals to verify that the account balance does not become negative or allow excess withdrawals.
- Used `AtomicInteger` to count successful concurrent withdrawals.
- Displayed thread names, execution lifecycle and final account balances.

**New source files:**

- `Miniproject/src/service/AccountWorker.java`
- `Miniproject/src/service/UnsafeDepositDemo.java`

**Modified source files:**

- `Miniproject/src/model/Account.java`
- `Miniproject/src/service/MiniBank.java`

**Key concepts:** Multithreading, `Runnable`, synchronization, race conditions, thread safety, `join()`, `CyclicBarrier` and `AtomicInteger`.

## Lab 10 – Part A

**CO4: Advanced Concurrency – Thread Pools, Producer-Consumer and Deadlock Prevention**

1. **Thread Pool Runner** – ExecutorService and fixed thread pools.

   - Created a fixed thread pool containing 3 worker threads.
   - Submitted 10 independent Runnable tasks using the executor.
   - Displayed task IDs and the names of executing worker threads.
   - Used a short delay to observe thread reuse.
   - Called `shutdown()` to stop accepting new tasks.
   - Used `awaitTermination()` to wait for submitted tasks to finish.

2. **Producer-Consumer** – Shared buffer and thread coordination.

   - Created a shared buffer with a limited capacity of 3.
   - Implemented producer and consumer threads.
   - Used synchronized methods to protect shared buffer operations.
   - Used `wait()` when the buffer was full or empty.
   - Used `notifyAll()` to wake waiting threads after buffer operations.
   - Produced and consumed 10 items in order.
   - Used `join()` to wait for both threads to complete.

3. **Deadlock Demonstration** – Deadlock creation and prevention.

   - Created two shared lock objects.
   - Used two threads to acquire the locks in opposite orders.
   - Used `CountDownLatch` to coordinate the threads and reliably demonstrate deadlock.
   - Used daemon threads so the intentional deadlock does not prevent JVM termination.
   - Demonstrated prevention through a consistent lock acquisition order.

### Lab 10 – Part B

MiniBank enhancements:

- Created the `TransactionProcessor` class using `Executors.newFixedThreadPool(4)`.
- Implemented transaction submission using `submit(Runnable task)` and `ExecutorService.execute()`.
- Implemented graceful shutdown using `shutdown()` and `awaitTermination()`.
- Created the `BankTransaction` class implementing `Runnable` for deposit and withdrawal operations.
- Submitted multiple banking transactions to the thread pool.
- Tracked and displayed the number of tasks executed by each worker thread.
- Implemented the `TransactionBuffer` class using a shared array-based circular buffer.
- Used synchronized `put()` and `take()` methods for producer-consumer coordination.
- Used `wait()` and `notifyAll()` to coordinate the producer and consumer threads.
- Created producer and consumer threads to process banking transactions through the shared buffer.
- Implemented a deadlock demonstration using two accounts and opposite-direction transfers.
- Demonstrated deadlock prevention by acquiring account locks in a consistent account-number order.
- Created the `TimedTransferTask` class to measure transfer execution time.
- Displayed a warning when a transfer exceeds the configured execution-time threshold.
- Integrated thread-pool processing, producer-consumer processing and deadlock demonstrations into MiniBank.

**New source files:**

- `Miniproject/src/service/BankTransaction.java`
- `Miniproject/src/service/TransactionBuffer.java`
- `Miniproject/src/service/TransactionProcessor.java`
- `Miniproject/src/service/TimedTransferTask.java`
- `Miniproject/src/service/TransferDeadlockDemo.java`

**Modified source files:**

- `Miniproject/src/model/Account.java`
- `Miniproject/src/service/MiniBank.java`

**Key concepts:** `ExecutorService`, fixed thread pools, `Runnable`, task submission, graceful shutdown, `awaitTermination()`, producer-consumer pattern, synchronized shared buffers, `wait()`, `notifyAll()`, deadlock, consistent lock ordering and execution-time monitoring.

---

## Requirements

- Java Development Kit (JDK) 21.
- Visual Studio Code or another Java IDE.
- Git.

## How to Compile and Run

Run the following commands from the repository root using PowerShell.

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
Push-Location .\lab-03\Practical-1
javac *.java
java Driver
Pop-Location
```

**Duplicate Card Check**

```powershell
Push-Location .\lab-03\Practical-2
javac *.java
java Driver
Pop-Location
```

**Fraction**

```powershell
Push-Location .\lab-03\Practical-3
javac *.java
java Driver
Pop-Location
```

### Lab 04 – Part A

**Password Strength Checker**

```powershell
Push-Location .\lab-04\Practical-1
javac *.java
java Driver
Pop-Location
```

**Chat-Log Filter**

```powershell
Push-Location .\lab-04\Practical-2
javac *.java
java Driver
Pop-Location
```

**Template Filler**

```powershell
Push-Location .\lab-04\Practical-3
javac *.java
java Driver
Pop-Location
```

### Lab 05 – Part A

**Shape Areas**

```powershell
Push-Location .\lab-05\Practical-1
javac *.java
java ShapeAreas
Pop-Location
```

**Employee Payroll**

```powershell
Push-Location .\lab-05\Practical-2
javac *.java
java Payroll
Pop-Location
```

**Media Late Fees**

```powershell
Push-Location .\lab-05\Practical-3
javac *.java
java MediaLateFees
Pop-Location
```

### Lab 06 – Part A

**Remote Control System**

```powershell
Push-Location .\lab-06\Practical-1
javac *.java
java RemoteControl
Pop-Location
```

**Notification Sender System**

```powershell
Push-Location .\lab-06\Practical-2
javac *.java
java NotificationSenders
Pop-Location
```

**Discount Engine – Run from JAR**

```powershell
java -jar .\lab-06\Practical-3\DiscountEngine.jar
```

**Compile the Discount Engine from source**

```powershell
Push-Location .\lab-06\Practical-3

New-Item -ItemType Directory -Force out | Out-Null

javac -d out src\discount\DiscountRule.java src\app\DiscountEngine.java

java -cp out app.DiscountEngine

Pop-Location
```

### Lab 07 – Part A

**Practical 1 – Signup Form Validator**

```powershell
Push-Location .\lab-07\Practical-1
javac *.java
java Driver
Pop-Location
```

**Practical 2 – Mini Test Runner**

```powershell
Push-Location .\lab-07\Practical-2
javac *.java
java Driver
Pop-Location
```

**Practical 3 – Column Mapper**

```powershell
Push-Location .\lab-07\Practical-3
javac *.java
java Driver
Pop-Location
```

### Lab 08 – Part A

**Practical 1 – Guarded Calculator**

```powershell
Push-Location .\lab-08\Practical-1
javac GuardedCalculator.java
java GuardedCalculator
Pop-Location
```

**Practical 2 – Stock Issue**

```powershell
Push-Location .\lab-08\Practical-2
javac StockIssue.java
java StockIssue
Pop-Location
```

**Practical 3 – Try-with-Resources Demo**

```powershell
Push-Location .\lab-08\Practical-3
javac TryWithResourcesDemo.java
java TryWithResourcesDemo
Pop-Location
```

### Lab 09 – Part A

**Practical 1 – Counter Race**

```powershell
Push-Location .\lab-09\Practical-1
javac *.java
java CounterRace
Pop-Location
```

**Practical 2 – Seat Booking Race**

```powershell
Push-Location .\lab-09\Practical-2
javac *.java
java SeatBookingRace
Pop-Location
```

**Practical 3 – Shared Array Sum**

```powershell
Push-Location .\lab-09\Practical-3
javac *.java
java SharedArraySum
Pop-Location
```

### Lab 10 – Part A

**Practical 1 – Thread Pool Runner**

```powershell
Push-Location .\lab-10\Practical-1
javac ThreadPoolRunner.java
java ThreadPoolRunner
Pop-Location
```

**Practical 2 – Producer-Consumer**

```powershell
Push-Location .\lab-10\Practical-2
javac ProducerConsumer.java
java ProducerConsumer
Pop-Location
```

**Practical 3 – Deadlock Demonstration**

```powershell
Push-Location .\lab-10\Practical-3
javac DeadlockDemo.java
java DeadlockDemo
Pop-Location
```

### MiniBank – Part B

**Compile the complete MiniBank project from source**

Run these commands from the repository root:

```powershell
New-Item -ItemType Directory -Force .\Miniproject\build | Out-Null

$files = Get-ChildItem -Path .\Miniproject\src -Recurse -Filter *.java |
    ForEach-Object { $_.FullName }

javac -d .\Miniproject\build $files
```

This compiles all Java source files, including the exception, model, service, util and custom annotation packages.

**Run the compiled MiniBank application**

```powershell
java -cp .\Miniproject\build service.MiniBank
```

**Create or update the runnable MiniBank JAR**

Run from the repository root after compiling the source:

```powershell
Push-Location .\Miniproject

jar cfm MiniBank.jar manifest.txt -C build .

Pop-Location
```

**Run the runnable MiniBank JAR**

```powershell
java -jar .\Miniproject\MiniBank.jar
```

The source compilation and execution commands are the recommended method for testing the latest MiniBank implementation. Rebuild the JAR whenever the source code changes.

---

## Git Tags

The following Git tags mark the completion of each laboratory:

- `lab-01` – Lab 01 completed.
- `lab-02` – Lab 02 completed.
- `lab-03` – Lab 03 completed.
- `lab-04` – Lab 04 completed.
- `lab-05` – Lab 05 completed.
- `lab-06` – Lab 06 completed.
- `lab-07` – Lab 07 completed.
- `lab-08` – Lab 08 completed.
- `lab-09` – Lab 09 completed.
- `lab-10` – Lab 10 completed.

## Author

**Vishva Fultariya**

B.Tech – Computer Science and Engineering  
CSPIT, CHARUSAT  
Academic Year 2026–27
