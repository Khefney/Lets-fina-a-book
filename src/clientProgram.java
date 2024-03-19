/*
Author: Kirsten Hefney
Description: This Java program represents a client program that utilizes a `BookDatabase` to manage and
search a collection of books. It first reads data from a CSV file, populating the `BookDatabase` with books.
Then, it prompts the user to choose a search criteria (by author, year range, or genre) and performs the
corresponding search operation, displaying the results. The program handles user input and CSV parsing,
ensuring robust functionality for searching and managing book data.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class clientProgram {

    public static void main(String[] args) {
        // Create a BookDatabase object
        BookDatabase bookDatabase = new BookDatabase();

        // Read data from the CSV file and populate the BookDatabase object
        readDataFromCSV("dataset.csv", bookDatabase);


        // Print the contents of the BookDatabase
        System.out.println("Book Database Contents:");
        System.out.println(bookDatabase);

        // Create a Scanner object to read user input
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to enter search criteria
            System.out.println("\nEnter search criteria:");
            System.out.println("1. Search by Author");
            System.out.println("2. Search by Year Range");
            System.out.println("3. Search by Genre");
            System.out.print("Enter your choice: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a valid integer choice.");
                return;
            }

            // Perform search based on user choice
            switch (choice) {
                case 1:
                    System.out.print("Enter author's first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter author's last name: ");
                    String lastName = scanner.nextLine();
                    Author author = new Author(firstName, lastName);
                    System.out.println("Books by author " + author + ":");
                    System.out.println(bookDatabase.search(author));
                    break;
                case 2:
                    System.out.print("Enter start year: ");
                    int startYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter end year: ");
                    int endYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Books published between " + startYear + " and " + endYear + ":");
                    System.out.println(bookDatabase.search(startYear, endYear));
                    break;
                case 3:
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.println("Books in genre " + genre + ":");
                    System.out.println(bookDatabase.search(genre));
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    /*
    What this method readDataFromCSV does it read the data from the file and the parts = the number of the columns
    this ensures that it reads all of our data from the .csv correctly that we initlaized earlier

     */
    private static void readDataFromCSV(String filename, BookDatabase bookDatabase) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            // Skip the first row (header row)
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(","); //CSV format: first name, last name, title, year, genre, publisher, rating, price

                if (parts.length == 8) { //Ensure all columns are present
                    String authorFirstName = parts[0];
                    String authorLastName = parts[1];
                    String title = parts[2];
                    int year = Integer.parseInt(parts[3]);
                    String genre = parts[4];
                    String publisher = parts[5];
                    double rating = Double.parseDouble(parts[6]);
                    double price = Double.parseDouble(parts[7].replace("$", "")); // Remove currency symbol causes an error

                    // Create Author object
                    Author author = new Author(authorFirstName, authorLastName);

                    // Create Book object
                    Book book = new Book(author, title, year, genre, publisher, rating, price);

                    // Add Book to BookDatabase
                    bookDatabase.addBook(book);
                } else {
                    System.out.println("Invalid line in CSV: " + line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numeric values in CSV: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for more information
        }
    }

}

