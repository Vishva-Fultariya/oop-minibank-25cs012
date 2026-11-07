
package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import model.Account;

public class StatePersister {

    // Save account array to a file.
    public static void save(Account[] accounts, Path file)
            throws IOException {

        // Create parent directories if they do not exist.
        if (file.getParent() != null) {
            Files.createDirectories(file.getParent());
        }

        // Write objects using ObjectOutputStream.
        try (ObjectOutputStream output =
                new ObjectOutputStream(
                        new FileOutputStream(file.toFile()))) {

            output.writeObject(accounts);

            System.out.println(
                    "Account data saved successfully."
            );
        }
    }

    // Load account array from a file.
    public static Account[] load(Path file)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream input =
                new ObjectInputStream(
                        new FileInputStream(file.toFile()))) {

            Account[] accounts = (Account[]) input.readObject();

            // Synchronize account numbering after loading.
            Account.synchronizeAccountCounter(accounts);

            System.out.println(
                    "Account data loaded successfully."
            );

            return accounts;
        }
    }
}
