
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FolderTreeReport {

    public static void generateReport(Path folder, Path reportFile)
            throws IOException {

        StringBuilder report = new StringBuilder();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        report.append("========== FOLDER TREE REPORT ==========\n");
        report.append("Folder: ").append(folder.toAbsolutePath()).append("\n\n");

        int[] fileCount = {0};
        long[] totalSize = {0};

        Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(
                    Path file, BasicFileAttributes attributes) {

                fileCount[0]++;
                totalSize[0] += attributes.size();

                String modifiedTime = attributes.lastModifiedTime()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .format(formatter);

                report.append("File Name: ")
                      .append(file.getFileName())
                      .append("\n");

                report.append("Path: ")
                      .append(folder.relativize(file))
                      .append("\n");

                report.append("Size: ")
                      .append(attributes.size())
                      .append(" bytes\n");

                report.append("Last Modified: ")
                      .append(modifiedTime)
                      .append("\n\n");

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(
                    Path file, IOException error) throws IOException {

                throw error;
            }
        });

        report.append("========== SUMMARY ==========\n");
        report.append("Total files: ").append(fileCount[0]).append("\n");
        report.append("Total size: ").append(totalSize[0]).append(" bytes\n");

        Files.writeString(reportFile, report.toString());

        System.out.println("Folder report generated successfully.");
        System.out.println("Report saved at: " + reportFile.toAbsolutePath());
        System.out.println("\n" + report);
    }
}
