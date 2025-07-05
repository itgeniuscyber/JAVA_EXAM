import java.util.Scanner;

public class UgandaCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book description:");
        String description = scanner.nextLine();

        String[] words = description.split("\\s+");
        int count = 0;

        for (String word : words) {
            if (word.equalsIgnoreCase("Uganda")) {
                count++;
            }
        }

        System.out.println("The word 'Uganda' appears " + count + " times.");
    }
}

