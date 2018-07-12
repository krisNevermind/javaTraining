package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (! app.getContactHelper().isThereContact()){
            app.goTo().addNewContact();
            app.getContactHelper().createContact(new  NewContactData().withFirstName("name1").withLastName("name2"));
        }
    }

    @Test
    public void testContactDeletion() {
        Set<NewContactData> before = app.getContactHelper().all();
        NewContactData deletedContact = before.iterator().next();
 //       int index = before.size() - 1;
        app.getContactHelper().deleteContact(deletedContact);
        app.getWebDriver().switchTo().alert().accept();
        app.getContactHelper().returnHome();
        Set<NewContactData> after = app.getContactHelper().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(after, before);
    }


}
