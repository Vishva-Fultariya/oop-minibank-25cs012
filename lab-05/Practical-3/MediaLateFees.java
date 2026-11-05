
abstract class Media {
    protected String title;
    protected int lateDays;

    public Media(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }

    abstract double calculateLateFee();

    public void displayDetails() {
        System.out.println("Media Title: " + title);
        System.out.println("Late Days: " + lateDays);
        System.out.printf("Late Fee: Rs. %.2f%n", calculateLateFee());
    }
}

class Book extends Media {
    public Book(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double calculateLateFee() {
        return lateDays * 2.0;
    }
}

class DVD extends Media {
    public DVD(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double calculateLateFee() {
        return lateDays * 5.0;
    }
}

class Magazine extends Media {
    public Magazine(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double calculateLateFee() {
        return lateDays * 3.0;
    }
}

public class MediaLateFees {
    public static void main(String[] args) {

        Media[] mediaItems = {
            new Book("Java Programming", 5),
            new DVD("Inception", 3),
            new Magazine("Tech Monthly", 4)
        };

        double totalFees = 0;

        System.out.println("===== MEDIA LATE FEE SYSTEM =====");

        for (Media item : mediaItems) {
            item.displayDetails();

            totalFees += item.calculateLateFee();

            if (item instanceof Book) {
                System.out.println("Media Type: Book");
            } else if (item instanceof DVD) {
                System.out.println("Media Type: DVD");
            } else if (item instanceof Magazine) {
                System.out.println("Media Type: Magazine");
            }

            System.out.println("--------------------------------");
        }

        System.out.printf("Total Late Fees: Rs. %.2f%n", totalFees);
    }
}
