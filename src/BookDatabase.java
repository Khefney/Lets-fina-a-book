/*
Author: Khefney
Description: This Java program defines a `BookDatabase` class for managing a collection of books stored in an `ArrayList`.
It includes methods for adding and removing books, searching for books by author, publication year, or genre,
and getters and setters for accessing and modifying the book collection.
The `toString()` method generates a string representation of the book database,
listing all books in the collection.
*/

import java.util.ArrayList;

public class BookDatabase {
    private ArrayList<Book> books;

    // Default constructor initializes an empty ArrayList of books
    public BookDatabase() {
        this.books = new ArrayList<>();
    }

    // Parameterized constructor initializes the book database with an existing list of books
    public BookDatabase(ArrayList<Book> books) {
        this.books = books;
    }

    // Method to add a book to the database
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the database
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Getter for retrieving the list of books in the database
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Setter for updating the list of books in the database
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    // Method to search for books by author
    public ArrayList<Book> search(Author author) {
        ArrayList<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            // Check if both first name and last name match
            if (book.getAuthor().getFirstName().equalsIgnoreCase(author.getFirstName()) &&
                    book.getAuthor().getLastName().equalsIgnoreCase(author.getLastName())) { //makes it so its not case senstitive
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }


    // Method to search for books within a given year range
    public ArrayList<Book> search(int startYear, int endYear) {
        ArrayList<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() >= startYear && book.getYear() <= endYear) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    // Method to search for books by genre
    public ArrayList<Book> search(String genre) {
        ArrayList<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre.trim())) { //makes it so its not case sensitive
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    // Override toString method to provide a string representation of the BookDatabase
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BookDatabase {\n");
        for (Book book : books) {
            sb.append("\t").append(book).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }


}
