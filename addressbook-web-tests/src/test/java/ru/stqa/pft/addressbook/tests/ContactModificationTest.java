package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification(){
        if (! app.getContactHelper().isThereContact()){
            app.getNavigationHelper().addNewContact();
            app.getContactHelper().createContact(new NewContactData("name1", "name2", "12345", "email@email.com"));
        }
        List<NewContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().openContactForEditing();
        app.getContactHelper().fillInContactData(new NewContactData("name1", "name2", "12345", "email@email.com"));
        app.getContactHelper().submitContactModification();
        List<NewContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }

}
