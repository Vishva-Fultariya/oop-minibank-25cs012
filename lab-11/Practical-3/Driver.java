
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Driver {

    public static void main(String[] args) {

        Path folder = Path.of("sample-folder");

        Path reportFile = Path.of("folder-report.txt");

        try {

            // Create main folder and subfolders
            Files.createDirectories(folder.resolve("docs"));
            Files.createDirectories(folder.resolve("logs"));

            // Create sample files
            Files.writeString(folder.resolve("readme.txt"),
                    "Welcome to the sample folder.");

            Files.writeString(folder.resolve("docs/guide.txt"),
                    "This is the documentation file.");

            Files.writeString(folder.resolve("logs/app.log"),
                    "Application started successfully.");

            Files.writeString(folder.resolve("logs/error.log"),
                    "No errors found.");

            // Generate the folder report
            FolderTreeReport.generateReport(folder, reportFile);

        } catch (IOException e) {

            System.out.println("File operation error: " + e.getMessage());
        }
    }
}
