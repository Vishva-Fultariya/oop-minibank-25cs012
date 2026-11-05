package service;

import model.Account;

public class StatementFormatter {

    private StatementFormatter() {
        // Utility class; prevent object creation.
    }

    public static String buildStatement(Account account) {

        if (account == null) {
            return "Unable to generate statement: Account not found.";
        }

        return """
                ===== ACCOUNT STATEMENT =====
                Account Number: %s
                Owner Name: %s
                Current Balance: Rs. %.2f
                Account Status: %s
                =============================
                """.formatted(
                account.getAccountNumber(),
                account.getOwnerName(),
                account.getBalance(),
                account.isActive() ? "Active" : "Inactive"
        );
    }
}