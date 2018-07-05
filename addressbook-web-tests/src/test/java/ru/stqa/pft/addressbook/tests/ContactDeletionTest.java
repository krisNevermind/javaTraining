package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        if (! app.getContactHelper().isThereContact()){
            app.getNavigationHelper().addNewContact();
            app.getContactHelper().createContact(new NewContactData("name1", "name2", "12345", "email@email.com"));
        }
        List<NewContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getWebDriver().switchTo().alert().accept();
        app.getContactHelper().returnHome();
        List<NewContactData> after = app.getContactHelper().getContactList();
 //       Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(after, before);
    }

}
