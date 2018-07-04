package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class NewContactData {
    private final String firstName;
    private final String lastName;
    private final String homePhoneNumber;
    private final String email;

    public NewContactData(String firstName, String lastName, String homePhoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhoneNumber = homePhoneNumber;
        this.email = email;
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
                "firstName='" + firstName + '\'' +
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

