package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        app.getNavigationHelper().addNewContact();
        app.getContactHelper().fillInContactData(new NewContactData("name1", "name2", "12345", "email@email.com"));
        app.getContactHelper().submitNewContact();
        app.returnToHomePage();
    }

}