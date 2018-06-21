package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        addNewContact();
        fillInContactData(new NewContactData("name1", "name2", "12345", "email@email.com"));
        submitNewContact();
        returnToHomePage();
    }

}