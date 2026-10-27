package FeedbackPortal;

import java.io.*;
import java.util.Scanner;

public class FeedbackPortal {
    public  static String[] names = new String[100];
    public  static int[] ratings = new int[100];
    public  static String[] comments = new String[100];

    public  static int count = 0;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


     public static void showMenu() {
        System.out.println("===== CUSTOMER FEEDBACK PORTAL =====");
        System.out.println("1. Add feedback");
        System.out.println("2. Show all feedback");
        System.out.println("3. Show average rating");
        System.out.println("4. Search by rating");
        System.out.println("5. Delete feedback");
        System.out.println("6. Save to file");
        System.out.println("7. Save and exit");
        System.out.print("choose: ");
    }

    // Step 4: Write addFeedback(). Use if to check the rating is between 1 and 5
    public static void addFeedback() throws IOException {
        if (count >= names.length) {
            System.out.println("The feedback list is full.");
            return;
        }

        System.out.print("Customer name: ");
        names[count] = br.readLine();

        while (true) {
            System.out.print("Rating (1 to 5): ");

            try {
                int rating = Integer.parseInt(br.readLine());

                if (rating >= 1 && rating <= 5) {
                    ratings[count] = rating;
                    break;
                }

                System.out.println("Rating must be between 1 and 5.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        System.out.print("Comment: ");
        comments[count] = br.readLine();

        count++;
        System.out.println("Feedback added");
    }

    // Step 5: Write showAll() with a for loop.
    public static void showAll() {
        if (count == 0) {
            System.out.println("There is no feedback to show.");
            return;
        }

        for (int i = 0; i < count; i++) {
        System.out.println((i + 1) + ": " + names[i] + ", " + ratings[i] + ", " + comments[i]);
        }
    }

    //Step 6: Write showAverage(). Add all ratings in a loop, then divide by count.
    public static void showAverage() {
        if (count == 0) {
            System.out.println("There is no feedback");
            return;
        }
        int total = 0;

        for (int i = 0; i < count; i++) {
            total += ratings[i];
        }

        double average = (double) total / count;
        System.out.printf("Average rating: %.2f%n", average);
    }

    //Step 7: Write searchByRating(). Print only the feedback with the chosen rating
    public static void searchByRating() throws IOException {
        System.out.print("Enter a rating to search for (1 to 5): ");
        int chosenrating;

        try {
            chosenrating = Integer.parseInt(br.readLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
            return;
        }
        if (chosenrating < 1 || chosenrating > 5) {
            System.out.println("Rating must be between 1 and 5.");
            return;
        }

        boolean foundrating = false;

        for (int i = 0; i < count; i++) {
            if (ratings[i] == chosenrating) {
                System.out.println((i + 1) + ": " + names[i] + ", " + ratings[i]+ ", " + comments[i]);
                foundrating = true;
            }
        }
        if (!foundrating) {
            System.out.println("No feedback found with that rating.");
        }
    }

    //Step 8: Write deleteFeedback(). Shift all three arrays left.
    public static void deleteFeedback() throws IOException {
        if (count == 0) {
            System.out.println("There is no feedback to delete.");
            return;
        }

        showAll();
        System.out.print("Enter the feedback number to delete: ");

        int number;

        try {
            number = Integer.parseInt(br.readLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid feedback number.");
            return;
        }

        if (number < 1 || number > count) {
            System.out.println("That feedback number is invalid.");
            return;
        }

        int index = number - 1;

        for (int i = index; i < count - 1; i++) {
            names[i] = names[i + 1];
            ratings[i] = ratings[i + 1];
            comments[i] = comments[i + 1];
        }
        count--;
        System.out.println("Feedback deleted");
    }

    //Step 9: Write saveFeedback() and loadFeedback() using BufferedWriter and BufferedReader.
    public static void saveFeedback() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"))) {
            for (int i = 0; i < count; i++) {
                writer.write(names[i] + "|" + ratings[i] + "|" + comments[i]);
                writer.newLine();
            }

            System.out.println("Feedback saved.");
        } catch (IOException e) {
            System.out.println("Error saving feedback: " + e.getMessage());
        }
    }

    public static void loadFeedback() {
        try (BufferedReader reader =
                    new BufferedReader(new FileReader("feedback.txt"))) {
            String line;

            while ((line = reader.readLine()) != null && count < names.length) {
                String[] parts = line.split("\\|");

                names[count] = parts[0];
                ratings[count] = Integer.parseInt(parts[1]);
                comments[count] = parts[2];
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: a saved rating is not a number.");
        }
    }



    public static void main(String[] args) {
        loadFeedback();
        boolean on = true;

        while (on) {
            showMenu();

            try {
            int input = Integer.parseInt(br.readLine());

            switch (input) {
                    case 1:
                        addFeedback();
                        break;
                    case 2:
                        showAll();
                        break;
                    case 3:
                        showAverage();
                        break;
                    case 4:
                        searchByRating();
                        break;
                    case 5:
                        deleteFeedback();
                        break;
                    case 6:
                        saveFeedback();
                        break;
                    case 7:
                        saveFeedback();
                        on = false;
                        break;
                    default:
                        System.out.println("Choose a number from 1 to 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            } catch (IOException e) {
                System.out.println("Input error: " + e.getMessage());
                on = false;
            }
        }
    }
}
