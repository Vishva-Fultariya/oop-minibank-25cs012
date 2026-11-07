package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class ReportGenerator {

    public static String generateReport(Path logsFolder, Path reportFile)
            throws IOException {

        Files.createDirectories(logsFolder);

        long totalDeposits = 0;
        long totalWithdrawals = 0;

        StringBuilder report = new StringBuilder();

        report.append("========== MINIBANK TRANSACTION REPORT ==========\n\n");

        try (DirectoryStream<Path> files = Files.newDirectoryStream(logsFolder)) {

            for (Path file : files) {

                if (!Files.isRegularFile(file)) {
                    continue;
                }

                String fileName = file.getFileName().toString();

                if (!fileName.toLowerCase().endsWith(".log")) {
                    continue;
                }

                BasicFileAttributes attributes = Files.readAttributes(
                        file, BasicFileAttributes.class
                );

                if (attributes.size() == 0) {
                    continue;
                }

                report.append("Log File: ").append(fileName).append('\n');
                report.append("Size: ").append(attributes.size())
                        .append(" bytes\n");
                report.append("Last Modified: ")
                        .append(attributes.lastModifiedTime()).append("\n\n");

                try (BufferedReader reader = Files.newBufferedReader(
                        file, StandardCharsets.UTF_8)) {

                    String line;

                    while ((line = reader.readLine()) != null) {

                        String[] parts = line.trim().split("\\s+");

                        if (parts.length != 3) {
                            continue;
                        }

                        try {
                            long amount = Long.parseLong(parts[2]);

                            if (amount <= 0) {
                                continue;
                            }

                            if (parts[0].equalsIgnoreCase("DEPOSIT")) {
                                totalDeposits += amount;
                            } else if (parts[0].equalsIgnoreCase("WITHDRAW")) {
                                totalWithdrawals += amount;
                            }

                        } catch (NumberFormatException ignored) {
                            // Ignore malformed transaction amounts.
                        }
                    }
                }
            }
        }

        long netChange = totalDeposits - totalWithdrawals;

        report.append("---------------- SUMMARY ----------------\n");
        report.append("Total Deposits: Rs. ")
                .append(totalDeposits).append('\n');
        report.append("Total Withdrawals: Rs. ")
                .append(totalWithdrawals).append('\n');
        report.append("Net Change: Rs. ")
                .append(netChange).append('\n');
        report.append("==========================================\n");

        if (reportFile.getParent() != null) {
            Files.createDirectories(reportFile.getParent());
        }

        Files.writeString(
                reportFile,
                report.toString(),
                StandardCharsets.UTF_8
        );

        return report.toString();
    }
}
