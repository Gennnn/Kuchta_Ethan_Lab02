package me.ethan.inheritence;

import java.time.Year;
import java.util.Objects;

public class Person {

    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int birthYear;

    public Person(String ID, String firstName, String lastName, String title, int birthYear) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.birthYear = birthYear;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear && ID.equals(person.ID) && firstName.equals(person.firstName) && lastName.equals(person.lastName) && title.equals(person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title, birthYear);
    }

    /**
     * @return Returns the first name and the last name as a String
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * @return Returns the title, first and last name of the person as a String
     */
    public String formalName() {
        return title + " " + firstName + " " + lastName;
    }

    /**
     * @return returns the current age of a person based on the current year as an int
     */
    public int getAge() {
        return Integer.parseInt(Year.now().toString()) - birthYear;
    }

    /**
     * @param year the year from which you'd like the age to be calculated
     * @return returns the age of an individual given the year variable as an int
     */
    public int getAge(int year) {
        return year - birthYear;
    }

    /**
     * @return returns the id, name, title, and birthyear as a comma seperated string
     */

    public String toCSVDataRecord() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + birthYear;
    }
}
