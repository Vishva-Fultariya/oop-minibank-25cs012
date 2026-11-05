package service;

import util.Command;
import util.TransactionType;

public class CommandParser {

    private CommandParser() {
        // Utility class; prevent object creation.
    }

    public static Command parse(String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Command cannot be empty.");
        }

        String[] parts = input.trim().split("\\s+");

        if (parts.length != 3) {
            throw new IllegalArgumentException(
                    "Enter command in format: TYPE ACCOUNT_NUMBER AMOUNT"
            );
        }

        try {
            TransactionType type = TransactionType.valueOf(
                    parts[0].toUpperCase()
            );

            String accountNumber = parts[1];
            long amount = Long.parseLong(parts[2]);

            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "Amount must be greater than zero."
                );
            }

            return new Command(type, accountNumber, amount);

        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Amount must be a valid number.");
        }
    }
}