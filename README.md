# LetsFindABook

## Introduction

Welcome to LetsFindABook, a Java project aimed at managing and searching a collection of books effectively. This project facilitates reading book data from a CSV file, populating a book database, and conducting various search operations based on user-defined criteria such as author, publication year range, and genre.

## Project Overview

The LetsFindABook project comprises several Java classes:

1. **Author:** Defines attributes and methods related to authors of books.
2. **Book:** Represents individual books with attributes such as title, author, year, genre, rating, and price.
3. **BookDatabase:** Manages a collection of books, providing methods to add, remove, and search for books based on different criteria.
4. **clientProgram:** A client program that utilizes the BookDatabase to interact with users, enabling them to perform search operations on the book collection.

## Features

- **CSV Data Parsing:** Read book data from a CSV file and populate the book database.
- **Search Operations:** Perform searches by author, publication year range, or genre.
- **User Interaction:** Utilize a client program to prompt users for search criteria and display search results.

## Usage

To use LetsFindABook:

1. Clone the repository to your local machine.
2. Compile the Java source files.
3. Run the `clientProgram` class to interact with the book database and perform search operations.

Example usage:

```bash
javac *.java
java clientProgram
```

Follow the prompts to perform searches based on your criteria.

## Dependencies

This project has no external dependencies beyond the Java standard library.

## Contributions

Contributions to LetsFindABook are welcome! Feel free to submit issues for bugs or feature requests. If you'd like to contribute code, please fork the repository, make your changes, and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
