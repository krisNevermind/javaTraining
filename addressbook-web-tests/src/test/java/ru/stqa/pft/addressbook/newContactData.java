package ru.stqa.pft.addressbook;

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
}
