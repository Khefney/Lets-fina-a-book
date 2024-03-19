/*
Khefney
  (\(\  
  ( -.-) 
 o_(")(")
Description: This Java program defines a `Book` class representing books, with attributes like
`author`, `title`, `year`, `publisher`, `genre`, `rating`, and `price`. It includes constructors, getters, setters, and a `toString()` method for managing book details.
The class also incorporates an `Author` object to represent the book's author,
enabling composition of author details within a book object.
*/


public class Book {
    private Author author;
    private String title;
    private int year;
    private String publisher;
    private String genre;
    private double rating;
    private double price;

    // Default constructor initializes a book with default attribute values
    public Book() {
        this.author = new Author();
        this.title = "";
        this.year = 0;
        this.publisher = "";
        this.genre = "";
        this.rating = 0.0;
        this.price = 0.0;
    }

    // Parameterized constructor initializes a book with provided attribute values
    public Book(Author author, String title, int year, String genre, String publisher, double rating, double price) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
    }

    // Getter and setter methods for all attributes

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override toString method to provide a string representation of the Book
    @Override
    public String toString() {
        return String.format(
                "Book{\n" +
                        "\tAuthor: %s %s\n" +
                        "\tTitle: %s\n" +
                        "\tYear: %d\n" +
                        "\tGenre: %s\n" +
                        "\tPublisher: %s\n" +
                        "\tRating: %.1f\n" +
                        "\tPrice: %.2f\n" +
                        "}",
                author.getFirstName(), author.getLastName(), title, year, genre, publisher, rating, price);
    }

}

