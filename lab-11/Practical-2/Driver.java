
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Driver {

    public static void main(String[] args) {

        Path folder = Path.of("logs");

        try {

            // Create the logs folder
            Files.createDirectories(folder);

            // Create sample log files
            Files.writeString(folder.resolve("app1.log"),
                    "INFO Application started\n"
                    + "ERROR Database connection failed\n"
                    + "INFO User logged in\n");

            Files.writeString(folder.resolve("app2.log"),
                    "INFO Payment completed\n"
                    + "WARN Low disk space\n"
                    + "ERROR Payment timeout\n");

            Files.writeString(folder.resolve("app3.log"),
                    "INFO Server stopped\n"
                    + "ERROR Shutdown failure\n");

            String keyword = "ERROR";

            System.out.println("Searching for keyword: " + keyword);

            LogAnalyzer.analyzeLogs(folder, keyword);

        } catch (IOException e) {

            System.out.println("File operation error: " + e.getMessage());
        }
    }
}
