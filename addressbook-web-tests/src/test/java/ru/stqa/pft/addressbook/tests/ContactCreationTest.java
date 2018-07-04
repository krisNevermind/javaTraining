package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        List<NewContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().addNewContact();
        NewContactData contact = new NewContactData("name1", "name2", "12345", "email@email.com");
        app.getContactHelper().createContact(contact);
        app.returnToHomePage();
        List<NewContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);

        before.add(contact);
        Assert.assertEquals(after, before);
    }

}