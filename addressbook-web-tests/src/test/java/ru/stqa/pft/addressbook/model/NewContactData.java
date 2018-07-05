package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class NewContactData {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String homePhoneNumber;
    private final String email;

    public NewContactData(int id, String firstName, String lastName, String homePhoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhoneNumber = homePhoneNumber;
        this.email = email;
    }

    public NewContactData(String firstName, String lastName, String homePhoneNumber, String email) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhoneNumber = homePhoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName);
    }
}

