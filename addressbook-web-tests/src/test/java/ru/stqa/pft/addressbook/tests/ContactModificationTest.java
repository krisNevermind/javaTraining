package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification(){
        if (! app.getContactHelper().isThereContact()){
            app.getNavigationHelper().addNewContact();
            app.getContactHelper().createContact(new NewContactData("name1", "name2", "12345", "email@email.com"));
        }
        List<NewContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().openContactForEditing(before.size() - 1);
        NewContactData contact = new NewContactData(before.get(before.size() - 1).getId(), "name7", "name2", "12345", "email@email.com");
        app.getContactHelper().fillInContactData(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnHome();
        List<NewContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
