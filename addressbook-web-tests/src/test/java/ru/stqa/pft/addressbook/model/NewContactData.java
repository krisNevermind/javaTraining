package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class NewContactData {
    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String homePhoneNumber;
    private String email;

  /*  public NewContactData(int id, String firstName, String lastName, String homePhoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhoneNumber = homePhoneNumber;
        this.email = email;
    }

    public NewContactData(String firstName, String lastName, String homePhoneNumber, String email) {
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhoneNumber = homePhoneNumber;
        this.email = email;
    }
*/
    public int getId() {
        return id;
    }

    public NewContactData withId(int id) {
        this.id = id;
        return this;
    }

    public NewContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public NewContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public NewContactData withHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
        return this;
    }

    public NewContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "NewContactData{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewContactData that = (NewContactData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }
}

