/*
Khefney
  (\(\  
  ( -.-) 
 o_(")(")
Description: This Java program defines an `Author` class with attributes `firstName` and `lastName`,
along with constructors, getters, setters, and a `toString()` method for representing author objects.
The class encapsulates the properties of an author, allowing for the creation, modification, and retrieval of
author information.
*/

public class Author {
    private String firstName;
    private String lastName;

    // Default constructor initializes an author with default attribute values
    public Author() {
        // Initialize attributes to default values
        this.firstName = "";
        this.lastName = "";
    }

    // Parameterized constructor initializes an author with provided first and last names
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter and setter methods for first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and setter methods for last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Override toString method to provide a string representation of the Author
    @Override
    public String toString() {
        String s = firstName + " " + lastName;
        return s;
    }
}

