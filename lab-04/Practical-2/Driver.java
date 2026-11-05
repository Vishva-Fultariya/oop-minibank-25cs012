
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        String[] logs = {
            "10:05 alice Hello there",
            "10:10 bob Good morning",
            "10:15 charlie How are you?",
            "10:20 david hello everyone",
            "10:25"
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine();

        System.out.println();

        String result = ChatFilter.filterLogs(logs, keyword);

        System.out.println(result);

        sc.close();
    }
}
