
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.stream.Stream;

public class LogAnalyzer {

    public static void analyzeLogs(Path folder, String keyword)
            throws IOException {

        int totalLines = 0;
        int matchingLines = 0;

        System.out.println("========== LOG ANALYSIS ==========");

        try (Stream<Path> files = Files.list(folder)) {

            for (Path file : (Iterable<Path>) files
                    .filter(Files::isRegularFile)
                    .sorted(Comparator.comparing(p -> p.getFileName().toString()))::iterator) {

                BasicFileAttributes attributes =
                        Files.readAttributes(file, BasicFileAttributes.class);

                int fileLines = 0;

                try (BufferedReader reader = Files.newBufferedReader(file)) {

                    String line;

                    while ((line = reader.readLine()) != null) {

                        totalLines++;
                        fileLines++;

                        if (line.toLowerCase().contains(keyword.toLowerCase())) {
                            matchingLines++;
                        }
                    }
                }

                System.out.println("\nFile: " + file.getFileName());
                System.out.println("File size: " + attributes.size() + " bytes");
                System.out.println("Lines in file: " + fileLines);
            }
        }

        System.out.println("\n========== FINAL SUMMARY ==========");
        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing keyword '" + keyword
                + "': " + matchingLines);
    }
}
