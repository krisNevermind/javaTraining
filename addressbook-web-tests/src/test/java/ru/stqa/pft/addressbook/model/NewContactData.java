package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class NewContactData {
    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;
    private String email;
    private String email2;
    private String email3;
    private String allEmails;
    private String address;
    private File photo;

  /*  public NewContactData(int id, String firstName, String lastName, String homePhone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.email = email;
    }

    public NewContactData(String firstName, String lastName, String homePhone, String email) {
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
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

    public NewContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public NewContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public NewContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public NewContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public NewContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public NewContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public NewContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public NewContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public NewContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getFirstName() {

        return firstName; }

    public String getLastName() {

        return lastName;
    }

    public NewContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getHomePhone() {

        return homePhone;
    }

    public String getMobilePhone() {

        return mobilePhone;
    }

    public String getWorkPhone() {

        return workPhone;
    }

    public String getAllPhones(){

        return  allPhones;
    }

    public String getEmail() {

        return email;
    }
    public String getEmail2() {

        return email2;
    }
    public String getEmail3() {

        return email3;
    }

    public String getAllEmails(){

        return  allEmails;
    }

    public String getAddress() {

        return address;
    }

    public File getPhoto() {
        return photo;
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

